package fr.formation.simploncinema.service.booking;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import fr.formation.simploncinema.domain.dtos.booking.*;
import fr.formation.simploncinema.domain.entities.booking.*;
import fr.formation.simploncinema.domain.entities.movietheater.*;
import fr.formation.simploncinema.domain.entities.referentials.*;
import fr.formation.simploncinema.repository.referentials.*;
import fr.formation.simploncinema.utilities.*;
import fr.formation.simploncinema.repository.booking.*;
import fr.formation.simploncinema.repository.movietheater.MeansOfPaymentRepository;
import fr.formation.simploncinema.repository.movietheater.RateRepository;

@Service
public class PendingBookingManagerServiceImpl extends UtilitiesAlgoManagerImpl
		implements PendingBookingManagerService {

	private final PendingBookingRepository repository;
	private final ClientRepository clientrepository;
	private final ProjectionRepository sessionrepository;
	private final ProjectionBookingRepository sessionbookingrepository;
	private final PendingTicketRepository pendingrepository;
	private final MeansOfPaymentRepository meansOfPaymentrepository;
	private final RateRepository raterepo;

	public PendingBookingManagerServiceImpl(ClientRepository clientrepository, PendingBookingRepository repository,
			ProjectionRepository sessionrepository, ProjectionBookingRepository sessionbookingrepository,
			PendingTicketRepository pendingrepository, MeansOfPaymentRepository meansOfPaymentrepository,
			RateRepository raterepo) {
		this.repository = repository;
		this.clientrepository = clientrepository;
		this.sessionrepository = sessionrepository;
		this.sessionbookingrepository = sessionbookingrepository;
		this.pendingrepository = pendingrepository;
		this.meansOfPaymentrepository = meansOfPaymentrepository;
		this.raterepo = raterepo;
	}

	@Override
	public Optional<PendingBookingDTO> getPendingBookingById(long refpendingbooking) {
		PendingBookingDTO pendingBookingDTO = new PendingBookingDTO();
		PendingBooking pendingbooking = repository.findById(refpendingbooking).get();
		pendingBookingDTO = getPendingBookingDTO(pendingbooking);
		return Optional.of(pendingBookingDTO);

	}

	@Override
	public void createPendingBooking(long refClient, String movietheatername, Date projectiondate, String moviename)
			throws ParseException {

		PendingBooking pendingbooking = new PendingBooking();

		List<Projection> sessions = sessionrepository.findByProjectiondate(projectiondate);
		long indice = 1;
		for (int i = 0; i < sessions.size(); i++) {

			MovieTheater currentmovietheater = sessions.get(i).getMovieTheater();
			Movie currentmovie = sessions.get(i).getMovie();
			if (movietheatername.equals(currentmovietheater.getMovietheatername())
					&& moviename.equals(currentmovie.getMoviename())) {
				indice = sessions.get(i).getId();
				break;
			}
		}
		Client client = clientrepository.findById(refClient).get();
		//ProjectionBooking sessionBooking = sessionbookingrepository.findById(indice).get();
		Projection session = sessionrepository.findById(indice).get();
		List<PendingBooking> pendingbookings = repository.findAll();

		//pendingbooking = initPendingBooking(client, sessions, pendingbookings, sessionBooking);
		pendingbooking = initPendingBooking(client, sessions, pendingbookings, session);
		repository.save(pendingbooking);

	}

	@Override
	public void deletePendingBooking(long refpendingbooking) {
		repository.deleteById(refpendingbooking);

	}

	@Override
	public void updatePendingBooking(long refpendingbooking, PendingBookingDTO pendingbookingDTO) {
		PendingBooking pendingBooking = repository.findById(refpendingbooking).get();
		pendingBooking = getPendingBooking(pendingbookingDTO);
		repository.save(pendingBooking);

	}
	


	@Override
	public List<PendingBookingDTO> findAllPendingBookings() {
		List<PendingBooking> pendingbookings = repository.findAll();
		List<PendingBookingDTO> pendingbookingsDTO = getPendingbookingsDTO(pendingbookings);

		return pendingbookingsDTO;
	}

	@Override
	public void updatePendingBookingChoixNumberSeats(long refpendingbooking, long numberseats) throws ParseException {
		PendingBooking pendingBooking = repository.findById(refpendingbooking).get();
		pendingBooking.setNumberofseatschosen(numberseats);
		List<PendingTicket> pendingTicketNumberSeats = new ArrayList<PendingTicket>();

		List<PendingTicket> pendingtickets = pendingrepository.findAll();
		long refpendingticket = getNumberIDReference(pendingtickets.size());
		for (int i = 0; i < numberseats; i++) {
			PendingTicket pendingticket = initPendingTicket(pendingBooking, numberseats, refpendingticket);
			pendingTicketNumberSeats.add(pendingticket);
			refpendingticket++;
		}
		
		pendingBooking.setPendingtickets(pendingTicketNumberSeats);
		repository.save(pendingBooking);
	}

	@Override
	public void updatePendingBookingCB(long refpendingbooking, String meansOfPayment) throws ParseException {
		PendingBooking pendingBooking = repository.findById(refpendingbooking).get();
		MeansOfPayment meansofpayment = meansOfPaymentrepository.findByName(meansOfPayment).get();
		meansofpayment.setName(meansOfPayment);
		pendingBooking.setMeansofpayment(meansofpayment);
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		pendingBooking.setModificationdate(formatter.parse(formatter.format(new Date())));
		repository.save(pendingBooking);
	}

	@Override
	public void updatePendingBookingRates(long refpendingbooking, long numberticketsratenormal,
			long numberticketsrate26, long numberticketsrate14) throws ParseException {
		PendingBooking pendingBooking = repository.findById(refpendingbooking).get();
		List<Rate> rates = raterepo.findAll();

		HashMap<Rate, Long> map = getNumberofTicketsByRates(rates, 
				numberticketsratenormal,numberticketsrate26, numberticketsrate14);

		List<Rate> ratesTickets =getListRates(map);

		List<PendingTicket> pendingTickets = pendingBooking.getPendingtickets();

		for (int i = 0; i < ratesTickets.size(); i++) {
			PendingTicket pendingticket = pendingTickets.get(i);
			pendingticket.setRate(ratesTickets.get(i));
			SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
			pendingticket.setModificationdate(formatter.parse(formatter.format(new Date())));
		}

		System.out.println("Size rates :"+rates.size()+" / Size pending tickets :"+pendingTickets.size()+" /Size ratetickets :"+ratesTickets.size());
		double totalrate = totalrate(map);

		pendingBooking.setTotalrate(totalrate);
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		pendingBooking.setModificationdate(formatter.parse(formatter.format(new Date())));
		pendingBooking.setPendingtickets(pendingTickets);

		repository.save(pendingBooking);
	}

	@Override
	public void updatePendingBookingChoixNumberSeatsAndRows(long refpendingbooking, long numberseats, long row) throws ParseException {

		PendingBooking pendingBooking = repository.findById(refpendingbooking).get();
		pendingBooking.setNumberofseatschosen(numberseats);
		pendingBooking.setRownumber(row);
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

		pendingBooking.setModificationdate(formatter.parse(formatter.format(new Date())));

	//	ProjectionBooking sessionBooking = sessionbookingrepository.findById(pendingBooking.getSessionbooking().getId()).get();

		ProjectionBooking sessionBooking = sessionbookingrepository.findById(pendingBooking.getProjection().getId()).get();

		pendingBooking = updatePendingTicketsWithChoiceRow(pendingBooking, row, sessionBooking);



		repository.save(pendingBooking);

	}

}

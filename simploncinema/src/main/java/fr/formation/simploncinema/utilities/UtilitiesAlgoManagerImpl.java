package fr.formation.simploncinema.utilities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import fr.formation.simploncinema.domain.entities.booking.BookedTicket;
import fr.formation.simploncinema.domain.entities.booking.Booking;
import fr.formation.simploncinema.domain.entities.booking.PendingBooking;
import fr.formation.simploncinema.domain.entities.booking.PendingTicket;
import fr.formation.simploncinema.domain.entities.booking.ProjectionBooking;
import fr.formation.simploncinema.domain.entities.booking.Ticket;
import fr.formation.simploncinema.domain.entities.movietheater.Projection;
import fr.formation.simploncinema.domain.entities.movietheater.Rate;
import fr.formation.simploncinema.domain.entities.referentials.Client;

public class UtilitiesAlgoManagerImpl extends UtilitiesBookingManagerImpl implements UtilitiesAlgosManager {

    @Override
    public long getNumberIDReference(long size) {
	long idref = 0;
	if (size > 0) {
	    idref = 1 + size;
	} else {
	    idref = 1;
	}
	return idref;

    }

    @Override
    public PendingBooking updatePendingTicketsWithChoiceRow(PendingBooking pendingbooking, long row,
	    ProjectionBooking projectionBooking) throws ParseException {
	List<Integer> seatnumbersavailable = new ArrayList<Integer>();
	seatnumbersavailable = searchavailableseatnumberswithrow(projectionBooking.getTickets(), row);
	System.out.println("Size of available seats:" + seatnumbersavailable);

	List<PendingTicket> pendingTickets = pendingbooking.getPendingtickets();
	for (int i = 0; i < pendingbooking.getPendingtickets().size(); i++) {
	    PendingTicket pendingticket = pendingbooking.getPendingtickets().get(i);
	    SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
	    pendingticket.setModificationdate(formatter.parse(formatter.format(new Date())));
	    pendingticket.setRownumber(row);
	    pendingticket.setIsproposed(true);
	    pendingticket.setSeatnumber(seatnumbersavailable.get(i));
	    pendingticket.setPendingbooking(pendingbooking);
	}
	pendingbooking.setPendingtickets(pendingTickets);

	return pendingbooking;

    }

    @Override
    public PendingTicket initPendingTicket(PendingBooking pendingbooking, long numberseats, long refpendingticket)
	    throws ParseException {

	PendingTicket pendingticket = new PendingTicket();
	SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
	pendingticket.setCreationdate(formatter.parse(formatter.format(new Date())));
	pendingticket.setIsproposed(false);
	pendingticket.setNumberofseatschosen(numberseats);
	pendingticket.setRefpendingticket(refpendingticket);
	pendingticket.setPendingbooking(pendingbooking);
	return pendingticket;

    }

    public List<Integer> searchavailableseatnumberswithrow(List<Ticket> tickets, long row) {
	List<Integer> seatnumbersavailable = new ArrayList<Integer>();
	for (int i = 0; i < tickets.size(); i++) {
	    Ticket ticket = tickets.get(i);
	    if (ticket.getRownumber() == row) {
		if (ticket.isIsregistered() == false) {
		    seatnumbersavailable.add((int) ticket.getSeatnumber());

		}
	    }
	}
	return seatnumbersavailable;

    }

    /*
     * @Override public PendingBooking initPendingBooking(Client client,
     * List<Projection> projections, List<PendingBooking> pendingbookings,
     * ProjectionBooking projectionBooking) throws ParseException { PendingBooking
     * pendingbooking = new PendingBooking();
     * pendingbooking.setStatus("IN PROGRESS");
     * pendingbooking.setNumberofseatschosen(0); pendingbooking.setRownumber(0);
     * pendingbooking.setTotalrate(0); SimpleDateFormat formatter = new
     * SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
     * pendingbooking.setCreationdate(formatter.parse(formatter.format(new
     * Date()))); // pendingbooking.setprojectionbooking(projectionBooking);
     * pendingbooking.setClient(client); long refprojectionbooking =
     * getNumberIDReference(pendingbookings.size());
     * pendingbooking.setRefpendingbooking(refprojectionbooking);
     * 
     * 
     * return pendingbooking; }
     */

    @Override
    public PendingBooking initPendingBooking(Client client, List<Projection> projections,
	    List<PendingBooking> pendingbookings, Projection projection) throws ParseException {
	PendingBooking pendingbooking = new PendingBooking();
	pendingbooking.setStatus("IN PROGRESS");
	pendingbooking.setNumberofseatschosen(0);
	pendingbooking.setRownumber(0);
	pendingbooking.setTotalrate(0);
	SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
	pendingbooking.setCreationdate(formatter.parse(formatter.format(new Date())));
	pendingbooking.setProjection(projection);
	pendingbooking.setClient(client);
	long refprojectionbooking = getNumberIDReference(pendingbookings.size());
	pendingbooking.setRefpendingbooking(refprojectionbooking);

	return pendingbooking;
    }

    @Override
    public Booking initBooking(PendingBooking pendingBooking, List<Booking> bookings) throws ParseException {

	Booking booking = new Booking();

	booking.setClient(pendingBooking.getClient());
	booking.setMeansofpayment(pendingBooking.getMeansofpayment());
	booking.setNumberofseatschosen(pendingBooking.getNumberofseatschosen());
	SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
	booking.setRegistrationdate(formatter.parse(formatter.format(new Date())));
	booking.setRownumber(pendingBooking.getRownumber());
	booking.setTotalrate(pendingBooking.getTotalrate());
	// booking.setprojection(pendingBooking.getprojectionbooking().getprojection());
	booking.setProjection(pendingBooking.getProjection());
	long refbooking = getNumberIDReference(bookings.size());
	booking.setRefbooking(refbooking);

	return booking;

    }

    @Override
    public ProjectionBooking initProjectionBooking(Projection projection, List<ProjectionBooking> projectionBookings) {

	ProjectionBooking projectionbooking = new ProjectionBooking();
	projectionbooking.setProjection(projection);
	projectionbooking.setRefprojectionbooking(getNumberIDReference(projectionBookings.size()));

	return projectionbooking;
    }

    @Override
    public Ticket initTicket(ProjectionBooking projectionbooking, long rownnumber, long refticket, long seatnumber) {

	Ticket ticket = new Ticket();
	ticket.setIsregistered(false);
	ticket.setRownumber(rownnumber);
	ticket.setSeatnumber(seatnumber);

	ticket.setRefticket(refticket);
	ticket.setProjectionbooking(projectionbooking);

	return ticket;

    }

    @Override
    public BookedTicket initBookedTicket(Booking booking, PendingTicket pendingTicket, long refbooking)
	    throws ParseException {

	BookedTicket bookedTicket = new BookedTicket();

	bookedTicket.setNumberofseatschosen(pendingTicket.getNumberofseatschosen());
	bookedTicket.setRate(pendingTicket.getRate());
	bookedTicket.setRownumber(pendingTicket.getRownumber());
	bookedTicket.setSeatnumber(pendingTicket.getSeatnumber());
	SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
	bookedTicket.setRegistrationdate(formatter.parse(formatter.format(new Date())));

	bookedTicket.setRefbookedticket(refbooking);
	bookedTicket.setBooking(booking);

	return bookedTicket;

    }

    @Override
    public HashMap<Rate, Long> getNumberofTicketsByRates(List<Rate> rates, long numberticketsratenormal,
	    long numberticketsrate26, long numberticketsrate14) {
	HashMap<Rate, Long> map = new HashMap<Rate, Long>();

	for (int i = 0; i < rates.size(); i++) {
	    Rate rate = rates.get(i);
	    String type = rates.get(i).getType();

	    if (type.equals("Normal")) {
		map.put(rate, numberticketsratenormal);

	    } else if (type.equals("-26")) {
		map.put(rate, numberticketsrate26);

	    } else if (type.equals("-14")) {
		map.put(rate, numberticketsrate14);
	    }
	}
	return map;
    }

    @Override
    public List<Rate> getListRates(HashMap<Rate, Long> map) {
	List<Rate> ratesTickets = new ArrayList<Rate>();
	for (Entry<Rate, Long> rate : map.entrySet()) {
	    long numberticket = rate.getValue();
	    Rate rateType = rate.getKey();

	    if (rate.getValue() > 0) {
		for (int i = 0; i < numberticket; i++) {
		    Rate rateticket = rateType;
		    ratesTickets.add(rateticket);
		}

	    }
	}
	return ratesTickets;
    }

    @Override
    public double totalrate(HashMap<Rate, Long> map) {
	double totalrate = 0;
	for (Entry<Rate, Long> rate : map.entrySet()) {
	    long numberticket = rate.getValue();
	    Rate rateType = rate.getKey();
	    totalrate += numberticket * rateType.getPrice();
	}
	return totalrate;
    }

    @Override
    public PendingBooking changeStatusToConfirmed(PendingBooking pendingBooking) {
	for (int i = 0; i < pendingBooking.getPendingtickets().size(); i++) {
	    PendingTicket pendingTicket = pendingBooking.getPendingtickets().get(i);
	    pendingTicket.setIsproposed(false);
	}

	return pendingBooking;
    }
}
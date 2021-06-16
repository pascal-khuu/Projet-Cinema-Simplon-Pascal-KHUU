package fr.formation.simploncinema.controllers.booking;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.formation.simploncinema.domain.dtos.booking.PendingBookingDTO;
import fr.formation.simploncinema.service.booking.PendingBookingManagerService;

@RestController
public class PendingBookingManagerController {

    private final PendingBookingManagerService service;

    public PendingBookingManagerController(PendingBookingManagerService service) {
	this.service = service;
    }

    @GetMapping("/pendingbooking/{id}/by-id")

    public Optional<PendingBookingDTO> getPendingBookingById(@PathVariable("id") Long refpendingbooking) {
	System.out.println(" call in controller");
	return service.getPendingBookingById(refpendingbooking);
    }

    @GetMapping("/pendingbookings")

    public List<PendingBookingDTO> findAllPendingBookings() {
	List<PendingBookingDTO> pendingbookings = service.findAllPendingBookings();
	return pendingbookings;
    }

    @DeleteMapping("/pendingbooking/{id}/cancel")

    public void deletePendingBooking(@PathVariable("id") Long refpendingbooking) {
	service.deletePendingBooking(refpendingbooking);
    }

    @PostMapping("/pendingbooking/create/{refclient}/{movietheatername}/{projectiondate}/{moviename}")
    public void createPendingBooking(@PathVariable("refclient") Long refclient,
	    @PathVariable("movietheatername") String movietheatername,
	    @PathVariable("projectiondate") String projectiondate, @PathVariable("moviename") String moviename)
	    throws ParseException {

	SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
	Date parsedDateProjectionDate = formatter.parse(projectiondate);

	service.createPendingBooking(refclient, movietheatername, parsedDateProjectionDate, moviename);
    }

    @PatchMapping("/pendingbooking/{id}/update")
    public void updatePendingBooking(@PathVariable("id") Long id, @RequestBody PendingBookingDTO dto) {
	System.out.println(dto);
	service.updatePendingBooking(id, dto);
    }

    @PatchMapping("/pendingbooking/{id}/{numberseats}/update/by-numberseats")
    public void updatePendingBookingChoixNumberSeats(@PathVariable("id") Long id,
	    @PathVariable("numberseats") Long numberseats) throws ParseException {
	service.updatePendingBookingChoixNumberSeats(id, numberseats);
    }

    @PatchMapping("/pendingbooking/{id}/{numberseats}/{row}/update/by-numberseats-row")
    public void updatePendingBookingChoixNumberSeatsAndRows(@PathVariable("id") Long refpendingbooking,
	    @PathVariable("numberseats") Long numberseats, @PathVariable("row") Long row) throws ParseException {
	service.updatePendingBookingChoixNumberSeatsAndRows(refpendingbooking, numberseats, row);
    }

    @PatchMapping("/pendingbooking/{id}/{meansofpayment}/update/by-meansofpayment")
    public void updatePendingBookingCB(@PathVariable("id") Long refpendingbooking,
	    @PathVariable("meansofpayment") String meansofpayment) throws ParseException {
	service.updatePendingBookingCB(refpendingbooking, meansofpayment);
    }

    @PatchMapping("/pendingbooking/{id}/{nbnormal}/{nb26}/{nb14}/update/by-rates")
    public void updatePendingBookingRates(@PathVariable("id") long refpendingbooking,
	    @PathVariable("nbnormal") long numberticketsratenormal, @PathVariable("nb26") long numberticketsrate26,
	    @PathVariable("nb14") long numberticketsrate14) throws ParseException {
	service.updatePendingBookingRates(refpendingbooking, numberticketsratenormal, numberticketsrate26,
		numberticketsrate14);
    }

}

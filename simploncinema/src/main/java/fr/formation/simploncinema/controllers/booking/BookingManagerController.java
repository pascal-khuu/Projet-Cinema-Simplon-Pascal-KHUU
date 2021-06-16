package fr.formation.simploncinema.controllers.booking;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.formation.simploncinema.domain.dtos.booking.BookingDTO;
import fr.formation.simploncinema.service.booking.BookingManagerService;

@RestController
public class BookingManagerController {

    private final BookingManagerService service;

    public BookingManagerController(BookingManagerService service) {
	this.service = service;
    }

    @GetMapping("/booking/{id}/by-id")

    public Optional<BookingDTO> getBookingById(@PathVariable("id") Long refbooking) {
	System.out.println(" call in controller");
	return service.getBookingById(refbooking);
    }

    @GetMapping("/bookings")

    public List<BookingDTO> findAllBookings() {
	List<BookingDTO> bookings = service.findAllBookings();
	return bookings;
    }

    @DeleteMapping("/booking/{id}/cancel")

    public void deleteBooking(@PathVariable("id") Long refbooking) {
	service.deleteBooking(refbooking);
    }

    @PostMapping("/booking/{idpendingbooking}/create")
    public void createBooking(@PathVariable("idpendingbooking") Long idpendingbooking) throws ParseException {

	service.createBooking(idpendingbooking);
    }

}

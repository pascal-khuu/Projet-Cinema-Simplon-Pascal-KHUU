package fr.formation.simploncinema.controllers.movietheater;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.formation.simploncinema.domain.dtos.movietheater.MeansOfPaymentDTO;
import fr.formation.simploncinema.service.movietheater.MeansOfPaymentService;

@RestController
public class MeansOfPaymentController {

    private final MeansOfPaymentService service;

    public MeansOfPaymentController(MeansOfPaymentService service) {
	this.service = service;
    }

    @GetMapping("/meansofpayment/{id}/by-id")

    public Optional<MeansOfPaymentDTO> getMeansOfPaymentById(@PathVariable("id") Long id) {
	// service=null
	System.out.println(" call in controller");
	return Optional.of(service.getMeansOfPaymentById(id).get());
    }

    @GetMapping("/meansofpayment/{name}")

    public Optional<MeansOfPaymentDTO> getMeansOfPaymentByname(@PathVariable("name") String name) {
	// service=null
	System.out.println(" call in controller");
	return Optional.of(service.getMeansOfPaymentByname(name).get());
    }

    @GetMapping("/meansofpayments")

    public List<MeansOfPaymentDTO> findAllMeansOfPayments() {
	List<MeansOfPaymentDTO> meansofpayments = service.findAllMeansOfPayments();
	return meansofpayments;
    }

    @DeleteMapping("/meansofpayment/{id}/delete")

    public void deleteMeansOfPayment(@PathVariable("id") Long id) {
	service.deleteMeansOfPayment(id);
    }

    @PostMapping("/meansofpayment/create")
    public void createMeansOfPayment(@RequestBody MeansOfPaymentDTO dto) {
	System.out.println(dto);
	service.createMeansOfPayment(dto);
    }

    @PatchMapping("/meansofpayment/{id}/update")
    public void updateMeansOfPayment(@PathVariable("id") Long id, @RequestBody MeansOfPaymentDTO dto) {
	System.out.println(dto);
	service.updateMeansOfPayment(id, dto);
    }
}

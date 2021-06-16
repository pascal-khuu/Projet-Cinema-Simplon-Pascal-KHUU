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

import fr.formation.simploncinema.domain.dtos.movietheater.RateDTO;
import fr.formation.simploncinema.service.movietheater.RateService;

@RestController
public class RateController {

    private final RateService service;

    public RateController(RateService service) {
	this.service = service;
    }

    @GetMapping("/rate/{id}/by-id")

    public Optional<RateDTO> getRateById(@PathVariable("id") Long id) {
	// service=null
	System.out.println(" call in controller");
	return Optional.of(service.getRateById(id).get());
    }

    @GetMapping("/rate/{type}")

    public Optional<RateDTO> getRateByType(@PathVariable("name") String type) {
	// service=null
	System.out.println(" call in controller");
	return Optional.of(service.getRateByType(type).get());
    }

    @GetMapping("/rates")

    public List<RateDTO> findAllRates() {
	List<RateDTO> rates = service.findAllRates();
	return rates;
    }

    @DeleteMapping("/rate/{id}/delete")

    public void deleteRate(@PathVariable("id") Long id) {
	service.deleteRate(id);
    }

    @PostMapping("/rate/create")
    public void createRate(@RequestBody RateDTO dto) {
	System.out.println(dto);
	service.createRate(dto);
    }

    @PatchMapping("/rate/{id}/update")
    public void updateRate(@PathVariable("id") Long id, @RequestBody RateDTO dto) {
	System.out.println(dto);
	service.updateRate(id, dto);
    }
}

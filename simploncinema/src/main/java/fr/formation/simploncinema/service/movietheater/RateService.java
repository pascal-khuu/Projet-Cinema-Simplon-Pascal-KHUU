package fr.formation.simploncinema.service.movietheater;

import java.util.List;
import java.util.Optional;

import fr.formation.simploncinema.domain.dtos.movietheater.MeansOfPaymentDTO;
import fr.formation.simploncinema.domain.dtos.movietheater.RateDTO;

public interface RateService {

	Optional<RateDTO> getRateByType(String type);
	Optional<RateDTO> getRateById(long id);
    
    void createRate(RateDTO dto);
    void deleteRate(long id);
    List<RateDTO> findAllRates();
	void updateRate(long id, RateDTO dto);
	
}

package fr.formation.simploncinema.service.movietheater;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import fr.formation.simploncinema.domain.dtos.movietheater.*;
import fr.formation.simploncinema.domain.entities.movietheater.*;
import fr.formation.simploncinema.repository.movietheater.*;
import fr.formation.simploncinema.utilities.*;



@Service
public class RateServiceImpl extends UtilitiesDataManagerImpl  implements RateService  {

	private final RateRepository repository;

	
	public RateServiceImpl(RateRepository repository) {
		this.repository = repository;
		
	}

	@Override
	public Optional<RateDTO> getRateByType(String type) {
		Rate rate = repository.findByType(type).get();
		RateDTO rateDTO = getRateDTO(rate);
		return Optional.of(rateDTO);
	}

	@Override
	public void createRate(RateDTO dto) {
		Rate rate= getRate(dto);
		repository.save(rate);

	}
	
	@Override
	public void updateRate(long id,RateDTO dto) {
		Rate rate =repository.findById(id).get();
		rate=  getRate(dto);
		repository.save(rate);

	}

	@Override
	public Optional<RateDTO> getRateById(long id) {
		Rate rate = repository.findById(id).get();
		RateDTO rateDTO = getRateDTO(rate);
		return Optional.of(rateDTO);
	}


	@Override
	public void deleteRate(long id) {
		repository.deleteById(id);

	}


	@Override
	public List<RateDTO> findAllRates() {
		List<Rate> rates = repository.findAll();
		List<RateDTO> ratesDTO = getRatesDTO(rates);

		return ratesDTO;
	}

	
	
}

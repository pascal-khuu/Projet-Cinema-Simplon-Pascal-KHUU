package fr.formation.simploncinema.service.movietheater;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import fr.formation.simploncinema.domain.dtos.movietheater.*;
import fr.formation.simploncinema.domain.entities.movietheater.*;
import fr.formation.simploncinema.repository.movietheater.*;
import fr.formation.simploncinema.utilities.*;



@Service
public class MeansOfPaymentServiceImpl extends UtilitiesDataManagerImpl  implements MeansOfPaymentService  {

	private final MeansOfPaymentRepository repository;

	
	public MeansOfPaymentServiceImpl(MeansOfPaymentRepository repository) {
		this.repository = repository;
		
	}

	@Override
	public Optional<MeansOfPaymentDTO> getMeansOfPaymentByname(String name) {
		MeansOfPayment meansOfPayment = repository.findByName(name).get();
		MeansOfPaymentDTO meansOfPaymentDTO = getMeansOfPaymentDTO(meansOfPayment).get();
		return Optional.of(meansOfPaymentDTO);
	}

	@Override
	public Optional<MeansOfPaymentDTO> getMeansOfPaymentById(long id) {
		MeansOfPayment meansOfPayment = repository.findById(id).get();
		MeansOfPaymentDTO meansOfPaymentDTO = getMeansOfPaymentDTO(meansOfPayment).get();
		return Optional.of(meansOfPaymentDTO);
	}

	@Override
	public void createMeansOfPayment(MeansOfPaymentDTO dto) {
		MeansOfPayment meansOfPayment = getMeansOfPayment(dto).get();
		repository.save(meansOfPayment);
		
	}

	@Override
	public void deleteMeansOfPayment(long id) {
		repository.deleteById(id);
		
	}

	@Override
	public List<MeansOfPaymentDTO> findAllMeansOfPayments() {
		List<MeansOfPayment> meansOfPayments = repository.findAll();
		List<MeansOfPaymentDTO> meansOfPaymentsDTO = getMeansOfPaymentDTO(meansOfPayments);

		return meansOfPaymentsDTO;
	}

	@Override
	public void updateMeansOfPayment(long id, MeansOfPaymentDTO dto) {
		MeansOfPayment meansOfPayment =repository.findById(id).get();
		meansOfPayment= getMeansOfPayment(dto).get();
		repository.save(meansOfPayment);

		
	}
	
}

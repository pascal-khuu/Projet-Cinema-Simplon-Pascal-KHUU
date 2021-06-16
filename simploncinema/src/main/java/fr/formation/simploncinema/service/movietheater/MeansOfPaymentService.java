package fr.formation.simploncinema.service.movietheater;

import java.util.List;
import java.util.Optional;

import fr.formation.simploncinema.domain.dtos.movietheater.MeansOfPaymentDTO;

public interface MeansOfPaymentService {

	Optional<MeansOfPaymentDTO> getMeansOfPaymentByname(String name);
	Optional<MeansOfPaymentDTO> getMeansOfPaymentById(long id);
    
    void createMeansOfPayment(MeansOfPaymentDTO dto);
    void deleteMeansOfPayment(long id);
    List<MeansOfPaymentDTO> findAllMeansOfPayments();
	void updateMeansOfPayment(long id, MeansOfPaymentDTO dto);
	
}

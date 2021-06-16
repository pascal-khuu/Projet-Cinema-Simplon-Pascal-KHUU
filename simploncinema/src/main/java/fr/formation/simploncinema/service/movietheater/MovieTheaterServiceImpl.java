package fr.formation.simploncinema.service.movietheater;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import fr.formation.simploncinema.domain.dtos.movietheater.MovieTheaterDTO;
import fr.formation.simploncinema.domain.entities.movietheater.MovieTheater;
import fr.formation.simploncinema.domain.entities.referentials.Address;
import fr.formation.simploncinema.repository.movietheater.MovieTheaterRepository;
import fr.formation.simploncinema.repository.referentials.AddressRepository;
import fr.formation.simploncinema.utilities.UtilitiesDataManagerImpl;



@Service
public class MovieTheaterServiceImpl extends UtilitiesDataManagerImpl  implements MovieTheaterService  {

	private final MovieTheaterRepository repositoryMovieTheater;
	private final AddressRepository repositoryAddress;

	
	
	

	public MovieTheaterServiceImpl(MovieTheaterRepository repositoryMovieTheater,
		AddressRepository repositoryAddress) {
	    super();
	    this.repositoryMovieTheater = repositoryMovieTheater;
	    this.repositoryAddress = repositoryAddress;
	}

	public MovieTheaterRepository getRepositoryMovieTheater() {
	    return repositoryMovieTheater;
	}

	public AddressRepository getRepositoryAddress() {
	    return repositoryAddress;
	}

	@Override
	public Optional<MovieTheaterDTO> getMovietheaterByMovietheatername(String movietheatername) {
		MovieTheater movietheater = repositoryMovieTheater.findByMovietheatername(movietheatername).get();
		MovieTheaterDTO movietheaterDTO = getMovieTheaterDTO(movietheater);
		return Optional.of(movietheaterDTO);
	}

	@Override
	public void createMovietheater(MovieTheaterDTO dto) {
		//MovieTheater movietheater = getMovieTheater(dto);
	    	MovieTheater movietheater = new MovieTheater();
	    	movietheater.setMovietheatername(dto.getMovietheatername());
	    	Long addressId = dto.getAddressId();
	    	Address address = repositoryAddress.getOne(addressId);
	    	movietheater.setAddress(address);
	    	repositoryMovieTheater.save(movietheater);
	}
	
	@Override
	public void updateMovietheater(long id,MovieTheaterDTO dto) {
		MovieTheater movietheater =repositoryMovieTheater.findById(id).get();
		movietheater= getMovieTheater(dto);
		repositoryMovieTheater.save(movietheater);

	}

	@Override
	public Optional<MovieTheaterDTO> getMovietheaterById(long id) {
		MovieTheater movietheater = repositoryMovieTheater.findById(id).get();
		MovieTheaterDTO movietheaterDTO = getMovieTheaterDTO(movietheater);
		return Optional.of(movietheaterDTO);
	}


	@Override
	public void deleteMovietheater(long id) {
		repositoryMovieTheater.deleteById(id);

	}


	@Override
	public List<MovieTheaterDTO> findAllMovietheaters() {
		List<MovieTheater> movietheaters = repositoryMovieTheater.findAll();
		List<MovieTheaterDTO> movietheatersDTO = getMovieTheatersDTO(movietheaters);

		return movietheatersDTO;
	}
	
}

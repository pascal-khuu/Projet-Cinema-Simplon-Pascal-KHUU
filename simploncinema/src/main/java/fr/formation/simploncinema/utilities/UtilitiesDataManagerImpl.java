package fr.formation.simploncinema.utilities;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import fr.formation.simploncinema.domain.dtos.movietheater.MeansOfPaymentDTO;
import fr.formation.simploncinema.domain.dtos.movietheater.MovieDTO;
import fr.formation.simploncinema.domain.dtos.movietheater.MovieTheaterDTO;
import fr.formation.simploncinema.domain.dtos.movietheater.MovieTypeDTO;
import fr.formation.simploncinema.domain.dtos.movietheater.ProjectionDTO;
import fr.formation.simploncinema.domain.dtos.movietheater.RateDTO;
import fr.formation.simploncinema.domain.dtos.movietheater.RoomDTO;
import fr.formation.simploncinema.domain.dtos.referentials.AddressDTO;
import fr.formation.simploncinema.domain.dtos.referentials.CityDTO;
import fr.formation.simploncinema.domain.dtos.referentials.ClientDTO;
import fr.formation.simploncinema.domain.entities.movietheater.MeansOfPayment;
import fr.formation.simploncinema.domain.entities.movietheater.Movie;
import fr.formation.simploncinema.domain.entities.movietheater.MovieTheater;
import fr.formation.simploncinema.domain.entities.movietheater.MovieType;
import fr.formation.simploncinema.domain.entities.movietheater.Projection;
import fr.formation.simploncinema.domain.entities.movietheater.Rate;
import fr.formation.simploncinema.domain.entities.movietheater.Room;
import fr.formation.simploncinema.domain.entities.referentials.Address;
import fr.formation.simploncinema.domain.entities.referentials.City;
import fr.formation.simploncinema.domain.entities.referentials.Client;

public class UtilitiesDataManagerImpl implements UtilitiesDataManager {

	@Override
	public List<ProjectionDTO> getProjectionsDTO(List<Projection> projections) {
		ArrayList<ProjectionDTO> projectionsDTO = new ArrayList<ProjectionDTO>();

		for (int i = 0; i < projections.size(); i++) {

			ProjectionDTO projectionDTO = getProjectionDTO(projections.get(i));
			projectionsDTO.add(projectionDTO);
		}
		return projectionsDTO;
	}

	@Override
	public List<RoomDTO> getRoomsDTO(List<Room> rooms) {
		ArrayList<RoomDTO> roomsDTO = new ArrayList<RoomDTO>();
		for (int i = 0; i < rooms.size(); i++) {
			RoomDTO roomDTO = getRoomDTO(rooms.get(i), rooms.get(i).getMovietheater());
			roomsDTO.add(roomDTO);
		}
		return roomsDTO;
	}

	@Override
	public List<MovieTypeDTO> getMovietypesDTO(List<MovieType> movietypes) {
		ArrayList<MovieTypeDTO> movietypesDTO = new ArrayList<MovieTypeDTO>();
		for (int i = 0; i < movietypes.size(); i++) {
			MovieTypeDTO movietypeDTO = getMovieTypeDTO(movietypes.get(i));
			movietypesDTO.add(movietypeDTO);
		}
		return movietypesDTO;
	}

	@Override
	public List<MovieTheaterDTO> getMovieTheatersDTO(List<MovieTheater> movietheaters) {
		ArrayList<MovieTheaterDTO> movieTheatersDTO = new ArrayList<MovieTheaterDTO>();
		for (int i = 0; i < movietheaters.size(); i++) {
			MovieTheaterDTO movietheaterDTO = getMovieTheaterDTO(movietheaters.get(i));
			movieTheatersDTO.add(movietheaterDTO);
		}
		return movieTheatersDTO;
	}

	@Override
	public List<MovieDTO> getMoviesDTO(List<Movie> movies) {
		ArrayList<MovieDTO> moviesDTO = new ArrayList<MovieDTO>();
		for (int i = 0; i < movies.size(); i++) {
			MovieDTO movieDTO = getMovieDTO(movies.get(i), movies.get(i).getMovietype());
			moviesDTO.add(movieDTO);
		}
		return moviesDTO;
	}

	@Override
	public ProjectionDTO getProjectionDTO(Projection projection) {
		ProjectionDTO projectionDTO = new ProjectionDTO();
		projectionDTO.setRoom(getRoomDTO(projection.getRoom(), projection.getMovieTheater()));
		projectionDTO.setMovieTheater(getMovieTheaterDTO(projection.getMovieTheater()));
		projectionDTO.setMovie(getMovieDTO(projection.getMovie(), projection.getMovie().getMovietype()));
		projectionDTO.setVersion(projection.getVersion());
		projectionDTO.setProjectiondate(projection.getProjectiondate());
		projectionDTO.setStarthour(projection.getStarthour());
		projectionDTO.setEndhour(projection.getEndhour());

		return projectionDTO;
	}

	@Override
	public MovieTheaterDTO getMovieTheaterDTO(MovieTheater movietheater) {
		MovieTheaterDTO movietheaterDTO = new MovieTheaterDTO();
		movietheaterDTO.setMovietheatername(movietheater.getMovietheatername());
		
		//movietheaterDTO.setAddress(getAddressDTO(movietheater.getAddress(), movietheater.getAddress().getCity()));
		return movietheaterDTO;
	}

	@Override
	public RoomDTO getRoomDTO(Room room, MovieTheater movietheater) {
		RoomDTO roomDTO = new RoomDTO();
		roomDTO.setNumberofrows(room.getNumberofrows());
		roomDTO.setTotalofseats(room.getTotalofseats());
		roomDTO.setRoomnumber(room.getRoomnumber());
		roomDTO.setNumberofseatsbyrow(room.getNumberofseatsbyrow());
		roomDTO.setMovietheater(getMovieTheaterDTO(movietheater));
		return roomDTO;
	}

	@Override
	public MovieDTO getMovieDTO(Movie movie, MovieType movietype) {
		MovieDTO movieDTO = new MovieDTO();
		movieDTO.setMoviename(movie.getMoviename());
		movieDTO.setMoviedescription(movie.getMoviedescription());
		movieDTO.setDuration(movie.getDuration());
		movieDTO.setReleasedate(movie.getReleasedate());
		movieDTO.setMovietype(getMovieTypeDTO(movietype));
		return movieDTO;
	}

	@Override
	public MovieTypeDTO getMovieTypeDTO(MovieType movietype) {
		MovieTypeDTO movieTypeDTO = new MovieTypeDTO();
		movieTypeDTO.setType(movietype.getType());

		return movieTypeDTO;
	}

	@Override
	public Projection getProjection(ProjectionDTO projectionDTO) {
		Projection projection = new Projection();
		projection.setRoom(getRoom(projectionDTO.getRoom(), projectionDTO.getMovieTheater()));
		projection.setMovieTheater(getMovieTheater(projectionDTO.getMovieTheater()));
		projection.setMovie(getMovie(projectionDTO.getMovie(), projectionDTO.getMovie().getMovietype()));
		projection.setVersion(projectionDTO.getVersion());
		projection.setProjectiondate(projectionDTO.getProjectiondate());
		projection.setStarthour(projectionDTO.getStarthour());
		projection.setEndhour(projectionDTO.getEndhour());

		return projection;
	}

	@Override
	public Room getRoom(RoomDTO roomDTO, MovieTheaterDTO movietheaterDTO) {
		Room room = new Room();
		room.setNumberofrows(roomDTO.getNumberofrows());
		room.setTotalofseats(roomDTO.getTotalofseats());
		room.setRoomnumber(roomDTO.getRoomnumber());
		room.setNumberofseatsbyrow(roomDTO.getNumberofseatsbyrow());
		room.setMovietheater(getMovieTheater(movietheaterDTO));
		return room;
	}

	@Override
	public Movie getMovie(MovieDTO movieDTO, MovieTypeDTO movietypeDTO) {
		Movie movie = new Movie();
		movie.setMoviename(movieDTO.getMoviename());
		movie.setMoviedescription(movieDTO.getMoviedescription());
		movie.setDuration(movieDTO.getDuration());
		movie.setReleasedate(movieDTO.getReleasedate());
		movie.setMovietype(getMovieType(movietypeDTO));
		return movie;
	}

	@Override
	public MovieType getMovieType(MovieTypeDTO movietypeDTO) {
		MovieType movieType = new MovieType();
		movieType.setType(movietypeDTO.getType());

		return movieType;
	}

	@Override
	public MovieTheater getMovieTheater(MovieTheaterDTO movietheaterDTO) {
		MovieTheater movietheater = new MovieTheater();
		movietheater.setMovietheatername(movietheaterDTO.getMovietheatername());
		//movietheater.setAddress(getAddress(movietheaterDTO.getAddress(), movietheaterDTO.getAddress().getCity()));
		return movietheater;
	}

	@Override
	public ArrayList<RateDTO> getRatesDTO(List<Rate> rates) {
		ArrayList<RateDTO> ratesDTO = new ArrayList<RateDTO>();
		for (int i = 0; i < rates.size(); i++) {
			RateDTO rateDTO = getRateDTO(rates.get(i));
			ratesDTO.add(rateDTO);
		}
		return ratesDTO;
	}

	@Override
	public ArrayList<MeansOfPaymentDTO> getMeansOfPaymentDTO(List<MeansOfPayment> meansofpayments) {
		ArrayList<MeansOfPaymentDTO> meansOfPaymentsDTO = new ArrayList<MeansOfPaymentDTO>();
		for (int i = 0; i < meansofpayments.size(); i++) {
			MeansOfPaymentDTO meansOfPaymentDTO = getMeansOfPaymentDTO(meansofpayments.get(i)).get();
			meansOfPaymentsDTO.add(meansOfPaymentDTO);
		}
		return meansOfPaymentsDTO;
	}

	@Override
	public RateDTO getRateDTO(Rate rate) {
		RateDTO rateDTO = new RateDTO();
		rateDTO.setPrice(rate.getPrice());
		rateDTO.setType(rate.getType());
		return rateDTO;
	}

	@Override
	public Optional<MeansOfPaymentDTO> getMeansOfPaymentDTO(MeansOfPayment meansOfPayment) {
		MeansOfPaymentDTO meansOfPaymentDTO = new MeansOfPaymentDTO();
		if (meansOfPayment != null) {
			meansOfPaymentDTO.setName(meansOfPayment.getName());
		}
		return Optional.of(meansOfPaymentDTO);
	}

	@Override
	public Rate getRate(RateDTO rateDTO) {
		Rate rate = new Rate();
		rate.setPrice(rateDTO.getPrice());
		rate.setType(rateDTO.getType());
		return rate;
	}

	@Override
	public Optional<MeansOfPayment> getMeansOfPayment(MeansOfPaymentDTO meansOfPaymentDTO) {
		MeansOfPayment meansOfPayment = new MeansOfPayment();
		if (meansOfPaymentDTO != null) {
			meansOfPayment.setName(meansOfPaymentDTO.getName());
		}
		return Optional.of(meansOfPayment);
	}

	@Override
	public ArrayList<ClientDTO> getClientsDTO(List<Client> clients) {
		ArrayList<ClientDTO> clientsDTO = new ArrayList<ClientDTO>();
		for (int i = 0; i < clients.size(); i++) {
			ClientDTO clientDTO = getClientDTO(clients.get(i), clients.get(i).getAddress());
			clientsDTO.add(clientDTO);
		}
		return clientsDTO;
	}

	@Override
	public ArrayList<CityDTO> getCitiesDTO(List<City> cities) {
		ArrayList<CityDTO> citiesDTO = new ArrayList<CityDTO>();
		for (int i = 0; i < cities.size(); i++) {
			CityDTO cityDTO = getCityDTO(cities.get(i));
			citiesDTO.add(cityDTO);

		}
		return citiesDTO;
	}

	@Override
	public ArrayList<AddressDTO> getAddressesDTO(List<Address> addresses) {
		ArrayList<AddressDTO> addressesDTO = new ArrayList<AddressDTO>();
		for (int i = 0; i < addresses.size(); i++) {
			AddressDTO addressDTO = getAddressDTO(addresses.get(i), addresses.get(i).getCity());
			addressesDTO.add(addressDTO);

		}
		return addressesDTO;
	}

	@Override
	public ClientDTO getClientDTO(Client client, Address address) {
		ClientDTO clientDTO = new ClientDTO();
		clientDTO.setRefclient(client.getRefclient());
		clientDTO.setFirstname(client.getFirstname());
		clientDTO.setLastname(client.getLastname());
		clientDTO.setMail(client.getMail());
		clientDTO.setPassword(client.getPassword());
		clientDTO.setGender(client.getGender());
		clientDTO.setMobilephone(client.getMobilephone());
		clientDTO.setBirthdate(client.getBirthdate());
		clientDTO.setSubscriptiondate(client.getSubscriptiondate());
		clientDTO.setNotificationmessage(client.getNotificationmessage());
		clientDTO.setMailmessage(client.getMailmessage());
		clientDTO.setAddress(getAddressDTO(address, address.getCity()));

		return clientDTO;
	}

	@Override
	public CityDTO getCityDTO(City city) {
		CityDTO cityDTO = new CityDTO();
		cityDTO.setCityname(city.getCityname());
		return cityDTO;
	}

	@Override
	public AddressDTO getAddressDTO(Address address, City city) {
		AddressDTO addressDTO = new AddressDTO();
		addressDTO.setCity(getCityDTO(city));
		addressDTO.setCountry(address.getCountry());
		addressDTO.setPostalcode(address.getPostalcode());
		addressDTO.setStreet_number(address.getStreet_number());
		addressDTO.setStreetype(address.getStreetype());

		return addressDTO;
	}

	@Override
	public Client getClient(ClientDTO clientDTO, AddressDTO addressDTO) {
		Client client = new Client();
		client.setRefclient(clientDTO.getRefclient());
		client.setFirstname(clientDTO.getFirstname());
		client.setLastname(clientDTO.getLastname());
		client.setMail(clientDTO.getMail());
		client.setPassword(clientDTO.getPassword());
		client.setGender(clientDTO.getGender());
		client.setMobilephone(clientDTO.getMobilephone());
		client.setBirthdate(clientDTO.getBirthdate());
		client.setSubscriptiondate(clientDTO.getSubscriptiondate());
		client.setNotificationmessage(clientDTO.getNotificationmessage());
		client.setMailmessage(clientDTO.getMailmessage());
		client.setAddress(getAddress(addressDTO, addressDTO.getCity()));

		return client;
	}

	@Override
	public City getCity(CityDTO cityDTO) {
		City city = new City();
		city.setCityname(cityDTO.getCityname());
		return city;
	}

	@Override
	public Address getAddress(AddressDTO addressDTO, CityDTO cityDTO) {
		Address address = new Address();
		address.setCity(getCity(cityDTO));
		address.setCountry(addressDTO.getCountry());
		address.setPostalcode(addressDTO.getPostalcode());
		address.setStreet_number(addressDTO.getStreet_number());
		address.setStreetype(addressDTO.getStreetype());
		return address;
	}

}

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

public interface UtilitiesDataManager {

    // Algo conversion de Entities vers DTO
    List<ProjectionDTO> getProjectionsDTO(List<Projection> sessions);
    List<RoomDTO> getRoomsDTO(List<Room> rooms);
    List<MovieTypeDTO> getMovietypesDTO(List<MovieType> movietypes);
    List<MovieTheaterDTO> getMovieTheatersDTO(List<MovieTheater> movietheaters);
    List<MovieDTO> getMoviesDTO(List<Movie> movies);
    ProjectionDTO getProjectionDTO(Projection session);
    RoomDTO getRoomDTO(Room room, MovieTheater movietheater);
    MovieDTO getMovieDTO(Movie movie, MovieType movietype);
    MovieTypeDTO getMovieTypeDTO(MovieType movietype);
    MovieTheaterDTO getMovieTheaterDTO(MovieTheater movietheater);
    ArrayList<RateDTO> getRatesDTO(List<Rate> rates);
    ArrayList<MeansOfPaymentDTO> getMeansOfPaymentDTO(List<MeansOfPayment> meansofpayments);
    RateDTO getRateDTO(Rate rate);
    Optional<MeansOfPaymentDTO> getMeansOfPaymentDTO(MeansOfPayment meansOfPayment);
    List<ClientDTO> getClientsDTO(List<Client> clients);
    List<CityDTO> getCitiesDTO(List<City> cities);
    List<AddressDTO> getAddressesDTO(List<Address> addresses);
    ClientDTO getClientDTO(Client client, Address address);
    CityDTO getCityDTO(City city);
    AddressDTO getAddressDTO(Address address, City city);

    // Algo conversion de DTO vers Entities
    Projection getProjection(ProjectionDTO sessionDTO);
    Room getRoom(RoomDTO roomDTO, MovieTheaterDTO movietheaterDTO);
    Movie getMovie(MovieDTO movieDTO, MovieTypeDTO movietypeDTO);
    MovieType getMovieType(MovieTypeDTO movietypeDTO);
    MovieTheater getMovieTheater(MovieTheaterDTO movietheaterDTO);
    Rate getRate(RateDTO rateDTO);
    Optional<MeansOfPayment> getMeansOfPayment(MeansOfPaymentDTO meansOfPaymentDTO);
    Client getClient(ClientDTO clientDTO, AddressDTO addressDTO);
    City getCity(CityDTO cityDTO);
    Address getAddress(AddressDTO addressDTO, CityDTO cityDTO);

}

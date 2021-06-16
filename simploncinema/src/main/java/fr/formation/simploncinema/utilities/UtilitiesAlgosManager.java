 package fr.formation.simploncinema.utilities;

import java.text.ParseException;
import java.util.HashMap;
import java.util.List;

import fr.formation.simploncinema.domain.entities.booking.BookedTicket;
import fr.formation.simploncinema.domain.entities.booking.Booking;
import fr.formation.simploncinema.domain.entities.booking.PendingBooking;
import fr.formation.simploncinema.domain.entities.booking.PendingTicket;
import fr.formation.simploncinema.domain.entities.booking.ProjectionBooking;
import fr.formation.simploncinema.domain.entities.booking.Ticket;
import fr.formation.simploncinema.domain.entities.movietheater.Projection;
import fr.formation.simploncinema.domain.entities.movietheater.Rate;
import fr.formation.simploncinema.domain.entities.referentials.Client;

public interface UtilitiesAlgosManager {

    // Algo permettant de retourner l'ID de reference d'un nouvel objet
    long getNumberIDReference(long size);

    // Algo permettant d'initialiser une séance de réservation (à partir d'une
    // séance et d'une liste de séances de réservations)
    ProjectionBooking initProjectionBooking(Projection projection, List<ProjectionBooking> projectionBookings);

    // Algo permettant d'initialiser une réservation en cours (à partir d'un
    // client, d'une liste de séances, d'une liste
    // de réservations en cours et d'une séance)
    PendingBooking initPendingBooking(Client client, List<Projection> projections, List<PendingBooking> pendingbookings,
	    Projection projection) throws ParseException;

    // Algo permettant d'initialiser un ticket de cinéma
    Ticket initTicket(ProjectionBooking projectionbooking, long rownnumber, long refticket, long seatnumber);

    // Algo permettant de retourner le nombre de tickets par tarif avec un HashMap
    // (tarif, nombre de tickets)
    public HashMap<Rate, Long> getNumberofTicketsByRates(List<Rate> rates, long numberticketsratenormal,
	    long numberticketsrate26, long numberticketsrate14);

    // Algo permettant de retourner la liste de tarifs à partir d'un hashmap (tarif,
    // nombre de tickets)
    public List<Rate> getListRates(HashMap<Rate, Long> map);

    // Algo permettant de retourner le total d'un tarif à partir d'un hashmap
    // (tarif, nombre de tickets)
    public double totalrate(HashMap<Rate, Long> map);

    // Algo permettant de changer le statut d'une réservation en cours à CONFIRME
    PendingBooking changeStatusToConfirmed(PendingBooking pendingBooking);

    // Algo permettant d'initialiser une réservation à partir d'une réservation en
    // cours et d'une liste de réservations)
    Booking initBooking(PendingBooking pendingBooking, List<Booking> bookings) throws ParseException;

    // Algo permettant d'initialiser un ticket réservé à partir d'une réservation,
    // d'un ticket en cours et d'un id de référence de réservation
    BookedTicket initBookedTicket(Booking booking, PendingTicket pendingTicket, long refbooking) throws ParseException;

    // Algo permettant d'initialiser d'un ticket en cours à partir d'une réservation
    // en cours, d'un nombre de sièges et d'un id de référence de ticket)
    PendingTicket initPendingTicket(PendingBooking pendingbooking, long numberseats, long refpendingticket)
	    throws ParseException;

    // Algo permettant de MAJ une réservation en cours avec le choix de la rangée en
    // fonction d'une séance de réservation
    PendingBooking updatePendingTicketsWithChoiceRow(PendingBooking pendingbooking, long row,
	    ProjectionBooking projectionBooking) throws ParseException;
}

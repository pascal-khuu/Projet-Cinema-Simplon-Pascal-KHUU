package fr.formation.simploncinema.repository.booking;


import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.simploncinema.domain.entities.booking.*;

public interface PendingTicketRepository extends JpaRepository<PendingTicket, Long> {

}

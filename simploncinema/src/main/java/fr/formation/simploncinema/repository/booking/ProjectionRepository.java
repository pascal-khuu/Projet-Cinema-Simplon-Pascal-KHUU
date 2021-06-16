package fr.formation.simploncinema.repository.booking;


import java.util.ArrayList;
import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.simploncinema.domain.entities.movietheater.*;

public interface ProjectionRepository extends JpaRepository<Projection, Long> {

    ArrayList<Projection> findByProjectiondate(Date projectiondate);
}

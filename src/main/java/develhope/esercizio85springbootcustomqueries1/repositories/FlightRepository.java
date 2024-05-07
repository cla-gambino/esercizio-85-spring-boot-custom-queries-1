package develhope.esercizio85springbootcustomqueries1.repositories;

import develhope.esercizio85springbootcustomqueries1.entities.Flight;
import develhope.esercizio85springbootcustomqueries1.entities.FlightStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {
    List<Flight> findAllByStatus(FlightStatus status);
}

package develhope.esercizio85springbootcustomqueries1.repositories;

import develhope.esercizio85springbootcustomqueries1.entities.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {
}

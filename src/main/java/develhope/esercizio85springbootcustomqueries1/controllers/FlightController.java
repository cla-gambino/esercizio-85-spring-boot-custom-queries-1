package develhope.esercizio85springbootcustomqueries1.controllers;

import develhope.esercizio85springbootcustomqueries1.entities.Flight;
import develhope.esercizio85springbootcustomqueries1.entities.FlightStatus;
import develhope.esercizio85springbootcustomqueries1.services.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/flights")
public class FlightController {

    @Autowired
    FlightService flightService;

    @GetMapping("/create-flights")
    public List<Flight> createFlights() {
        return flightService.createFlights(50);
    }

    @GetMapping("/all-flights")
    public List<Flight> getAllFlights() {
        return flightService.getAllFlights();
    }

    @GetMapping("/by-status")
    public List<Flight> getFlightsByStatus(@RequestParam("status") FlightStatus status) {
        return flightService.getFlightsByStatus(status);
    }
}

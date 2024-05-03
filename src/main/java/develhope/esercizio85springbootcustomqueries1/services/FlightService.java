package develhope.esercizio85springbootcustomqueries1.services;


import develhope.esercizio85springbootcustomqueries1.entities.Flight;
import develhope.esercizio85springbootcustomqueries1.entities.FlightStatus;
import develhope.esercizio85springbootcustomqueries1.repositories.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


@Service
public class FlightService {

    @Autowired
    FlightRepository flightRepository;

    public List<Flight> createFlights(int count) {
        Random random = new Random();
        List<Flight> flights = IntStream.range(0, count)
                .mapToObj(i -> {
                    Flight flight = new Flight();
                    flight.setDescription("Flight " + i);
                    flight.setFromAirpoirt(generateAirportCode());
                    flight.setToAirport(generateAirportCode());
                    flight.setStatus(FlightStatus.ON_TIME);
                    return flight;
                })
                .collect(Collectors.toList());
        return flightRepository.saveAll(flights);
    }

    public List<Flight> getAllFlights() {
        return flightRepository.findAll();
    }

    private String generateAirportCode() {
        Random random = new Random();
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            sb.append(alphabet.charAt(random.nextInt(alphabet.length())));
        }
        return sb.toString();
    }
}

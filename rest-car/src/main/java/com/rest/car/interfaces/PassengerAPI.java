package com.rest.car.interfaces;

import com.rest.car.domain.Passenger;
import com.rest.car.domain.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
@RestController
@RequestMapping(path = "/passengers", produces = MediaType.APPLICATION_JSON_VALUE)
public class PassengerAPI {

    @Autowired
    public PassengerRepository passengerRepository;

    @GetMapping()
    public List<Passenger> listPassengers() {
        return passengerRepository.findAll();
    }

    @GetMapping("/{id}")
    public Passenger findPassenger(@PathVariable Long id) {
        return passengerRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PostMapping()
    public Passenger createPassenger(@RequestBody Passenger passenger) {
        return passengerRepository.save(passenger);
    }

    @PutMapping("/{id}")
    public Passenger fullUpdatePassenger(@PathVariable Long id, @RequestBody Passenger passenger) {
        Passenger foundPassenger = findPassenger(id);

        foundPassenger.setName(passenger.getName());

        return passengerRepository.save(foundPassenger);
    }

    @PatchMapping("/{id}")
    public Passenger updatePassenger(@PathVariable Long id, @RequestBody Passenger passenger) {
        Passenger foundPassenger = findPassenger(id);

        foundPassenger.setName(Optional.ofNullable(passenger.getName()).orElse(foundPassenger.getName()));

        return passengerRepository.save(foundPassenger);
    }

    @DeleteMapping("/{id}")
    public void deletePassenger(@PathVariable Long id) {
        passengerRepository.delete(findPassenger(id));
    }
}

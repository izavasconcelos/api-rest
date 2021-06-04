package com.rest.car.interfaces.incoming;

import com.rest.car.domain.Driver;
import com.rest.car.domain.DriverRepository;
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
@RequestMapping(path = "/drivers", produces = MediaType.APPLICATION_JSON_VALUE)
public class DriverAPI {

    @Autowired
    public DriverRepository driverRepository;

    @GetMapping()
    public List<Driver> listDrivers() {
        return driverRepository.findAll();
    }

    @GetMapping("/{id}")
    public Driver findDriver(@PathVariable Long id) {
        return driverRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PostMapping()
    public Driver createDriver(@RequestBody Driver driver) {
        return driverRepository.save(driver);
    }

    @PutMapping("/{id}")
    public Driver fullUpdateDriver(@PathVariable Long id, @RequestBody Driver driver) {
        Driver foundDriver = findDriver(id);

        foundDriver.setBirthDate(driver.getBirthDate());
        foundDriver.setName(driver.getName());

        return driverRepository.save(foundDriver);
    }

    @PatchMapping("/{id}")
    public Driver updateDriver(@PathVariable Long id, @RequestBody Driver driver) {
        Driver foundDriver = findDriver(id);

        foundDriver.setBirthDate(Optional.ofNullable(driver.getBirthDate()).orElse(foundDriver.getBirthDate()));
        foundDriver.setName(Optional.ofNullable(driver.getName()).orElse(foundDriver.getName()));

        return driverRepository.save(foundDriver);
    }

    @DeleteMapping("/{id}")
    public void deleteDriver(@PathVariable Long id) {
        driverRepository.delete(findDriver(id));
    }
}

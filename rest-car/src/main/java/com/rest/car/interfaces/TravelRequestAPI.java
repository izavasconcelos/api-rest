package com.rest.car.interfaces;

import com.rest.car.domain.TravelService;
import com.rest.car.interfaces.input.TravelRequestInput;
import com.rest.car.interfaces.mapping.TravelRequestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Service
@RestController
@RequestMapping(path = "/travelRequests", produces = MediaType.APPLICATION_JSON_VALUE)
public class TravelRequestAPI {

    @Autowired
    private TravelService travelService;

    @Autowired
    private TravelRequestMapper mapper;

    @PostMapping
    public void makeTravelRequest(@RequestBody TravelRequestInput travelRequestInput) {
        travelService.saveTravelRequest(mapper.map(travelRequestInput));
    }
}

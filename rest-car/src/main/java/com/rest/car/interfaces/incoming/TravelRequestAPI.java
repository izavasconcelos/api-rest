package com.rest.car.interfaces.incoming;

import com.rest.car.domain.TravelRequest;
import com.rest.car.domain.TravelService;
import com.rest.car.interfaces.incoming.input.TravelRequestInput;
import com.rest.car.interfaces.incoming.mapping.TravelRequestMapper;
import com.rest.car.interfaces.incoming.output.TravelRequestOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
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
    public EntityModel<TravelRequestOutput> makeTravelRequest(@RequestBody TravelRequestInput travelRequestInput) {
        TravelRequest request = travelService.saveTravelRequest(mapper.map(travelRequestInput));
        TravelRequestOutput output = mapper.map(request);

        return mapper.buildOutputModel(request, output);
    }
}

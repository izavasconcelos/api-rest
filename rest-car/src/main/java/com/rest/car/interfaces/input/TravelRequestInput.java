package com.rest.car.interfaces.input;

import lombok.Data;

@Data
public class TravelRequestInput {

    private Long passengerId;
    private String origin;
    private String destination;
}

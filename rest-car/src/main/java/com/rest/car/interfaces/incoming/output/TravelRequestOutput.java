package com.rest.car.interfaces.incoming.output;

import com.rest.car.domain.TravelRequestStatus;
import lombok.Data;

import java.util.Date;

@Data
public class TravelRequestOutput {

    private Long id;
    private String origin;
    private String destination;
    private TravelRequestStatus status;
    private Date creationDate;
}

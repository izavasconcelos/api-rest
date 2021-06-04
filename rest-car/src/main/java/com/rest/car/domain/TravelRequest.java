package com.rest.car.domain;

import com.rest.car.domain.Passenger;
import com.rest.car.domain.TravelRequestStatus;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class TravelRequest {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Passenger passenger;
    private String origin;
    private String destination;

    @Enumerated(EnumType.STRING)
    private TravelRequestStatus status;
    private Date creationDate;
}

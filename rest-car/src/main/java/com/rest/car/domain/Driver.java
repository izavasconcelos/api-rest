package com.rest.car.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Data
@Entity
public class Driver {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private Date birthDate;
}

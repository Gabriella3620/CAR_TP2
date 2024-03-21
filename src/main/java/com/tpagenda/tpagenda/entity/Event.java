package com.tpagenda.tpagenda.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Event {

    @Id
    @GeneratedValue
    private Long id;

    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;

    private String description;

}

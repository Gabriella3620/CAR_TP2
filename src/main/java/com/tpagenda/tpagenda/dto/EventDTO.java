package com.tpagenda.tpagenda.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;


@Data
@AllArgsConstructor
public class EventDTO {
    private Long id;

    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;

    private String description;
    private String agendaName;
}

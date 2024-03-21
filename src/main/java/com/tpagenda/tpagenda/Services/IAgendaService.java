package com.tpagenda.tpagenda.Services;

import org.springframework.stereotype.Service;

import com.tpagenda.tpagenda.entity.Agenda;

import java.util.List;

@Service
public interface IAgendaService {
    void addAgenda(String email, String nom);

    Iterable<Agenda> getAllAgenda();

    List<Agenda> getAgendaByEmail(String email);

}

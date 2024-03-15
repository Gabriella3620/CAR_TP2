package com.tpagenda.tpagenda.Services;
import org.springframework.stereotype.Service;

import com.tpagenda.tpagenda.Agenda;

import java.util.List;


@Service
public interface AgendaService {
    void addAgenda(String email, String nom);
    Iterable<Agenda> getAllAgenda();

    List<Agenda> getAgendaByEmail(String email);

}


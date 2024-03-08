package com.example.demo.Services;

import com.example.demo.Agenda;

import org.springframework.stereotype.Service;

@Service
public interface AgendaService {
    void ajouterAgenda(String nom);

    Iterable<Agenda> getAllAgenda();
}

package com.tpagenda.tpagenda.Repository;

import java.util.List;

import com.tpagenda.tpagenda.dto.EventDTO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tpagenda.tpagenda.entity.Agenda;
import com.tpagenda.tpagenda.entity.Personne;

@Repository
public interface AgendaRepository extends CrudRepository<Agenda, String> {
    List<Agenda> findByPersonne(Personne personne);

    Agenda findByNom(String nom);

    @Query("SELECT DISTINCT new com.tpagenda.tpagenda.dto.EventDTO(event.id, event.startDateTime, event.endDateTime, event.description, a.nom) FROM Agenda a INNER join a.events event WHERE a.nom=:name")
    List<EventDTO> findAllByNom(String name);
}

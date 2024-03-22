package com.tpagenda.tpagenda.Services.implementation;

import com.tpagenda.tpagenda.Repository.EventRepository;
import com.tpagenda.tpagenda.Services.IAgendaService;
import com.tpagenda.tpagenda.dto.EventDTO;
import com.tpagenda.tpagenda.entity.Agenda;
import com.tpagenda.tpagenda.entity.Event;
import com.tpagenda.tpagenda.entity.Personne;
import com.tpagenda.tpagenda.Repository.AgendaRepository;
import com.tpagenda.tpagenda.Repository.PersonneRepository;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AgendaServiceImpl implements IAgendaService {
    @Autowired
    private AgendaRepository agendaRepository;

    @Autowired
    private EventRepository eventRepository;

    @Override
    public Iterable<Agenda> getAllAgenda() {
        return agendaRepository.findAll();
    }

    @Override
    public void addAgenda(String email, String nom) {
        agendaRepository.save(new Agenda(email, nom));
    }

    @Autowired
    private PersonneRepository personneRepository;

    public List<Agenda> getAgendaByEmail(String email) {
        Personne personne = personneRepository.findByEmail(email);

        if (personne != null) {
            return agendaRepository.findByPersonne(personne);
        } else {
            return null;
        }
    }

    public boolean createEvent(String email, EventDTO eventDTO) {

        Agenda agenda = agendaRepository.findByNom(eventDTO.getAgendaName());
        if (!agenda.getPersonne().getEmail().equals(email)) {
            return false;
        }
        Event event = new Event();
        event.setDescription(eventDTO.getDescription());
        event.setEndDateTime(eventDTO.getEndDateTime());
        event.setStartDateTime(eventDTO.getStartDateTime());

        Event saved = eventRepository.save(event);
        agenda.getEvents().add(saved);
        agendaRepository.save(agenda);

        return true;

    }

    public List<EventDTO> getAllEvents(String email, String agendaName) {
        return agendaRepository.findAllByNom(agendaName);
    }

    public void deleteEvent(String email, String name, Long id) {
        Agenda agenda = agendaRepository.findByNom(name);
        if (agenda.getPersonne().getEmail().equals(email)) {
            agenda.getEvents().removeIf(event -> event.getId() == id);

            agendaRepository.save(agenda);
            eventRepository.deleteById(id);
        }

    }

    public boolean editEvent(String email, EventDTO eventDTO) {

        Agenda agenda = agendaRepository.findByNom(eventDTO.getAgendaName());
        if (!agenda.getPersonne().getEmail().equals(email)) {
            return false;
        }
        Optional<Event> optional = eventRepository.findById(eventDTO.getId());
        if (optional.isEmpty()) {
            return false;
        }
        Event event = optional.get();
        event.setDescription(eventDTO.getDescription());
        event.setEndDateTime(eventDTO.getEndDateTime());
        event.setStartDateTime(eventDTO.getStartDateTime());

        eventRepository.save(event);

        return true;

    }
}

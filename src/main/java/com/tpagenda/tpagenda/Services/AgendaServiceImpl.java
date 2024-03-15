package com.tpagenda.tpagenda.Services;
import com.tpagenda.tpagenda.Agenda;
import com.tpagenda.tpagenda.Personne;
import com.tpagenda.tpagenda.Repository.AgendaRepository;
import com.tpagenda.tpagenda.Repository.PersonneRepository;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class AgendaServiceImpl implements AgendaService {
    @Autowired
    private AgendaRepository agendaRepository;

    @Override
    public Iterable<Agenda> getAllAgenda() {
        return agendaRepository.findAll();
    }

    @Override
    public void addAgenda(String email ,String nom) {
        agendaRepository.save(new Agenda(email, nom));
    }

    @Autowired
    private PersonneRepository personneRepository;
    
    public List<Agenda> getAgendaByEmail(String email) {
        Personne personne = personneRepository.findByEmail(email);
        

        if(personne != null) {
            return agendaRepository.findByPersonne(personne);
        } else {
            return null;
        }
    }
}

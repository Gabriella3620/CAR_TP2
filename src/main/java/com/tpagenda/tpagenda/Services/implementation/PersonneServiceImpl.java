package com.tpagenda.tpagenda.Services.implementation;

import com.tpagenda.tpagenda.Services.IPersonneService;
import com.tpagenda.tpagenda.entity.Personne;
import com.tpagenda.tpagenda.Repository.PersonneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonneServiceImpl implements IPersonneService {

    @Autowired
    private PersonneRepository personneRepository;

    @Override
    public void addPerson(String email, String password, String prenom, String nom) {
        Personne personne = new Personne(email, password, nom, prenom);
        personne.toString();
        personneRepository.save(personne);
    }

    @Override
    public Iterable<Personne> getAllPersonne() {
        return personneRepository.findAll();
    }

    public Personne findUser(String email, String password) {
        return personneRepository.findByEmailAndPassword(email, password);
    }
}
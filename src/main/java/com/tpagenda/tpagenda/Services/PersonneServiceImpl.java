package com.tpagenda.tpagenda.Services;
import com.tpagenda.tpagenda.Personne;
import com.tpagenda.tpagenda.Repository.PersonneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class PersonneServiceImpl implements PersonneService {
    
    @Autowired
    private PersonneRepository repo;

    @Override
    public void addPerson(String email, String password, String prenom, String nom) {
        repo.save(new Personne(email,password,nom,prenom));
    }

    @Override
    public Iterable<Personne> getAllPersonne(){
        return repo.findAll();
    }
}
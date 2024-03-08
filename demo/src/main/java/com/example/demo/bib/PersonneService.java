package com.example.demo.bib;

import org.springframework.beans.factory.annotation.Autowired;



import org.springframework.stereotype.Service;

@Service
public interface PersonneService {
	void ajoutPersonne(String email, String password, String prenom, String nom);
	Iterable<Personne> getAllPersonne();
}

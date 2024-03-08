package com.example.demo.Services;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.example.demo.Personne;

@Service
public interface PersonneService {
	void ajoutPersonne(String email, String password, String prenom, String nom);

	Iterable<Personne> getAllPersonne();
}

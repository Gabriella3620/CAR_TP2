package com.example.demo.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Personne;
import com.example.demo.Repository.PersonneRepository;

@Service

public class PersonneServiceImpl {

	public class PersonneServicesImpl implements PersonneService {

		@Autowired
		private PersonneRepository repo;

		@Override
		public void ajoutPersonne(String nom, String prenom, String email, String password) {
			repo.save(new Personne(nom, prenom, email, password));
		}

		@Override
		public Iterable<Personne> getAllPersonne() {
			return repo.findAll();
		}

	}
}

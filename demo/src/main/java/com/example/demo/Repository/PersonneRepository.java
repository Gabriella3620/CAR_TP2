package com.example.demo.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Personne;

@Repository
public interface PersonneRepository extends CrudRepository<Personne, Long> {
	Personne findByEmailAndPassword(String email, String password);
}
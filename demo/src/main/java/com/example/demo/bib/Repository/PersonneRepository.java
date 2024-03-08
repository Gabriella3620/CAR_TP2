package com.example.demo.bib;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface PersonneRepository extends CrudRepository<Personne, Long> {
	Personne findByEmailAndPassword(String email, String password);
}
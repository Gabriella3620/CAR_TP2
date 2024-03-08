package com.example.demo.bib;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;



@Entity
public class Personne {

	@Id
	private String email;
	private String password;
	private String prenom;
	private String nom;

	public Personne() {
	}

	public Personne(String email, String password, String prenom,String nom) {
		this.prenom = prenom;
		this.nom = nom;
		this.email = email;
		this.password = password;

	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getEmail() {
		return email;
	}
	public void setId(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}



}
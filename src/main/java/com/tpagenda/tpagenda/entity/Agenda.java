package com.tpagenda.tpagenda.entity;

import com.tpagenda.tpagenda.entity.Personne;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Agenda {

    private String email;
    @Id
    private String nom;

    @ManyToOne
    @JoinColumn(name = "email", insertable = false, updatable = false)
    private Personne personne;

    @OneToMany
    private List<Event> events;

    public Agenda() {
    }

    public Agenda(String email, String nom) {
        this.email = email;
        this.nom = nom;
    }

}

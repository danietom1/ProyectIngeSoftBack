package com.example.proyectingesoftback.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Cuestionarios")
public class Cuestionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer IdCuestionario;

    private String NombreCuestionario;

    @OneToMany(mappedBy = "cuestionario", cascade = CascadeType.ALL)
    //@JsonIgnore
    private Set<Pregunta> preguntas;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Cuestionario() {
    }

    public Cuestionario(Integer idCuestionario, String nombreCuestionario, Set<Pregunta> preguntas, User user) {
        IdCuestionario = idCuestionario;
        NombreCuestionario = nombreCuestionario;
        this.preguntas = preguntas;
        this.user = user;
    }

    public Integer getIdCuestionario() {
        return IdCuestionario;
    }

    public void setIdCuestionario(Integer idCuestionario) {
        IdCuestionario = idCuestionario;
    }

    public Set<Pregunta> getPreguntas() {
        return preguntas;
    }

    public void setPreguntas(Set<Pregunta> preguntas) {
        this.preguntas = preguntas;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getNombreCuestionario() {
        return NombreCuestionario;
    }

    public void setNombreCuestionario(String nombreCuestionario) {
        NombreCuestionario = nombreCuestionario;
    }
}

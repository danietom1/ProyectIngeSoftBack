package com.example.proyectingesoftback.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;


@Entity
@Table(name = "Respuestas")
public class Respuesta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int IdRespuesta;

    private boolean EsCorrecta;

    private String Contenido;

    @ManyToOne
    @JoinColumn(name = "pregunta_id")
    @JsonIgnore //comment
    private Pregunta pregunta;

    public Respuesta() {
    }

    public Respuesta(int idRespuesta, boolean esCorrecta, String contenido, Pregunta pregunta) {
        IdRespuesta = idRespuesta;
        EsCorrecta = esCorrecta;
        Contenido = contenido;
        this.pregunta = pregunta;
    }

    public int getIdRespuesta() {
        return IdRespuesta;
    }

    public void setIdRespuesta(int idRespuesta) {
        IdRespuesta = idRespuesta;
    }

    public boolean isEsCorrecta() {
        return EsCorrecta;
    }

    public void setEsCorrecta(boolean esCorrecta) {
        EsCorrecta = esCorrecta;
    }

    public String getContenido() {
        return Contenido;
    }

    public void setContenido(String contenido) {
        Contenido = contenido;
    }

    public Pregunta getPregunta() {
        return pregunta;
    }

    public void setPregunta(Pregunta pregunta) {
        this.pregunta = pregunta;
    }
}

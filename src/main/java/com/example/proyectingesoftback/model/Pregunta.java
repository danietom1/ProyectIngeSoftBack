package com.example.proyectingesoftback.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;


@Entity
@Table(name = "Preguntas")
public class Pregunta {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer IdPregunta;

        private String Indicador;

        private String Contexto;

        private String Enunciado;

        @OneToMany(mappedBy = "pregunta", cascade = CascadeType.ALL)
        //@JsonIgnore
        private Set<Respuesta> respuestas;

        @ManyToOne
        @JoinColumn(name = "cuestionario_id")
        @JsonIgnore //comment
        private Cuestionario cuestionario;

        public Pregunta() {
        }

        public Pregunta(Integer idPregunta, String indicador, String contexto, String enunciado, Set<Respuesta> respuestas, Cuestionario cuestionario) {
                IdPregunta = idPregunta;
                Indicador = indicador;
                Contexto = contexto;
                Enunciado = enunciado;
                this.respuestas = respuestas;
                this.cuestionario = cuestionario;
        }

        public Integer getIdPregunta() {
                return IdPregunta;
        }

        public void setIdPregunta(Integer idCaso) {
                this.IdPregunta = idCaso;
        }

        public String getIndicador() {
                return Indicador;
        }

        public void setIndicador(String indicador) {
                Indicador = indicador;
        }

        public String getContexto() {
                return Contexto;
        }

        public void setContexto(String contexto) {
                Contexto = contexto;
        }

        public String getEnunciado() {
                return Enunciado;
        }

        public void setEnunciado(String enunciado) {
                Enunciado = enunciado;
        }

        public Set<Respuesta> getRespuestas() {
                return respuestas;
        }

        public void setRespuestas(Set<Respuesta> respuestas) {
                this.respuestas = respuestas;
        }

        public Cuestionario getCuestionario() {
                return cuestionario;
        }

        public void setCuestionario(Cuestionario cuestionario) {
                this.cuestionario = cuestionario;
        }
}

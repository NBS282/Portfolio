package Dominio;

/**
 * @authors NICOLAS BIDENTI (305108) - MATTEO QUAGLIATA (298144)
 */

import java.io.Serializable;
import java.util.*;

public class Entrevista implements Serializable{

    private Evaluador evaluador;
    private Postulante postulante;
    private int puntaje;
    private String comentario;
    private int numero;
    
    public Entrevista(Evaluador evaluador, Postulante postulante, int puntaje, String comentario) {
        this.evaluador = evaluador;
        this.postulante = postulante;
        this.puntaje = puntaje;
        this.comentario = comentario;
    }
    
    public Evaluador getEvaluador() {
        return evaluador;
    }

    public void setEvaluador(Evaluador evaluador) {
        this.evaluador = evaluador;
    }

    public Postulante getPostulante() {
        return postulante;
    }

    public void setPostulante(Postulante postulante) {
        this.postulante = postulante;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
    
    public void setNumero(int num){
        numero = num;
    }
    
    public int getNumero(){
        return numero;
    }
}

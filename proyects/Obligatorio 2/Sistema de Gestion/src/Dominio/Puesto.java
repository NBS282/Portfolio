package Dominio;
/**
 * @authors NICOLAS BIDENTI (305108) - MATTEO QUAGLIATA (298144)
 */

import java.io.Serializable;
import java.util.ArrayList;

public class Puesto implements Serializable {

    private String nombre;
    private String tipo;
    private ArrayList<Tema> temasRequeridos; 

    public Puesto(String nombre, String tipo, ArrayList<Tema> temasRequeridos) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.temasRequeridos = temasRequeridos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public ArrayList<Tema> getTemasRequeridos() {
        return temasRequeridos;
    }

    public void addTemaRequerido(Tema temaRequerido) {
        this.temasRequeridos.add(temaRequerido);
    }
    
    @Override
    public String toString(){
        return this.nombre;
    }
}



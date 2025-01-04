package Dominio;
/**
 * @authors NICOLAS BIDENTI (305108) - MATTEO QUAGLIATA (298144)
 */

import java.io.Serializable;

public class Evaluador implements Serializable{

    private String nombre;
    private String cedula;
    private String direccion;
    private int añoIngreso;

    public Evaluador(String nombre, String cedula, String direccion, int añoIngreso) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.direccion = direccion;
        this.añoIngreso = añoIngreso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getAñoIngreso() {
        return añoIngreso;
    }

    public void setAñoIngreso(int añoIngreso) {
        this.añoIngreso = añoIngreso;
    }

    @Override
    public String toString() {
        return this.nombre + "(" + this.cedula + ")";
    }

}

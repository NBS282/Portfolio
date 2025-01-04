package Dominio;
/**
 * @authors NICOLAS BIDENTI (305108) - MATTEO QUAGLIATA (298144)
 */

import Dominio.*;
import java.io.Serializable;
import java.util.*;
import javax.swing.JOptionPane;

public class Postulante implements Serializable {

    private String nombre;
    private String cedula;
    private String direccion;
    private String telefono;
    private String mail;
    private String link;
    private String tipo;
    private HashMap<Tema, Integer> experiencia;

    public Postulante(String nombre, String cedula, String direccion, String telefono, String mail, String link, String tipo) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.direccion = direccion;
        this.telefono = telefono;
        this.mail = mail;
        this.link = link;
        this.tipo = tipo;
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public HashMap<Tema, Integer> getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(HashMap<Tema, Integer> unaExperiencia) {
        experiencia = unaExperiencia;

    }

    public void addExperiencia(Tema unTema, int nivel) {
        this.experiencia.put(unTema, nivel);
    }

    public ArrayList<String> mostrarExperiencia(HashMap<Tema, Integer> temas) {
        ArrayList<String> temaniv = new ArrayList<>();
        for (Map.Entry<Tema, Integer> elem : temas.entrySet()) {
            temaniv.add(elem.getKey() + " (" + elem.getValue() + ")");
        }
        return temaniv;
    }

    @Override
    public String toString() {
        return this.nombre + "(" + this.cedula + ")";
    }
}

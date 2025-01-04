package Dominio;
/**
 * @authors NICOLAS BIDENTI (305108) - MATTEO QUAGLIATA (298144)
 */

import java.io.Serializable;
import java.util.Objects;

public class Tema implements Serializable {

    private String nombre;
    private String descripcion;

    public Tema(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return this.nombre;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true; // Si es la misma referencia, son iguales
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false; // Si el objeto es nulo o no es de la misma clase, no son iguales
        }
        Tema comp = (Tema) obj;
        return this.getNombre().equals(comp.getNombre());
    }
}

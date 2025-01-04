package Archivo;

import java.io.*;
import java.util.Formatter;

public class ArchivoGrabacion {

    private Formatter out;

    public ArchivoGrabacion(String unNombre) {
        try {
            out = new Formatter(unNombre);
        } catch (FileNotFoundException e) {
            System.out.println("Error grabación " + unNombre);
            System.exit(1);
        } catch (SecurityException e) {
            System.out.println("Sin permisos.");
            System.exit(1);
        }
    }

    public ArchivoGrabacion(String unNombre, boolean next) {
        // si el parametro *viene en true, indica que se extiende
        // si es false, se sobreescribe
        try {
            FileWriter f = new FileWriter(unNombre, next);
            out = new Formatter(f);
        } catch (IOException e) {
            System.out.println("No se puede crear/extender.");
            System.exit(1);
        }
    }

    public void grabarLinea(String linea) {
        out.format("%s%n", linea);
    }

    public void cerrar() {
        out.close();
    }
}

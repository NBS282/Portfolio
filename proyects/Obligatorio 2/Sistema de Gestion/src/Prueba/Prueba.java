package Prueba;

/**
 * @authors NICOLAS BIDENTI (305108) - MATTEO QUAGLIATA (298144)
 */
import Dominio.Sistema;
import Interfaz.Menu;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.swing.JOptionPane;

public class Prueba {

    private static Sistema sis;
    private static Menu menu;

    public static void main(String[] args) {
        int opcionSeleccionada = opciones();
        boolean opt = seleccion(opcionSeleccionada);
        while (!opt) {
            opcionSeleccionada = opciones();
            opt = seleccion(opcionSeleccionada);
        }

        Menu m1 = new Menu(sis);
        m1.setVisible(true);

        m1.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent we) {
                try {
                    FileOutputStream f = new FileOutputStream("archivo.ser");
                    BufferedOutputStream b = new BufferedOutputStream(f);
                    ObjectOutputStream s = new ObjectOutputStream(b);
                    s.writeObject(sis);
                    s.close();
                    JOptionPane.showMessageDialog(null, "Sistema guardado con éxito.");
                } catch (IOException ioException) {
                    JOptionPane.showMessageDialog(null, "Error al crear el archivo");
                }
            }
        });

    }

    public static boolean seleccion(int opcionSeleccionada) {
        boolean creo = false;
        if (opcionSeleccionada == 0) {
            creo = true;
            sis = new Sistema();
        } else if (opcionSeleccionada == 1) {
            try {
                FileInputStream f1 = new FileInputStream("archivo.ser");
                BufferedInputStream b1 = new BufferedInputStream(f1);
                ObjectInputStream s1 = new ObjectInputStream(b1);
                sis = (Sistema) s1.readObject();
                s1.close();
                creo = true;
            } catch (FileNotFoundException fileNotFoundException) {
                creo = false;
                JOptionPane.showMessageDialog(null, "El sistema no puede encontrar el archivo especificado");
            } catch (IOException ioException) {
                creo = false;
                JOptionPane.showMessageDialog(null, "Error al leer el archivo");
            } catch (ClassNotFoundException classNotFoundException) {
                creo = false;
                JOptionPane.showMessageDialog(null, "Error al leer el archivo");
            }
        }

        return creo;
    }

    public static int opciones() {
        String[] opciones = {"Crear sistema vacío", "Cargar sistema anterior"};
        int opcionSeleccionada = JOptionPane.showOptionDialog(
                null,
                "Elige una opción",
                "Opciones",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null,
                opciones,
                opciones[0]
        );

        return opcionSeleccionada;
    }
}

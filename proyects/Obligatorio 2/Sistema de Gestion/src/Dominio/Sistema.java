package Dominio;
/**
 * @authors NICOLAS BIDENTI (305108) - MATTEO QUAGLIATA (298144)
 */

import Archivo.ArchivoGrabacion;
import java.io.*;
import java.util.*;

public class Sistema extends Observable implements Serializable {

    private ArrayList<Puesto> puestos = new ArrayList<>();
    private ArrayList<Entrevista> entrevistas = new ArrayList<>();
    private ArrayList<Tema> temas = new ArrayList<>();
    private ArrayList<Evaluador> evaluadores = new ArrayList<>();
    private ArrayList<Postulante> postulantes = new ArrayList<>();
    private int contador = 1;

    // Agregamos los elementos a las listas
    public void addPuesto(Puesto puesto) {
        puestos.add(puesto);
        setChanged();
        notifyObservers();
    }

    public void addEntrevista(Entrevista entrevista) {
        entrevistas.add(entrevista);
        entrevista.setNumero(contador++);
        setChanged();
        notifyObservers();
    }

    public void addTema(Tema tema) {
        temas.add(tema);
        setChanged();
        notifyObservers();
    }

    public void addEvaluador(Evaluador evaluador) {
        evaluadores.add(evaluador);
        setChanged();
        notifyObservers();
    }

    public void addPostulante(Postulante postulante) {
        postulantes.add(postulante);
        setChanged();
        notifyObservers();
    }

    public ArrayList<Puesto> getPuestos() {
        return puestos;
    }

    public ArrayList<Entrevista> getEntrevistas() {
        return entrevistas;
    }

    public ArrayList<Tema> getTemas() {
        return temas;
    }

    public ArrayList<Evaluador> getEvaluadores() {
        return evaluadores;
    }

    public ArrayList<Postulante> getPostulantes() {
        return postulantes;
    }

    public HashMap<Tema, Integer> removeTemaNiv(String temaAeliminar, HashMap<Tema, Integer> temas) {
        Iterator<Map.Entry<Tema, Integer>> it = temas.entrySet().iterator();

        while (it.hasNext()) {
            Map.Entry<Tema, Integer> entry = it.next();
            if (entry.getKey().toString().equals(temaAeliminar)) {
                it.remove(); // Eliminar del HashMap
            }
        }
        setChanged();
        notifyObservers();
        return temas;
    }

    public ArrayList<Tema> removeTemaPuesto(String temaAeliminar, ArrayList<Tema> temasRequeridos) {
        ArrayList<Tema> copiaTemasRequeridos = new ArrayList<>(temasRequeridos);//ConcurrentModificationException

        for (Tema tema : copiaTemasRequeridos) {
            if (tema.toString().equals(temaAeliminar)) {
                temasRequeridos.remove(tema);
            }
        }

        return temasRequeridos;
    }

    public boolean cedulaUnica(String cedula, ArrayList<Postulante> postulantes, ArrayList<Evaluador> evaluadores) {
        boolean ok = true;
        for (Postulante post : postulantes) {
            if (post.getCedula().equals(cedula)) {
                ok = false;
            }
        }

        for (Evaluador ev : evaluadores) {
            if (ev.getCedula().equals(cedula)) {
                ok = false;
            }
        }
        return ok;
    }

    public ArrayList<Postulante> consultaPuesto(int nivel, ArrayList<Postulante> postulantes, Puesto puesto, ArrayList<Entrevista> entrevista) {

        ArrayList<Postulante> postulantesOk = new ArrayList<>();
        ArrayList<Entrevista> entrevistasOk = new ArrayList<>();
        ArrayList<Postulante> postulantesOrden = new ArrayList<>();

        for (Entrevista entrev : entrevista) {
            Postulante post = entrev.getPostulante();
            if (post.getTipo().equals(puesto.getTipo()) && postulantesNiv(nivel, post, puesto) && !postulantesOk.contains(post)) {
                postulantesOk.add(post);
            }
        }

        for (Postulante post : postulantesOk) {
            Entrevista entrev = null;
            entrev = ultimaEntrevista(post, entrevista);
            entrevistasOk.add(entrev);
        }

        ordenarEntrevistasPorPuntajeDescendente(entrevistasOk);

        for (Entrevista entrev : entrevistasOk) {
            Postulante post = entrev.getPostulante();
            postulantesOrden.add(post);
        }

        setChanged();
        notifyObservers();

        return postulantesOrden;
    }

    public void cargarListaAArchivo(Puesto puesto, ArrayList<Postulante> postulantes) {
        ArchivoGrabacion arch = new ArchivoGrabacion("Consulta.txt"); // Creo el Archivo
        arch.grabarLinea("Puesto: " + puesto.getNombre());
        arch.grabarLinea("Postulantes:");
        for (Postulante postulante : postulantes) {
            String linea = postulante.getNombre() + ", " + "(" + postulante.getCedula() + ")" + ", " + postulante.getMail();
            arch.grabarLinea(linea);
        }
        arch.cerrar();

    }

    public ArrayList<Entrevista> historilaPostulante(Postulante postulante, ArrayList<Entrevista> entrevistas) {

        ArrayList<Entrevista> entrevistasAPost = new ArrayList<>();

        for (Entrevista entrev : entrevistas) {
            if (entrev.getPostulante().equals(postulante)) {
                entrevistasAPost.add(entrev);
            }
        }

        ordenarEntrevistasPorNumeroCreciente(entrevistasAPost);

        setChanged();
        notifyObservers();

        return entrevistasAPost;
    }

    public ArrayList<Entrevista> marcarComentario(String palabra, ArrayList<Entrevista> entrevistas, Postulante postulante) {
        //recibe el arraylist de historialpostulantes
        String comentario = "";

        ArrayList<Entrevista> entrevistasPost = new ArrayList<>();

        for (Entrevista entre : entrevistas) {
            if (entre.getPostulante().equals(postulante)) {
                if (entre.getComentario().contains(palabra)) {
                    String palabraRemplazar = "<font color='red'>" + palabra + "</font>";

                    comentario = entre.getComentario().replaceAll(palabra, palabraRemplazar);
                    comentario = "<html>" + comentario + "</html>";

                    Entrevista entrevista = new Entrevista(entre.getEvaluador(), postulante, entre.getPuntaje(), comentario);
                    entrevista.setNumero(entre.getNumero());
                    entrevistasPost.add(entrevista);
                }
            }
        }

        setChanged();
        notifyObservers();

        return entrevistasPost;
    }

    public int consultaPorTematicaNivel(Tema tema, ArrayList<Postulante> postulantes) {

        int cant = 0;
        for (Postulante post : postulantes) {
            HashMap<Tema, Integer> experiencia = new HashMap<>();
            experiencia = post.getExperiencia();
            Integer nivel = experiencia.get(tema);

            if (nivel != null && nivel > 5) {
                cant++;
            }
        }

        setChanged();
        notifyObservers();

        return cant;
    }

    public int consultaPorTematicaPuesto(Tema tema, ArrayList<Puesto> puestos) {

        int cant = 0;
        for (Puesto puesto : puestos) {
            ArrayList<Tema> temasrequeridos = new ArrayList<>();
            temasrequeridos = puesto.getTemasRequeridos();

            if (temasrequeridos.contains(tema)) {
                cant++;
            }
        }

        setChanged();
        notifyObservers();
        return cant;
    }

//metodos helpers:
    public Entrevista ultimaEntrevista(Postulante postulante, ArrayList<Entrevista> entrevista) {

        Entrevista ultimaentrev = null;
        for (Entrevista entrev : entrevista) {
            if (entrev.getPostulante().equals(postulante)) {
                ultimaentrev = entrev;
            }
        }
        return ultimaentrev;

    }

    public boolean postulantesNiv(int niv, Postulante postulante, Puesto puesto) {
        //temas requeridos para el puesto
        ArrayList<Tema> temasRequeridos = puesto.getTemasRequeridos();

        //temas que el postulante tiene 
        HashMap<Tema, Integer> experiencia = postulante.getExperiencia();

        boolean ok = true;

        // Verifica si el postulante cumple con todos los temas requeridos
        for (Tema puestoTema : temasRequeridos) {
            if (!experiencia.containsKey(puestoTema)) {
                ok = false; // El postulante no cumple con un tema requerido
                break;
            } else {
                int comp = experiencia.get(puestoTema); //el valor asociado a la clave
                if (niv > comp) {
                    ok = false; // El nivel de postulante no es suficiente
                    break;
                }
            }
        }
        return ok;
    }

    public void ordenarEntrevistasPorPuntajeDescendente(ArrayList<Entrevista> listaEntrevistas) {
        Collections.sort(listaEntrevistas, new Comparator<Entrevista>() {
            @Override
            public int compare(Entrevista e1, Entrevista e2) {
                return Integer.compare(e2.getPuntaje(), e1.getPuntaje());
            }
        });
    }

    public void ordenarPostulantesPorCedulaCreciente(ArrayList<Postulante> listaPostulantes) {
        Collections.sort(listaPostulantes, new Comparator<Postulante>() {
            @Override
            public int compare(Postulante p1, Postulante p2) {
                String cedula1 = p1.getCedula();
                String cedula2 = p2.getCedula();
                
                int numCedula1 = obtenerNumeroCedula(cedula1);
                int numCedula2 = obtenerNumeroCedula(cedula2);

                return Integer.compare(numCedula1, numCedula2);
            }

            private int obtenerNumeroCedula(String cedula) {
                // Remueve caracteres no numéricos
                String numeros = cedula.replaceAll("\\D", "");

                // si no hay numeros, como determinado devuelve 0
                if (numeros.isEmpty()) {
                    return 0; 
                }

                return Integer.parseInt(numeros);
            }
        });
    }

    public void ordenarEntrevistasPorNumeroCreciente(ArrayList<Entrevista> listaEntrevistas) {
        Collections.sort(listaEntrevistas, new Comparator<Entrevista>() {
            @Override
            public int compare(Entrevista e1, Entrevista e2) {
                return Integer.compare(e1.getNumero(), e2.getNumero());
            }
        });
    }
}

package mx.com.gm.peliculas.datos;

import java.io.*;
import java.util.*;
import mx.com.gm.peliculas.domain.Pelicula;
import mx.com.gm.peliculas.excepciones.*;

public class AccesoDatosImpl implements IAccesoDatos {

    @Override
    public boolean existe(String nombre) throws AccesoDatosEx {
        File archivo = new File(nombre); //Inicializamos el archivo.
        return archivo.exists(); //Preguntamos si existe el archivo y retornamos.
    }

    @Override
    public List<Pelicula> listar(String nombre) throws LecturaDatosEx {
        File archivo = new File(nombre); //Inicializamos el archivo.
        List<Pelicula> peliculas = new ArrayList<>(); //
        try {
            var entrada = new BufferedReader(new FileReader(archivo)); //Variable para leer y listar las peliculas.
            String linea = null; //Variable para leer cada linea
            linea = entrada.readLine(); //Leemos cada linea
            while (linea != null) {
                Pelicula pelicula = new Pelicula(linea);
                peliculas.add(pelicula);
                linea = entrada.readLine();
                //Si no es null, sigue el ciclo while y sigue listando peliculas.
            }
            entrada.close(); //Sale del ciclo while y cerramos el flujo.

                //Manejo excepciones:
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
            throw new LecturaDatosEx("Error al listar peliculas. " + ex.getMessage());

        } catch (IOException ex) {
            ex.printStackTrace(System.out);
            throw new LecturaDatosEx("Error al listar peliculas. " + ex.getMessage());
        }
        return peliculas; //retornamos la lista prev creada.
    }

    @Override
    public void escribir(Pelicula pelicula, String nombre, boolean anexar) throws EscrituraDatosEx {
        File archivo = new File(nombre); //Inicializamos el archivo.
        try {
            var salida = new PrintWriter(new FileWriter(archivo)); //Variable para escribir el archivo.
            salida.println(pelicula.toString());
            salida.close();
            System.out.println("Se ha escrito correctamente el archivo.");
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
            throw new EscrituraDatosEx("Error al escribir el archivo." + ex.getMessage());
        }

    }

    @Override
    public String buscar(String nombreArchivo, String buscar) throws LecturaDatosEx {
        File archivo = new File(nombreArchivo);
        String resultado = null;
        try {
            var entrada = new BufferedReader(new FileReader(archivo));
            var linea = entrada.readLine();
            var indice = 1;
            while (linea != null) {
                if (buscar != null && buscar.equalsIgnoreCase(linea)) {
                    resultado = "Nombre: " + linea + " Indice: " + indice;
                    break;
                }
                linea = entrada.readLine();
                indice++;
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
            throw new LecturaDatosEx("Error en la busqueda." + ex.getMessage());
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
            throw new LecturaDatosEx("Error en la busqueda." + ex.getMessage());
        }
        return resultado;
    }

    @Override
    public void crear(String nombreArchivo) throws AccesoDatosEx {
        File archivo = new File(nombreArchivo);
        try {
            var entrada = new PrintWriter(new FileWriter(archivo));
            entrada.close();
            System.out.println("Se ha creado el archivo correctamente.");
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
            throw new AccesoDatosEx("Error al crear el archivo." + ex.getMessage());
        }

    }

    @Override
    public void borrar(String nombreArchivo) throws AccesoDatosEx {
        File archivo = new File(nombreArchivo);
        if (archivo.exists()) {
            archivo.delete();
        }
        System.out.println("Se ha borrado el archivo correctamente.");
    }

}

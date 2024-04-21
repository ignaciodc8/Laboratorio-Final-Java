package mx.com.gm.peliculas.datos;

import java.util.List;
import mx.com.gm.peliculas.domain.*;
import mx.com.gm.peliculas.excepciones.*;

public interface IAccesoDatos {
    boolean existe(String nombre) throws AccesoDatosEx;
    
    List<Pelicula> listar(String nombre) throws LecturaDatosEx;
    
    void escribir(Pelicula pelicula, String nombre, boolean anexar) throws EscrituraDatosEx;
    
    String buscar(String nombreArchivo, String buscar)throws LecturaDatosEx;
    
    void crear(String nombreArchivo)throws AccesoDatosEx;
    
    void borrar(String nombreArchivo) throws AccesoDatosEx;
    
}

package mx.com.gm.peliculas.excepciones;

public class AccesoDatosEx extends Exception { //Trabajamos con excepciones por ende extiende de Exception
    
    //Definimos constructor con argumento
    public AccesoDatosEx(String mensaje) {
    super(mensaje);
    }
}

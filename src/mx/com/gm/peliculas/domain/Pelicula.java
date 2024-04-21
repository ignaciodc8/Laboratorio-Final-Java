package mx.com.gm.peliculas.domain;
//A las clases ubicadas en el paquete de domain se las conoce generalmente como ENTIDADES.

//Clase pelicula la cual tendra informacion de las mismas
public class Pelicula {
    /*Para los atributos aplicaremos JavaBeans, 
    por lo que debe tener un atributo privado, 
    un constructor vacio, metodos getter & setter para cada atributo 
    y extencion de serializable (no utilizamos en este caso)*/
    
    private String nombre; //attr privado
    
    public Pelicula() {
    //Constructor vacio
    }
    
    public Pelicula(String nombre) {
    this.nombre = nombre; //Inicializamos atributo
    }

    //Insertamos getters & setters + toString().
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Pelicula{" + "nombre=" + nombre + '}';
    }
    
    
}

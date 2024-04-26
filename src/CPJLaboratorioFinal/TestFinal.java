package CPJLaboratorioFinal;

import java.util.Scanner;
import mx.com.gm.peliculas.negocio.*;

public class TestFinal {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion = -1;
        ICatalogoPeliculas catalogo = new CatalogoPeliculasImpl();
        while (opcion != 0) {
            System.out.println("""
                               Bienvenido al programa de registro de peliculas. A continuacion, elija una opcion para continuar
                               1. Iniciar catalogo de peliculas
                               2. Agregar pelicula
                               3. Listar peliculas
                               4. Buscar pelicula
                               0. Salir""");
            opcion = Integer.parseInt(scanner.nextLine());
            switch (opcion) {
                case 1:
                    catalogo.iniciarArchivo();
                    break;
                case 2:
                    var nombrePelicula = scanner.nextLine();
                    catalogo.agregarPelicula(nombrePelicula);
                    break;
                case 3:
                    catalogo.listarPeliculas();
                    break;
                case 4:
                    var buscar = scanner.nextLine();
                    catalogo.buscarPelicula(buscar);
                    break;
                case 0:
                    System.out.println("Hasta pronto!");
                default:
                    System.out.println("Opcion incorrecta");
                    break;
            }
        }
    }
}

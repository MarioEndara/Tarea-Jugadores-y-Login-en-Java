import java.util.List;
import java.util.Scanner;

public class Aplicacion {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Autenticación de usuario
        System.out.println("Iniciar sesión");
        System.out.print("Usuario: ");
        String usuario = scanner.nextLine();
        System.out.print("Contraseña: ");
        String contrasena = scanner.nextLine();

        if (UsuarioService.autenticarUsuario(usuario, contrasena)) {
            System.out.println("Autenticación exitosa.");
            boolean salir = false;
            while (!salir) {
                System.out.println("\nOpciones:");
                System.out.println("1. Ver lista de jugadores");
                System.out.println("2. Agregar nuevo jugador");
                System.out.println("3. Buscar jugador por nombre");
                System.out.println("4. Eliminar jugador");
                System.out.println("5. Salir");
                System.out.print("Elige una opción: ");
                int opcion = scanner.nextInt();
                scanner.nextLine();

                switch (opcion) {
                    case 1:
                        List<String> jugadores = JugadorService.listarJugadores();
                        if (jugadores.isEmpty()) {
                            System.out.println("No hay jugadores registrados.");
                        } else {
                            jugadores.forEach(System.out::println);
                        }
                        break;
                    case 2:
                        System.out.print("Nombre del jugador: ");
                        String nombre = scanner.nextLine();
                        System.out.print("Posición: ");
                        String posicion = scanner.nextLine();
                        System.out.print("Equipo: ");
                        String equipo = scanner.nextLine();
                        System.out.print("Edad: ");
                        int edad = scanner.nextInt();
                        scanner.nextLine();  // Limpiar el buffer
                        JugadorService.agregarJugador(nombre, posicion, equipo, edad);
                        System.out.println("Jugador agregado.");
                        break;
                    case 3:
                        System.out.print("Nombre del jugador a buscar: ");
                        String buscarNombre = scanner.nextLine();
                        List<String> resultados = JugadorService.buscarJugadorPorNombre(buscarNombre);
                        if (resultados.isEmpty()) {
                            System.out.println("No se encontraron jugadores.");
                        } else {
                            resultados.forEach(System.out::println);
                        }
                        break;
                    case 4:
                        System.out.print("ID del jugador a eliminar: ");
                        int id = scanner.nextInt();
                        scanner.nextLine();  // Limpiar el buffer
                        JugadorService.eliminarJugador(id);
                        System.out.println("Jugador eliminado.");
                        break;
                    case 5:
                        salir = true;
                        break;
                    default:
                        System.out.println("Opción no válida.");
                        break;
                }
            }
        } else {
            System.out.println("Autenticación fallida.");
        }
        scanner.close();
    }
}

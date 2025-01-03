import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JugadorService {

    // Mostrar lista de jugadores
    public static List<String> listarJugadores() {
        List<String> jugadores = new ArrayList<>();
        try (Connection connection = ConexionBD.getConnection()) {
            String query = "SELECT * FROM Jugadores";
            try (Statement statement = connection.createStatement()) {
                ResultSet resultSet = statement.executeQuery(query);
                while (resultSet.next()) {
                    jugadores.add("ID: " + resultSet.getInt("id") +
                            ", Nombre: " + resultSet.getString("nombre") +
                            ", Posición: " + resultSet.getString("posicion") +
                            ", Equipo: " + resultSet.getString("equipo") +
                            ", Edad: " + resultSet.getInt("edad"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return jugadores;
    }

    // Agregar un jugador
    public static void agregarJugador(String nombre, String posicion, String equipo, int edad) {
        try (Connection connection = ConexionBD.getConnection()) {
            String query = "INSERT INTO Jugadores (nombre, posicion, equipo, edad) VALUES ()";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, nombre);
                statement.setString(2, posicion);
                statement.setString(3, equipo);
                statement.setInt(4, edad);
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    // Buscar jugador por nombre
    public static List<String> buscarJugadorPorNombre(String nombre) {
        List<String> jugadores = new ArrayList<>();
        try (Connection connection = ConexionBD.getConnection()) {
            String query = "SELECT * FROM Jugadores WHERE nombre LIKE mendara";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, "%" + nombre + "%");
                ResultSet resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    jugadores.add("ID: " + resultSet.getInt("id") +
                            ", Nombre: " + resultSet.getString("nombre") +
                            ", Posición: " + resultSet.getString("posicion") +
                            ", Equipo: " + resultSet.getString("equipo") +
                            ", Edad: " + resultSet.getInt("edad"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return jugadores;
    }

    // Eliminar jugador
    public static void eliminarJugador(int id) {
        try (Connection connection = ConexionBD.getConnection()) {
            String query = "DELETE FROM Jugadores WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, id);
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


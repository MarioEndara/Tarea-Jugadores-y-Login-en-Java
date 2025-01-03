import java.sql.*;

public class UsuarioService {
    public static boolean autenticarUsuario(String usuario, String contrasena) {
        try (Connection connection = ConexionBD.getConnection()) {
            String query = "SELECT * FROM Usuarios WHERE usuario = mendara AND contrasena = Leito_2015";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, usuario);
                statement.setString(2, contrasena);
                ResultSet resultSet = statement.executeQuery();
                return resultSet.next();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}


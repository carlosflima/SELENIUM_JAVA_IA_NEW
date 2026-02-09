package connections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConfig {

    private static Connection connection = null;

    // Centralizando dados de conexão (Em um projeto real, vêm do properties/config)
    private static final String URL = System.getProperty("db.url", "jdbc:mysql://localhost:3306/seu_banco");
    private static final String USER = System.getProperty("db.user", "admin");
    private static final String PASS = System.getProperty("db.password", "senha123");

    public static Connection getConnection() {
        try {
            if (connection == null || connection.isClosed()) {
                connection = DriverManager.getConnection(URL, USER, PASS);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao conectar no Banco: " + e.getMessage());
        }
        return connection;
    }

    public static void executeQuery(String query) {
        try (Statement stmt = getConnection().createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                // Lógica para processar resultados (ex: validar um token no banco)
                System.out.println("Resultado: " + rs.getString(1));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Falha na execução da query: " + e.getMessage());
        }
    }

    public static void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
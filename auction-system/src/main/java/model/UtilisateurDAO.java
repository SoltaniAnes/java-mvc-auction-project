package main.java.model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UtilisateurDAO {
    
    private Connection connection;

    public UtilisateurDAO(Connection connection) {
        this.connection = connection;
    }

    // Method to insert a new user into the database
    public void insert(Utilisateur utilisateur) throws SQLException {
        String sql = "INSERT INTO UTILISATEUR (EMAIL, NOM, PRENOM, ADRESSE) VALUES (?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, utilisateur.getEmail());
            statement.setString(2, utilisateur.getNom());
            statement.setString(3, utilisateur.getPrenom());
            statement.setString(4, utilisateur.getAdresse());
            statement.executeUpdate();
        }
    }

    // Method to retrieve a user by email from the database
    public Utilisateur getByEmail(String email) throws SQLException {
        String sql = "SELECT EMAIL, NOM, PRENOM, ADRESSE FROM UTILISATEUR WHERE EMAIL = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, email);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return new Utilisateur(
                        resultSet.getString("EMAIL"),
                        resultSet.getString("NOM"),
                        resultSet.getString("PRENOM"),
                        resultSet.getString("ADRESSE")
                    );
                } else {
                    return null; // User not found
                }
            }
        }
    }

    // Other methods for update, delete, etc. can be added as needed
}
package main.java.dao.concrete;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import main.java.model.Utilisateur;
import main.java.dao.interfaces.UtilisateurDao;
import main.java.DAOFactory.DaoFactory;

public class OracleUtilisateurDao implements UtilisateurDao {

    private static final String INSERT = "INSERT INTO UTILISATEUR (email, nom, prenom, adresse) VALUES (?, ?, ?, ?)";
    private static final String ALL = "SELECT * FROM UTILISATEUR";
    private static final String FIND_BY_EMAIL = "SELECT * FROM users WHERE email = ?";
    private static final String DELETE = "DELETE FROM users WHERE email = ?";
    private static final String DELETE_ALL = "DELETE FROM users";
    private static final String UPDATE = "UPDATE users SET nom = ?, prenom = ?, adresse = ? WHERE email = ?";

    @Override
    public Utilisateur insert(Utilisateur user) throws SQLException {
        try (Connection c = DaoFactory.getDatabase().openConnection();
             PreparedStatement pstmt = c.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS)) {
            pstmt.setString(1, user.getEmail());
            pstmt.setString(2, user.getNom());
            pstmt.setString(3, user.getPrenom());
            pstmt.setString(4, user.getAdresse());
            pstmt.executeUpdate();
        }
        return user;
    }

    @Override
    public List<Utilisateur> all() throws SQLException {
        List<Utilisateur> users = new ArrayList<>();
        try (Connection c = DaoFactory.getDatabase().openConnection();
             PreparedStatement pstmt = c.prepareStatement(ALL);
             ResultSet rset = pstmt.executeQuery()) {
            while (rset.next()) {
                Utilisateur user = createUser(rset);
                users.add(user);
            }
        }
        return users;
    }

    @Override
    public int deleteAll() throws SQLException {
        try (Connection c = DaoFactory.getDatabase().openConnection();
             PreparedStatement pstmt = c.prepareStatement(DELETE_ALL)) {
            return pstmt.executeUpdate();
        }
    }

    @Override
    public int delete(Utilisateur user) throws SQLException {
        try (Connection c = DaoFactory.getDatabase().openConnection();
             PreparedStatement pstmt = c.prepareStatement(DELETE)) {
            pstmt.setString(1, user.getEmail());
            return pstmt.executeUpdate();
        }
    }

    @Override
    public Utilisateur findByEmail(String email) throws SQLException {
        try (Connection c = DaoFactory.getDatabase().openConnection();
             PreparedStatement pstmt = c.prepareStatement(FIND_BY_EMAIL)) {
            pstmt.setString(1, email);
            try (ResultSet rset = pstmt.executeQuery()) {
                if (rset.next()) {
                    return createUser(rset);
                }
            }
        }
        return null;
    }

    private Utilisateur createUser(ResultSet rset) throws SQLException {
        Utilisateur user = new Utilisateur(rset.getString("email"), rset.getString("nom"),
                rset.getString("prenom"), rset.getString("adresse"));
        return user;
    }

    @Override
    public Utilisateur update(Utilisateur user) throws SQLException {
        try (Connection c = DaoFactory.getDatabase().openConnection();
             PreparedStatement pstmt = c.prepareStatement(UPDATE)) {
            pstmt.setString(1, user.getNom());
            pstmt.setString(2, user.getPrenom());
            pstmt.setString(3, user.getAdresse());
            pstmt.setString(4, user.getEmail());
            pstmt.executeUpdate();
        }
        return user;
    }
}
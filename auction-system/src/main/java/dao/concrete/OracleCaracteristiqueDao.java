package main.java.dao.concrete;

import main.java.dao.interfaces.CaracteristiqueDao;
import main.java.model.Caracteristique;
import main.java.DAOFactory.DaoFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OracleCaracteristiqueDao implements CaracteristiqueDao {

    private static final String INSERT = "INSERT INTO caracteristique (id_produit,nom, valeur) VALUES (?, ?)";
    private static final String ALL = "SELECT * FROM caracteristique";
    private static final String DELETE_ALL = "DELETE FROM caracteristique";
    private static final String DELETE = "DELETE FROM caracteristique WHERE nom = ?";
    private static final String FIND_BY_NAME = "SELECT * FROM caracteristique WHERE nom = ?";

    @Override
    public Caracteristique insert(Caracteristique caracteristique) throws SQLException {
        try (Connection c = DaoFactory.getDatabase().openConnection();
             PreparedStatement pstmt = c.prepareStatement(INSERT)) {
            pstmt.setString(1, caracteristique.getNom());
            pstmt.setString(2, String.join(",", caracteristique.getValeurs()));
            pstmt.executeUpdate();
        }
        return caracteristique;
    }

    @Override
    public List<Caracteristique> all() throws SQLException {
        List<Caracteristique> caracteristiques = new ArrayList<>();
        try (Connection c = DaoFactory.getDatabase().openConnection();
             PreparedStatement pstmt = c.prepareStatement(ALL);
             ResultSet rset = pstmt.executeQuery()) {
            while (rset.next()) {
                Caracteristique caracteristique = createCaracteristique(rset);
                caracteristiques.add(caracteristique);
            }
        }
        return caracteristiques;
    }

    @Override
    public int deleteAll() throws SQLException {
        try (Connection c = DaoFactory.getDatabase().openConnection();
             PreparedStatement pstmt = c.prepareStatement(DELETE_ALL)) {
            return pstmt.executeUpdate();
        }
    }

    @Override
    public int delete(Caracteristique caracteristique) throws SQLException {
        try (Connection c = DaoFactory.getDatabase().openConnection();
             PreparedStatement pstmt = c.prepareStatement(DELETE)) {
            pstmt.setString(1, caracteristique.getNom());
            return pstmt.executeUpdate();
        }
    }

    @Override
    public Caracteristique findByName(String name) throws SQLException {
        Caracteristique caracteristique = null;
        try (Connection c = DaoFactory.getDatabase().openConnection();
             PreparedStatement pstmt = c.prepareStatement(FIND_BY_NAME)) {
            pstmt.setString(1, name);
            try (ResultSet rset = pstmt.executeQuery()) {
                if (rset.next()) {
                    caracteristique = createCaracteristique(rset);
                }
            }
        }
        return caracteristique;
    }

    private Caracteristique createCaracteristique(ResultSet rset) throws SQLException {
        String nom = rset.getString("nom");
        String valeursString = rset.getString("valeurs");
        List<String> valeursList = Arrays.asList(valeursString.split(","));
        return new Caracteristique(nom, new ArrayList<>(valeursList));
    }
}

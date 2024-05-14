package main.java.dao.concrete;

import main.java.DAOFactory.DaoFactory;
import main.java.dao.interfaces.CategorieDao;
import main.java.model.Categorie;
import main.java.model.Produit;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OracleCategorieDao implements CategorieDao {

    private static final String INSERT = "INSERT INTO Categorie (nom, description) VALUES (?, ?)";
    private static final String ALL = "SELECT * FROM Categorie";

    private static final String BYNAME = "SELECT * FROM Categorie where nom=?";
    private static final String DELETE = "DELETE FROM Categorie WHERE nom=?";

    @Override
    public Categorie insert(Categorie categorie) throws SQLException {
        try (Connection c = DaoFactory.getDatabase().openConnection();
             PreparedStatement pstmt = c.prepareStatement(INSERT)) {
            pstmt.setString(1, categorie.getNom());
            pstmt.setString(2, categorie.getDescription());
            pstmt.executeUpdate();
        }
        return categorie;
    }

    @Override
    public List<Categorie> all() throws SQLException {
        List<Categorie> categories = new ArrayList<>();
        try (Connection c = DaoFactory.getDatabase().openConnection();
             PreparedStatement pstmt = c.prepareStatement(ALL);
             ResultSet rset = pstmt.executeQuery()) {
            while (rset.next()) {
                Categorie categorie = createCategorie(rset);
                categories.add(categorie);
            }
        }
        return categories;
    }

    @Override
    public int delete(Categorie produit) throws SQLException {
        int rset;
        try (Connection c = DaoFactory.getDatabase().openConnection();
             PreparedStatement pstmt = c.prepareStatement(DELETE)) {
            ;
            pstmt.setString(1, produit.getNom());
            rset = pstmt.executeUpdate();
        }
        System.out.println(rset);
        return rset ;
    }

    @Override
    public Categorie findByName(String name) throws SQLException {
        Categorie categorie;
        try (Connection c = DaoFactory.getDatabase().openConnection();
             PreparedStatement pstmt = c.prepareStatement(BYNAME)){
             pstmt.setString(1,name);
             ResultSet rset = pstmt.executeQuery() ;
             rset.next();
             categorie = createCategorie(rset);
        }
        return categorie;
    }

    private Categorie createCategorie(ResultSet rset) throws SQLException {

        Categorie categorie = new Categorie(rset.getString("nom"), rset.getString("description"));
        return categorie;
    }
}

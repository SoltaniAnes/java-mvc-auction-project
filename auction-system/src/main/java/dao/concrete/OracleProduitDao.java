package main.java.dao.concrete;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import main.java.dao.interfaces.CategorieDao;
import main.java.dao.interfaces.VenteDao;
import main.java.model.Caracteristique;
import main.java.model.Categorie;
import main.java.model.Produit;
import main.java.dao.interfaces.ProduitDao;
import main.java.DAOFactory.DaoFactory;

public class OracleProduitDao implements ProduitDao {

    private static final String INSERT = "INSERT INTO produit (id_produit, nom, prix_revient, stock, categorie) VALUES (?, ?, ?, ?, ?)";
    private static final String ALL = "SELECT * FROM produit";
    private static final String DELETE_ALL = "DELETE FROM produit";
    public CategorieDao categorieDao;

    public OracleProduitDao() {
        this.categorieDao = new OracleCategorieDao();
    }
    @Override
    public Produit insert(Produit produit) throws SQLException {
        try (Connection c = DaoFactory.getDatabase().openConnection();
             PreparedStatement pstmt = c.prepareStatement(INSERT)) {
            pstmt.setObject(1, produit.getId_produit());
            pstmt.setString(2, produit.getNom());
            pstmt.setFloat(3, produit.getPrix_revient());
            pstmt.setInt(4, produit.getStock());
            pstmt.setString(5, produit.getCategorie().getNom());
            pstmt.executeUpdate();
        }
        return produit;
    }

    @Override
    public List<Produit> all() throws SQLException {
        List<Produit> produits = new ArrayList<>();
        try (Connection c = DaoFactory.getDatabase().openConnection();
             PreparedStatement pstmt = c.prepareStatement(ALL);
             ResultSet rset = pstmt.executeQuery()) {
            while (rset.next()) {
                Produit produit = createProduit(rset);
                produits.add(produit);
            }
        }
        return produits;
    }

    @Override
    public int deleteAll() throws SQLException {
        try (Connection c = DaoFactory.getDatabase().openConnection();
             PreparedStatement pstmt = c.prepareStatement(DELETE_ALL)) {
            return pstmt.executeUpdate();
        }
    }

    @Override
    public int delete(Produit produit) throws SQLException {
        // Implement delete method as needed
        return 0;
    }

    @Override
    public Produit findById(UUID id) throws SQLException {
        // Implement findById method as needed
        return null;
    }

    private Produit createProduit(ResultSet rset) throws SQLException {
        int id_produit = rset.getInt("id_produit");
        String nom = rset.getString("nom");
        int prix_revient = rset.getInt("prix_revient");
        int stock = rset.getInt("stock");
        Categorie categorie = categorieDao.findByName(rset.getString("categorie"));
        Array caracteristiquesArray = null;
        List<String> caracteristiquesList = new ArrayList<>();
        if (caracteristiquesArray != null) {
            ResultSet rs = ((Array) caracteristiquesArray).getResultSet();
            while (rs.next()) {
                caracteristiquesList.add(rs.getString(2));
            }
        }
        return new Produit(id_produit, nom, prix_revient, stock,  categorie);
    }

}
package test;

import main.java.model.Caracteristique;
import main.java.model.Categorie;
import main.java.model.Produit;
import main.java.dao.interfaces.ProduitDao;
import main.java.dao.concrete.OracleProduitDao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class OracleProduitDaoTest {
    public static void main(String[] args) {
        // Create a new produit DAO
        ProduitDao produitDao = new OracleProduitDao();

        // Create sample data for the produit
        String nom = "Sample Produit";
        int prix_revient = 50;
        int stock = 100;
        List<Caracteristique> caracteristiques = new ArrayList<>();
        List<Categorie> categories = new ArrayList<>();

        // Insert the produit into the database
        try {
            UUID id_produit = UUID.randomUUID();
            Produit produit = new Produit(id_produit, nom, prix_revient, stock, (ArrayList<Categorie>) categories);
            produitDao.insert(produit);
            System.out.println("Produit inserted: " + produit);
        } catch (SQLException e) {
            System.err.println("Error inserting produit: " + e.getMessage());
        }
    }
}
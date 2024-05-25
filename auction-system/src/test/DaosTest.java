package test;

import main.java.dao.concrete.*;
import main.java.dao.interfaces.*;
import main.java.model.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class DaosTest {
    public static void main(String[] args) {
        try {
            // Step 1: Create and insert Utilisateur
            UtilisateurDao utilisateurDao = new OracleUtilisateurDao();
            Utilisateur user = new Utilisateur("test@gmail.com", "Doe", "John", "123 Main St");
            Utilisateur insertedUser = utilisateurDao.insert(user);
            System.out.println("User inserted: " + insertedUser.getEmail());

            // Step 2: Create and insert Categorie
            CategorieDao categorieDao = new OracleCategorieDao();
            Categorie categorie = new Categorie("Electronics", "Electronic items");
            Categorie insertedCategorie = categorieDao.insert(categorie);
            System.out.println("Category inserted: " + insertedCategorie.getNom());

            // Step 3: Create and insert Produit
            ProduitDao produitDao = new OracleProduitDao();
            Produit produit = new Produit(50, "Laptop", 500.0f, 10, categorie);
            produit.setCategorie(insertedCategorie);
            Produit insertedProduit = produitDao.insert(produit);
            System.out.println("Product inserted: " + insertedProduit.getNom());

            /*// Step 4: Create and insert Caracteristique
            CaracteristiqueDao caracteristiqueDao = new OracleCaracteristiqueDao();
            ArrayList<String> valeurs = new ArrayList<>();
            valeurs.add("16GB RAM");
            valeurs.add("512GB SSD");
            Caracteristique caracteristique = new Caracteristique("Laptop Spec", valeurs);
            Caracteristique insertedCaracteristique = caracteristiqueDao.insert(caracteristique);
            System.out.println("Characteristic inserted: " + insertedCaracteristique.getNom());*/

            // Step 5: Create and insert SalleDeVente
            SalleDeVenteDao salleDeVenteDao = new OracleSalleDeVenteDao();
            SalleDeVente salleDeVente = new SalleDeVente(1,insertedCategorie, "All kinds of electronic items.", TypeDeVente.DESCENDANTE, "All kinds of electronic items.");
            SalleDeVente insertedSalleDeVente = salleDeVenteDao.insert(salleDeVente);
            System.out.println("Sale room inserted: " + insertedSalleDeVente.getNom());

            // Step 6: Create and insert Vente
            VenteDao venteDao = new OracleVenteDao();
            Vente vente = new Vente(1,"test@gmail.com", insertedProduit.getId_produit(), insertedSalleDeVente.getId_salle_de_vente(), 100.0f, new Date(), 6, true, false);
            Vente insertedVente = venteDao.insert(vente);
            System.out.println("Sale inserted: " + insertedVente.getId_vente());

            // Step 7: Create and insert Enchere
            EnchereDao enchereDao = new OracleEnchereDao();
            Enchere enchere = new Enchere(50, "test@gmail.com",  150.0f, new Date(),insertedVente);
            Enchere insertedEnchere = enchereDao.insert(enchere);
            System.out.println("Auction inserted: " + insertedEnchere.getID_Enchere());

            // Retrieve and print all inserted data
            System.out.println("All users: " + utilisateurDao.all().size());
            System.out.println("All categories: " + categorieDao.all().size());
            System.out.println("All products: " + produitDao.all().size());
          //  System.out.println("All characteristics: " + caracteristiqueDao.all().size());
            System.out.println("All sale rooms: " + salleDeVenteDao.all().size());
            System.out.println("All sales: " + venteDao.all().size());
            System.out.println("All auctions: " + enchereDao.all().size());

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
package test;

import java.sql.SQLException;

import main.java.dao.concrete.OracleCategorieDao;
import main.java.dao.concrete.OracleUtilisateurDao;
import main.java.dao.interfaces.CategorieDao;
import main.java.dao.interfaces.UtilisateurDao;
import main.java.model.Categorie;
import main.java.model.Utilisateur;

public class OracleCategorieDaoTest {
    public static void main(String[] args) throws SQLException {
        CategorieDao categorieDao = new OracleCategorieDao();
        // Create a new user
        Categorie categorie = new Categorie("Telephones","Catégorie des téléphonies");


        try {
            // Insert the user into the database
            Categorie insertedCategorie = categorieDao.insert(categorie);

            Categorie firstcat=categorieDao.all().get(0);

            System.out.println(firstcat.getNom());
            System.out.println(categorieDao.delete(firstcat));
            //System.out.println("Categorie inserted successfully with Name: " + insertedCategorie.getNom());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
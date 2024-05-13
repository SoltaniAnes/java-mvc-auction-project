package test;

import java.sql.SQLException;
import main.java.dao.concrete.OracleUtilisateurDao;
import main.java.dao.interfaces.UtilisateurDao;
import main.java.model.Utilisateur;

public class OracleUserDaoTest {
    public static void main(String[] args) {
        UtilisateurDao userDao = new OracleUtilisateurDao();

        // Create a new user
        Utilisateur user = new Utilisateur("johndoe@gmail.com","Doe","Jhon","test");
        user.setNom("John Doe");
        user.setEmail("johndoe@gmail.com");

        try {
            // Insert the user into the database
            Utilisateur insertedUser = userDao.insert(user);
            System.out.println("User inserted successfully with ID: " + insertedUser.getEmail());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
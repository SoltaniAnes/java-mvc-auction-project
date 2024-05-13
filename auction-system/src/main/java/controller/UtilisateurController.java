package main.java.controller;
import main.java.model.Utilisateur;
import main.java.dao.concrete.OracleUtilisateurDao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UtilisateurController {

    private OracleUtilisateurDao utilisateurDao;

    public UtilisateurController() {
        this.utilisateurDao = new OracleUtilisateurDao();
    }

    public void createUtilisateur(String email, String nom, String prenom, String adresse) throws SQLException {
        Utilisateur utilisateur = new Utilisateur(email, nom, prenom, adresse);
        utilisateurDao.insert(utilisateur);
    }

    // Get Arraylist of all users
    public List<Utilisateur> getAllUsers() throws SQLException {
        return utilisateurDao.all();
    }

    // Delete all users
    public void deleteAllUsers() throws SQLException {
        utilisateurDao.deleteAll();
    }

    // Delete a user
    public void deleteUser(Utilisateur user) throws SQLException {
        utilisateurDao.delete(user);
    }

    // Find a user by email
    public Utilisateur findUserByEmail(String email) throws SQLException {
        return utilisateurDao.findByEmail(email);
    }

    // Update a user
    public void updateUser(Utilisateur user) throws SQLException {
        utilisateurDao.update(user);
    }
}

package main.java.dao.interfaces;

import java.sql.SQLException;
import java.util.List;
import main.java.model.Utilisateur;

public interface UtilisateurDao {

    Utilisateur insert(Utilisateur user) throws SQLException;

    List<Utilisateur> all() throws SQLException;

    int deleteAll() throws SQLException;

    int delete(Utilisateur user) throws SQLException;

    Utilisateur findByEmail(String email) throws SQLException;

    Utilisateur update(Utilisateur user) throws SQLException;
}
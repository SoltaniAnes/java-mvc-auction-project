package main.java.dao.interfaces;

import main.java.model.Categorie;
import main.java.model.Produit;

import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

public interface CategorieDao {
    Categorie insert(Categorie categorie) throws SQLException;
    List<Categorie> all() throws SQLException;
    int delete(Categorie produit) throws SQLException;
    Produit findByName(String name) throws SQLException;

}

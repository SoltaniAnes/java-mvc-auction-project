package main.java.dao.interfaces;

import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import main.java.model.Produit;

public interface ProduitDao {
    Produit insert(Produit produit) throws SQLException;
    List<Produit> all() throws SQLException;
    int deleteAll() throws SQLException;
    int delete(Produit produit) throws SQLException;
    Produit findById(UUID id) throws SQLException;
}
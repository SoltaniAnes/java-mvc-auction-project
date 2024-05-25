package main.java.dao.interfaces;

import main.java.model.Vente;
import java.sql.SQLException;
import java.util.List;

public interface VenteDao {
    Vente insert(Vente vente) throws SQLException;
    List<Vente> all() throws SQLException;
    int deleteAll() throws SQLException;
    int delete(Vente vente) throws SQLException;
    Vente findById(int id) throws SQLException;
}
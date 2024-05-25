package main.java.dao.interfaces;

import main.java.model.SalleDeVente;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

public interface SalleDeVenteDao {
    SalleDeVente insert(SalleDeVente salleDeVente) throws SQLException;
    List<SalleDeVente> all() throws SQLException;
    int deleteAll() throws SQLException;
    int delete(SalleDeVente salleDeVente) throws SQLException;
    SalleDeVente findById(UUID id) throws SQLException;
}
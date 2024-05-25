package main.java.dao.interfaces;

import main.java.model.Caracteristique;
import java.sql.SQLException;
import java.util.List;

public interface CaracteristiqueDao {
    Caracteristique insert(Caracteristique caracteristique) throws SQLException;
    List<Caracteristique> all() throws SQLException;
    int deleteAll() throws SQLException;
    int delete(Caracteristique caracteristique) throws SQLException;
    Caracteristique findByName(String name) throws SQLException;
}
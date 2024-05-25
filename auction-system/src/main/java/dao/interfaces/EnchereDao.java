package main.java.dao.interfaces;

import main.java.model.Enchere;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

public interface EnchereDao {
    Enchere insert(Enchere enchere) throws SQLException;
    List<Enchere> all() throws SQLException;
    int deleteAll() throws SQLException;
    int delete(Enchere enchere) throws SQLException;
    Enchere findById(UUID id) throws SQLException;
}
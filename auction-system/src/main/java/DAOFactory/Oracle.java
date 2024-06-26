package main.java.DAOFactory;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import main.java.dao.concrete.OracleProduitDao;
import main.java.dao.interfaces.ProduitDao;
import main.java.dao.interfaces.UtilisateurDao;
import main.java.dao.concrete.OracleUtilisateurDao;

public class Oracle extends DaoFactory {

    private static final String DB_URL = "jdbc:oracle:thin:@hostname:1521:oracle1";
    private static final String USER = "";
    private static final String PASSWORD = "";

    @Override
    public Connection openConnection() {
        try {
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            return DriverManager.getConnection(DB_URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public UtilisateurDao getUserDao() {
        return new OracleUtilisateurDao();
    }
    @Override
    public ProduitDao getProduitDao() {
        return new OracleProduitDao();
    }
}

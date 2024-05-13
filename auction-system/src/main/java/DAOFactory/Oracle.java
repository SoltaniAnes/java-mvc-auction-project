package main.java.DAOFactory;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import main.java.dao.interfaces.UtilisateurDao;
import main.java.dao.concrete.OracleUtilisateurDao;

public class Oracle extends DaoFactory {

    private static final String DB_URL = "jdbc:oracle:thin:@oracle1.ensimag.fr:1521:oracle1";
    private static final String USER = "soltanim";
    private static final String PASSWORD = "soltanim";

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

}
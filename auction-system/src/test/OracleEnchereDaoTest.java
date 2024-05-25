package test;

import main.java.dao.concrete.OracleEnchereDao;
import main.java.dao.interfaces.EnchereDao;
import main.java.model.Enchere;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class OracleEnchereDaoTest {
    public static void main(String[] args) throws SQLException {
        EnchereDao enchereDao = new OracleEnchereDao();

        // Create a new auction
        Enchere enchere = new Enchere(1, "theo@gmail.com", 50.0f, new Date(),((OracleEnchereDao) enchereDao).venteDao.findById(1));

        try {
            // Insert the auction into the database
            Enchere insertedEnchere = enchereDao.insert(enchere);
            System.out.println("Auction inserted successfully with ID: " + insertedEnchere.getID_Enchere());

            // Retrieve all auctions
            List<Enchere> encheres = enchereDao.all();
            System.out.println("Total auctions in database: " + encheres.size());

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
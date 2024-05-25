package main.java.dao.concrete;

import main.java.dao.interfaces.VenteDao;
import main.java.model.Enchere;
import main.java.dao.interfaces.EnchereDao;
import main.java.DAOFactory.DaoFactory;
import main.java.model.Vente;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class OracleEnchereDao implements EnchereDao {

    private static final String INSERT = "INSERT INTO enchere (id_enchere, email, id_vente,prix_achat, date_enchere) VALUES (?, ?, ?, ?,?)";
    private static final String ALL = "SELECT * FROM enchere";
    private static final String DELETE_ALL = "DELETE FROM enchere";
    private static final String FIND_BY_ID = "SELECT * FROM enchere WHERE id_enchere = ?";
    public VenteDao venteDao;

    public  OracleEnchereDao() {
        this.venteDao = new OracleVenteDao();
    }

    @Override
    public Enchere insert(Enchere enchere) throws SQLException {
        try (Connection c = DaoFactory.getDatabase().openConnection();
             PreparedStatement pstmt = c.prepareStatement(INSERT)) {
            pstmt.setObject(1, enchere.getID_Enchere());
            pstmt.setString(2, enchere.getEmail_utilisateur());
            pstmt.setFloat(4, enchere.getPrix_achat());
            pstmt.setTimestamp(5, new Timestamp(enchere.getDate().getTime()));
            pstmt.setInt(3,enchere.getVente().getId_vente());
            pstmt.executeUpdate();
        }
        return enchere;
    }

    @Override
    public List<Enchere> all() throws SQLException {
        List<Enchere> encheres = new ArrayList<>();
        try (Connection c = DaoFactory.getDatabase().openConnection();
             PreparedStatement pstmt = c.prepareStatement(ALL);
             ResultSet rset = pstmt.executeQuery()) {
            while (rset.next()) {
                Enchere enchere = createEnchere(rset);
                encheres.add(enchere);
            }
        }
        return encheres;
    }

    @Override
    public int deleteAll() throws SQLException {
        try (Connection c = DaoFactory.getDatabase().openConnection();
             PreparedStatement pstmt = c.prepareStatement(DELETE_ALL)) {
            return pstmt.executeUpdate();
        }
    }

    @Override
    public int delete(Enchere enchere) throws SQLException {
        // Implement delete method as needed
        return 0;
    }

    @Override
    public Enchere findById(UUID id) throws SQLException {
        Enchere enchere = null;
        try (Connection c = DaoFactory.getDatabase().openConnection();
             PreparedStatement pstmt = c.prepareStatement(FIND_BY_ID)) {
            pstmt.setObject(1, id);
            try (ResultSet rset = pstmt.executeQuery()) {
                if (rset.next()) {
                    enchere = createEnchere(rset);
                }
            }
        }
        return enchere;
    }

    private Enchere createEnchere(ResultSet rset) throws SQLException {
        int id_enchere = rset.getInt("id_enchere");
        String email_utilisateur = rset.getString("email");
        float prix_achat = rset.getFloat("prix_achat");
        Date date = new Date(rset.getTimestamp("date_enchere").getTime());
        Vente vente=venteDao.findById(rset.getInt("id_vente"));
        return new Enchere(id_enchere, email_utilisateur, prix_achat, date,vente);
    }
}
package main.java.dao.concrete;

import main.java.dao.interfaces.VenteDao;
import main.java.model.Vente;
import main.java.DAOFactory.DaoFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OracleVenteDao implements VenteDao {

    private static final String INSERT = "INSERT INTO vente (id_vente, email, id_produit, ID_SALLE, prix_depart, date_debut, duree, revocable, enchere_unique) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String ALL = "SELECT * FROM vente";
    private static final String DELETE_ALL = "DELETE FROM vente";
    private static final String FIND_BY_ID = "SELECT * FROM vente WHERE id_vente = ?";

    @Override
    public Vente insert(Vente vente) throws SQLException {
        try (Connection c = DaoFactory.getDatabase().openConnection();
             PreparedStatement pstmt = c.prepareStatement(INSERT)) {
            pstmt.setObject(1, vente.getId_vente());
            pstmt.setString(2, vente.getEmail_utilisateur());
            pstmt.setObject(3, vente.getId_produit());
            pstmt.setObject(4, vente.getId_salle_de_vente());
            pstmt.setFloat(5, vente.getPrix_depart());
            pstmt.setTimestamp(6, new Timestamp(vente.getDate_debut().getTime()));
            pstmt.setInt(7, vente.getDuree());
            pstmt.setBoolean(8, vente.isRevocable());
            pstmt.setBoolean(9, vente.isEnchere_unique());
            pstmt.executeUpdate();
        }
        return vente;
    }

    @Override
    public List<Vente> all() throws SQLException {
        List<Vente> ventes = new ArrayList<>();
        try (Connection c = DaoFactory.getDatabase().openConnection();
             PreparedStatement pstmt = c.prepareStatement(ALL);
             ResultSet rset = pstmt.executeQuery()) {
            while (rset.next()) {
                Vente vente = createVente(rset);
                ventes.add(vente);
            }
        }
        return ventes;
    }

    @Override
    public int deleteAll() throws SQLException {
        try (Connection c = DaoFactory.getDatabase().openConnection();
             PreparedStatement pstmt = c.prepareStatement(DELETE_ALL)) {
            return pstmt.executeUpdate();
        }
    }

    @Override
    public int delete(Vente vente) throws SQLException {
        // Implement delete method as needed
        return 0;
    }

    @Override
    public Vente findById(int id) throws SQLException {
        Vente vente = null;
        try (Connection c = DaoFactory.getDatabase().openConnection();
             PreparedStatement pstmt = c.prepareStatement(FIND_BY_ID)) {
            pstmt.setObject(1, id);
            try (ResultSet rset = pstmt.executeQuery()) {
                if (rset.next()) {
                    vente = createVente(rset);
                }
            }
        }
        return vente;
    }

    private Vente createVente(ResultSet rset) throws SQLException {
        int id_vente =  rset.getInt("id_vente");
        String email_utilisateur = rset.getString("email");
        int id_produit =  rset.getInt("id_produit");
        int id_salle_de_vente = rset.getInt("id_salle");
        float prix_depart = rset.getFloat("prix_depart");
        Date date_debut = new Date(rset.getTimestamp("date_debut").getTime());
        int duree = rset.getInt("duree");
        boolean revocable = rset.getBoolean("revocable");
        boolean enchere_unique = rset.getBoolean("enchere_unique");
        return new Vente(id_vente,email_utilisateur, id_produit, id_salle_de_vente, prix_depart, date_debut, duree, revocable, enchere_unique);
    }
}
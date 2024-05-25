package main.java.dao.concrete;

import main.java.dao.interfaces.CategorieDao;
import main.java.model.SalleDeVente;
import main.java.model.Categorie;
import main.java.model.TypeDeVente;
import main.java.dao.interfaces.SalleDeVenteDao;
import main.java.DAOFactory.DaoFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class OracleSalleDeVenteDao implements SalleDeVenteDao {

    private static final String INSERT = "INSERT INTO SALLE_VENTE (ID_SALLE, categorie, type, nom, description) VALUES (?, ?, ?, ?, ?)";
    private static final String ALL = "SELECT * FROM SALLE_VENTE";
    private static final String DELETE_ALL = "DELETE FROM SALLE_VENTE";
    private static final String FIND_BY_ID = "SELECT * FROM SALLE_VENTE WHERE ID_SALLE = ?";
    private final CategorieDao categorieDao;
    public OracleSalleDeVenteDao() {
        this.categorieDao = new OracleCategorieDao();
    }
    @Override
    public SalleDeVente insert(SalleDeVente salleDeVente) throws SQLException {
        try (Connection c = DaoFactory.getDatabase().openConnection();
             PreparedStatement pstmt = c.prepareStatement(INSERT)) {
            pstmt.setObject(1, salleDeVente.getId_salle_de_vente());
            pstmt.setString(2, salleDeVente.getCategorie().getNom());
            pstmt.setString(3, salleDeVente.getType().toString());
            pstmt.setString(4, salleDeVente.getNom());
            pstmt.setString(5, salleDeVente.getDescription());
            pstmt.executeUpdate();
        }
        return salleDeVente;
    }

    @Override
    public List<SalleDeVente> all() throws SQLException {
        List<SalleDeVente> sallesDeVente = new ArrayList<>();
        try (Connection c = DaoFactory.getDatabase().openConnection();
             PreparedStatement pstmt = c.prepareStatement(ALL);
             ResultSet rset = pstmt.executeQuery()) {
            while (rset.next()) {
                SalleDeVente salleDeVente = createSalleDeVente(rset);
                sallesDeVente.add(salleDeVente);
            }
        }
        return sallesDeVente;
    }

    @Override
    public int deleteAll() throws SQLException {
        try (Connection c = DaoFactory.getDatabase().openConnection();
             PreparedStatement pstmt = c.prepareStatement(DELETE_ALL)) {
            return pstmt.executeUpdate();
        }
    }

    @Override
    public int delete(SalleDeVente salleDeVente) throws SQLException {
        // Implement delete method as needed
        return 0;
    }

    @Override
    public SalleDeVente findById(UUID id) throws SQLException {
        SalleDeVente salleDeVente = null;
        try (Connection c = DaoFactory.getDatabase().openConnection();
             PreparedStatement pstmt = c.prepareStatement(FIND_BY_ID)) {
            pstmt.setObject(1, id);
            try (ResultSet rset = pstmt.executeQuery()) {
                if (rset.next()) {
                    salleDeVente = createSalleDeVente(rset);
                }
            }
        }
        return salleDeVente;
    }

    private SalleDeVente createSalleDeVente(ResultSet rset) throws SQLException {
        int id_salle_de_vente = rset.getInt("id_salle");
        Categorie categorie = categorieDao.findByName(rset.getString("categorie"));
        TypeDeVente type = TypeDeVente.valueOf(rset.getString("type"));
        String nom = rset.getString("nom");
        String description = rset.getString("description");
        // Assuming you handle the ArrayList<Vente> elsewhere as it's not stored in the salle_de_vente table
        return new SalleDeVente(id_salle_de_vente,categorie, nom, type, description);
    }
}
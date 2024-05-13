package main.java.DAOFactory;

import java.sql.Connection;

import main.java.dao.interfaces.ProduitDao;
import main.java.dao.interfaces.UtilisateurDao;
import main.java.dao.concrete.OracleUtilisateurDao;
import main.java.dao.interfaces.UtilisateurDao;

public abstract class DaoFactory {

    public abstract Connection openConnection();
    public abstract UtilisateurDao getUserDao();
    public abstract ProduitDao getProduitDao();

    public static DaoFactory getDatabase() {
        return new Oracle();
    }

}


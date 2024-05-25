package main.java.model;
import java.util.Date;
import java.util.UUID;

public class Enchere {
    private int ID_Enchere;
    private String Email_utilisateur;
    private float Prix_achat;
    private Date Date;
    private Vente vente;
    public Enchere(int ID_Enchere, String email_utilisateur, float prix_achat, Date date,Vente vente) {
        this.ID_Enchere = ID_Enchere;
        this.Email_utilisateur = email_utilisateur;
        this.Prix_achat = prix_achat;
        this.Date = date;
        this.vente= vente;
    }

    public String getEmail_utilisateur() {
        return Email_utilisateur;
    }

    public void setEmail_utilisateur(String email_utilisateur) {
        Email_utilisateur = email_utilisateur;
    }

    public int getID_Enchere() {
        return ID_Enchere;
    }
    public Vente getVente() {
        return vente;
    }


    public void setID_Enchere(int ID_Enchere) {
        this.ID_Enchere = ID_Enchere;
    }

    public float getPrix_achat() {
        return Prix_achat;
    }

    public void setPrix_achat(float prix_achat) {
        Prix_achat = prix_achat;
    }

    public Date getDate() {
        return Date;
    }

    public void setDate(Date date) {
        this.Date = date;
    }
}

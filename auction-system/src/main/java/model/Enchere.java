package main.java.model;
import java.util.Date;

public class Enchere {
    private int ID_Enchere;
    private int Email_utilisateur;
    private float Prix_achat;
    private Date Date;

    public Enchere(int ID_Enchere, int email_utilisateur, float prix_achat, Date date) {
        this.ID_Enchere = ID_Enchere;
        this.Email_utilisateur = email_utilisateur;
        this.Prix_achat = prix_achat;
        this.Date = date;
    }

    public int getEmail_utilisateur() {
        return Email_utilisateur;
    }

    public void setEmail_utilisateur(int email_utilisateur) {
        Email_utilisateur = email_utilisateur;
    }

    public int getID_Enchere() {
        return ID_Enchere;
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

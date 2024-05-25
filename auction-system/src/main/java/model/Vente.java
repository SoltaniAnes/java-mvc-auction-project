package main.java.model;
import java.util.Date;
import java.util.UUID;

public class Vente {
    private int id_vente;
    private String email_utilisateur;
    private int id_produit;
    private int id_salle_de_vente;
    private float prix_depart;
    private Date date_debut;
    private int duree;
    private boolean revocable;
    private boolean enchere_unique;

    // Constructor
    public Vente(int id_vente,String email_utilisateur, int id_produit, int id_salle_de_vente, float prix_depart, Date date_debut, int duree, boolean revocable, boolean enchere_unique) {
        this.id_vente = id_vente;
        this.email_utilisateur = email_utilisateur;
        this.id_produit = id_produit;
        this.id_salle_de_vente = id_salle_de_vente;
        this.prix_depart = prix_depart;
        this.date_debut = date_debut;
        this.duree = duree;
        this.revocable = revocable;
        this.enchere_unique = enchere_unique;
    }

    // Getters
    public int getId_vente() {
        return id_vente;
    }
    public String getEmail_utilisateur() {
        return email_utilisateur;
    }
    public int getId_produit() {
        return id_produit;
    }
    public int getId_salle_de_vente() {
        return id_salle_de_vente;
    }
    public float getPrix_depart() {
        return prix_depart;
    }
    public Date getDate_debut() {
        return date_debut;
    }
    public int getDuree() {
        return duree;
    }
    public boolean isRevocable() {
        return revocable;
    }
    public boolean isEnchere_unique() {
        return enchere_unique;
    }

    // Setters
    public void setEmail_utilisateur(String email_utilisateur) {
        this.email_utilisateur = email_utilisateur;
    }
    public void setId_produit(int id_produit) {
        this.id_produit = id_produit;
    }
    public void setId_salle_de_vente(int id_salle_de_vente) {
        this.id_salle_de_vente = id_salle_de_vente;
    }
    public void setPrix_depart(float prix_depart) {
        this.prix_depart = prix_depart;
    }
    public void setDate_debut(Date date_debut) {
        this.date_debut = date_debut;
    }
    public void setDuree(int duree) {
        this.duree = duree;
    }
    public void setRevocable(boolean revocable) {
        this.revocable = revocable;
    }
    public void setEnchere_unique(boolean enchere_unique) {
        this.enchere_unique = enchere_unique;
    }

}


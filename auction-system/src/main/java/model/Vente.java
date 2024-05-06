package main.java.model;
import java.util.Date;
import java.util.UUID;

public class Vente {
    private UUID id_vente;
    private String email_utilisateur;
    private UUID id_produit;
    private UUID id_salle_de_vente;
    private float prix_depart;
    private Date date_debut;
    private Date duree;
    private boolean revocable;
    private boolean enchere_unique;

    // Constructor
    public Vente(String email_utilisateur, UUID id_produit, UUID id_salle_de_vente, float prix_depart, Date date_debut, Date duree, boolean revocable, boolean enchere_unique) {
        this.id_vente = UUID.randomUUID();
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
    public UUID getId_vente() {
        return id_vente;
    }
    public String getEmail_utilisateur() {
        return email_utilisateur;
    }
    public UUID getId_produit() {
        return id_produit;
    }
    public UUID getId_salle_de_vente() {
        return id_salle_de_vente;
    }
    public float getPrix_depart() {
        return prix_depart;
    }
    public Date getDate_debut() {
        return date_debut;
    }
    public Date getDuree() {
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
    public void setId_produit(UUID id_produit) {
        this.id_produit = id_produit;
    }
    public void setId_salle_de_vente(UUID id_salle_de_vente) {
        this.id_salle_de_vente = id_salle_de_vente;
    }
    public void setPrix_depart(float prix_depart) {
        this.prix_depart = prix_depart;
    }
    public void setDate_debut(Date date_debut) {
        this.date_debut = date_debut;
    }
    public void setDuree(Date duree) {
        this.duree = duree;
    }
    public void setRevocable(boolean revocable) {
        this.revocable = revocable;
    }
    public void setEnchere_unique(boolean enchere_unique) {
        this.enchere_unique = enchere_unique;
    }

}


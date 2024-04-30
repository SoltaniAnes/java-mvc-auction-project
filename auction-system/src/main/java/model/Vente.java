package model;

public class Vente {
    private int id_utilisateur;
    private int id_produit;
    private int id_salle_de_vente;
    private float prix_depart;
    private Date date_debut;
    private int duree;
    private boolean revocable;
    private boolean enchere_unique;

    public Vente(int id_utilisateur, int id_produit, int id_salle_de_vente, float prix_depart, Date date_debut, int duree, boolean revocable, boolean enchere_unique) {
        this.id_utilisateur = id_utilisateur;
        this.id_produit = id_produit;
        this.id_salle_de_vente = id_salle_de_vente;
        this.prix_depart = prix_depart;
        this.date_debut = date_debut;
        this.duree = duree;
        this.revocable = revocable;
        this.enchere_unique = enchere_unique;
    }

    public int getId_utilisateur() {
        return id_utilisateur;
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

    public void setId_utilisateur(int id_utilisateur) {
        this.id_utilisateur = id_utilisateur;
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


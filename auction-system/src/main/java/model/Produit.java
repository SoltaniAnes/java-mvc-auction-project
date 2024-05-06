package model;

public class Produit {

    // Attributes
    private int id_produit;
    private String nom;
    private int prix_revient;
    private int stock;
    private <ArrayList>Caracteristique caracteristiques;

    // Constructor
    public Produit(String nom, int prix_revient, int stock) {
        this.nom = nom;
        this.prix_revient = prix_revient;
        this.stock = stock;
    }

    // Getters
    public String getNom() {
        return nom;
    }

    public int getPrix_revient() {
        return prix_revient;
    }

    public int getStock() {
        return stock;
    }

    // Setters
    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrix_revient(int prix_revient) {
        this.prix_revient = prix_revient;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}

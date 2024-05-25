package main.java.model;
import java.util.ArrayList;
import java.util.UUID;

public class Produit {

    // Attributes
    private int id_produit;
    private String nom;
    private float prix_revient;
    private int stock;
    private ArrayList<Caracteristique> caracteristiques;
    private Categorie categorie;

    // Constructor
    public Produit(int id_produit, String nom, float prix_revient, int stock, Categorie categorie) {
        this.id_produit = id_produit;
        this.nom = nom;
        this.prix_revient = prix_revient;
        this.stock = stock;
        this.caracteristiques = caracteristiques;
        this.categorie = categorie;
    }

    // Getters
    public int getId_produit() {
        return id_produit;
    }
    public String getNom() {
        return nom;
    }
    public float getPrix_revient() {
        return prix_revient;
    }
    public int getStock() {
        return stock;
    }
    public ArrayList<Caracteristique> getCaracteristiques() {
        return caracteristiques;
    }
    public Categorie getCategorie() {
        return categorie;
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
    public void setCaracteristiques(ArrayList<Caracteristique> caracteristiques) {
        this.caracteristiques = caracteristiques;
    }
    public void setCategories(Categorie categorie) {
        this.categorie = categorie;
    }

    // Functions

    // Add a caracteristique to the list of caracteristiques
    public void addCaracteristique(Caracteristique caracteristique) {
        caracteristiques.add(caracteristique);
    }

    // Remove a caracteristique from the list of caracteristiques
    public void removeCaracteristique(Caracteristique caracteristique) {
        caracteristiques.remove(caracteristique);
    }

    // Create a product
    public void creerProduit(String nom, int prix_revient, int stock, Categorie categorie) {
        this.nom = nom;
        this.prix_revient = prix_revient;
        this.stock = stock;
        this.caracteristiques = caracteristiques;
        this.categorie = categorie;
    }



    public void setCategorie(Categorie insertedCategorie) {
        this.categorie=insertedCategorie;
    }
}

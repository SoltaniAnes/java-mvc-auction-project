package main.java.model;
import java.util.ArrayList;
import java.util.UUID;

public class Produit {

    // Attributes
    private UUID id_produit;
    private String nom;
    private int prix_revient;
    private int stock;
    private ArrayList<Caracteristique> caracteristiques;
    private ArrayList<Categorie> categories;

    // Constructor
    public Produit(UUID id_produit, String nom, int prix_revient, int stock, ArrayList<Categorie> categories) {
        this.id_produit = UUID.randomUUID();
        this.nom = nom;
        this.prix_revient = prix_revient;
        this.stock = stock;
        this.caracteristiques = caracteristiques;
        this.categories = categories;
    }

    // Getters
    public UUID getId_produit() {
        return id_produit;
    }
    public String getNom() {
        return nom;
    }
    public int getPrix_revient() {
        return prix_revient;
    }
    public int getStock() {
        return stock;
    }
    public ArrayList<Caracteristique> getCaracteristiques() {
        return caracteristiques;
    }
    public String getCategories() {
        return getCategoriesAsString();
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
    public void setCategories(ArrayList<Categorie> categories) {
        this.categories = categories;
    }

    // Functions
    // Add a categorie to the list of categories
    public void addCategorie(Categorie categorie) {
        categories.add(categorie);
    }

    // Remove a categorie from the list of categories
    public void removeCategorie(Categorie categorie) {
        categories.remove(categorie);
    }

    // Add a caracteristique to the list of caracteristiques
    public void addCaracteristique(Caracteristique caracteristique) {
        caracteristiques.add(caracteristique);
    }

    // Remove a caracteristique from the list of caracteristiques
    public void removeCaracteristique(Caracteristique caracteristique) {
        caracteristiques.remove(caracteristique);
    }

    // Create a product
    public void creerProduit(String nom, int prix_revient, int stock, ArrayList<Categorie> categories) {
        this.nom = nom;
        this.prix_revient = prix_revient;
        this.stock = stock;
        this.caracteristiques = caracteristiques;
        this.categories = categories;
    }
    public String getCategoriesAsString() {
        StringBuilder stringBuilder = new StringBuilder();

        // Iterate over each category in the list
        for (Categorie categorie : categories) {
            // Append the category name to the string builder
            stringBuilder.append(categorie.getNom());

            // Append a semicolon if it's not the last category
            if (categories.indexOf(categorie) < categories.size() - 1) {
                stringBuilder.append(";");
            }
        }

        // Return the string representation of categories
        return stringBuilder.toString();
    }
    public String[] setCategoriesFromString(String categoriesString) {
        // Split the string into an array of category names
        String[] categoryNames = categoriesString.split(";");

        return categoryNames;
    }
}

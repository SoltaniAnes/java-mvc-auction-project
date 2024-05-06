package main.java.model;

public class Categorie {

    // Attributes
    private String nom;
    private String description;

    // Constructor
    public Categorie(String nom, String description) {
        this.nom = nom;
        this.description = description;
    }

    // Getters
    public String getNom() {
        return nom;
    }

    public String getDescription() {
        return description;
    }

    // Setters
    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
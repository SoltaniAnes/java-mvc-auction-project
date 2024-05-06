package main.java.model;
import java.util.ArrayList;

public class Caracteristique {

    // Attributes
    private String nom;
    private ArrayList<String> valeurs;

    // Constructor
    public Caracteristique(String nom, ArrayList<String> valeurs) {
        this.nom = nom;
        this.valeurs = valeurs;
    }

    // Getters
    public String getNom() {
        return nom;
    }

    public ArrayList<String> getValeurs() {
        return valeurs;
    }

    // Setters
    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setValeurs(ArrayList<String> valeurs) {
        this.valeurs = valeurs;
    }

    public void addValeur(String valeur) {
        valeurs.add(valeur);
    }
}
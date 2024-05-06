package main.java.model;
import java.util.ArrayList;

public class SalleDeVente {

    // Attributes
    private int id_salle_de_vente;
    private Categorie categorie;
    private String nom; // Optional ?
    private String description;
    private ArrayList<Vente> ventes;

    // Constructor
    public SalleDeVente(int idSalleDeVente, Categorie categorie, String nom, String description) {
        this.id_salle_de_vente = idSalleDeVente;
        this.categorie = categorie;
        this.nom = nom;
        this.description = description;
    }

    // Getters
    public Categorie getCategorie() {
        return categorie;
    }

    public String getNom() {
        return nom;
    }

    public String getDescription() {
        return description;
    }

    public ArrayList<Vente> getVentes() {
        return ventes;
    }

    // Setters
    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setVentes(ArrayList<Vente> ventes) {
        this.ventes = ventes;
    }

    // Functions
    // Add a vente to the list of ventes
    public void addVente(Vente vente) {
        ventes.add(vente);
    }

    // Remove a vente from the list of ventes
    public void removeVente(Vente vente) {
        ventes.remove(vente);
    }
}
package main.java.model;
import java.util.ArrayList;
import java.util.UUID;

public class SalleDeVente {

    // Attributes
    private UUID id_salle_de_vente;
    private Categorie categorie;
    private String nom; // Optional ?
    private String description;
    private ArrayList<Vente> ventes;

    // Constructor
    public SalleDeVente(Categorie categorie, String nom, String description) {
        this.id_salle_de_vente = UUID.randomUUID();
        this.categorie = categorie;
        this.nom = nom;
        this.description = description;
    }

    // Getters
    public UUID getId_salle_de_vente() {
        return id_salle_de_vente;
    }
    
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
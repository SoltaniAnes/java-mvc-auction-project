public class Produit {

    private String Nom;
    private int Prix_revient;
    private int Stock;

    public String getNom() {
        return Nom;
    }

    public void setNom(String nom) {
        Nom = nom;
    }

    public void setPrix_revient(int prix_revient) {
        Prix_revient = prix_revient;
    }

    public void setStock(int Stock) {
        this.Stock = Stock;
    }

    public int getPrix_revient() {
        return Prix_revient;
    }

    public int getStock() {
        return stock;
    }
}

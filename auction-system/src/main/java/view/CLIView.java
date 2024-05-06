package main.java.view;

public class CLIView {

    // Functions
    // Display the main menu
    public void displayMainMenu() {
        System.out.println("Bienvenue dans le système d'enchères. \n");
        System.out.println("1. Gestion des produits");
        System.out.println("3. Gestion des ventes");
        System.out.println("4. Gestion des clients");
        System.out.println("5. Gestion des encheres");
        System.out.println("6. Quitter");
    }

    // Display the gestion des produits menu
    public void displayGestionDesProduitsMenu() {
        System.out.println("1. Ajouter un produit");
        System.out.println("2. Modifier un produit");
        System.out.println("3. Supprimer un produit");
        System.out.println("4. Retour");
    }

    // Display the gestion des salles de vente menu
    public void displayGestionDesSallesDeVenteMenu() {
        System.out.println("1. Ajouter une salle de vente");
        System.out.println("2. Modifier une salle de vente");
        System.out.println("3. Supprimer une salle de vente");
        System.out.println("4. Retour");
    }

    // Display message
    public void displayMessage(String message) {
        System.out.println(message);
    }

    // Display error message
    public void displayErrorMessage(String message) {
        System.err.println(message);
    }

    // Display prompt
    public void displayPrompt(String prompt) {
        System.out.print(prompt);
    }

}

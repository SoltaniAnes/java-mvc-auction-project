package main.java.view;
import main.java.controller.UtilisateurController;
import main.java.model.Utilisateur;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class CLIUtilisateur {

    private UtilisateurController utilisateurController;
    private Scanner scanner;

    public CLIUtilisateur() {
        this.utilisateurController = new UtilisateurController();
        this.scanner = new Scanner(System.in);
    }

    public void afficherMenu() {
        int choix;
        do {
            System.out.println("Menu gestion des utilisateurs:");
            System.out.println("1. Lister tous les utilisateurs");
            System.out.println("2. Créer un nouvel utilisateur");
            System.out.println("3. Mettre à jour un utilisateur");
            System.out.println("4. Supprimer un utilisateur");
            System.out.println("5. Quitter");
            System.out.print("Entrez votre choix : ");
            choix = scanner.nextInt();
            scanner.nextLine(); // Pour consommer le retour à la ligne

            switch (choix) {
                case 1:
                    listerUtilisateurs();
                    break;
                case 2:
                    creerUtilisateur();
                    break;
                case 3:
                    mettreAJourUtilisateur();
                    break;
                case 4:
                    supprimerUtilisateur();
                    break;
                case 5:
                    System.out.println("Fin du programme.");
                    break;
                default:
                    System.out.println("Choix invalide, veuillez réessayer.");
            }
        } while (choix != 5);
    }

    private void listerUtilisateurs() {
        try {
            List<Utilisateur> utilisateurs = utilisateurController.getAllUsers();
            System.out.println("Liste des utilisateurs :");
            for (Utilisateur utilisateur : utilisateurs) {
                System.out.println(utilisateur.getNom() + " " + utilisateur.getPrenom() + " (" + utilisateur.getEmail() + ")");
                System.out.println(" ");
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de la récupération des utilisateurs : " + e.getMessage());
        }
    }

    private void creerUtilisateur() {
        System.out.println("Création d'un nouvel utilisateur :");
        System.out.print("Entrez l'email de l'utilisateur : ");
        String email = scanner.nextLine();
        System.out.print("Entrez le nom de l'utilisateur : ");
        String nom = scanner.nextLine();
        System.out.print("Entrez le prénom de l'utilisateur : ");
        String prenom = scanner.nextLine();
        System.out.print("Entrez l'adresse de l'utilisateur : ");
        String adresse = scanner.nextLine();
        System.out.println(email + " " + nom + " " + prenom + " " + adresse);

//        try {
//            utilisateurController.createUtilisateur(email, nom, prenom, adresse);
//            System.out.println("Utilisateur créé avec succès !");
//        } catch (SQLException e) {
//            System.out.println("Erreur lors de la création de l'utilisateur : " + e.getMessage());
//        }
    }

    private void mettreAJourUtilisateur() {
        System.out.println("Mise à jour des informations d'un utilisateur :");
        System.out.print("Entrez l'email de l'utilisateur à mettre à jour : ");
        String email = scanner.nextLine();

        try {
            Utilisateur utilisateur = utilisateurController.findUserByEmail(email);
            if (utilisateur != null) {
                System.out.print("Nouvel email : ");
                String nouvelEmail = scanner.nextLine();
                System.out.print("Nouveau nom : ");
                String nom = scanner.nextLine();
                System.out.print("Nouveau prénom : ");
                String prenom = scanner.nextLine();
                System.out.print("Nouvelle adresse : ");
                String adresse = scanner.nextLine();

                utilisateur.setEmail(nouvelEmail);
                utilisateur.setNom(nom);
                utilisateur.setPrenom(prenom);
                utilisateur.setAdresse(adresse);

                utilisateurController.updateUser(utilisateur);
                System.out.println("Utilisateur mis à jour avec succès !");
            } else {
                System.out.println("Aucun utilisateur trouvé avec cet email.");
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de la mise à jour de l'utilisateur : " + e.getMessage());
        }
    }

    private void supprimerUtilisateur() {
        System.out.println("Suppression d'un utilisateur :");
        System.out.print("Entrez l'email de l'utilisateur à supprimer : ");
        String email = scanner.nextLine();

        try {
            Utilisateur utilisateur = utilisateurController.findUserByEmail(email);
            if (utilisateur != null) {
                utilisateurController.deleteUser(utilisateur);
                System.out.println("Utilisateur supprimé avec succès !");
            } else {
                System.out.println("Aucun utilisateur trouvé avec cet email.");
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de la suppression de l'utilisateur : " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        CLIUtilisateur utilisateurView = new CLIUtilisateur();
        utilisateurView.afficherMenu();
    }
}

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utilisateur {
    private String email;
    private String nom;
    private String prenom;
    private String adresse;

    // Constructor
    public Utilisateur(String email, String nom, String prenom, String adresse) {
        if (!isValidEmail(email)) {
            throw new IllegalArgumentException("Format d'email invalide.");
        }
        this.email = email;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
    }



    // Getters
    public String getEmail() {
        return email;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    // Setters
    public void setEmail(String email) {
        if (!isValidEmail(email)) {
            throw new IllegalArgumentException("Format d'email invalide.");
        }
        this.email = email;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    // Functions
    // Check if the email is valid
    private boolean isValidEmail(String email) {
        String regex = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}

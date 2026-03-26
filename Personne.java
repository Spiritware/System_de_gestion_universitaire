import java.time.LocalDate;

/**
 * Classe abstraite représentant toute personne dans le système CampusConnect.
 */
public abstract class Personne {
    private String id;
    private String nom;
    private String prenom;
    private String email;
    private LocalDate dateNaissance;

    public Personne(String id, String nom, String prenom, String email, LocalDate dateNaissance) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.dateNaissance = dateNaissance;
    }

    // Méthode polymorphique à redéfinir dans chaque sous-classe
    public abstract void afficherDetails();

    public String getNomComplet() {
        return prenom + " " + nom;
    }

    // Getters
    public String getId()              { return id; }
    public String getNom()             { return nom; }
    public String getPrenom()          { return prenom; }
    public String getEmail()           { return email; }
    public LocalDate getDateNaissance(){ return dateNaissance; }

    // Setters avec validation
    public void setEmail(String email) {
        if (email == null || !email.contains("@"))
            throw new IllegalArgumentException("Email invalide.");
        this.email = email;
    }
}
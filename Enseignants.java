import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Représente un enseignant de l'ENSPD.
 */
public class Enseignants extends Personne {
    private String statut;      // "Permanent" ou "Vacataire"
    private String departement;
    private List<String> enseignements; // codes des cours enseignés

    public Enseignants(String id, String nom, String prenom, String email,
                       LocalDate dateNaissance, String statut, String departement) {
        super(id, nom, prenom, email, dateNaissance);
        this.statut        = statut;
        this.departement   = departement;
        this.enseignements = new ArrayList<>();
    }

    /** Ajoute un enseignement (code cours) à la liste de l'enseignant. */
    public void ajouterEnseignement(String codeCours) {
        if (!enseignements.contains(codeCours))
            enseignements.add(codeCours);
    }

    @Override
    public void afficherDetails() {
        System.out.println("ENSEIGNANT - Statut: " + statut
            + " | Nom: " + getNomComplet()
            + " | Département: " + departement);
    }

    // Getters
    public String getStatut()                   { return statut; }
    public String getDepartement()              { return departement; }
    public List<String> getEnseignements()      { return enseignements; }
}

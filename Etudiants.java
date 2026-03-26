import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Représente un étudiant inscrit à l'ENSPD.
 */
public class Etudiants extends Personne {
    private String matricule;
    private String filiere;
    private String anneeEtude; // Ex: L1, L2, L3, M1, M2

    private List<Notes> notes;
    private List<String> coursInscrits; // codes des cours

    public Etudiants(String id, String nom, String prenom, String email,
                    LocalDate dateNaissance, String matricule, String filiere, String anneeEtude) {
        super(id, nom, prenom, email, dateNaissance);
        this.matricule   = matricule;
        this.filiere     = filiere;
        this.anneeEtude  = anneeEtude;
        this.notes       = new ArrayList<>();
        this.coursInscrits = new ArrayList<>();
    }

    /** Ajoute une note à l'étudiant. */
    public void ajouterNote(Notes note) {
        this.notes.add(note);
    }

    /** Calcule la moyenne pondérée pour un cours donné. */
    public double calculerMoyenne(String codeCours) {
        double somme = 0, totalCoeff = 0;
        for (Notes n : notes) {
            if (n.getCodeCours().equals(codeCours)) {
                somme      += n.getValeur() * n.getCoefficient();
                totalCoeff += n.getCoefficient();
            }
        }
        if (totalCoeff == 0) return 0;
        return somme / totalCoeff;
    }

    /** Affiche le relevé de notes complet de l'étudiant. */
    public void afficherReleve() {
        System.out.println("=== Relevé de notes de " + getNomComplet() + " ===");
        for (Notes n : notes) {
            System.out.println("Cours: " + n.getCodeCours()
                + " | Note: " + n.getValeur()
                + " | Coeff: " + n.getCoefficient());
        }
    }

    /** Inscrit l'étudiant à un cours (par code). */
    public void inscrireCours(String codeCours) {
        if (!coursInscrits.contains(codeCours))
            coursInscrits.add(codeCours);
    }

    @Override
    public void afficherDetails() {
        System.out.println("ETUDIANT - Matricule: " + matricule
            + " | Nom: " + getNomComplet()
            + " | Filière: " + filiere
            + " | Année: " + anneeEtude);
    }

    // Getters
    public String getMatricule()         { return matricule; }
    public String getFiliere()           { return filiere; }
    public String getAnneeEtude()        { return anneeEtude; }
    public List<Notes> getListeNotes()   { return notes; }
    public List<String> getCoursInscrits() { return coursInscrits; }
}

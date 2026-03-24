public class Notes {
    private String codeCours;
    private double valeur;
    private double coefficient;
    private String intitule; // ex: "Devoir 1", "Examen final"

    public Notes(String codeCours, String intitule, double valeur, double coefficient) {
        if (valeur < 0 || valeur > 20)
            throw new IllegalArgumentException("La note doit être comprise entre 0 et 20.");
        if (coefficient <= 0)
            throw new IllegalArgumentException("Le coefficient doit être positif.");
        this.codeCours   = codeCours;
        this.intitule    = intitule;
        this.valeur      = valeur;
        this.coefficient = coefficient;
    }

    // Getters
    public String getCodeCours()   { return codeCours; }
    public String getIntitule()    { return intitule; }
    public double getValeur()      { return valeur; }
    public double getCoefficient() { return coefficient; }

    @Override
    public String toString() {
        return intitule + " [" + codeCours + "] : " + valeur + "/20 (coeff. " + coefficient + ")";
    }
}
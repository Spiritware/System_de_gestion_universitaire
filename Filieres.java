
public class Filieres {
    private String code;
    private String libelle;

    public Filieres(String code, String libelle) {
        this.code    = code;
        this.libelle = libelle;
    }

    public String getCode()    { return code; }
    public String getLibelle() { return libelle; }

    @Override
    public String toString() {
        return code + " - " + libelle;
    }
}

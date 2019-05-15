package ca.ikeypro.DAO;

/**
 *
 * @author Judith
 */
public class License {

    private int idLicense;
    private String license;
    private String codeProduit;
    private String etat;

    public License(int idLicense, String license, String codeProduit, String etat) {
        this.idLicense = idLicense;
        this.license = license;
        this.codeProduit = codeProduit;
        this.etat = etat;
    }

    public int getIdLicense() {
        return idLicense;
    }

    public void setIdLicense(int idLicense) {
        this.idLicense = idLicense;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public String getCodeProduit() {
        return codeProduit;
    }

    public void setCodeProduit(String codeProduit) {
        this.codeProduit = codeProduit;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

}

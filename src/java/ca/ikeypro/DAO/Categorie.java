package ca.ikeypro.DAO;

/**
 * @author Anis
 */
public class Categorie {

    private String idCategorie;
    private String categorie;

    public Categorie() {
    }

    public Categorie(String idCategorie, String categorie) {
        this.idCategorie = idCategorie;
        this.categorie = categorie;
    }

    public String getIdCategorie() {
        return idCategorie;
    }

    public void setIdCategorie(String idCategorie) {
        this.idCategorie = idCategorie;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }
}

package ca.ikeypro.DAO;

/**
 *
 * @author Judith
 */
public class Edition {
    
    private String id_Edition;
    private String Edition;
    public Edition() {
    }

    public Edition(String id_Edition, String Edition) {
        this.id_Edition = id_Edition;
        this.Edition = Edition;
    }

    public String getId_Edition() {
        return id_Edition;
    }

    public void setId_Edition(String id_Edition) {
        this.id_Edition = id_Edition;
    }

    public String getEdition() {
        return Edition;
    }

    public void setEdition(String Edition) {
        this.Edition = Edition;
    }
    
}

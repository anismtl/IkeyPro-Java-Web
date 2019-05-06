package ca.ikeypro.DAO;

/**
 * @author Judith
 */
public class Client {
    private int idClient;
    private String nomClient;
    private String prenomClient;
    private String courriel;
    private String tel;
    private String adresseClient;
    private String motPasse;

    public Client(){}
    
    public Client(int idClient, String nomClient, String prenomClient, String courriel, String tel, String adresseClient, String motPasse) {
        this.idClient = idClient;
        this.nomClient = nomClient;
        this.prenomClient = prenomClient;
        this.courriel = courriel;
        this.tel = tel;
        this.adresseClient = adresseClient;
        this.motPasse = motPasse;
    }

    public Client(String nomClient, String prenomClient, String courriel, String tel, String adresseClient, String motPasse) {
        this.nomClient = nomClient;
        this.prenomClient = prenomClient;
        this.courriel = courriel;
        this.tel = tel;
        this.adresseClient = adresseClient;
        this.motPasse = motPasse;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public String getNomClient() {
        return nomClient;
    }

    public void setNomClient(String nomClient) {
        this.nomClient = nomClient;
    }

    public String getPrenomClient() {
        return prenomClient;
    }

    public void setPrenomClient(String prenomClient) {
        this.prenomClient = prenomClient;
    }

    public String getCourriel() {
        return courriel;
    }

    public void setCourriel(String courriel) {
        this.courriel = courriel;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getAdresseClient() {
        return adresseClient;
    }

    public void setAdresseClient(String adresseClient) {
        this.adresseClient = adresseClient;
    }

    public String getMotPasse() {
        return motPasse;
    }

    public void setMotPasse(String motPasse) {
        this.motPasse = motPasse;
    }

    @Override
    public String toString() {
        return "Client{" + "idClient=" + idClient + ", nomClient=" + nomClient + ", prenomClient=" + prenomClient + ", courriel=" + courriel + ", tel=" + tel + ", adresseClient=" + adresseClient + ", motPasse=" + motPasse + '}';
    }
    
    
}

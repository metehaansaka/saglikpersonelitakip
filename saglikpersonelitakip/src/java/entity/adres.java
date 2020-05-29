
package entity;

public class adres {
    private int adres_id;
    private int hasta_id;
    private String adres;

    public adres() {
    }

    public adres(int adres_id, int hasta_id, String adres) {
        this.adres_id = adres_id;
        this.hasta_id = hasta_id;
        this.adres = adres;
    }

    @Override
    public String toString() {
        return "adres{" + "adres_id=" + adres_id + ", hasta_id=" + hasta_id + ", adres=" + adres + '}';
    }

    public int getAdres_id() {
        return adres_id;
    }

    public void setAdres_id(int adres_id) {
        this.adres_id = adres_id;
    }

    public int getHasta_id() {
        return hasta_id;
    }

    public void setHasta_id(int hasta_id) {
        this.hasta_id = hasta_id;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }
    
}

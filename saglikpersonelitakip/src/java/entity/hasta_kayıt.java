/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author lenovo
 */
public class hasta_kayıt {
    private int hasta_id;
    private String hasta_ad;
    private String hasta_soyad;
    private String hasta_adres;
    private String hasta_ihtiyacsaati;
    private String hasta_acıklama; 
    
    
   

    public hasta_kayıt(int hasta_id, String hasta_ad, String hasta_soyad, String hasts_adres, String hasta_ihtiyacsaati, String hasta_acıklama) {
        this.hasta_id = hasta_id;
        this.hasta_ad = hasta_ad;
        this.hasta_soyad = hasta_soyad;
        this.hasta_adres = hasts_adres;
        this.hasta_ihtiyacsaati = hasta_ihtiyacsaati;
        this.hasta_acıklama = hasta_acıklama;
    }

    @Override
    public String toString() {
        return "hasta_kay\u0131t{" + "hasta_id=" + hasta_id + ", hasta_ad=" + hasta_ad + ", hasta_soyad=" + hasta_soyad + ", hasta_adres=" + hasta_adres + ", hasta_ihtiyacsaati=" + hasta_ihtiyacsaati + ", hasta_ac\u0131klama=" + hasta_acıklama + '}';
    }
    
    
    
    

    public int getHasta_id() {
        return hasta_id;
    }

    public void setHasta_id(int hasta_id) {
        this.hasta_id = hasta_id;
    }

    public String getHasta_ad() {
        return hasta_ad;
    }

    public void setHasta_ad(String hasta_ad) {
        this.hasta_ad = hasta_ad;
    }

    public String getHasta_soyad() {
        return hasta_soyad;
    }

    public void setHasta_soyad(String hasta_soyad) {
        this.hasta_soyad = hasta_soyad;
    }

    public String getHasta_adres() {
        return hasta_adres;
    }

    public void setHasta_adres(String hasts_adres) {
        this.hasta_adres = hasta_adres;
    }

    public String getHasta_ihtiyacsaati() {
        return hasta_ihtiyacsaati;
    }

    public void setHasta_ihtiyacsaati(String hasta_ihtiyacsaati) {
        this.hasta_ihtiyacsaati = hasta_ihtiyacsaati;
    }

    public String getHasta_acıklama() {
        return hasta_acıklama;
    }

    public void setHasta_acıklama(String hasta_acıklama) {
        this.hasta_acıklama = hasta_acıklama;
    }
    
    
    
}

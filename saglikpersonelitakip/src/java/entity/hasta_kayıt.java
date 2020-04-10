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
    private String hasta_ihtiyacsaati;
    private String hasta_aciklama; 

    public hasta_kayıt(int hasta_id, String hasta_ad, String hasta_soyad, String hasta_aciklama) {
        this.hasta_id = hasta_id;
        this.hasta_ad = hasta_ad;
        this.hasta_soyad = hasta_soyad;
        this.hasta_aciklama = hasta_aciklama;
    }

    public hasta_kayıt() {

        }
    

    @Override
    public String toString() {
        return "hasta_kay\u0131t{" + "hasta_id=" + hasta_id + ", hasta_ad=" + hasta_ad + ", hasta_soyad=" + hasta_soyad + ", hasta_aciklama=" + hasta_aciklama + '}';
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

    public String getHasta_acıklama() {
        return hasta_aciklama;
    }

    public void setHasta_acıklama(String hasta_acıklama) {
        this.hasta_aciklama = hasta_acıklama;
    }
    
    
    
}

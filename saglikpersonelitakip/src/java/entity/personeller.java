/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author Metehan
 */
public class personeller {

    private int personel_id;
    private String persone_adsoyad;
    private String personel_telefon;
    private String personel_cinsiyet;
    private String personel_brans;

    @Override
    public String toString() {
        return "personeller{" + "personel_id=" + personel_id + ", persone_adsoyad=" + persone_adsoyad + ", personel_telefon=" + personel_telefon + ", personel_cinsiyet=" + personel_cinsiyet + ", personel_brans=" + personel_brans + '}';
    }

    public personeller() {
    }

    public personeller(int personel_id, String persone_adsoyad, String personel_telefon, String personel_cinsiyet, String personel_brans) {
        this.personel_id = personel_id;
        this.persone_adsoyad = persone_adsoyad;
        this.personel_telefon = personel_telefon;
        this.personel_cinsiyet = personel_cinsiyet;
        this.personel_brans = personel_brans;
    }

    public String getPersone_adsoyad() {
        return persone_adsoyad;
    }

    public void setPersone_adsoyad(String persone_adsoyad) {
        this.persone_adsoyad = persone_adsoyad;
    }

    public String getPersonel_telefon() {
        return personel_telefon;
    }

    public void setPersonel_telefon(String personel_telefon) {
        this.personel_telefon = personel_telefon;
    }

    public String getPersonel_cinsiyet() {
        return personel_cinsiyet;
    }

    public void setPersonel_cinsiyet(String personel_cinsiyet) {
        this.personel_cinsiyet = personel_cinsiyet;
    }

    public String getPersonel_brans() {
        return personel_brans;
    }

    public void setPersonel_brans(String personel_brans) {
        this.personel_brans = personel_brans;
    }

    public int getPersonel_id() {
        return personel_id;
    }

    public void setPersonel_id(int personel_id) {
        this.personel_id = personel_id;
    }

}

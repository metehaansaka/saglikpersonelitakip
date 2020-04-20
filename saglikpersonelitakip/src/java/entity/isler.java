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
public class isler {
    private int is_id;
    private int personel_id;
    private int hasta_id;
    private String is_yapilan;
    private String ucret;
    private String tarih;

    @Override
    public String toString() {
        return "isler{" + "is_id=" + is_id + ", personel_id=" + personel_id + ", hasta_id=" + hasta_id + ", is_yapilan=" + is_yapilan + ", ucret=" + ucret + ", tarih=" + tarih + '}';
    }

    public isler() {
    }

    public isler(int is_id, int personel_id, int hasta_id, String is_yapilan, String ucret, String tarih) {
        this.is_id = is_id;
        this.personel_id = personel_id;
        this.hasta_id = hasta_id;
        this.is_yapilan = is_yapilan;
        this.ucret = ucret;
        this.tarih = tarih;
    }
    
    
   

    public int getIs_id() {
        return is_id;
    }

    public void setIs_id(int is_id) {
        this.is_id = is_id;
    }

    public int getPersonel_id() {
        return personel_id;
    }

    public void setPersonel_id(int personel_id) {
        this.personel_id = personel_id;
    }

    public int getHasta_id() {
        return hasta_id;
    }

    public void setHasta_id(int hasta_id) {
        this.hasta_id = hasta_id;
    }

    public String getIs_yapilan() {
        return is_yapilan;
    }

    public void setIs_yapilan(String is_yapilan) {
        this.is_yapilan = is_yapilan;
    }

    public String getUcret() {
        return ucret;
    }

    public void setUcret(String ucret) {
        this.ucret = ucret;
    }

    public String getTarih() {
        return tarih;
    }

    public void setTarih(String tarih) {
        this.tarih = tarih;
    }
    
}

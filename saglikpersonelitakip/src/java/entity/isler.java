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
    private hasta_kayıt hasta;
    private String is_yapilan;
    private String ucret;
    private String tarih;

    @Override
    public String toString() {
        return "isler{" + "is_id=" + is_id + ", personel_id=" + personel_id + ", hasta_id=" + hasta.getHasta_id() + ", is_yapilan=" + is_yapilan + ", ucret=" + ucret + ", tarih=" + tarih + '}';
    }

    public isler() {
    }

    public isler(int is_id, int personel_id, hasta_kayıt hasta, String is_yapilan, String ucret, String tarih) {
        this.is_id = is_id;
        this.personel_id = personel_id;
        this.hasta = hasta;
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

    public hasta_kayıt getHasta() {
        if (this.hasta==null) {
            this.hasta=new hasta_kayıt();
        }
        return hasta;
    }

    public void setHasta(hasta_kayıt hasta) {
        this.hasta = hasta;
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

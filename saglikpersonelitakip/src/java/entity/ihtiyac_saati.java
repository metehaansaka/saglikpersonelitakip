/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;


import static com.oracle.wls.shaded.org.apache.xalan.lib.ExsltDatetime.time;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


/**
 *
 * @author lenovo
 */
public class ihtiyac_saati {
    private int ihtiyac_id;
    private int hasta_id;
    private String gun;
    private time saat;

    @Override
    public String toString() {
        return "ihtiyac_saati{" + "ihtiyac_id=" + ihtiyac_id + ", hasta_id=" + hasta_id + ", gun=" + gun + ", saat=" + saat + '}';
    }
    

    public ihtiyac_saati(int ihtiyac_id, int hasta_id, String gun, time saat) {
        this.ihtiyac_id = ihtiyac_id;
        this.hasta_id = hasta_id;
        this.gun = gun;
        this.saat = saat;
    }

    public int getIhtiyac_id() {
        return ihtiyac_id;
    }

    public void setIhtiyac_id(int ihtiyac_id) {
        this.ihtiyac_id = ihtiyac_id;
    }

    public int getHasta_id() {
        return hasta_id;
    }

    public void setHasta_id(int hasta_id) {
        this.hasta_id = hasta_id;
    }

    public String getGun() {
        return gun;
    }

    public void setGun(String gun) {
        this.gun = gun;
    }

    public time getSaat() {
        return saat;
    }

    public void setSaat(time saat) {
        this.saat = saat;
    }
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ihtiyac_saatiDAO;
import entity.adres;
import entity.hasta_kayıt;
import entity.ihtiyac_saati;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author lenovo
 */
@Named
@SessionScoped
public class ihtiyac_saatiController implements Serializable{
    private List<ihtiyac_saati> ihList;
    private ihtiyac_saatiDAO ihdao;
    private ihtiyac_saati ih;
    adresController ac = new adresController();
    private List<adres> ad;
    private int a;
    
    public String listele(int a){
        this.a=a;
        this.ihList=this.getIhdao().getIhtiyacSaati(a);
        this.ad= ac.listele(a);
        this.ih = new ihtiyac_saati();
        return "ihtiyacsaati";
    }
    
    public String delete(ihtiyac_saati a){
        this.getIhdao().delete(a);
        this.ihList=this.getIhdao().getIhtiyacSaati(this.getA());
        return "ihtiyacsaati";
    }
    public String select(ihtiyac_saati a){
        this.ih=a;
        return "ihtiyacsaati";
    }
    
    public String update(){
        this.getIhdao().update(this.ih);
        this.ih = new ihtiyac_saati();
        return "ihtiyacsaati";
    }
    
    public String reset (){
        this.ih=new ihtiyac_saati();
        return "ihtiyacsaati";
    }
    
    public String create(int a){
        this.getIhdao().insert(a,this.ih);
        this.ih = new ihtiyac_saati();  
        this.ihList=this.getIhdao().getIhtiyacSaati(this.getA());
        return "ihtiyacsaati";
    }
    
    public List<ihtiyac_saati> getIhList() {
        return ihList;
    }

    public void setIhList(List<ihtiyac_saati> ihList) {
        this.ihList = ihList;
    }

    public ihtiyac_saatiDAO getIhdao() {
        if (this.ihdao==null) {
            this.ihdao=new ihtiyac_saatiDAO();
        }
        return ihdao;
    }

    public void setIhdao(ihtiyac_saatiDAO ihdao) {
        this.ihdao = ihdao;
    }

    public ihtiyac_saati getIh() {
        if (this.ih==null) {
            this.ih=new ihtiyac_saati();
        }
        return ih;
    }

    public void setIh(ihtiyac_saati ih) {
        this.ih = ih;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public List<adres> getAd() {
        return ad;
    }

    public void setAd(List<adres> ad) {
        this.ad = ad;
    }
    
    
    
}

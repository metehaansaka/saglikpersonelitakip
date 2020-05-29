package controller;

import dao.bossaatlerDAO;
import entity.bossaatler;
import entity.hasta_kayıt;
import entity.isler;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class bossaatController implements Serializable {

    private List<bossaatler> saatlist;
    private bossaatlerDAO saatDao;
    private bossaatler bossaat;
    private int a;
    
    public hasta_kayıt getById(int id){
       return this.getSaatDao().getById(id);
    }
    
    public String delete(bossaatler b) {
        this.getSaatDao().delete(b);
        this.saatlist=this.getSaatDao().getBossaatlerr(this.getA());
        return "bossaatler";
    }
    
    public String updateForm(bossaatler b){
        this.bossaat = b;
        return "bossaatler";
    }
    public String reset(){
        this.bossaat = new bossaatler();
        return "bossaatler";
    }
    public String uptade(){
        this.getSaatDao().update(this.bossaat);
        this.bossaat=new bossaatler();
        return "bossaatler";
    }
    public String create(int id) {
        this.getSaatDao().insert(this.bossaat, id);
        this.bossaat = new bossaatler();
        this.saatlist=this.getSaatDao().getBossaatlerr(this.getA());
        return "bossaatler";
    }

    public String listele(int a) {
        this.a=a;
        this.saatlist = this.getSaatDao().getBossaatlerr(a);
        this.bossaat = new bossaatler();
        return "bossaatler";
    }

    public List<bossaatler> getSaatlist() {
        return saatlist;
    }

    public void setSaatlist(List<bossaatler> saatlist) {
        this.saatlist = saatlist;
    }

    public bossaatlerDAO getSaatDao() {
        if (this.saatDao == null) {
            this.saatDao = new bossaatlerDAO();
        }
        return saatDao;
    }

    public void setSaatDao(bossaatlerDAO saatDao) {
        this.saatDao = saatDao;
    }

    public bossaatler getBossaat() {
        if (this.bossaat == null) {
            this.bossaat = new bossaatler();
        }
        return bossaat;
    }

    public void setBossaat(bossaatler bossaat) {
        this.bossaat = bossaat;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }
    
}

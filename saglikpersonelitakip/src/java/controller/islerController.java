/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.islerDAO;
import entity.hasta_kayıt;
import entity.ihtiyac_saati;
import entity.isler;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author Metehan
 */
@Named
@SessionScoped
public class islerController implements Serializable {

    private List<isler> ilist;
    private isler i;
    private islerDAO idao;
    private List<hasta_kayıt> hlist;
    private List<ihtiyac_saati> islist;
    private int a;
    
    public String delete(int id){
        this.getIdao().delete(id);
        this.ilist = this.getIdao().getIsler(a);
        return "bossaatler";
    }
    
    public String select(isler is){
        this.i=is;
        return "bossaatler";
    }
    
    public String update(){
        this.getIdao().update(this.i);
        return "bossaatler";
    }
    
    public String reset(){
        this.i=new isler();
        return "bossaatler";
    }
    
    public String create(int id) {
        this.getIdao().getInsert(id, this.i);
        this.i = new isler();
        return "bossaatler";
    }

    public String hastaCagir(int id) {
        this.hlist = this.getIdao().getHastaCagir(id);
        this.islist = this.getIdao().getIhtiyacSaati(id);
        return "hasta";
    }

    public String Listele(int a) {
        this.ilist = this.getIdao().getIsler(a);
        this.a = a;
        return "bossaatler";
    }

    public List<isler> getIlist() {
        return ilist;
    }

    public void setIlist(List<isler> ilist) {
        this.ilist = ilist;
    }

    public isler getI() {
        if (this.i == null) {
            this.i = new isler();
        }
        return i;
    }

    public void setI(isler i) {
        this.i = i;
    }

    public islerDAO getIdao() {
        if (this.idao == null) {
            this.idao = new islerDAO();
        }
        return idao;
    }

    public void setIdao(islerDAO idao) {
        this.idao = idao;
    }

    public List<hasta_kayıt> getHlist() {
        return hlist;
    }

    public void setHlist(List<hasta_kayıt> hlist) {
        this.hlist = hlist;
    }

    public List<ihtiyac_saati> getIslist() {
        return islist;
    }

    public void setIslist(List<ihtiyac_saati> islist) {
        this.islist = islist;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

}

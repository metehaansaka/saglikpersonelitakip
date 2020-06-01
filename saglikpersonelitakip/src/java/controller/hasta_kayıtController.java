/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.hasta_kayıtDAO;
import entity.hasta_kayıt;
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
public class hasta_kayıtController implements Serializable {

    private List<hasta_kayıt> hkList;
    private hasta_kayıtDAO hkdao;
    private hasta_kayıt hasta;
    private int page = 1;
    private int pageSize = 5;
    private int pageCount;
    
    public void ileri(){
        if (this.page==this.pageCount) {
            this.page=1;
        }else{
            this.page++;
        }
    }
    
    public void geri(){
        if (this.page==1) {
            this.page=this.pageCount;
        }else{
            this.page--;
        }
    }
    
    
    public String delete(int h) {
        this.getHkdao().verisil(h);
        return "hastakayit";
    }

    public String update() {
        this.getHkdao().veriduzenle(this.hasta.getHasta_id(), this.hasta.getHasta_ad(), this.hasta.getHasta_soyad(), this.hasta.getHasta_acıklama());
        return "hastakayit";
    }

    public String reset() {
        this.hasta = new hasta_kayıt();
        return "hastakayit";
    }

    public String select(hasta_kayıt h) {
        this.hasta = h;
        return "hastakayit";
    }

    public String create() {
        this.getHkdao().veriekle(this.hasta.getHasta_ad(), this.hasta.getHasta_soyad(), this.hasta.getHasta_acıklama());
        return "hastakayit";
    }

    public List<hasta_kayıt> getHkList() {
        this.hkList = this.getHkdao().getHastaKayit(page,pageSize);
        return hkList;
    }

    public void setHkList(List<hasta_kayıt> hkList) {
        this.hkList = hkList;
    }

    public hasta_kayıtDAO getHkdao() {
        if (this.hkdao == null) {
            this.hkdao = new hasta_kayıtDAO();
        }
        return hkdao;
    }

    public void setHkdao(hasta_kayıtDAO hkdao) {
        this.hkdao = hkdao;
    }

    public hasta_kayıt getHasta() {
        if (this.hasta == null) {
            this.hasta = new hasta_kayıt();
        }
        return hasta;
    }

    public void setHasta(hasta_kayıt hasta) {
        this.hasta = hasta;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageCount() {
        this.pageCount = (int) Math.ceil(this.getHkdao().count() / (double) this.pageSize);
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

}

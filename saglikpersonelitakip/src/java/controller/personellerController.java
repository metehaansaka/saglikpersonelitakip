/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.personellerDAO;
import entity.personeller;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.servlet.http.Part;

/**
 *
 * @author Metehan
 */
@Named
@SessionScoped
public class personellerController implements Serializable {

    private List<personeller> pplist;
    private personellerDAO pdao;
    private personeller personel;
    private int page = 1;
    private int pageSize = 5;
    private int pageCount;
    private Part doc;

    public void ileri() {
        if (this.page == this.pageCount) {
            this.page = 1;
        } else {
            this.page++;
        }
    }

    public void geri() {
        if (this.page == 1) {
            this.page = this.pageCount;
        } else {
            this.page--;
        }
    }

    public String reset() {
        this.personel = new personeller();
        return "personeller";
    }

    public void delete(personeller p) {
        this.getPdao().delete(p);
    }

    public void select(personeller p) {
        this.personel = p;
    }

    public String update() {
        this.getPdao().update(this.personel);
        this.personel = new personeller();
        return "personeller";
    }

    public String create() {
        this.getPdao().insert(this.personel);
        fileController fc = new fileController();
        fc.upload(this.doc);
        return "personeller";
    }

    public List<personeller> getPplist() {
        this.pplist = this.getPdao().getPersonell(page, pageSize);
        return pplist;
    }

    public void setPplist(List<personeller> pplist) {
        this.pplist = pplist;
    }

    public personellerDAO getPdao() {
        if (this.pdao == null) {
            this.pdao = new personellerDAO();
        }
        return pdao;
    }

    public void setPdao(personellerDAO pdao) {
        this.pdao = pdao;
    }

    public personeller getPersonel() {
        if (this.personel == null) {
            this.personel = new personeller();
        }
        return personel;
    }

    public void setPersonel(personeller personel) {
        this.personel = personel;
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
        this.pageCount = (int) Math.ceil(this.getPdao().count() / (double) this.pageSize);
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public Part getDoc() {
        return doc;
    }

    public void setDoc(Part doc) {
        this.doc = doc;
    }
    
}

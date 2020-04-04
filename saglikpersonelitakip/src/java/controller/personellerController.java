/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.personellerDAO;
import entity.personeller;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

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
    
    public String delete(personeller p) {
        this.getPdao().delete(p);
        return "personeller";
    }

    public String create() {
        this.getPdao().insert(this.personel);
        return "personeller";
    }

    public List<personeller> getPplist() {
        this.pplist = this.getPdao().getPersonell();
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

}

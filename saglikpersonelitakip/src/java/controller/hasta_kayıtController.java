/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.hasta_kayıtDAO;
import entity.hasta_kayıt;
import java.io.Serializable;
import java.util.ArrayList;
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
    
  

    public List<hasta_kayıt> getHkList() {
        return hkList;
    }

    public void setHkList(List<hasta_kayıt> hkList) {
        this.hkList = hkList;
    }

    public hasta_kayıtDAO getHkdao() {
        return hkdao;
    }

    public void setHkdao(hasta_kayıtDAO hkdao) {
        this.hkdao = hkdao;
    }

    public hasta_kayıt getHasta() {
        return hasta;
    }

    public void setHasta(hasta_kayıt hasta) {
        this.hasta = hasta;
    }

    public hasta_kayıtController() {
         this.hkList=new ArrayList();
        this.hkdao=new hasta_kayıtDAO ();
    }
    

    
    
    
    
    
}

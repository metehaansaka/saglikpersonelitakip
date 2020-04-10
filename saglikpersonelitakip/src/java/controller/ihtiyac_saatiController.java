/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ihtiyac_saatiDAO;
import entity.ihtiyac_saati;
import java.util.List;

/**
 *
 * @author lenovo
 */
public class ihtiyac_saatiController {
    private List<ihtiyac_saati> ihList;
    private ihtiyac_saatiDAO ihdao;
    private ihtiyac_saati ih;

    public List<ihtiyac_saati> getIhList() {
        return ihList;
    }

    public void setIhList(List<ihtiyac_saati> ihList) {
        this.ihList = ihList;
    }

    public ihtiyac_saatiDAO getIhdao() {
        return ihdao;
    }

    public void setIhdao(ihtiyac_saatiDAO ihdao) {
        this.ihdao = ihdao;
    }

    public ihtiyac_saati getIh() {
        return ih;
    }

    public void setIh(ihtiyac_saati ih) {
        this.ih = ih;
    }
    
    
    
}


package controller;

import dao.bransDAO;
import entity.brans;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class bransController implements Serializable{
    List<brans> bransList;
    bransDAO bDAO;
    brans brans;

    public List<brans> getBransList() {
        this.bransList = this.getbDAO().getBrans();
        return bransList;
    }

    public void setBransList(List<brans> bransList) {
        this.bransList = bransList;
    }

    public bransDAO getbDAO() {
        if (this.bDAO==null) {
            this.bDAO= new bransDAO();
        }
        return bDAO;
    }

    public void setbDAO(bransDAO bDAO) {
        this.bDAO = bDAO;
    }

    public brans getBrans() {
        if (this.brans==null) {
            this.brans = new brans();
        }
        return brans;
    }

    public void setBrans(brans brans) {
        this.brans = brans;
    }
    
    
}

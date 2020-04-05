
package controller;

import dao.bossaatlerDAO;
import entity.bossaatler;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class bossaatController implements Serializable{
    private List<bossaatler> saatlist;
    private bossaatlerDAO saatDao;
    private bossaatler bossaat;
    
    public String listele(int a){
        this.saatlist = this.getSaatDao().getBossaatlerr(a);
        return "bossaatler";
    }

    public List<bossaatler> getSaatlist() {
        return saatlist;
    }

    public void setSaatlist(List<bossaatler> saatlist) {
        this.saatlist = saatlist;
    }

    public bossaatlerDAO getSaatDao() {
        if (this.saatDao==null) {
            this.saatDao=new bossaatlerDAO();
        }
        return saatDao;
    }

    public void setSaatDao(bossaatlerDAO saatDao) {
        this.saatDao = saatDao;
    }

    public bossaatler getBossaat() {
        if (this.bossaat==null) {
            this.bossaat=new bossaatler();
        }
        return bossaat;
    }

    public void setBossaat(bossaatler bossaat) {
        this.bossaat = bossaat;
    }
    
    
}

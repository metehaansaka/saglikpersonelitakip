
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

    public bossaatController() {
        this.saatlist = new ArrayList();
        this.saatDao = new bossaatlerDAO();
    }

    public List<bossaatler> getSaatlist() {
        this.saatlist = this.getSaatDao().getBossaatlerr();
        return saatlist;
    }

    public void setSaatlist(List<bossaatler> saatlist) {
        this.saatlist = saatlist;
    }

    public bossaatlerDAO getSaatDao() {
        return saatDao;
    }

    public void setSaatDao(bossaatlerDAO saatDao) {
        this.saatDao = saatDao;
    }
    
    
}

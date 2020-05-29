package controller;

import dao.adresDAO;
import entity.adres;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class adresController implements Serializable {

    private List<adres> alist;
    private adresDAO adao;
    private adres a;
    
    
    public adresController() {
    }

    public String delete(int id) {
        this.getAdao().delete(id);
        return "ihtiyacsaati";
    }

    public String sec(adres ad) {
        this.a = ad;
        return "ihtiyacsaati";
    }

    public String update(int id) {
        this.getAdao().update(id, this.a);
        this.a = new adres();
        return "ihtiyacsaati";
    }

    public String insert(int id) {
        this.getAdao().insert(id, this.a);
        this.a = new adres();
        return "ihtiyacsaati";
    }

    public List<adres> getAlist() {
        return alist;
    }

    public void setAlist(List<adres> alist) {
        this.alist = alist;
    }

    public adresDAO getAdao() {
        if (this.adao == null) {
            this.adao = new adresDAO();
        }
        return adao;
    }

    public void setAdao(adresDAO adao) {
        this.adao = adao;
    }

    public adres getA() {
        if (this.a == null) {
            this.a = new adres();
        }
        return a;
    }

    public void setA(adres a) {
        this.a = a;
    }

    public List<adres> listele(int a) {
        this.alist = this.getAdao().getAdres(a);
        return this.alist;
    }

}

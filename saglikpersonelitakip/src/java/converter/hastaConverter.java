/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package converter;

import dao.bossaatlerDAO;
import entity.hasta_kayıt;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Metehan
 */
@FacesConverter(value="hastaConverter")  
public class hastaConverter implements Converter{
    
    private bossaatlerDAO bdao;

    public bossaatlerDAO getBdao() {
        if (this.bdao==null) {
            this.bdao = new bossaatlerDAO();
        }
        return bdao;
    }

    public void setBdao(bossaatlerDAO bdao) {
        this.bdao = bdao;
    }

   
    
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        return this.bdao.getById(Integer.valueOf(value));
    }

    @Override
    public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
        hasta_kayıt h = (hasta_kayıt)arg2;
        return String.valueOf(h.getHasta_id());
    }
    
}

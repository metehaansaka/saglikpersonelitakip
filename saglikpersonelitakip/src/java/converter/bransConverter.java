package converter;

import dao.bransDAO;
import entity.brans;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "bransConverter")
public class bransConverter implements Converter {

    private bransDAO bDAO;

    public bransDAO getbDAO() {
        if (this.bDAO==null) {
            this.bDAO=new bransDAO();
        }
        return bDAO;
    }

    public void setbDAO(bransDAO bDAO) {
        this.bDAO = bDAO;
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        return this.getbDAO().getById(Integer.valueOf(value));
    }

    @Override
    public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
        brans b = (brans) arg2;
        return String.valueOf(b.getBrans_id());
    }

}

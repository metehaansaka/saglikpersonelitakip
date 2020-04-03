
package dao;

import entity.bossaatler;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.DBConnection;

public class bossaatlerDAO {
    public List<bossaatler> getBossaatler(){
        List<bossaatler> csaat = new ArrayList();
        DBConnection db = new DBConnection();
        Connection c = db.connect();
        try {
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery("Select * From bossaatler");
            while(rs.next()){
                bossaatler saat = new bossaatler(rs.getString("pazartesi"),rs.getString("sali"),rs.getString("carsamba"),
                rs.getString("persembe"),rs.getString("cuma"),rs.getString("cumartesi"),rs.getString("pazar"));
                csaat.add(saat);
            }
        } catch (SQLException ex) {
            Logger.getLogger(bossaatlerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return csaat;
    }
}

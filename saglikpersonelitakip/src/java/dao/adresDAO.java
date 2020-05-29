package dao;

import entity.adres;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.DBConnection;

public class adresDAO {

    public List<adres> getAdres(int id) {
        List<adres> alist = new ArrayList();
        DBConnection db = new DBConnection();
        Connection c = db.connect();
        try {
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery("select * from adres where hasta_id=" + id);
            while (rs.next()) {
                adres a = new adres(rs.getInt("adres_id"), rs.getInt("hasta_id"), rs.getString("adres"));
                alist.add(a);
            }
        } catch (SQLException ex) {
            Logger.getLogger(adresDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return alist;
    }

    public void insert(int temp, adres a) {
        DBConnection db = new DBConnection();
        Connection c = db.connect();
        try {
            Statement st = c.createStatement();
            st.executeUpdate("insert into adres (hasta_id,adres) values('" + temp + "','" + a.getAdres() + "')");
        } catch (SQLException ex) {
            Logger.getLogger(adresDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void delete(int id) {
        DBConnection db = new DBConnection();
        Connection c = db.connect();
        try {
            Statement st = c.createStatement();
            st.executeUpdate("delete from adres where adres_id=" +id);
        } catch (SQLException ex) {
            Logger.getLogger(adresDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void update(int id, adres a) {
        DBConnection db = new DBConnection();
        Connection c = db.connect();
        try {
            Statement st = c.createStatement();
            st.executeUpdate("update adres set adres='"+a.getAdres()+"'where adres_id="+id);
        } catch (SQLException ex) {
            Logger.getLogger(adresDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

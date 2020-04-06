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

    public List<bossaatler> getBossaatlerr(int a) {
        List<bossaatler> csaat = new ArrayList();
        DBConnection db = new DBConnection();
        Connection c = db.connect();
        try {
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery("Select * from bossaatler where personel_id=" + a);
            while (rs.next()) {
                bossaatler saat = new bossaatler(rs.getInt("bossaatler_id"), rs.getInt("personel_id"), rs.getString("pazartesi"), rs.getString("sali"), rs.getString("carsamba"),
                        rs.getString("persembe"), rs.getString("cuma"), rs.getString("cumartesi"), rs.getString("pazar"));
                csaat.add(saat);
            }
        } catch (SQLException ex) {
            Logger.getLogger(bossaatlerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return csaat;
    }

    public void delete(bossaatler b) {
        DBConnection db = new DBConnection();
        Connection c = db.connect();
        try {
            Statement st = c.createStatement();
            st.executeUpdate("delete from bossaatler where bossaatler_id=" + b.getBossaatler_id());
        } catch (SQLException ex) {
            Logger.getLogger(bossaatlerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void insert(bossaatler bossaat, int id) {
        DBConnection db = new DBConnection();
        Connection c = db.connect();
        try {
            Statement st = c.createStatement();
            st.executeUpdate("insert into bossaatler (personel_id,pazartesi,sali,carsamba,persembe,cuma,cumartesi,pazar)"
                    + " values (" + id + ",'" + bossaat.getPazartesi() + "','" + bossaat.getSali() + "','" + bossaat.getCarsamba()
                    + "','" + bossaat.getPersembe() + "','" + bossaat.getCuma() + "','" + bossaat.getCumartesi()
                    + "','" + bossaat.getPazar() + "')");
        } catch (SQLException ex) {
            Logger.getLogger(bossaatlerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void update(bossaatler bossaat) {
        DBConnection db = new DBConnection();
        Connection c = db.connect();
        try {
            Statement st = c.createStatement();
            st.executeUpdate("update bossaatler set pazartesi='" + bossaat.getPazartesi() + "',sali='" + bossaat.getSali() + "',"
                    + "carsamba='" + bossaat.getCarsamba() + "',persembe='" + bossaat.getPersembe() + "',cuma='" + bossaat.getCuma() + "',"
                    + "cumartesi='"+bossaat.getCumartesi()+"',pazar='"+bossaat.getPazar()+"' where bossaatler_id="+bossaat.getBossaatler_id());
        } catch (SQLException ex) {
            Logger.getLogger(bossaatlerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.brans;
import entity.personeller;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.DBConnection;

/**
 *
 * @author Metehan
 */
public class personellerDAO {
    
    private bransDAO bDAO;

    public bransDAO getbDAO() {
        if (this.bDAO==null) {
            this.bDAO = new bransDAO();
        }
        return bDAO;
    }

    public void setbDAO(bransDAO bDAO) {
        this.bDAO = bDAO;
    }
    
    
    
    public List<personeller> getPersonell(int page,int pageSize) {
        List<personeller> plist = new ArrayList();
        DBConnection db = new DBConnection();
        Connection c = db.connect();
        int start = (page-1)*pageSize;
        try {
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery("Select * from personeller order by personel_id asc limit "+start+","+pageSize);
            while (rs.next()) {
                brans b = this.getbDAO().getById(rs.getInt("personel_brans"));
                personeller p = new personeller(rs.getInt("personel_id"), rs.getString("personel_adsoyad"), rs.getString("personel_telefon"),
                        rs.getString("personel_cinsiyet"), b);
                plist.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(personellerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return plist;
    }
    
    public int count() {
        int count=0;
        DBConnection db = new DBConnection();
        Connection c = db.connect();
        try {
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery("Select count(personel_id) as personel_count from personeller");
            rs.next();
            count=rs.getInt("personel_count");
        } catch (SQLException ex) {
            Logger.getLogger(personellerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return count;
    }

    public void insert(personeller personel) {
        DBConnection db = new DBConnection();
        Connection c = db.connect();
        try {
            Statement st = c.createStatement();
            st.executeUpdate("insert into personeller (personel_adsoyad,personel_telefon,personel_cinsiyet,personel_brans)"
                    + " values ('" + personel.getPersone_adsoyad() + "','" + personel.getPersonel_telefon() + "','" + personel.getPersonel_cinsiyet() + "','" + personel.getBrans().getBrans_id() + "')");
        } catch (SQLException ex) {
            Logger.getLogger(personellerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void delete(personeller p) {
        DBConnection db = new DBConnection();
        Connection c = db.connect();
        try {
            Statement st = c.createStatement();
            st.executeUpdate("delete from personeller where personel_id=" + p.getPersonel_id());
        } catch (SQLException ex) {
            Logger.getLogger(personellerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void update(personeller personel) {
         DBConnection db = new DBConnection();
        Connection c = db.connect();
        try {
            Statement st = c.createStatement();
            st.executeUpdate("update personeller set personel_adsoyad='"+personel.getPersone_adsoyad()+"',"
            + "personel_telefon='"+personel.getPersonel_telefon()+"',personel_cinsiyet='"+personel.getPersonel_cinsiyet()+"',"
            + "personel_brans='"+personel.getBrans().getBrans_id()+"' where personel_id=" + personel.getPersonel_id());
        } catch (SQLException ex) {
            Logger.getLogger(personellerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

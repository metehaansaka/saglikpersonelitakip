/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

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

    public List<personeller> getPersonell() {
        List<personeller> plist = new ArrayList();
        DBConnection db = new DBConnection();
        Connection c = db.connect();

        try {
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery("Select * from personeller");
            while (rs.next()) {
                personeller p = new personeller(rs.getInt("personel_id"), rs.getString("personel_adsoyad"), rs.getString("personel_telefon"),
                        rs.getString("personel_cinsiyet"), rs.getString("personel_brans"));
                plist.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(personellerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return plist;
    }

    public void insert(personeller personel) {
        DBConnection db = new DBConnection();
        Connection c = db.connect();
        try {
            Statement st = c.createStatement();
            st.executeUpdate("insert into personeller (personel_adsoyad,personel_telefon,personel_cinsiyet,personel_brans)"
                    + " values ('" + personel.getPersone_adsoyad() + "','" + personel.getPersonel_telefon() + "','" + personel.getPersonel_cinsiyet() + "','" + personel.getPersonel_brans() + "')");
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
            + "personel_brans='"+personel.getPersonel_brans()+"' where personel_id=" + personel.getPersonel_id());
        } catch (SQLException ex) {
            Logger.getLogger(personellerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

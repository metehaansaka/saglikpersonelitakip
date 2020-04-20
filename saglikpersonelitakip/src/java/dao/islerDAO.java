/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.hasta_kayıt;
import entity.ihtiyac_saati;
import entity.isler;
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
public class islerDAO {

    public List<isler> getIsler(int a) {

        List<isler> ilist = new ArrayList();
        DBConnection db = new DBConnection();
        Connection c = db.connect();
        try {
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery("select * from isler where personel_id=" + a);
            while (rs.next()) {
                isler i = new isler(rs.getInt("is_id"), rs.getInt("personel_id"), rs.getInt("hasta_id"), rs.getString("is_yapilan"), rs.getString("ucret"), rs.getString("tarih"));
                ilist.add(i);
            }
        } catch (SQLException ex) {
            Logger.getLogger(islerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return ilist;

    }

    public List<hasta_kayıt> getHastaCagir(int id) {
        List<hasta_kayıt> hlist = new ArrayList();
        DBConnection db = new DBConnection();
        Connection c = db.connect();
        try {
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery("Select * from hasta_kayit where hasta_id=" + id);
            while (rs.next()) {
                hasta_kayıt hk = new hasta_kayıt(rs.getInt("hasta_id"), rs.getString("hasta_ad"), rs.getString("hasta_soyad"), rs.getString("hasta_aciklama"));
                hlist.add(hk);
            }
        } catch (SQLException ex) {
            Logger.getLogger(islerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return hlist;
    }

    public List<ihtiyac_saati> getIhtiyacSaati(int id) {
        List<ihtiyac_saati> islist = new ArrayList();
        DBConnection db = new DBConnection();
        Connection c = db.connect();
        try {
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery("Select * from ihtiyac_saati where hasta_id=" + id);
            while (rs.next()) {
                ihtiyac_saati is = new ihtiyac_saati(rs.getInt("ihtiyac_id"), rs.getInt("hasta_id"), rs.getString("gun"), rs.getString("saat"));
                islist.add(is);
            }
        } catch (SQLException ex) {
            Logger.getLogger(islerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return islist;
    }

    public void getInsert(int id, isler i) {
        DBConnection db = new DBConnection();
        Connection c = db.connect();
        try {
            Statement st = c.createStatement();
            st.executeUpdate("insert into isler (personel_id,hasta_id,is_yapilan,ucret,tarih) values ('" + id + "','" + i.getHasta_id()
                    + "','" + i.getIs_yapilan() + "','" + i.getUcret() + "','" + i.getTarih() + "')");
        } catch (SQLException ex) {
            Logger.getLogger(islerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void update(isler i) {
        DBConnection db = new DBConnection();
        Connection c = db.connect();
         try {
            Statement st = c.createStatement();
            st.executeUpdate("update isler set hasta_id='"+i.getHasta_id()+"', is_yapilan='"+i.getIs_yapilan()+"',ucret="
                    + "'"+i.getUcret()+"',tarih='"+i.getTarih()+"' where is_id="+i.getIs_id());
        } catch (SQLException ex) {
            Logger.getLogger(islerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void delete(int id) {
        DBConnection db = new DBConnection();
        Connection c = db.connect();
         try {
            Statement st = c.createStatement();
            st.executeUpdate("delete from isler where is_id="+id);
        } catch (SQLException ex) {
            Logger.getLogger(islerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;


import static com.oracle.wls.shaded.org.apache.xalan.lib.ExsltDatetime.time;
import entity.hasta_kayıt;
import entity.ihtiyac_saati;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
 * @author lenovo
 */
public class ihtiyac_saatiDAO {
    
    public List<ihtiyac_saati> getIhtiyacSaati(int a) {
        List<ihtiyac_saati> ihtiyaclist = new ArrayList();
        DBConnection db = new DBConnection();
        Connection c = db.connect();
        try {
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery("Select * from ihtiyac_saati where hasta_id=" + a);
            while (rs.next()) {
                ihtiyac_saati ihtiyac = new ihtiyac_saati(rs.getInt("ihtiyac_id"),rs.getInt("hasta_id"),rs.getString("gun"),rs.getString("saat"));
                ihtiyaclist.add(ihtiyac);
            }
        } catch (SQLException ex) {
            Logger.getLogger(bossaatlerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ihtiyaclist;
    }
    
    public void veridüzenle(int ihtiyac_id,int hasta_id,String gün,String saat){
        DBConnection db = new DBConnection();
        Connection con = db.connect();
        String durumbilgisi="";
        try{
            String duzenlemeSorgusu="UPDATE ihtiyac_saati"
                   
                     +" SET hasta_id=?"
                     +" ,gün=?"
                     +",saat=?"
                     +"WHERE ihtiyac_id=?";
            PreparedStatement preparedstatement =con.prepareStatement(duzenlemeSorgusu);
            preparedstatement.setInt(1, hasta_id);
            preparedstatement.setString(2, gün);
            preparedstatement.setString(3, saat);
            preparedstatement.setInt(4, hasta_id);
        }catch(Exception e){
            System.out.println("Hata:"+e);
        }
         System.out.println(durumbilgisi);
    }

    public void delete(ihtiyac_saati a) {
        try {
            DBConnection db = new DBConnection();
            Connection con = db.connect();
            Statement st = con.createStatement();
            st.executeUpdate("delete from ihtiyac_saati where ihtiyac_id="+a.getIhtiyac_id());
        } catch (SQLException ex) {
            Logger.getLogger(ihtiyac_saatiDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void insert(int a,ihtiyac_saati ih) {
         try {
            DBConnection db = new DBConnection();
            Connection con = db.connect();
            Statement st = con.createStatement();
            st.executeUpdate("insert into ihtiyac_saati (hasta_id,gun,saat) values ('"+a+"',"
                    + "'"+ih.getGun()+"','"+ih.getSaat()+"')");
        } catch (SQLException ex) {
            Logger.getLogger(ihtiyac_saatiDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void update(ihtiyac_saati ih) {
        try {
            DBConnection db = new DBConnection();
            Connection con = db.connect();
            Statement st = con.createStatement();
            st.executeUpdate("update from ihtiyac_saati gun="+ih.getGun()+"saat="+ih.getSaat()+"where ihtiyac_id="+ih.getIhtiyac_id());
        } catch (SQLException ex) {
            Logger.getLogger(ihtiyac_saatiDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
   
    
    
    
}

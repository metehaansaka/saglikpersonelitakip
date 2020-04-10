/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;


import static com.oracle.wls.shaded.org.apache.xalan.lib.ExsltDatetime.time;
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
        
   
    
    
    
}

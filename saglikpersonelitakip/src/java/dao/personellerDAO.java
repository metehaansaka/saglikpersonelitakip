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
    public List<personeller> getPersonell(){
        List<personeller> plist= new ArrayList();
        DBConnection db = new DBConnection();
        Connection c = db.connect();
        
        try {
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery("Select * from personeller");
            while(rs.next()){
                personeller p = new personeller(rs.getString("personel_adsoyad"),rs.getString("personel_telefon"),
                rs.getString("personel_cinsiyet"),rs.getString("personel_brans"));
                plist.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(personellerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return plist;        
    }
}


package dao;

import entity.brans;
import entity.hasta_kayıt;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;

public class bransDAO {
    public List<brans> getBrans(){
        List<brans> bList = new ArrayList();
        DBConnection db = new DBConnection();
        Connection c = db.connect();
        
        try{
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery("select * from brans");
            while(rs.next()){
                brans b = new brans(rs.getInt("brans_id"),rs.getString("brans"));
                bList.add(b);
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        return bList;
    }

    public brans getById(int id){
        brans b=null;
        DBConnection db = new DBConnection();
        Connection c = db.connect();
        try{
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery("Select * from brans where brans_id=" + id);
            rs.next();
            b = new brans(rs.getInt("brans_id"),rs.getString("brans"));
            
        }catch(SQLException e){
            System.out.println(e);
        }
        return b;
    }
    
}

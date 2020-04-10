/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;


import static com.oracle.wls.shaded.org.apache.xalan.lib.ExsltDatetime.time;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 *
 * @author lenovo
 */
public class ihtiyac_saatiDAO {
     static Connection con=null;
    public static Connection DBConnection()
    {
        try{
            Class.forName("com.mysql.jdbc.Driver").newIntance();
            con=DriverManager.getConnection( "jbdc:mysql:///sağlıkper.takip","ihtiyac_saati","456"
            );
          if(!con.isClosed()){
              System.out.println("veritabanına bağlandık");
          }else{
              System.out.println("veritabanı ile bağlantı kurulamadı");
          }  
          return con;
        }catch(Exception e){
            System.out.println("bağlantı kurulma hatası");
            return null;
        }
    }
    public void veridüzenle(int ihtiyac_id,int hasta_id,String gün,time saat){
        String durumbilgisi="";
        try{
            String duzenlemeSorgusu="UPDATE ihtiyac_saati"
                   
                     +" SET hasta_id=?"
                     +" ,gün=?"
                     +",saat=?"
                     +"WHERE ihtiyac_id=?";
            PreparedStatement preparedstatement =con.preparedstatement(duzenlemeSorgusu);
            
            preparedstatement.setInt(1, hasta_id);
            preparedstatement.setString(2, gün);
            preparedstatement.seTime(3, saat);
            preparedstatement.setInt(4, hasta_id);
        }catch(Exception e){
            System.out.println("Hata:"+e);
        }
         System.out.println(durumbilgisi);
    }
        
   
    
    
    
}

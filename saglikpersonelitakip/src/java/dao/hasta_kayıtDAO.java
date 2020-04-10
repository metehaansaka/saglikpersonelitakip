/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.hasta_kayıt;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import dao.ihtiyac_saatiDAO;
/**
 *
 * @author lenovo
 */
public class hasta_kayıtDAO {
    static Connection con=null;
    public static Connection DBConnection()
    {
        try{
            Class.forName("com.mysql.jdbc.Driver").newIntance();
            con=DriverManager.getConnection( "jbdc:mysql:///sağlıkper.takip","hasta_kayıt","456"
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
    public String verioku(){
        DBConnection();
        String personelBilgisi="";
        String hasta_kayıt = null;
      
        try{
            PreparedStatement statement=(PreparedStatement)
                    con.prepareStatement("SELECT*FROM hasta_kayıt");
            ResulSet resulset=statement.executeQuery();
            while(resulset.next()){
               System.out.println(resulset.getInt(1)+""+resulset.getString(2)+""+resulset.getString(3)+""+resulset.getString(4)+""+resulset.getString(5)+""+resulset.getString(6));
               hasta_kayıt=hasta_kayıt+"&"
                       +resulset.Int(1)+"&"+resulset.getString(2)+""
                       +resulset.getString(3)+"&"+resulset.getString(4)+"&"
                       +resulset.getString(5)+""+resulset.getString(6);
            }
        }catch(SQLException e){
             System.out.println("Hata:"+e);
        }
        return hasta_kayıt;
                
        
    
    }
 
  public void veriekle(int hasta_id,String hasta_ad,String hasta_soyad,String hasta_adres, String hasta_ihtiyacsaati,String hasta_acıklama){
      String durumbilgisi="";
      try{
          
          String eklemeSorgusu=("INSERT INTO hasta_kayıt"+"(hasta_id,hasta_ad,hasta_soyad"+"hasta_adres,hasta_ihtiyacsaati,hasta_acıklama)"+"VALUES(?,?,?,?,?,?));");
                 
                  
      PreparedStatement preparedstatement=con.preparedstatement(eklemeSorgusu);
            
      preparedstatement.setInt(1,hasta_id);
      preparedstatement.setString(2,hasta_ad);
      preparedstatement.setString(3,hasta_soyad);
      preparedstatement.setString(4,hasta_adres);
      preparedstatement.setString(5,hasta_ihtiyacsaati);
      preparedstatement.setString(6,hasta_acıklama);
      boolean resulset==preparedstatement.execute();
      if(resulset){
          durumbilgisi="ekleme başarısız!";
          
      }else{
          durumbilgisi="ekleme başarılı.";
      }
      
            
       
                  
                  
      }catch(SQLException e){
          System.out.println("Hata;"+e);
      }
      System.out.println(durumbilgisi);
  }
  public void veriduzenle(int hasta_id,String hasta_ad,String hasta_soyad,String hasta_adres,hasta_ihtiyacsaati,String hasta_acıklama){
     String durumbilgisi="";
     try{
         String duzenlemeSorgusu="UPDATE hasta_kayıt"
                 
                 
                 +" SET hasta_soyad=?"
                 +",hasta_adres=?"
                 +",hasta_ihtiyacsaati=?"
                 +",hasta_acıklama=?"
                 +"WHERE hasta_id=?";
          PreparedStatement preparedstatement=con.preparedstatement(duzenlemeSorgusu);
            
      preparedstatement.setint(1,hasta_id);
      preparedstatement.setString(2,hasta_ad);
      preparedstatement.setString(3,hasta_soyad);
      preparedstatement.setString(4,hasta_adres);
      preparedstatement.setString(5,hasta_ihtiyacsaati);
      preparedstatement.setString(6,hasta_acıklama);
         
      int resulset=preparedstatement.executeUpdate();
      if(resulset==1){
          durumbilgisi=resulset+"kayıt güncellendi";
      }else{
          durumbilgisi="güncellenemedi!";
      }
      
     }catch(Exception e){
         System.out.println("Hata:"+e);
     }
       System.out.println(durumbilgisi);
  }
  public void verisil(int hasta_id){
      String durumbilgisi="";
      try{
          String silmeSorgusu="DELETE FROM hasta_kayıt WHERE hasta_id=?";
          PreparedStatement preparedstatement=con.prepareStatement(silmeSorgusu);
          preparedstatement.setInt(1, hasta_id);
          boolean resulset=preparedstatement.execute();
            if(resulset){
                durumbilgisi="silme işlemi başarısız";
                
            }else{
                durumbilgisi="silme işlemi başarılı";
            }
          
      }catch(SQLException e){
          System.out.println("Hata:"+e);
      }
      System.out.println(durumbilgisi);
  }
  
    
}

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
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;

/**
 *
 * @author lenovo
 */
public class hasta_kayıtDAO {

    public List<hasta_kayıt> getHastaKayit() {
        List<hasta_kayıt> hlist = new ArrayList();
        DBConnection db = new DBConnection();
        Connection con = db.connect();
        String personelBilgisi = "";
        String hasta_kayıt = null;

        try {
            PreparedStatement statement = (PreparedStatement) con.prepareStatement("SELECT*FROM hasta_kayit");
            ResultSet resulset = statement.executeQuery();
            while (resulset.next()) {
                hasta_kayıt hasta = new hasta_kayıt(resulset.getInt("hasta_id"), resulset.getString("hasta_ad"), resulset.getString("hasta_soyad"), resulset.getString("hasta_aciklama"));
                hlist.add(hasta);
            }
        } catch (SQLException e) {
            System.out.println("Hata:" + e);
        }
        return hlist;

    }

    public void veriekle(String hasta_ad, String hasta_soyad, String hasta_acıklama) {
        DBConnection db = new DBConnection();
        Connection con = db.connect();
        String durumbilgisi = "";
        try {

            String eklemeSorgusu = ("insert into hasta_kayit (hasta_ad,hasta_soyad,hasta_aciklama) values(?,?,?)");

            PreparedStatement preparedstatement = con.prepareStatement(eklemeSorgusu);

            preparedstatement.setString(1, hasta_ad);
            preparedstatement.setString(2, hasta_soyad);
            preparedstatement.setString(3, hasta_acıklama);
            if (preparedstatement.execute()) {
                durumbilgisi = "ekleme başarılı";

            } else {
                durumbilgisi = "ekleme başarısız.";
            }

        } catch (SQLException e) {
            System.out.println("Hata;" + e);
        }
        System.out.println(durumbilgisi);
    }

    public void veriduzenle(int hasta_id, String hasta_ad, String hasta_soyad, String hasta_acıklama) {
        DBConnection db = new DBConnection();
        Connection con = db.connect();
        String durumbilgisi = "";
        try {
            String duzenlemeSorgusu = "UPDATE hasta_kayit"
                    + " SET hasta_ad=?"
                    + ",hasta_soyad=?"
                    + ",hasta_aciklama=?"
                    + "WHERE hasta_id=?";
            PreparedStatement preparedstatement = con.prepareStatement(duzenlemeSorgusu);
            
            preparedstatement.setString(1, hasta_ad);
            preparedstatement.setString(2, hasta_soyad);
            preparedstatement.setString(3, hasta_acıklama);
            preparedstatement.setInt(4, hasta_id);

            int resulset = preparedstatement.executeUpdate();
            if (resulset == 1) {
                durumbilgisi = resulset + "kayıt güncellendi";
            } else {
                durumbilgisi = "güncellenemedi!";
            }

        } catch (Exception e) {
            System.out.println("Hata:" + e);
        }
        System.out.println(durumbilgisi);
    }

    public void verisil(int hasta_id) {
        DBConnection db = new DBConnection();
        Connection con = db.connect();
        String durumbilgisi = "";
        try {
            String silmeSorgusu = "DELETE FROM hasta_kayit WHERE hasta_id=?";
            PreparedStatement preparedstatement = con.prepareStatement(silmeSorgusu);
            preparedstatement.setInt(1, hasta_id);
            boolean resulset = preparedstatement.execute();
            if (resulset) {
                durumbilgisi = "silme işlemi başarısız";

            } else {
                durumbilgisi = "silme işlemi başarılı";
            }

        } catch (SQLException e) {
            System.out.println("Hata:" + e);
        }
        System.out.println(durumbilgisi);
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.file;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;

/**
 *
 * @author Metehan
 */
public class fileDAO {

    public String getFile(int id) {
        String fileList = null;
        DBConnection db = new DBConnection();
        Connection c = db.connect();
        try{
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery("Select fileName from file where personel_id="+id);
            rs.next();
            fileList = rs.getString("fileName");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return fileList;
    }

    public void insert(file f, int personel_id) {
        DBConnection db = new DBConnection();
        Connection c = db.connect();
        try {
            Statement st = c.createStatement();
            st.executeUpdate("insert into file (filePath,fileName,fileType,personel_id) values ('" + f.getFilePath() + "',"
                    + "'" + f.getFileName() + "','" + f.getFileType() + "','"+personel_id+"')");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
   
}

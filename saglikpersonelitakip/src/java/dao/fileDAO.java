/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.file;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;

/**
 *
 * @author Metehan
 */
public class fileDAO {

    public List<file> getFile() {
        List<file> file = new ArrayList();

        return file;
    }

    public void insert(file f) {
        DBConnection db = new DBConnection();
        Connection c = db.connect();
        try {
            Statement st = c.createStatement();
            st.executeUpdate("insert into file (filePath,fileName,fileType) values ('" + f.getFilePath() + "',"
                    + "'" + f.getFileName() + "','" + f.getFileType() + "')");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

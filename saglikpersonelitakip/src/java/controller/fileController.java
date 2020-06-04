/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.fileDAO;
import entity.file;
import java.io.File;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.servlet.http.Part;

/**
 *
 * @author Metehan
 */
@Named
@SessionScoped
public class fileController implements Serializable {

    private file file;
    private String fList;
    private fileDAO fDAO;
    private final String uploadTo = "/C:/Users/Metehan/Desktop/upload/";

    public void upload(Part dc, int personel_id) {
        try {
            InputStream input = dc.getInputStream();
            File f = new File(uploadTo + dc.getSubmittedFileName());
            Files.copy(input, f.toPath());
            file = this.getFile();
            file.setFilePath(f.getParent());
            file.setFileName(f.getName());
            file.setFileType(dc.getContentType());
            this.getfDAO().insert(file, personel_id);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public file getFile() {
        if (this.file == null) {
            this.file = new file();
        }
        return file;
    }

    public void setFile(file file) {
        this.file = file;
    }

    public String getfList(int id) {
        this.fList = this.getfDAO().getFile(id);
        return fList;
    }

    public void setfList(String fList) {
        this.fList = fList;
    }
    

    public fileDAO getfDAO() {
        if (this.fDAO == null) {
            this.fDAO = new fileDAO();
        }
        return fDAO;
    }

    public void setfDAO(fileDAO fDAO) {
        this.fDAO = fDAO;
    }

    public String getUploadTo() {
        return uploadTo;
    }

}

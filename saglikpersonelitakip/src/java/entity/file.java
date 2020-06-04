/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author Metehan
 */
public class file {
    private String filePath;
    private String fileName;
    private String fileType;
    private int id;
    private int personel_id;
    
    public file() {
    } 

    public file(String filePath, String fileName, String fileType, int id, int personel_id) {
        this.filePath = filePath;
        this.fileName = fileName;
        this.fileType = fileType;
        this.id = id;
        this.personel_id = personel_id;
    }
    
    
    
    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPersonel_id() {
        return personel_id;
    }

    public void setPersonel_id(int personel_id) {
        this.personel_id = personel_id;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + this.personel_id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final file other = (file) obj;
        if (this.personel_id != other.personel_id) {
            return false;
        }
        return true;
    }

    
    
    
    
}

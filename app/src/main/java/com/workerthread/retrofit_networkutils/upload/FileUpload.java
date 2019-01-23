package com.workerthread.retrofit_networkutils.upload;

import java.io.Serializable;

public class FileUpload implements Serializable {

    public FileUpload(String name, String value, String fileType, String filePath) {
        this.name = name;
        this.value = value;
        this.fileType = fileType;
        this.filePath = filePath;
    }

    private String name;
    private String value;
    private String fileType;

    public FileUpload(String filePath) {
        this.filePath = filePath;
    }

    private String filePath;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}

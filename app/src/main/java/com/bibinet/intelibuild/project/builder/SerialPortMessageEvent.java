package com.bibinet.intelibuild.project.builder;

/**
 * Created by bibinet on 2018-1-9.
 */

public class SerialPortMessageEvent {
    private String productFile;
    private String productFileName;
    private String productName;
    private String productNumber;
    private String checkProject;
    private String doStand;

    public SerialPortMessageEvent(String productFile, String productFileName, String productName, String productNumber, String checkProject, String doStand) {
        this.productFile = productFile;
        this.productFileName = productFileName;
        this.productName = productName;
        this.productNumber = productNumber;
        this.checkProject = checkProject;
        this.doStand = doStand;
    }

    public String getProductFile() {
        return productFile;
    }

    public void setProductFile(String productFile) {
        this.productFile = productFile;
    }

    public String getProductFileName() {
        return productFileName;
    }

    public void setProductFileName(String productFileName) {
        this.productFileName = productFileName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductNumber() {
        return productNumber;
    }

    public void setProductNumber(String productNumber) {
        this.productNumber = productNumber;
    }

    public String getCheckProject() {
        return checkProject;
    }

    public void setCheckProject(String checkProject) {
        this.checkProject = checkProject;
    }

    public String getDoStand() {
        return doStand;
    }

    public void setDoStand(String doStand) {
        this.doStand = doStand;
    }
}
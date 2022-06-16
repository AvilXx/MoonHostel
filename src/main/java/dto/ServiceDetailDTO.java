/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import java.sql.Date;

/**
 *
 * @author avillX
 */
public class ServiceDetailDTO {
    private String detailID;
    private String CalUnit;
    private double unit_price;
    private Date updated_date;
    private String description;
    private String serviceID;

    public ServiceDetailDTO(String detailID, String CalUnit, double unit_price, Date updated_date, String description, String serviceID) {
        this.detailID = detailID;
        this.CalUnit = CalUnit;
        this.unit_price = unit_price;
        this.updated_date = updated_date;
        this.description = description;
        this.serviceID = serviceID;
    }

    public String getDetailID() {
        return detailID;
    }

    public void setDetailID(String detailID) {
        this.detailID = detailID;
    }

    public String getCalUnit() {
        return CalUnit;
    }

    public void setCalUnit(String CalUnit) {
        this.CalUnit = CalUnit;
    }

    public double getUnit_price() {
        return unit_price;
    }

    public void setUnit_price(double unit_price) {
        this.unit_price = unit_price;
    }

    public Date getUpdated_date() {
        return updated_date;
    }

    public void setUpdated_date(Date updated_date) {
        this.updated_date = updated_date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getServiceID() {
        return serviceID;
    }

    public void setServiceID(String serviceID) {
        this.serviceID = serviceID;
    }


}

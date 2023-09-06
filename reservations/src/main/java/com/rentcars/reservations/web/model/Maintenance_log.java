package com.rentcars.reservations.web.model;


import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Date;


public class Maintenance_log {

    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    @Size(min = 6, max = 15)
    private String registrationVehicle;
    @Size(max = 11)
    private int maintenanceKm;
    private Date maintenanceDate;
    @ManyToMany
    private List<Maintenance_type> maintenance_types;

    public Maintenance_log(){}

    public Maintenance_log(int id, String registrationVehicle, int maintenanceTypeId, int maintenanceKm, Date maintenanceDate, List<Maintenance_type> maintenance_types) {
        this.id = id;
        this.registrationVehicle = registrationVehicle;
        this.maintenanceKm = maintenanceKm;
        this.maintenanceDate = maintenanceDate;
        this.maintenance_types = maintenance_types;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRegistrationVehicle() {
        return registrationVehicle;
    }

    public void setRegistrationVehicle(String registrationVehicle) {
        this.registrationVehicle = registrationVehicle;
    }

    public int getMaintenanceKm() {
        return maintenanceKm;
    }

    public void setMaintenanceKm(int maintenanceKm) {
        this.maintenanceKm = maintenanceKm;
    }

    public Date getMaintenanceDate() {
        return maintenanceDate;
    }

    public void setMaintenanceDate(Date maintenanceDate) {
        this.maintenanceDate = maintenanceDate;
    }

    public List<Maintenance_type> getMaintenance_types() {
        return maintenance_types;
    }

    public void setMaintenance_types(List<Maintenance_type> maintenance_types) {
        this.maintenance_types = maintenance_types;
    }

    @Override
    public String toString() {
        return "Maintenance_log{" +
                "id=" + id +
                ", registrationVehicle='" + registrationVehicle + '\'' +
                ", maintenanceKm=" + maintenanceKm +
                ", maintenanceDate=" + maintenanceDate +
                '}';
    }
}

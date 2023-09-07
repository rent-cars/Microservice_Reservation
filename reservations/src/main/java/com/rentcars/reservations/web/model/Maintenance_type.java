package com.rentcars.reservations.web.model;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Date;


public class Maintenance_type {

    private int id;
    private String vehicleType;
    private String name;
    private int maintenanceKm;
    private int maintenanceYears;
    private int daysOff;
    @ManyToMany(mappedBy = "maintenance_types")
    private List<Maintenance_log> maintenance_logs;

    public Maintenance_type() {
    }

    public Maintenance_type(int id, String vehicleType, String name, int maintenanceKm, Date maintenanceDate, int daysOff, List<Maintenance_log> maintenance_logs) {
        this.id = id;
        this.vehicleType = vehicleType;
        this.name = name;
        this.maintenanceKm = maintenanceKm;
        this.maintenanceYears = maintenanceYears;
        this.daysOff = daysOff;
        this.maintenance_logs = maintenance_logs;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMaintenanceKm() {
        return maintenanceKm;
    }

    public void setMaintenanceKm(int maintenanceKm) {
        this.maintenanceKm = maintenanceKm;
    }

    public int getMaintenanceDate() {
        return maintenanceYears;
    }

    public void setMaintenanceDate(int maintenanceYears) {
        this.maintenanceYears = maintenanceYears;
    }

    public int getDaysOff() {
        return daysOff;
    }

    public void setDaysOff(int daysOff) {
        this.daysOff = daysOff;
    }

    public List<Maintenance_log> getMaintenance_logs() {
        return maintenance_logs;
    }

    public void setMaintenance_logs(List<Maintenance_log> maintenance_logs) {
        this.maintenance_logs = maintenance_logs;
    }

    @Override
    public String toString() {
        return "Maintenance_type{" +
                "id=" + id +
                ", vehicleType='" + vehicleType + '\'' +
                ", name='" + name + '\'' +
                ", maintenanceKm=" + maintenanceKm +
                ", maintenanceDate=" + maintenanceYears +
                ", daysOff=" + daysOff +
                ", maintenance_logs=" + maintenance_logs +
                '}';
    }
}

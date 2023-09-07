package com.rentcars.reservations.web.model;


import javax.persistence.*;
import java.util.Date;

@Entity
public class Reservations {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private Date startDate;
    private Date endDate;
    private int clientId;
    private String registrationVehicle;
    private int nbKms;
    private int currentPrice;

    public Reservations(){
            }

    public Reservations(int id, Date startDate, Date endDate, int clientId, String registrationVehicle, int nbKms, int currentPrice) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.clientId = clientId;
        this.registrationVehicle = registrationVehicle;
        this.nbKms = nbKms;
        this.currentPrice = currentPrice;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public String getRegistrationVehicle() {
        return registrationVehicle;
    }

    public void setRegistrationVehicle(String registrationVehicle) {
        this.registrationVehicle = registrationVehicle;
    }

    public int getNbKms() {return nbKms;}
    public void setNbKms(int nbKms) {
        this.nbKms = nbKms;
    }

    public int getCurrentPrice() {return currentPrice;}
    public void setCurrentPrice(int currentPrice) {
        this.currentPrice = currentPrice;
    }

    @Override
    public String toString(){
        return "Reservations{" +
                "id" + id +
                ", date de début='" + startDate + '\'' +
                ", date de fin='" + endDate +
                ", identifiant client=" + clientId +
                ", numéro d'identification du véhicule'" + registrationVehicle +
                ", nombre de kilomètres'" + nbKms +
                ", prix final estimatif'" + currentPrice +
                '}';
    }

}

package com.rentcars.reservations.web.model;


        import javax.persistence.Entity;
        import javax.persistence.Id;


// @JsonFilter("monFiltreDynamique")  // commenter pour pouvoir utiliser les autres méthodes qui n'ont pas de filtres


public class Vehicles {
    private String registration;
    private String type;
    private String color;
    private String model;
    private int cylinder;
    private int loadVolume;
    private int currentPrice;

    @Override
    public String toString() {
        return "Vehicles{" +
                "registration='" + registration + '\'' +
                ", type='" + type + '\'' +
                ", color='" + color + '\'' +
                ", model='" + model + '\'' +
                ", cylinder=" + cylinder +
                ", loadVolume=" + loadVolume +
                ", currentPrice=" + currentPrice +
                '}';
    }


    //  🥎 -------- constructor ----------

    public Vehicles(){};


    public Vehicles(String registration, String type, String color, String model, int cylinder, int loadVolume, int currentPrice) {
        this.registration = registration;
        this.type = type;
        this.color = color;
        this.model = model;
        this.cylinder = cylinder;
        this.loadVolume = loadVolume;
        this.currentPrice = currentPrice;
    }


    //  🥎 -------- getter and setter ----------

    public String getRegistration() {
        return registration;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getCylinder() {
        return cylinder;
    }

    public void setCylinder(int cylinder) {
        this.cylinder = cylinder;
    }

    public int getLoadVolume() {
        return loadVolume;
    }

    public void setLoadVolume(int loadVolume) {
        this.loadVolume = loadVolume;
    }

    public int getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(int currentPrice) {
        this.currentPrice = currentPrice;
    }
}

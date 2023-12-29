package com.saidur.own.amarbari.Network.Request;

import com.saidur.own.amarbari.Model.ModelRent;

public class RQ_House_Save {
    String name;
    String address;
    String owner;
    String image;
    String floor;
    String unit;
    String unit_floo;
    String room;
    String toilet;
    String belcony;
    String rent;

    public RQ_House_Save() {
    }

    public String getUnit_floo() {
        return unit_floo;
    }

    public void setUnit_floo(String unit_floo) {
        this.unit_floo = unit_floo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }


    public String getRent() {
        return rent;
    }

    public void setRent(String rent) {
        this.rent = rent;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getToilet() {
        return toilet;
    }

    public void setToilet(String toilet) {
        this.toilet = toilet;
    }

    public String getBelcony() {
        return belcony;
    }

    public void setBelcony(String belcony) {
        this.belcony = belcony;
    }
}

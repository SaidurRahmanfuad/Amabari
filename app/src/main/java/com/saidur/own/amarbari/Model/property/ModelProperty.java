package com.saidur.own.amarbari.Model.property;

import com.saidur.own.amarbari.Model.ModelRent;

public class ModelProperty {
    int id;
    String propertyId;
    String name;
    String address;
    String owner;
    String image;
    String floor;
    String unit;
    String voliume;
    ModelRent rent;

    public ModelProperty() {
    }

    public ModelProperty(int id, String propertyId, String name, String address, String floor, String unit, ModelRent rent) {
        this.id = id;
        this.propertyId = propertyId;
        this.name = name;
        this.address = address;
        this.floor = floor;
        this.unit = unit;
        this.rent = rent;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(String propertyId) {
        this.propertyId = propertyId;
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

    public ModelRent getRent() {
        return rent;
    }

    public void setRent(ModelRent rent) {
        this.rent = rent;
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

    public String getVoliume() {
        return voliume;
    }

    public void setVoliume(String voliume) {
        this.voliume = voliume;
    }
}

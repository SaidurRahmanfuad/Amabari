package com.saidur.own.amarbari.Model;

public class ModelRent {
    int id;
    String rent_unit;
    String rent_amount;
    String rent_pending;
    String rent_paid;
    String rent_house;
    String rent_houseAddress;
    String rent_date;
    String rent_due;
    String rent_advance;
    String rent_status;

    public ModelRent() {
    }

    public ModelRent(String rent_amount, String rent_house, String rent_houseAddress, String rent_date, String rent_status) {
        this.rent_amount = rent_amount;
        this.rent_house = rent_house;
        this.rent_houseAddress = rent_houseAddress;
        this.rent_date = rent_date;
        this.rent_status = rent_status;
    }

    public ModelRent(String rent_amount) {
        this.rent_amount = rent_amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRent_unit() {
        return rent_unit;
    }

    public void setRent_unit(String rent_unit) {
        this.rent_unit = rent_unit;
    }

    public String getRent_amount() {
        return rent_amount;
    }

    public void setRent_amount(String rent_amount) {
        this.rent_amount = rent_amount;
    }

    public String getRent_pending() {
        return rent_pending;
    }

    public void setRent_pending(String rent_pending) {
        this.rent_pending = rent_pending;
    }

    public String getRent_paid() {
        return rent_paid;
    }

    public void setRent_paid(String rent_paid) {
        this.rent_paid = rent_paid;
    }

    public String getRent_house() {
        return rent_house;
    }

    public void setRent_house(String rent_house) {
        this.rent_house = rent_house;
    }

    public String getRent_date() {
        return rent_date;
    }

    public void setRent_date(String rent_date) {
        this.rent_date = rent_date;
    }

    public String getRent_due() {
        return rent_due;
    }

    public void setRent_due(String rent_due) {
        this.rent_due = rent_due;
    }

    public String getRent_advance() {
        return rent_advance;
    }

    public void setRent_advance(String rent_advance) {
        this.rent_advance = rent_advance;
    }

    public String getRent_houseAddress() {
        return rent_houseAddress;
    }

    public void setRent_houseAddress(String rent_houseAddress) {
        this.rent_houseAddress = rent_houseAddress;
    }

    public String getRent_status() {
        return rent_status;
    }

    public void setRent_status(String rent_status) {
        this.rent_status = rent_status;
    }
}

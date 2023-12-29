package com.saidur.own.amarbari.Model;

public class ModelTenant {
    int id;
    String name;
    String mobile;
    String address;
    String nid;
    String image;
    ModelRent rentInfo;

    public ModelTenant(int id, String name, String mobile, String address, ModelRent rentInfo) {
        this.id = id;
        this.name = name;
        this.mobile = mobile;
        this.address = address;
        this.rentInfo = rentInfo;
    }

    public ModelTenant() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNid() {
        return nid;
    }

    public void setNid(String nid) {
        this.nid = nid;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public ModelRent getRentInfo() {
        return rentInfo;
    }

    public void setRentInfo(ModelRent rentInfo) {
        this.rentInfo = rentInfo;
    }
}

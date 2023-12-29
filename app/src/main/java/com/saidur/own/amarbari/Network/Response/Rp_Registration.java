package com.saidur.own.amarbari.Network.Response;

import com.saidur.own.amarbari.Model.Account.ModelProfile;

public class Rp_Registration {
    boolean status;
    String massage;
    int role;
    ModelProfile data;

    public Rp_Registration() {
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getMassage() {
        return massage;
    }

    public void setMassage(String massage) {
        this.massage = massage;
    }

    public ModelProfile getData() {
        return data;
    }

    public void setData(ModelProfile data) {
        this.data = data;
    }
}

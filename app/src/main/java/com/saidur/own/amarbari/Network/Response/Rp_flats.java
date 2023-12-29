package com.saidur.own.amarbari.Network.Response;

import com.saidur.own.amarbari.Model.Tanent_side.ModelFlats;

import java.util.List;

public class Rp_flats {
    boolean status;
    String massage;
    List<ModelFlats> data;

    public Rp_flats() {
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

    public List<ModelFlats> getData() {
        return data;
    }

    public void setData(List<ModelFlats> data) {
        this.data = data;
    }
}

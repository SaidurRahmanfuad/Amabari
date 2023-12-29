package com.saidur.own.amarbari.Network.Response;

import com.saidur.own.amarbari.Model.Tanent_side.ModelBuildings;

import java.util.List;

public class Rp_buildings {
   boolean status;
   String massage;
   List<ModelBuildings> data;

    public Rp_buildings() {
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

    public List<ModelBuildings> getData() {
        return data;
    }

    public void setData(List<ModelBuildings> data) {
        this.data = data;
    }
}

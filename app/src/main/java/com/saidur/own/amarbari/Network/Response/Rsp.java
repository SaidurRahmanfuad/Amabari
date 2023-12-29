package com.saidur.own.amarbari.Network.Response;

public class Rsp {
    boolean status;
    String massage;

    public Rsp() {
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
}

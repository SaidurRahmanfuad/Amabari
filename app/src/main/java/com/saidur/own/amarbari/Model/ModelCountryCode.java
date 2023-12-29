package com.saidur.own.amarbari.Model;

public class ModelCountryCode {
    private String ccode;
    private String id;
    private String status;
    private String name;

    public ModelCountryCode(String ccode, String id,String name) {
        this.ccode = ccode;
        this.id = id;
        this.name = name;
    }

    public ModelCountryCode() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCcode() {
        return ccode;
    }

    public void setCcode(String ccode) {
        this.ccode = ccode;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return ccode;
    }
}

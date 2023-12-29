package com.saidur.own.amarbari.Model;

public class ModelMenuProperty {
    int id;
    int icon;
    String name;
    String desc;
    String count;

    public ModelMenuProperty() {
    }

    public ModelMenuProperty(int id, int icon, String name, String desc, String count) {
        this.id = id;
        this.icon = icon;
        this.name = name;
        this.desc = desc;
        this.count = count;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }
}

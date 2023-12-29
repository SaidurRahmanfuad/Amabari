package com.saidur.own.amarbari.Model;

public class ModelMonth {
    int month;
    String monthName;

    public ModelMonth(int month, String monthName) {
        this.month = month;
        this.monthName = monthName;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public String getMonthName() {
        return monthName;
    }

    public void setMonthName(String monthName) {
        this.monthName = monthName;
    }

    @Override
    public String toString() {
        return monthName;
    }
}

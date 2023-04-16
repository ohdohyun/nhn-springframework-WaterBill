package com.nhnacademy.edu.springframework.project.repository;

public class Tariff {

    private int tariffId;
    private String city;
    private String sector;
    private int level;
    private int startRange;
    private int endRange;
    private int unitPrice;

    public Tariff(int tariffId, String city, String sector, int level, int startRange, int endRange, int unitPrice) {
        this.tariffId = tariffId;
        this.city = city;
        this.sector = sector;
        this.level = level;
        this.startRange = startRange;
        this.endRange = endRange;
        this.unitPrice = unitPrice;
    }

    public int getStartRange() {
        return startRange;
    }

    public int getEndRange() {
        return endRange;
    }

    public String getCity() {
        return city;
    }

    public String getSector() {
        return sector;
    }

    public int getUnitPrice() {
        return unitPrice;
    }

    @Override
    public String toString() {
        return "tariffId = " + tariffId
                + ", city = " + city
                + ", sector = " + sector
                + ", level = " + level
                + ", startRange = " + startRange
                + ", endRange = " + endRange
                + ", unitPrice = " + unitPrice;
    }
}

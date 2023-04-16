package com.nhnacademy.edu.springframework.project.repository;

public class Tariff {

    private int traiffId;
    private String city;
    private String sector;
    private int level;
    private int startRange;
    private int endRange;
    private int unitPrice;

    public Tariff(int traiffId, String city, String sector, int level, int startRange, int endRange, int unitPrice) {
        this.traiffId = traiffId;
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

    @Override
    public String toString() {
        return "traiffId = " + traiffId
                + ", city = " + city
                + ", sector = " + sector
                + ", level = " + level
                + ", startRange = " + startRange
                + ", endRange = " + endRange
                + ", unitPrice = " + unitPrice;
    }
}

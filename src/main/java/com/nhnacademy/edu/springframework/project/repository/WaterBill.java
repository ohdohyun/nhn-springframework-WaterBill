package com.nhnacademy.edu.springframework.project.repository;

public class WaterBill {
    private String city;
    private String sector;
    private int unitPrice;
    private int totalBill;

    public WaterBill(String city, String sector, int unitPrice, int totalBill) {
        this.city = city;
        this.sector = sector;
        this.unitPrice = unitPrice;
        this.totalBill = totalBill;
    }

    public int getTotalBill() {
        return totalBill;
    }

    public String getCity() {
        return city;
    }

    public String getSector() {
        return sector;
    }

    @Override
    public String toString() {
        return ("WaterBill{city='" + city
                + "', sector='" + sector
                + "', unitPrice='" + unitPrice
                + "', totalBill='" + totalBill
                + "}"
        );
    }
}

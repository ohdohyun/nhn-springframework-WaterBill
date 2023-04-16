package com.nhnacademy.edu.springframework.project.repository;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Tariff {

    @JsonProperty("순번")
    private int tariffId;
    @JsonProperty("지자체명")
    private String city;
    @JsonProperty("업종")
    private String sector;
    @JsonProperty("단계")
    private int level;
    @JsonProperty("구간시작(세제곱미터)")
    private int startRange;
    @JsonProperty("구간끝(세제곱미터)")
    private int endRange;
    @JsonProperty("구간금액(원)")
    private int unitPrice;
    @JsonProperty("단계별 기본요금(원)")
    private int pricePerLevel;


    public Tariff() {
    }

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

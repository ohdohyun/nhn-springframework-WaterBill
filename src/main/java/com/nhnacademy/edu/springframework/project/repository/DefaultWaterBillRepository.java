package com.nhnacademy.edu.springframework.project.repository;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DefaultWaterBillRepository {
    List<WaterBill> waterBills = new ArrayList<>();

    public void load(List<WaterBill> waterBills) {
        this.waterBills = waterBills;
    }

    public List<WaterBill> getWaterBills() {
        return waterBills;
    }
}

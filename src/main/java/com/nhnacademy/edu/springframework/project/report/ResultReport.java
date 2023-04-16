package com.nhnacademy.edu.springframework.project.report;

import com.nhnacademy.edu.springframework.project.repository.WaterBill;

import java.util.List;

public interface ResultReport {
    public void report(List<WaterBill> waterBillList);

    public void reportByCity(List<WaterBill> waterBillList, String city);
    public void reportBySector(List<WaterBill> waterBillList, String sector);

}

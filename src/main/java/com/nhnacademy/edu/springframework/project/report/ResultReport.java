package com.nhnacademy.edu.springframework.project.report;

import com.nhnacademy.edu.springframework.project.repository.WaterBill;

import java.util.List;

public interface ResultReport {
    public void report();

    public void reportByCity(String city);
    public void reportBySector(String sector);

}

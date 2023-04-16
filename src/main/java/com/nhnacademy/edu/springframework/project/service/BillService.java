package com.nhnacademy.edu.springframework.project.service;

import com.nhnacademy.edu.springframework.project.repository.WaterBill;

import java.util.List;

public interface BillService {
    public List<WaterBill> calCost(int usage);
}

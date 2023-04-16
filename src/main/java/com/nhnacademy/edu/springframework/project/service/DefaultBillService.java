package com.nhnacademy.edu.springframework.project.service;

import com.nhnacademy.edu.springframework.project.repository.TraiffRepository;
import org.springframework.stereotype.Service;

@Service
public class DefaultBillService implements BillService {
    private final TraiffRepository traiffRepository;

    public DefaultBillService(TraiffRepository traiffRepository) {
        this.traiffRepository = traiffRepository;
    }

    @Override
    public void calCost(int usage) {

    }
}

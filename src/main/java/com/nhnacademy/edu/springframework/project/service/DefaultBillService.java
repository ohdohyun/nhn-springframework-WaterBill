package com.nhnacademy.edu.springframework.project.service;

import com.nhnacademy.edu.springframework.project.repository.TariffRepository;
import org.springframework.stereotype.Service;

@Service
public class DefaultBillService implements BillService {
    private final TariffRepository tariffRepository;

    public DefaultBillService(TariffRepository tariffRepository) {
        this.tariffRepository = tariffRepository;
    }

    @Override
    public void calCost(int usage) {

    }
}

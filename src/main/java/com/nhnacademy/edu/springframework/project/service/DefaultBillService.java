package com.nhnacademy.edu.springframework.project.service;

import com.nhnacademy.edu.springframework.project.repository.Tariff;
import com.nhnacademy.edu.springframework.project.repository.TariffRepository;
import com.nhnacademy.edu.springframework.project.repository.WaterBill;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DefaultBillService implements BillService {
    private final TariffRepository tariffRepository;

    public DefaultBillService(TariffRepository tariffRepository) {
        this.tariffRepository = tariffRepository;
    }

    @Override
    public List<WaterBill> calCost(int usage) {
        List<Tariff> tariffList = tariffRepository.findByUsage(usage);

        return tariffList.stream()
                .map(tariff -> new WaterBill(tariff.getCity(), tariff.getSector(), tariff.getUnitPrice(), tariff.getUnitPrice() * usage))
                .collect(Collectors.toList());
    }
}

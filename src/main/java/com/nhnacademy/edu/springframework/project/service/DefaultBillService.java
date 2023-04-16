package com.nhnacademy.edu.springframework.project.service;

import com.nhnacademy.edu.springframework.project.repository.Tariff;
import com.nhnacademy.edu.springframework.project.repository.TariffRepository;
import com.nhnacademy.edu.springframework.project.repository.WaterBill;
import com.nhnacademy.edu.springframework.project.repository.WaterBillRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DefaultBillService implements BillService {
    private final TariffRepository tariffRepository;
    private final WaterBillRepository waterBillRepository;

    public DefaultBillService(TariffRepository tariffRepository, WaterBillRepository waterBillRepository) {
        this.tariffRepository = tariffRepository;
        this.waterBillRepository = waterBillRepository;
    }

    @Override
    public void calCost(int usage) {
        if (usage > 999999) {
            throw new RuntimeException("해당 데이터가 없습니다.");
        }
        List<Tariff> tariffList = tariffRepository.findByUsage(usage);

        waterBillRepository.load(tariffList.stream()
                .map(tariff -> new WaterBill(tariff.getCity(), tariff.getSector(), tariff.getUnitPrice(), tariff.getUnitPrice() * usage))
                .collect(Collectors.toList()));
    }
}

package com.nhnacademy.edu.springframework.project.report;

import com.nhnacademy.edu.springframework.project.repository.WaterBillRepository;
import com.nhnacademy.edu.springframework.project.repository.WaterBill;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class DefaultResultReport implements ResultReport {
    private final WaterBillRepository waterBillRepository;

    public DefaultResultReport(WaterBillRepository waterBillRepository) {
        this.waterBillRepository = waterBillRepository;
    }

    @Override
    public void report() {

        List<WaterBill> orderedWaterBillList = waterBillRepository.getWaterBills().stream()
                .sorted(Comparator.comparingDouble(WaterBill::getTotalBill))
                .limit(5)
                .collect(Collectors.toList());

        for (WaterBill waterBill : orderedWaterBillList) {
            System.out.println(waterBill.toString());
        }
    }

    @Override
    public void reportByCity(String city) {
        List<WaterBill> filteredList = waterBillRepository.getWaterBills().stream()
                .filter(waterBill -> city.equals(waterBill.getCity()))
                .sorted(Comparator.comparingDouble(WaterBill::getTotalBill))
                .limit(5)
                .collect(Collectors.toList());

        for (WaterBill waterBill : filteredList) {
            System.out.println(waterBill.toString());
        }
    }

    @Override
    public void reportBySector(String sector) {
        List<WaterBill> filteredList = waterBillRepository.getWaterBills().stream()
                .filter(waterBill -> sector.equals(waterBill.getSector()))
                .sorted(Comparator.comparingDouble(WaterBill::getTotalBill))
                .limit(5)
                .collect(Collectors.toList());

        for (WaterBill waterBill : filteredList) {
            System.out.println(waterBill.toString());
        }
    }
}

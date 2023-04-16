package com.nhnacademy.edu.springframework.project.report;

import com.nhnacademy.edu.springframework.project.repository.WaterBill;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class DefaultResultReport implements ResultReport {

    @Override
    public void report(List<WaterBill> waterBillList) {

        List<WaterBill> orderedWaterBillList = waterBillList.stream()
                .sorted(Comparator.comparingDouble(WaterBill::getTotalBill))
                .limit(5)
                .collect(Collectors.toList());

        for (WaterBill waterBill : orderedWaterBillList) {
            System.out.println(waterBill.toString());
        }
    }

    @Override
    public void reportByCity(List<WaterBill> waterBillList, String city) {
        List<WaterBill> filteredList = waterBillList.stream()
                .filter(waterBill -> city.equals(waterBill.getCity()))
                .sorted(Comparator.comparingDouble(WaterBill::getTotalBill))
                .limit(5)
                .collect(Collectors.toList());

        for (WaterBill waterBill : filteredList) {
            System.out.println(waterBill.toString());
        }
    }

    @Override
    public void reportBySector(List<WaterBill> waterBillList, String sector) {
        List<WaterBill> filteredList = waterBillList.stream()
                .filter(waterBill -> sector.equals(waterBill.getSector()))
                .sorted(Comparator.comparingDouble(WaterBill::getTotalBill))
                .limit(5)
                .collect(Collectors.toList());

        for (WaterBill waterBill : filteredList) {
            System.out.println(waterBill.toString());
        }
    }
}

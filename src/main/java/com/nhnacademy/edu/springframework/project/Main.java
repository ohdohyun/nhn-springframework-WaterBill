package com.nhnacademy.edu.springframework.project;

import com.nhnacademy.edu.springframework.project.config.AppConfig;
import com.nhnacademy.edu.springframework.project.report.DefaultResultReport;
import com.nhnacademy.edu.springframework.project.report.ResultReport;
import com.nhnacademy.edu.springframework.project.repository.Tariff;
import com.nhnacademy.edu.springframework.project.repository.TariffRepository;
import com.nhnacademy.edu.springframework.project.repository.WaterBill;
import com.nhnacademy.edu.springframework.project.service.BillService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

/**
 * 순번 , 지자체명 , 업종 , 단계 , 구간시작(세제곱미터)  , 구간끝(세제곱미터)  , 구간금액(원)  , 단계별 기본요금(원)
 */
public class Main {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        TariffRepository tariffRepository = context.getBean("csvTariffRepository", TariffRepository.class);
        BillService billService = context.getBean("defaultBillService", BillService.class);
        ResultReport resultReport = context.getBean("defaultResultReport", ResultReport.class);
        tariffRepository.load("Tariff_20220331.csv");
        int usage = 1000;

        List<WaterBill> waterBillList = billService.calCost(usage);
        resultReport.report(waterBillList);     // defaultReport 입니다. 사용량에 부합하는 결과중 가장 저렴한 5개만 출력합니다
        System.out.println("================");
        resultReport.reportByCity(waterBillList, "고령군");
        System.out.println("================");
        resultReport.reportBySector(waterBillList, "공업용");

    }
}
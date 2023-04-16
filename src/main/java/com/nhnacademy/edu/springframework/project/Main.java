package com.nhnacademy.edu.springframework.project;

import com.nhnacademy.edu.springframework.project.config.AppConfig;
import com.nhnacademy.edu.springframework.project.repository.Tariff;
import com.nhnacademy.edu.springframework.project.repository.TariffRepository;
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

        tariffRepository.load("s");

        BillService billService = context.getBean("defaultBillService", BillService.class);

        List<Tariff> list = tariffRepository.findByUsage(1000);
        for (Tariff tariff : list) {
            System.out.println(tariff.toString());
        }
    }
}
package com.nhnacademy.edu.springframework.project;

import com.nhnacademy.edu.springframework.project.config.AppConfig;
import com.nhnacademy.edu.springframework.project.repository.Tariff;
import com.nhnacademy.edu.springframework.project.repository.TraiffRepository;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

/**
 * 순번 , 지자체명 , 업종 , 단계 , 구간시작(세제곱미터)  , 구간끝(세제곱미터)  , 구간금액(원)  , 단계별 기본요금(원)
 */
public class Main {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        TraiffRepository traiffRepository = context.getBean("csvTraiffRepository", TraiffRepository.class);

        traiffRepository.load("s");
        List<Tariff> list = traiffRepository.findByUsage(1000);
        for (Tariff tariff : list) {
            System.out.println(tariff.toString());
        }
    }
}
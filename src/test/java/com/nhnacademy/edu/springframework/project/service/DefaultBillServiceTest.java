package com.nhnacademy.edu.springframework.project.service;

import com.nhnacademy.edu.springframework.project.config.AppConfig;
import com.nhnacademy.edu.springframework.project.repository.TariffRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = AppConfig.class)
class DefaultBillServiceTest {

    @Autowired
    BillService defaultBillService;

    @Test
    void calCost() {
        assertThrows(RuntimeException.class, () -> defaultBillService.calCost(1000000));
        assertDoesNotThrow(() -> defaultBillService.calCost(1000));
    }
}
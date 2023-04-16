package com.nhnacademy.edu.springframework.project.repository;

import com.nhnacademy.edu.springframework.project.config.AppConfig;
import com.nhnacademy.edu.springframework.project.parser.DataParser;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = AppConfig.class)
class MemoryTariffRepositoryTest {
    @Autowired
    TariffRepository csvTariffRepository;
    @Autowired
    DataParser dataParser;

    @Test
    void load() {
        assertThrows(RuntimeException.class, () -> csvTariffRepository.load(" "));
        assertDoesNotThrow(()->csvTariffRepository.load("Tariff_20220331.csv"));
    }

    @Test
    void findByUsage() {
        assertDoesNotThrow(() -> csvTariffRepository.findByUsage(1000));
    }
}
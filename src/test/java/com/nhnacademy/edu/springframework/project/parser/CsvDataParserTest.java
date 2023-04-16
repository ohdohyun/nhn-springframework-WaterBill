package com.nhnacademy.edu.springframework.project.parser;

import com.nhnacademy.edu.springframework.project.config.AppConfig;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = AppConfig.class)
class CsvDataParserTest {
    @Autowired
    DataParser dataParser;

    @Test
    void parse() {
        Assertions.assertThrows(RuntimeException.class, () -> dataParser.parse(" "));
        Assertions.assertDoesNotThrow(()->dataParser.parse("Tariff_20220331.csv"));
    }
}
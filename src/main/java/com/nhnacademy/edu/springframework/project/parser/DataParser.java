package com.nhnacademy.edu.springframework.project.parser;

import com.nhnacademy.edu.springframework.project.repository.Tariff;

import java.util.List;

public interface DataParser {
    List<Tariff> parse(String filePath);
}

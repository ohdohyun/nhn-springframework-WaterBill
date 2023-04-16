package com.nhnacademy.edu.springframework.project.repository;

import com.nhnacademy.edu.springframework.project.parser.DataParser;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CsvTraiffRepository implements TraiffRepository {

    //TODO 저장할 자료구조(메모리)
    List<Tariff> tariffs = new ArrayList<>();

    private final DataParser dataParser;

    public CsvTraiffRepository(DataParser dataParser) {
        this.dataParser = dataParser;
    }

    @Override
    public void load(String filePath) {
        this.tariffs = dataParser.parse(filePath);
    }

    @Override
    public List<Tariff> findByUsage(int usage) {
        return tariffs.stream()
                .filter(t -> usage >= t.getStartRange() && usage <= t.getEndRange())
                .collect(Collectors.toList());
    }
}

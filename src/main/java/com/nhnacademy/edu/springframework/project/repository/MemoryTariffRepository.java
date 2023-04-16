package com.nhnacademy.edu.springframework.project.repository;

import com.nhnacademy.edu.springframework.project.parser.DataParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class MemoryTariffRepository implements TariffRepository {

    List<Tariff> tariffs = new ArrayList<>();

    private final DataParser csvDataParser;
    private final DataParser jsonDataParser;

    @Autowired
    public MemoryTariffRepository(@Qualifier("csvDataParser") DataParser csvDataParser,
                                  @Qualifier("jsonDataParser") DataParser jsonDataParser) {
        this.csvDataParser = csvDataParser;
        this.jsonDataParser = jsonDataParser;
    }

    @Override
    public void load(String filePath) {
        DataParser dataParser = selectDataParser(filePath);
        this.tariffs = dataParser.parse(filePath);
    }

    @Override
    public List<Tariff> findByUsage(int usage) {
        return tariffs.stream()
                .filter(t -> usage >= t.getStartRange() && usage <= t.getEndRange())
                .collect(Collectors.toList());
    }

    private DataParser selectDataParser(String filePath) {
        if (filePath.endsWith(".csv")) {
            return csvDataParser;
        } else if (filePath.endsWith(".json")) {
            return jsonDataParser;
        } else {
            throw new IllegalArgumentException("Unsupported file format");
        }
    }
}

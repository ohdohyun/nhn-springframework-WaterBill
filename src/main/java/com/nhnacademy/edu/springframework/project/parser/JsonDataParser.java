package com.nhnacademy.edu.springframework.project.parser;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nhnacademy.edu.springframework.project.repository.Tariff;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;

@Component
@Primary
public class JsonDataParser implements DataParser {

    private final ObjectMapper objectMapper;

    public JsonDataParser(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public List<Tariff> parse(String filePath) {
        try {
            URL resource = getClass().getClassLoader().getResource(filePath);
            File json = new File(resource.getFile());
            Tariff[] tariffs = objectMapper.readValue(json, Tariff[].class);
            return List.of(tariffs);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

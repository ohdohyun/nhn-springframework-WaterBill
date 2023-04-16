package com.nhnacademy.edu.springframework.project.parser;

import com.nhnacademy.edu.springframework.project.repository.Tariff;
import org.springframework.stereotype.Component;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Component
public class CsvDataParser implements DataParser {

    @Override
    public List<Tariff> parse(String filePath) {
        try {
            URL resource = getClass().getClassLoader().getResource(filePath);
            File csv = new File(resource.getFile());
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(csv)));
            String line = null;

            List<Tariff> tariffs = new ArrayList<>();
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                // 공백 제거해서 Tariff 객체로 만들고, 리스트에 담아서 리턴
                tariffs.add(new Tariff(
                        Integer.parseInt(data[0].trim()),   // tariffId
                        data[1].trim(),                     // city
                        data[2].trim(),                     // sector
                        Integer.parseInt(data[3].trim()),   // level
                        Integer.parseInt(data[4].trim()),   // startRange
                        Integer.parseInt(data[5].trim()),   // endRange
                        Integer.parseInt(data[6].trim())    // unitPrice
                ));
            }

            return tariffs;

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}

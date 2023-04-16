package com.nhnacademy.edu.springframework.project.repository;

import java.util.List;

public interface TariffRepository {
    public void load(String filePath);

    public List<Tariff> findByUsage(int usage);
}

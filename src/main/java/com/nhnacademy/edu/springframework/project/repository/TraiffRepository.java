package com.nhnacademy.edu.springframework.project.repository;

import java.util.List;

public interface TraiffRepository {
    public void load(String filePath);

    public List<Tariff> findByUsage(int usage);
}

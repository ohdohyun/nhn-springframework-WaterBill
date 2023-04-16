package com.nhnacademy.edu.springframework.project.report;

public interface ResultReport {
    public void report();

    public void reportByCity(String city);
    public void reportBySector(String sector);

}

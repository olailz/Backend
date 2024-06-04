package com.example.m7dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ReportDto {

    private Long idPatient;
    private Date generationDate;
    private String reportType;
    private String conten;
}


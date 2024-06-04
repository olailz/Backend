package com.example.m7dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class GenerateReportRequest {

    private Long idPatient;
    private String reportType;
}
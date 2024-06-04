package com.example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MedicalHistoryDto {

    private Long idHistory;
    private Long  patientId;
    private Long doctorId;
    private Date consultationDate;
    private String diagnosis;
    private String treatament;

}
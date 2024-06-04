package com.example.m4dto;

import java.sql.Date;
import java.time.LocalTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppoimentDto {

    private Long idappoiment;
    private Long idpatient;
    private Long iddoctor;
    private Long idroom;
    private Date dateappoiment;
    private LocalTime appoimenttime;
    private String status;
    private String observacion;
}

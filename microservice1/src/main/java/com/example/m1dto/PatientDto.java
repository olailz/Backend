package com.example.m1dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatientDto {

    private Long id;
    private String name;
    private String lastname;
    private int phone;
    private String adress;
    private Date birthdate;
    private String email;

}
package com.example.m3dto;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MedicoDto {

   
    private Long id;
    private long especiality;
    private String name;
    private String lastname;
    private int phone;
    private String adress;
    private String email;

}
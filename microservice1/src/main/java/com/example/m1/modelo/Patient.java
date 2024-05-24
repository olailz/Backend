package com.example.m1.modelo;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Table(name="patient")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Patient  {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @JoinColumn(name="id_patient")
        private Long id_patient;

        private String name;
        private String lastname;
        private int phone;
        private String adress;
        private Date birthdate;
        private String email;
}

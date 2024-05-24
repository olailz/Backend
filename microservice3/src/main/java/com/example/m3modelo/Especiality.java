package com.example.m3modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="medical_speciality")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Especiality {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id_speciality")
        private Long idspeciality;

        @Column(name="speciality")
        private String speciality;
}


package com.example.m4modelo;


import java.sql.Date;
import java.time.LocalTime;

import com.example.m1.modelo.Patient;
import com.example.m3modelo.Medico;
import com.example.m5modelo.Room;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@Table(name = "appoiment")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Appoiment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idcitamedica;

    @OneToMany(mappedBy = "id_patient")
    private Patient idpatient;

    @OneToMany(mappedBy = "id_doctor")
    private Medico iddoctor;

    @OneToMany(mappedBy = "id_room")
    private Room idroom;

    private Date dateappoiment;
    private LocalTime appoimenttime;
    private String status;
    private String observacion;

}

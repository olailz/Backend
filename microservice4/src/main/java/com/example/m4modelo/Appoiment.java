package com.example.m4modelo;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalTime;
import com.example.m1.modelo.Patient;
import com.example.m3modelo.Medico;
import com.example.m6modelo.Room;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
    @Column(name="id_appointment")
    private Long idappoiment;

    @ManyToOne
    @JoinColumn(name = "id_patient")
    private Patient idpatient;

    @ManyToOne
    @JoinColumn( name="id_doctor")
    private Medico iddoctor;

    @ManyToOne
    @JoinColumn(name = "id_room")
    private Room idroom;

    @Column(name="date_appointment")
    private Date dateappoiment;

    @Column(name="appointment_time")
    private LocalTime appoimenttime;

    @Column(name="status")
    private String status;

    @Column(name="observacion")
    private String observacion;
}

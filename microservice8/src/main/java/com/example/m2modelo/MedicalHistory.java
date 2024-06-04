package com.example.m2modelo;

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
import com.example.m1.modelo.Patient;
import com.example.m3modelo.Medico;


import java.util.Date;

@Entity
@Table(name = "medical_history")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class MedicalHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JoinColumn(name = "id_history")
    private Long idHistory;
    
    @ManyToOne
    @JoinColumn(name = "id_patient")
    private Patient idpatient;

    @ManyToOne
    @JoinColumn(name="id_doctor")
    private Medico id_doctor;

    @Column(name = "fecha_consulta")
    private Date consultationDate;

    @Column(name = "diagnostico")
    private String diagnosis;

    @Column(name = "tratamiento")
    private String treatament;
}

package com.example.m6modelo;

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
@Entity
@Data
@Table(name="room")
@AllArgsConstructor
@NoArgsConstructor
public class Room {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_room")
    private Long idroom;

    private String estado;

    @ManyToOne
    @JoinColumn(name="id_patient")
    private Patient idpatient;
    
}

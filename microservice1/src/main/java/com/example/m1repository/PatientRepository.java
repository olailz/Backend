package com.example.m1repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.m1.modelo.Patient;

public interface PatientRepository  extends JpaRepository<Patient, Long>{

    List<Patient> findByName(String name);
    
}

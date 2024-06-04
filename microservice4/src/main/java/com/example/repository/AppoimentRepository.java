package com.example.repository;
import com.example.m1.modelo.Patient;
import  com.example.m4modelo.Appoiment;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AppoimentRepository extends JpaRepository<Appoiment,Long> {

    List<Appoiment> findByIdpatient(Patient idpatient);
   
}

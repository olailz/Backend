package com.example.m2repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.m1.modelo.Patient;
import com.example.m2modelo.MedicalHistory;

public interface MedicalHistoryRepository extends JpaRepository<MedicalHistory,Long>{

    List<MedicalHistory> findByIdpatient(Patient idpatient);
}

package com.example.m7repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.m1.modelo.Patient;
import com.example.m6modelo.Report;

public interface ReportRepository extends JpaRepository<Report,Long> {
    List<Report> findByIdpatient(Patient idpatient);
    
    List<Report> findByReportTypeAndGenerationDate(String reportType, Date generationDate);
}

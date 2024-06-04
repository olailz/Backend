package com.example.m7service;

import java.sql.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.m1.modelo.Patient;
import com.example.m1repository.PatientRepository;
import com.example.m6modelo.Report;
import com.example.m7dto.GenerateReportRequest;
import com.example.m7dto.ReportDto;
import com.example.m7repository.ReportRepository;

@Service
public class ReportService {

        private final ReportRepository reportRepository;
        private final PatientRepository patientRepository;

        public ReportService(ReportRepository reportRepository, PatientRepository patientRepository)
            {
                this.reportRepository = reportRepository;
                this.patientRepository = patientRepository;
            }

            public List<Report> getAll()
                {
                    return reportRepository.findAll();
                }
        public Report createReport(ReportDto reportDto) {
        Patient patient = patientRepository.findById(reportDto.getIdPatient())
                .orElseThrow(() -> new RuntimeException("Patient not found"));
        Report report = new Report();
        report.setIdpatient(patient);
        report.setGenerationDate(reportDto.getGenerationDate());
        report.setReportType(reportDto.getReportType());
        report.setConten(reportDto.getConten());
        return reportRepository.save(report);
    }

    public Report getReportById(Long id) {
        return reportRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Report not found"));
    }

    public List<Report> getReportsByPatientId(Patient idpatient) {
        return reportRepository.findByIdpatient(idpatient);
    }

    public Report updateReport(Long id, ReportDto reportDto) {
        Report report = getReportById(id);
        report.setGenerationDate(reportDto.getGenerationDate());
        report.setReportType(reportDto.getReportType());
        report.setConten(reportDto.getConten());
        return reportRepository.save(report);
    }

    public void deleteReport(Long id) {
        reportRepository.deleteById(id);
    }

    public Report generateReport(GenerateReportRequest request) {
        Patient patient = patientRepository.findById(request.getIdPatient())
                .orElseThrow(() -> new RuntimeException("Patient not found"));
        Report report = new Report();
        report.setIdpatient(patient);
        report.setGenerationDate(new Date(0));
        report.setReportType(request.getReportType());
        report.setConten("Generated Content based on business logic");
        return reportRepository.save(report);
    }

    public List<Report> searchReports(String type, Date date) {
        return reportRepository.findByReportTypeAndGenerationDate(type, date);
    }
}

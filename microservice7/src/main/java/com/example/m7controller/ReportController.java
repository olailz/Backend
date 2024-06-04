package com.example.m7controller;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.m1.modelo.Patient;
import com.example.m6modelo.Report;
import com.example.m7dto.GenerateReportRequest;
import com.example.m7dto.ReportDto;
import com.example.m7service.ReportService;

@RestController
@RequestMapping("/reports")
public class ReportController {

    @Autowired
    private ReportService reportService;


     @GetMapping
     public ResponseEntity<List<Report>>getList()
            {
                return ResponseEntity.ok(reportService.getAll());
            }
    @PostMapping
    public ResponseEntity<Report> createReport(@RequestBody ReportDto reportDto) {
        Report newReport = reportService.createReport(reportDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(newReport);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Report> getReportById(@PathVariable Long id) {
        Report report = reportService.getReportById(id);
        return ResponseEntity.ok(report);
    }

    @GetMapping("/patients/{idpatient}")
    public ResponseEntity<List<Report>> getReportsByPatientId(@PathVariable Patient idpatient) {
        List<Report> reports = reportService.getReportsByPatientId(idpatient);
        return ResponseEntity.ok(reports);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Report> updateReport(@PathVariable Long id, @RequestBody ReportDto reportDto) {
        Report updatedReport = reportService.updateReport(id, reportDto);
        return ResponseEntity.ok(updatedReport);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReport(@PathVariable Long id) {
        reportService.deleteReport(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/generate")
    public ResponseEntity<Report> generateReport(@RequestBody GenerateReportRequest request) {
        Report generatedReport = reportService.generateReport(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(generatedReport);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Report>> searchReports(@RequestParam String type, @RequestParam Date date) {
        List<Report> reports = reportService.searchReports(type, date);
        return ResponseEntity.ok(reports);
    }
}


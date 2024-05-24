package com.example.m2controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.dto.MedicalHistoryDto;
import com.example.m1.modelo.Patient;
import com.example.m2modelo.MedicalHistory;
import com.example.m2service.MedicalHistoryService;
import com.example.m3service.MedicoService;
import com.example.service.PatientService;

import java.util.List;
import java.util.Optional;

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

@RestController
@RequestMapping("/MedicalHistory")
public class MedicalHistoryController {

    private final MedicalHistoryService medicalHistoryService;
    private final PatientService patientService;
    private final MedicoService medicoService;


    public MedicalHistoryController(MedicalHistoryService medicalHistoryService, MedicoService medicoService, PatientService patientService)
        {
            this.medicalHistoryService = medicalHistoryService;
            this.medicoService = medicoService;
            this.patientService = patientService;
        
        }

     @GetMapping
     public ResponseEntity<List<MedicalHistory>> getList()
            {
                return ResponseEntity.ok(medicalHistoryService.getAll());
            }
      @GetMapping("/{id}")
         public ResponseEntity<MedicalHistory> getmedicalHistoryById(@PathVariable Long id) 
                {
                    Optional<MedicalHistory> patient = medicalHistoryService.getmedicalHistoryById(id);
                    return patient.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
                }
    @PostMapping("/create")
                public ResponseEntity<MedicalHistory> createMedicalHistory(@RequestBody MedicalHistoryDto medicalHistoryDto) {
                    MedicalHistory medicalHistory = medicalHistoryService.saveMedicalHistory(medicalHistoryDto);
                    return ResponseEntity.ok(medicalHistory);
                }
      @PutMapping("/{id}")
    public ResponseEntity<MedicalHistory> updateMedicalHistory(@PathVariable Long id, @RequestBody MedicalHistoryDto medicalHistoryDto) {
        MedicalHistory updatedMedicalHistory = medicalHistoryService.updateMedicalHistory(id, medicalHistoryDto);
        return ResponseEntity.ok(updatedMedicalHistory);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMedicalHistory(@PathVariable Long id) {
        medicalHistoryService.deleteMedicalHistory(id);
        return ResponseEntity.noContent().build();
    }
   
    @GetMapping("/patient/{idpatient}")
    public ResponseEntity<List<MedicalHistory>> getMedicalHistoryByPatientId(@PathVariable Patient idpatient) {
        List<MedicalHistory> medicalHistoryList = medicalHistoryService.findMedicalHistoryByPatientId(idpatient);
        if (medicalHistoryList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(medicalHistoryList, HttpStatus.OK);
    }
}

package com.example.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.m1.modelo.Patient;
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
@RequestMapping("/Patient")

public class PatientController {

        private final PatientService patientService;

        public PatientController(PatientService patientService)
            {
                this.patientService = patientService;
            }
        @GetMapping
        public ResponseEntity<List<Patient>>getList()
            {
                return ResponseEntity.ok(patientService.getAll());
            }
        @GetMapping("/{id}")
         public ResponseEntity<Patient> getPatientById(@PathVariable Long id) 
                {
                    Optional<Patient> patient = patientService.getPatientById(id);
                    return patient.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
                }
         

        @PostMapping("/add")
        public ResponseEntity<Patient> addPatient(@RequestBody Patient patient) 
                {
                    Patient savedPatient = patientService.savePatient(patient);
                    return new ResponseEntity<>(savedPatient, HttpStatus.CREATED);
                 }
                  @PutMapping("/patients/{id}")
        public ResponseEntity<?> updatePatient(@PathVariable Long id, @RequestBody Patient patientDetails) 
                {
                    Patient updatedPatient = patientService.updatePatient(id, patientDetails);
                    return ResponseEntity.ok().body(updatedPatient);
                }
        @DeleteMapping("/patients/{id}")
        public ResponseEntity<?> deletePatient(@PathVariable Long id) 
                {
                    patientService.deletePatient(id);
                    return ResponseEntity.ok().build();
                }
        @GetMapping("/patients")
        public ResponseEntity<?> findPatientByName(@RequestParam String name) 
                {
                    List<Patient> patients = patientService.findPatientByName(name);
                    return ResponseEntity.ok().body(patients);
                }

}

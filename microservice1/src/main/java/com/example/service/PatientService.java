package com.example.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.m1.modelo.Patient;
import com.example.m1repository.PatientRepository;

import jakarta.transaction.Transactional;

@Service
public class PatientService {

        private final PatientRepository patientRepository;

        public PatientService(PatientRepository patientRepository)
            {
                this.patientRepository=patientRepository;
            }
        public List<Patient>getAll()
                {
                    return patientRepository.findAll();
                }
         public Optional<Patient> getPatientById(Long id)
                 {
                    return patientRepository.findById(id);
                 }
        
        public Patient savePatient(Patient patient) 
                {
                    return patientRepository.save(patient);
                }
        public Patient updatePatient(Long id, Patient patientDetails) {
                    Patient patient = patientRepository.findById(id)
                            .orElseThrow(() -> new NoSuchElementException("Patient not found with id " + id));
                
                    // Actualizar los detalles del paciente
                    patient.setName(patientDetails.getName());
                    patient.setLastname(patientDetails.getLastname());
                    patient.setPhone(patientDetails.getPhone());
                    patient.setAdress(patientDetails.getAdress());
                    patient.setBirthdate(patientDetails.getBirthdate());
                    patient.setEmail(patientDetails.getEmail());
                
                    return patientRepository.save(patient);
                }
        
        public void deletePatient(Long id) 
                {
                    Patient patient = patientRepository.findById(id)
                    .orElseThrow(() -> new NoSuchElementException("Patient not found with id " + id));
                    patientRepository.delete(patient);
                }
        public List<Patient> findPatientByName(String name) 
                {
                    return patientRepository.findByName(name);
                }
       
        
    
}

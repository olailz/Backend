package com.example.m2service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import com.example.dto.MedicalHistoryDto;
import com.example.m1.modelo.Patient;
import com.example.m1dto.PatientDto;
import com.example.m1repository.PatientRepository;
import com.example.m2modelo.MedicalHistory;
import com.example.m2repository.MedicalHistoryRepository;
import com.example.m3dto.MedicoDto;
import com.example.m3modelo.Medico;
import com.example.m3repository.MedicoRepository;

@Service
public class MedicalHistoryService {

    private final MedicalHistoryRepository medicalHistoryRepository;
    private final PatientRepository patientRepository;
    private final MedicoRepository medicoRepository;

    public MedicalHistoryService(MedicalHistoryRepository medicalHistoryRepository, PatientRepository patientRepository, MedicoRepository medicoRepository)
        {
            this.medicalHistoryRepository = medicalHistoryRepository;
            this.patientRepository = patientRepository;
            this.medicoRepository = medicoRepository;
        }
      public List<MedicalHistory>getAll()
            {
                 return medicalHistoryRepository.findAll();
            }        
     public Optional<MedicalHistory> getmedicalHistoryById(Long id)
                 {
                    return medicalHistoryRepository.findById(id);
                 }

     public MedicalHistory saveMedicalHistory(MedicalHistoryDto medicalHistoryDto) {
                    Patient patient = patientRepository.findById(medicalHistoryDto.getPatientId())
                            .orElseThrow(() -> new RuntimeException("Patient not found"));
            
                    Medico doctor = medicoRepository.findById(medicalHistoryDto.getDoctorId())
                            .orElseThrow(() -> new RuntimeException("Doctor not found"));
            
                    MedicalHistory medicalHistory = new MedicalHistory();
                    medicalHistory.setIdpatient(patient);
                    medicalHistory.setId_doctor(doctor);
                    medicalHistory.setConsultationDate(medicalHistoryDto.getConsultationDate());
                    medicalHistory.setDiagnosis(medicalHistoryDto.getDiagnosis());
                    medicalHistory.setTreatament(medicalHistoryDto.getTreatament());
            
                    return medicalHistoryRepository.save(medicalHistory);
                }
        
    public MedicalHistory updateMedicalHistory(Long id, MedicalHistoryDto medicalHistoryDto) {
        MedicalHistory existingMedicalHistory = medicalHistoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Medical history not found"));

        Patient patient = patientRepository.findById(medicalHistoryDto.getPatientId())
                .orElseThrow(() -> new RuntimeException("Patient not found"));

        Medico doctor = medicoRepository.findById(medicalHistoryDto.getDoctorId())
                .orElseThrow(() -> new RuntimeException("Doctor not found"));

        existingMedicalHistory.setIdpatient(patient);
        existingMedicalHistory.setId_doctor(doctor);
        existingMedicalHistory.setConsultationDate(medicalHistoryDto.getConsultationDate());
        existingMedicalHistory.setDiagnosis(medicalHistoryDto.getDiagnosis());
        existingMedicalHistory.setTreatament(medicalHistoryDto.getTreatament());

        return medicalHistoryRepository.save(existingMedicalHistory);
    }

    public void deleteMedicalHistory(Long id) {
        MedicalHistory existingMedicalHistory = medicalHistoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Medical history not found"));
        medicalHistoryRepository.delete(existingMedicalHistory);
    }
  
    public List<MedicalHistory> findMedicalHistoryByPatientId(Patient idpatient) {
        // Aquí utilizamos el ID del paciente para buscar los historiales médicos correspondientes
        return medicalHistoryRepository.findByIdpatient(idpatient);
    }

            
}
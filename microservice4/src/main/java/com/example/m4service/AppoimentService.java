package com.example.m4service;

import com.example.m4modelo.Appoiment;
import com.example.repository.AppoimentRepository;
import com.example.m1.modelo.Patient;
import com.example.m1repository.PatientRepository;
import com.example.m3repository.MedicoRepository;
import com.example.m4dto.AppoimentDto;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class AppoimentService {

    private final AppoimentRepository appoimentRepository;
    private final PatientRepository patientRepository;
    private final MedicoRepository medicoRepository;

    public AppoimentService(AppoimentRepository appoimentRepository, PatientRepository patientRepository, MedicoRepository medicoRepository) {
        this.appoimentRepository = appoimentRepository;
        this.patientRepository = patientRepository;
        this.medicoRepository = medicoRepository;
    }

    public Appoiment createAppointment(AppoimentDto appointmentDto) {
        Appoiment appointment = convertToEntity(appointmentDto);
        return appoimentRepository.save(appointment);
    }

    public List<Appoiment> getAll() {
        return appoimentRepository.findAll();
    }

    private Appoiment convertToEntity(AppoimentDto appointmentDto) {
        Appoiment appointment = new Appoiment();
        appointment.setDateappoiment(appointmentDto.getDateappoiment());
        appointment.setAppoimenttime(appointmentDto.getAppoimenttime());
        appointment.setIddoctor(medicoRepository.findById(appointmentDto.getIddoctor()).orElseThrow());
        appointment.setIdpatient(patientRepository.findById(appointmentDto.getIdpatient()).orElseThrow());
        appointment.setStatus(appointmentDto.getStatus());
        appointment.setObservacion(appointmentDto.getObservacion());
        return appointment;
    }

    public Appoiment getAppointmentById(Long appointmentId) {
        return appoimentRepository.findById(appointmentId).orElseThrow();
    }

    public List<Appoiment> getAppointmentsByPatientId(Patient idpatient) {
        return appoimentRepository.findByIdpatient(idpatient);
    }

    public Appoiment updateAppointment(Long appointmentId, AppoimentDto appointmentDto) {
        Appoiment existingAppointment = appoimentRepository.findById(appointmentId).orElseThrow();
        existingAppointment.setDateappoiment(appointmentDto.getDateappoiment());
        existingAppointment.setAppoimenttime(appointmentDto.getAppoimenttime());
        existingAppointment.setIddoctor(medicoRepository.findById(appointmentDto.getIddoctor()).orElseThrow());
        existingAppointment.setIdpatient(patientRepository.findById(appointmentDto.getIdpatient()).orElseThrow());
        existingAppointment.setStatus(appointmentDto.getStatus());
        existingAppointment.setObservacion(appointmentDto.getObservacion());
        return appoimentRepository.save(existingAppointment);
    }

    public void deleteAppointment(Long appointmentId) {
        appoimentRepository.deleteById(appointmentId);
    }
}

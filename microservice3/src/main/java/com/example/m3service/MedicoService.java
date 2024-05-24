package com.example.m3service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.m3dto.MedicoDto;
import com.example.m3modelo.Especiality;
import com.example.m3modelo.Medico;
import com.example.m3repository.MedicoRepository;
import com.example.m3repository.EspecialityRepository;

@Service
public class MedicoService {


        private final MedicoRepository medicoRepository;
        private final EspecialityRepository especialityRepository;
        @Autowired
        public MedicoService(MedicoRepository medicoRepository, EspecialityRepository especialityRepository)
            {
                this.medicoRepository = medicoRepository;
                this.especialityRepository = especialityRepository;
            }

        public List<Medico> getAll()
                {
                    return medicoRepository.findAll();
                }

        
         public Optional<Medico> getMedicoById(Long id)
                 {
                    return medicoRepository.findById(id);
                 }
         public Medico savePatient(Medico medico) 
                 {
                     return medicoRepository.save(medico);
                 }
        
    public Medico saveMedico(MedicoDto medicoDto) {
        Especiality especiality = especialityRepository.findById(medicoDto.getEspeciality())
                .orElseThrow(() -> new IllegalArgumentException("Especiality not found"));

        Medico medico = new Medico();
        medico.setEspeciality(especiality);
        medico.setName(medicoDto.getName());
        medico.setLastname(medicoDto.getLastname());
        medico.setPhone(medicoDto.getPhone());
        medico.setAdress(medicoDto.getAdress());
        medico.setEmail(medicoDto.getEmail());

        return medicoRepository.save(medico);
    }

    public Medico updateMedico(Long id, MedicoDto medicoDto) {
        Medico existingMedico = medicoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Medico not found"));

        Especiality especiality = especialityRepository.findById(medicoDto.getEspeciality())
                .orElseThrow(() -> new IllegalArgumentException("Especiality not found"));

        existingMedico.setEspeciality(especiality);
        existingMedico.setName(medicoDto.getName());
        existingMedico.setLastname(medicoDto.getLastname());
        existingMedico.setPhone(medicoDto.getPhone());
        existingMedico.setAdress(medicoDto.getAdress());
        existingMedico.setEmail(medicoDto.getEmail());

        return medicoRepository.save(existingMedico);
    }

    public void deleteMedico(Long id) {
        Medico existingMedico = medicoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Medico not found"));
        medicoRepository.delete(existingMedico);
    }

    public List<Medico> findMedicosByName(String name) {
        return medicoRepository.findByName(name);
    }
}

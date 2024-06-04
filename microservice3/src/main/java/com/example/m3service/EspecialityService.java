package com.example.m3service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.m3dto.MedicoDto;
import com.example.m3modelo.Especiality;
import com.example.m3modelo.Medico;
import com.example.m3repository.EspecialityRepository;

@Service
public class EspecialityService {
    private final EspecialityRepository especialityRepository;

    public EspecialityService(EspecialityRepository especialityRepository)
        {
            this.especialityRepository= especialityRepository;
        }
    
    public List<Especiality>getAll()
        {
            return especialityRepository.findAll();
        }
    
         public Optional<Especiality> getespecialityById(Long id)
                 {
                    return especialityRepository.findById(id);
                 }

        
   
     public Especiality saveEspeciality(Especiality especiality) 
                 {
                     return especialityRepository.save(especiality);
                 }

    public Especiality updateEspeciality(Long id, Especiality especialityDetails) {
                    Especiality especiality = especialityRepository.findById(id)
                            .orElseThrow(() -> new NoSuchElementException("Patient not found with id " + id));
                
                    // Actualizar los detalles de la especialidad
                    especiality.setSpeciality(especialityDetails.getSpeciality());
                   
                
                    return especialityRepository.save(especiality);
                }
        

    public void deleteEspeciality(Long id) {
        Especiality existingEspeciality = especialityRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Especiality not found"));
        especialityRepository.delete(existingEspeciality);
    }

}

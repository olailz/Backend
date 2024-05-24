package com.example.m3service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.m3modelo.Especiality;
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

}

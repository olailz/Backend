package com.example.m3contoller;

import org.springframework.web.bind.annotation.RestController;

import com.example.m3modelo.Especiality;
import com.example.m3service.EspecialityService;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/especiality")

public class EspecialityController {

        private final EspecialityService especialityService;

        public EspecialityController(EspecialityService especialityService)
            {   
                this.especialityService = especialityService;
            }

        @GetMapping
        public ResponseEntity<List<Especiality>>getList()
            {
                return ResponseEntity.ok(especialityService.getAll());
            }
}

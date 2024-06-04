package com.example.m3contoller;

import org.springframework.web.bind.annotation.RestController;

import com.example.m3dto.EspecialityDto;
import com.example.m3dto.MedicoDto;
import com.example.m3modelo.Especiality;
import com.example.m3modelo.Medico;
import com.example.m3service.EspecialityService;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


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

          @GetMapping("/{id}")
    public ResponseEntity<Especiality> getEspecialityById(@PathVariable Long id) 
            {
                Optional<Especiality> patient = especialityService.getespecialityById(id);
                return patient.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
            }
            @PostMapping("/add")
            public ResponseEntity<Especiality> addEspeciality(@RequestBody Especiality especiality) 
                    {
                        Especiality savedEspeciality = especialityService.saveEspeciality(especiality);
                        return new ResponseEntity<>(savedEspeciality, HttpStatus.CREATED);
                     }
  @PutMapping("/especiality/{id}")
                     public ResponseEntity<?> updateEspeciality(@PathVariable Long id, @RequestBody Especiality especialityDetails) 
                             {
                                 Especiality updatedEspeciality = especialityService.updateEspeciality(id, especialityDetails);
                                 return ResponseEntity.ok().body(updatedEspeciality);
                             }
     @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEspeciality(@PathVariable Long id) {
        especialityService.deleteEspeciality(id);
        return ResponseEntity.noContent().build();
    }  
}

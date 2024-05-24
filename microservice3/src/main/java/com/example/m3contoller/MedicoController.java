package com.example.m3contoller;

import org.springframework.web.bind.annotation.RestController;

import com.example.m3dto.MedicoDto;
import com.example.m3modelo.Medico;
import com.example.m3service.MedicoService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/Medico")
public class MedicoController {

    private final MedicoService medicoService;
    @Autowired
    public MedicoController(MedicoService medicoService)
        {
            this.medicoService = medicoService;
        }
     @GetMapping
    public ResponseEntity<List<Medico>>getList()
            {
                return ResponseEntity.ok(medicoService.getAll());
            }
    @GetMapping("/{id}")
    public ResponseEntity<Medico> getMedicoById(@PathVariable Long id) 
            {
                Optional<Medico> patient = medicoService.getMedicoById(id);
                return patient.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
            }
    @PostMapping("/add")
    public ResponseEntity<Medico> createMedico(@RequestBody MedicoDto medicoDto) {
        Medico medico = medicoService.saveMedico(medicoDto);
        return ResponseEntity.ok(medico);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Medico> updateMedico(@PathVariable Long id, @RequestBody MedicoDto medicoDto) {
        Medico updatedMedico = medicoService.updateMedico(id, medicoDto);
        return ResponseEntity.ok(updatedMedico);
    }
     @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMedico(@PathVariable Long id) {
        medicoService.deleteMedico(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/search")
    public ResponseEntity<List<Medico>> findMedicosByName(@RequestParam String name) {
        List<Medico> medicos = medicoService.findMedicosByName(name);
        return ResponseEntity.ok(medicos);
    }
}

package com.example.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.m1.modelo.Patient;
import com.example.m3modelo.Medico;
import com.example.m4modelo.Appoiment;
import com.example.m4service.AppoimentService;

import java.util.List;
import com.example.m4dto.AppoimentDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/Appoiment")

public class AppoimentController {

        private final AppoimentService appoimentService;

        public AppoimentController(AppoimentService appoimentService)
            {
                this.appoimentService = appoimentService;
            }

        //METODO PARA INSERTAR UNA CITA MEDICA
        @PostMapping
        public ResponseEntity<Appoiment> createAppointment(@RequestBody AppoimentDto appointmentDto) {
                Appoiment createdAppointment = appoimentService.createAppointment(appointmentDto);
                return ResponseEntity.status(HttpStatus.CREATED).body(createdAppointment);
            }
    //METODO PARA MOSTRAR TODAS LAS CITAS MEDICAS
    @GetMapping
    public ResponseEntity<List<Appoiment>>getList()
            {
                return ResponseEntity.ok(appoimentService.getAll());
            }
     @GetMapping("/{appointmentId}")
    public ResponseEntity<Appoiment> getAppointmentById(@PathVariable Long appointmentId) {
        Appoiment appointment = appoimentService.getAppointmentById(appointmentId);
        return ResponseEntity.ok(appointment);
    }
    @GetMapping("/patient/{idpatient}")
    public ResponseEntity<List<Appoiment>> getAppointmentsByPatientId(@PathVariable Patient idpatient) {
        List<Appoiment> appointments = appoimentService.getAppointmentsByPatientId(idpatient);
        return ResponseEntity.ok(appointments);
    }

    @PutMapping("/{appointmentId}")
    public ResponseEntity<Appoiment> updateAppointment(@PathVariable Long appointmentId, @RequestBody AppoimentDto appointmentDto) {
        Appoiment updatedAppointment = appoimentService.updateAppointment(appointmentId, appointmentDto);
        return ResponseEntity.ok(updatedAppointment);
    }

    // Método para eliminar una cita médica por su ID
    @DeleteMapping("/{appointmentId}")
    public ResponseEntity<Void> deleteAppointment(@PathVariable Long appointmentId) {
        appoimentService.deleteAppointment(appointmentId);
        return ResponseEntity.noContent().build();
    }
  

}

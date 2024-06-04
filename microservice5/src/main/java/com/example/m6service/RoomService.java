package com.example.m6service;
import java.util.List;
import org.springframework.stereotype.Service;
import com.example.m1.modelo.Patient;
import com.example.m1repository.PatientRepository;
import com.example.m6dto.RoomDto;
import com.example.m6modelo.Room;
import com.example.m6repository.RoomRepository;

@Service
public class RoomService {

    private final RoomRepository roomRepository;
    private final PatientRepository patientRepository;

    public RoomService(RoomRepository roomRepository, PatientRepository patientRepository)
        {
            this.roomRepository = roomRepository;
            this.patientRepository = patientRepository;
        }
    public List<Room>getAll()
                {
                    return roomRepository.findAll();
                }
     public Room updateRoom(Long id, RoomDto roomDto) {
        Room existingRoom = roomRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Room not found"));
            
             // Si roomDto.getIdpatient() es null, establece el paciente a null
            if (roomDto.getIdpatient() == null) {
                    existingRoom.setIdpatient(null);
            } else {
            // De lo contrario, busca y establece el paciente
            Patient patient = patientRepository.findById(roomDto.getIdpatient())
                 .orElseThrow(() -> new RuntimeException("Patient not found"));
             existingRoom.setIdpatient(patient);
                    }
            
                    existingRoom.setEstado(roomDto.getEstado());
            
                    return roomRepository.save(existingRoom);
                }

                public Room getRoomById(Long id) {
                    return roomRepository.findById(id)
                        .orElseThrow(() -> new RuntimeException("Room not found"));
                }
}

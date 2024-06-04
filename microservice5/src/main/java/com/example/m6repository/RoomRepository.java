package com.example.m6repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.m1.modelo.Patient;
import com.example.m6modelo.Room;

public interface RoomRepository extends JpaRepository<Room,Long>{

            List<Room> findByIdpatient(Patient idpatient);

}

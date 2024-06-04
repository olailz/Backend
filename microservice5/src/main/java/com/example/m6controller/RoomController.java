package com.example.m6controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.m6dto.RoomDto;
import com.example.m6modelo.Room;
import com.example.m6service.RoomService;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;



@RestController
@RequestMapping("/Room")

public class RoomController {

        private final RoomService roomService;

        public RoomController(RoomService roomService)
            {
                this.roomService = roomService;
            }
         @GetMapping
        public ResponseEntity<List<Room>>getList()
            {
                return ResponseEntity.ok(roomService.getAll());
            }
            @PutMapping("/{id}")
            public ResponseEntity<Room> updateRoom(@PathVariable Long id, @RequestBody RoomDto roomDto) {
                Room updatedRoom = roomService.updateRoom(id, roomDto);
                return ResponseEntity.ok(updatedRoom);
            }

            @GetMapping("/{id}")
    public ResponseEntity<Room> getRoomById(@PathVariable Long id) {
        Room room = roomService.getRoomById(id);
        return ResponseEntity.ok(room);
    }
}

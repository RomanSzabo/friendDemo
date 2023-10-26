package com.example.demo.controller;

import com.example.demo.entity.Hobby;
import com.example.demo.repository.HobbyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hobby")
public class HobbyController {

    @Autowired
    private HobbyRepository hobbyRepository;

    @GetMapping()
    public ResponseEntity<List<Hobby>> getAllhobby() {
        return ResponseEntity.ok(hobbyRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Hobby> getHobby(@PathVariable("id") int id) {
        return ResponseEntity.ok(hobbyRepository.findById(id).orElseThrow());
    }

    @PostMapping()
    public ResponseEntity<Hobby> createHobby(@RequestBody Hobby hobby) {
        return ResponseEntity.ok(hobbyRepository.save(hobby));
    }

    @PutMapping()
    public ResponseEntity<Hobby> updateHobby(@RequestBody Hobby hobby) {
        return ResponseEntity.ok(hobbyRepository.save(hobby));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteHobby(@PathVariable("id") int id) {
        hobbyRepository.delete(hobbyRepository.findById(id).orElseThrow());
        return ResponseEntity.ok().build();
    }

}

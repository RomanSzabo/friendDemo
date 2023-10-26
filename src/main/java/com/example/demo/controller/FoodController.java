package com.example.demo.controller;

import com.example.demo.entity.Food;
import com.example.demo.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/food")
public class FoodController {

    @Autowired
    private FoodRepository foodRepository;

    @GetMapping()
    public ResponseEntity<List<Food>> getAllFoods() {
        return ResponseEntity.ok(foodRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Food> getFood(@PathVariable("id") int id) {
        return ResponseEntity.ok(foodRepository.findById(id).orElseThrow());
    }

    @PostMapping()
    public ResponseEntity<Food> createFood(@RequestBody Food food) {
        return ResponseEntity.ok(foodRepository.save(food));
    }

    @PutMapping()
    public ResponseEntity<Food> updateFood(@RequestBody Food food) {
        return ResponseEntity.ok(foodRepository.save(food));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteFood(@PathVariable("id") int id) {
        foodRepository.delete(foodRepository.findById(id).orElseThrow());
        return ResponseEntity.ok().build();
    }

}

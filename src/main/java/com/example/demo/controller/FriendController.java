package com.example.demo.controller;

import com.example.demo.entity.*;
import com.example.demo.repository.FriendLikesFoodRepository;
import com.example.demo.repository.FriendRepository;
import com.example.demo.service.FriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/friend")
public class FriendController {

    @Autowired
    private FriendRepository friendRepository;

    @Autowired
    private FriendLikesFoodRepository friendLikesFoodRepository;

    @Autowired
    private FriendService friendService;

    @GetMapping()
    public ResponseEntity<List<Friend>> getAllFriend(@RequestParam(value = "name", required = false) String firstName) {
        if (firstName != null) {
            return ResponseEntity.ok(friendRepository.findAllByFirstNameOrderByFirstName(firstName));
        }
        return ResponseEntity.ok(friendRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Friend> getArticle(@PathVariable("id") int id) {
        return ResponseEntity.ok(friendRepository.findById(id).orElseThrow());
    }

    @GetMapping("/{id}/hobbies")
    public ResponseEntity<List<Hobby>> getFriendHobbies(@PathVariable("id") int id) {
        return ResponseEntity.ok(friendService.getFriendHobbies(id));
    }

    @GetMapping("/{id}/food")
    public ResponseEntity<List<Food>> getFriendFood(@PathVariable("id") int id) {
        return ResponseEntity.ok(friendService.getFriendFood(id));
    }

    @GetMapping("/food")
    public ResponseEntity<List<Friend>> getFriendFoodFilter(@RequestParam("foodId") List<Integer> foodIds) {
        return ResponseEntity.ok(friendService.getFriendsByFoodIds(foodIds));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Friend> createFriend(@RequestBody Friend friend) {
        return ResponseEntity.ok(friendRepository.save(friend));
    }

    @PostMapping("/food")
    public ResponseEntity<FriendLikesFood> addFoodToFriend(@RequestBody FriendLikesFood food) {
        return ResponseEntity.ok(friendLikesFoodRepository.save(food));
    }

    @PostMapping("/hobby")
    public ResponseEntity<FriendHasHobby> addHobbyToFriend(@RequestBody FriendHasHobby friendHasHobby) {
        friendService.saveFriendHobby(friendHasHobby.getFid(), friendHasHobby.getHid());
        return ResponseEntity.ok(friendHasHobby);
    }

    @PutMapping()
    public ResponseEntity<Friend> updateFriend(@RequestBody Friend friend) {
        return ResponseEntity.ok(friendRepository.save(friend));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteFriend(@PathVariable("id") int id) {
        friendRepository.delete(friendRepository.findById(id).orElseThrow());
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}/hobby/{hobbyId}")
    public ResponseEntity<?> deleteFriendsHobby(@PathVariable("id") int id, @PathVariable("hobbyId") int hobbyId) {
        friendService.deleteFriendsHobby(id, hobbyId);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}/food/{foodId}")
    public ResponseEntity<?> deleteFriendsFood(@PathVariable("id") int id, @PathVariable("foodId") int foodId) {
        friendService.deleteFriendsFood(id, foodId);
        return ResponseEntity.ok().build();
    }



}

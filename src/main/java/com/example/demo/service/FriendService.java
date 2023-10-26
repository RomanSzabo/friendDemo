package com.example.demo.service;

import com.example.demo.entity.Food;
import com.example.demo.entity.Friend;
import com.example.demo.entity.FriendHasHobby;
import com.example.demo.entity.Hobby;
import com.example.demo.repository.FoodRepository;
import com.example.demo.repository.FriendLikesFoodRepository;
import com.example.demo.repository.FriendRepository;
import com.example.demo.repository.HobbyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FriendService {

    @Autowired
    private FriendRepository friendRepository;

    @Autowired
    private FoodRepository foodRepository;

    @Autowired
    private FriendLikesFoodRepository friendLikesFoodRepository;

    @Autowired
    private HobbyRepository hobbyRepository;

    public List<Hobby> getFriendHobbies(int friendId) {
        return hobbyRepository.findByFriendId(friendId);
    }

    public List<Food> getFriendFood(int friendId) {
        return foodRepository.findAllByFriendId(friendId);
    }

    public List<Friend> getFriendsByFoodIds(List<Integer> foodIds) {
        return friendRepository.findAllByFoodIds(foodIds);
    }

    public void saveFriendHobby(int friendId, int hobbyId) {
        hobbyRepository.saveFriendHobby(friendId, hobbyId);
    }

    public void deleteFriendsHobby(int friendId, int hobbyId) {
        hobbyRepository.deleteFriendHobby(friendId, hobbyId);
    }

    public void deleteFriendsFood(int friendId, int foodId) {
        friendLikesFoodRepository.deleteByFidAndFoid(friendId, foodId);
    }

}

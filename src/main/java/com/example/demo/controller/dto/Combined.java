package com.example.demo.controller.dto;

import com.example.demo.entity.Food;
import com.example.demo.entity.Friend;
import com.example.demo.entity.Hobby;
import lombok.Data;

import java.util.List;

@Data
public class Combined {

    private List<Friend> friends;

    private List<Hobby> hobbies;

    private List<Food> foods;

}

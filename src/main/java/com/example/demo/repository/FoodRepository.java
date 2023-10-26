package com.example.demo.repository;

import com.example.demo.entity.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoodRepository extends JpaRepository<Food, Integer> {

    @Query("select a from Food a join FriendLikesFood b on a.id = b.foid where b.fid = ?1")
    List<Food> findAllByFriendId(int friendId);

}

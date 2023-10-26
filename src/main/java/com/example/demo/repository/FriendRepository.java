package com.example.demo.repository;

import com.example.demo.entity.Friend;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FriendRepository extends JpaRepository<Friend, Integer> {

    List<Friend> findAllByFirstNameOrderByFirstName(String firstName);

    @Query("select a from Friend a join FriendLikesFood b on a.id = b.fid where b.foid in :foodIds")
    List<Friend> findAllByFoodIds(List<Integer> foodIds);

}

package com.example.demo.repository;

import com.example.demo.entity.FriendLikesFood;
import com.example.demo.entity.FriendLikesFoodPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface FriendLikesFoodRepository extends JpaRepository<FriendLikesFood, FriendLikesFoodPK> {

    @Transactional
    void deleteByFidAndFoid(int friendId, int foodId);

}

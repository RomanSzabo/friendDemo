package com.example.demo.repository;

import com.example.demo.entity.FriendHasHobby;
import com.example.demo.entity.Hobby;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface HobbyRepository extends JpaRepository<Hobby, Integer> {

    @Query("select a from Hobby a join FriendHasHobby b on a.id = b.hid where b.fid = :friendId")
    List<Hobby> findByFriendId(int friendId);

    @Modifying
    @Query(value = "INSERT INTO friend_has_hobby (fid, hid) VALUES (?1, ?2)", nativeQuery = true)
    @Transactional
    void saveFriendHobby(int friendId, int hobbyId);

    @Modifying
    @Query(value = "DELETE FROM friend_has_hobby WHERE fid = ?1 AND hid = ?2", nativeQuery = true)
    @Transactional
    void deleteFriendHobby(int friendId, int hobbyId);

}

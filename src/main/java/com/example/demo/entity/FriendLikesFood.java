package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Objects;

@Entity
@Table(name = "friend_likes_food")
@IdClass(com.example.demo.entity.FriendLikesFoodPK.class)
@Data
public class FriendLikesFood {

    @Id
    private Integer fid;

    @Id
    private Integer foid;

}

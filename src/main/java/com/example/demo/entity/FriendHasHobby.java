package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Objects;

@Entity
@Table(name = "friend_has_hobby")
@IdClass(com.example.demo.entity.FriendHasHobbyPK.class)
@Data
public class FriendHasHobby {
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "fid")
    private Integer fid;

    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "hid")
    private Integer hid;

}

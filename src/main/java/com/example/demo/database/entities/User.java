package com.example.demo.database.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Table(name = "users")
@Entity
public class User {
    
    @Id
    @GeneratedValue
    private Long id;

    private String username;
    private String password;

    private String displayName;
    private String phoneNumber;
    
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @OneToMany(mappedBy = "user")
    private List<Tweet> tweets = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<Reply> replies = new ArrayList<>();

    @ManyToMany(mappedBy = "usersLikes")
    private List<Tweet> likedTweets = new ArrayList<>();

}
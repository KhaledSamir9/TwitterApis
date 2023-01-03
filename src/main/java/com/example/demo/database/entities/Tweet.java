package com.example.demo.database.entities;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Table(name = "tweets")
@Entity
public class Tweet {
    
    @Id
    @GeneratedValue
    private Long id;

    private String body;

    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "tweet")
    private List<Reply> replies = new ArrayList<>();

    @ManyToOne
    private User user;

    @ManyToMany
    private List<User> usersLikes = new ArrayList<>();

}

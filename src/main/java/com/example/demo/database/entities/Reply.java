package com.example.demo.database.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Table(name = "replies")
@Entity
public class Reply {

    @Id
    @GeneratedValue
    private Long id;

    private String body;

    @ManyToOne
    private Tweet tweet;

    @ManyToOne
    private User user;
}

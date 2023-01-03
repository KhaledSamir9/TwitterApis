package com.example.demo.api.v1.tweets;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetTweetResponse {
    
    private Long id;

    private String body;

    private LocalDateTime createdAt;

    // other data

}

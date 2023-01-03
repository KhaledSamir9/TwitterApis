package com.example.demo.api.v1.tweets;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateTweetRequest {
    
    private String body;

    private Long userId;

}

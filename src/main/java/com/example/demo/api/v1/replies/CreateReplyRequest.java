package com.example.demo.api.v1.replies;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateReplyRequest {
    
    private Long tweetId;

    private String body;

    private Long userId;

}

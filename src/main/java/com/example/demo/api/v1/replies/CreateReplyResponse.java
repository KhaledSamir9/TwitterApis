package com.example.demo.api.v1.replies;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateReplyResponse {
    
    private Long replyId;

    private String body;

}

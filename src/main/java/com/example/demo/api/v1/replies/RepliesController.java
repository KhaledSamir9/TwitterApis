package com.example.demo.api.v1.replies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.services.TweetingService;

@RestController
@RequestMapping("/api/v1")
public class RepliesController {
    
    @Autowired
    TweetingService tweetingService;


    @PostMapping("/replies")
    public CreateReplyResponse createReply(@RequestBody CreateReplyRequest request) {
        return tweetingService.createNewReply(request);
    }


}

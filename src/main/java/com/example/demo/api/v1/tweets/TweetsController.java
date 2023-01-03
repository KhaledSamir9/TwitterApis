package com.example.demo.api.v1.tweets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.services.TweetingService;

@RestController
@RequestMapping("/api/v1")
public class TweetsController {
    
    @Autowired
    private TweetingService tweetingService;
    
    @PostMapping("/tweets")
    public CreateTweetResponse addNewTweet(@RequestBody CreateTweetRequest createTweetRequest) {
        return tweetingService.createNewTweet(createTweetRequest);
    }

    @GetMapping("/tweets/{id}")
    public GetTweetResponse getTweetById(@PathVariable Long id) {
        return tweetingService.getTweetById(id);
    }

    @DeleteMapping("/tweets/{id}")
    public void deleteById(@PathVariable Long id) {
        tweetingService.deleteById(id);
    }
    

}

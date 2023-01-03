package com.example.demo.services;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.api.v1.replies.CreateReplyRequest;
import com.example.demo.api.v1.replies.CreateReplyResponse;
import com.example.demo.api.v1.tweets.CreateTweetRequest;
import com.example.demo.api.v1.tweets.CreateTweetResponse;
import com.example.demo.api.v1.tweets.GetTweetResponse;
import com.example.demo.database.entities.Reply;
import com.example.demo.database.entities.Tweet;
import com.example.demo.database.entities.User;
import com.example.demo.database.repository.ReplyRepository;
import com.example.demo.database.repository.TweetRepository;
import com.example.demo.database.repository.UserRepository;

@Service
public class TweetingService {

    @Autowired
    private TweetRepository tweetRepository;

    @Autowired
    private ReplyRepository replyRepository;

    @Autowired
    private UserRepository userRepository;

    public CreateTweetResponse createNewTweet(CreateTweetRequest createTweetRequest) {
        String tweetBody = createTweetRequest.getBody();
        Long userId = createTweetRequest.getUserId();

        Optional<User> userOpt = userRepository.findById(userId);
        User user = userOpt.get();

        Tweet tweet = new Tweet();
        tweet.setBody(tweetBody);
        tweet.setCreatedAt(LocalDateTime.now());
        tweet.setUser(user);
        Tweet savedTweet = tweetRepository.save(tweet);

        CreateTweetResponse response = new CreateTweetResponse();
        response.setId(savedTweet.getId());
        response.setBody(savedTweet.getBody());
        response.setCreatedAt(savedTweet.getCreatedAt());

        return response;
    }

    public GetTweetResponse getTweetById(Long id) {
        Optional<Tweet> tweetOpt = tweetRepository.findById(id);
        Tweet tweet = tweetOpt.get();

        GetTweetResponse response = new GetTweetResponse();
        response.setId(tweet.getId());
        response.setBody(tweet.getBody());
        response.setCreatedAt(tweet.getCreatedAt());
        return response;
    }

    public void deleteById(Long id) {
        tweetRepository.deleteById(id);
    }

    public CreateReplyResponse createNewReply(CreateReplyRequest request) {
        Long userId = request.getUserId();
        Long tweetId = request.getTweetId();
        String body = request.getBody();
        
        Optional<User> userOpt = userRepository.findById(userId);
        User user = userOpt.get();

        Optional<Tweet> tweetOpt = tweetRepository.findById(tweetId);
        Tweet tweet = tweetOpt.get();

        Reply reply = new Reply();
        reply.setBody(body);
        reply.setUser(user);
        reply.setTweet(tweet);

        Reply savedReply = replyRepository.save(reply);

        CreateReplyResponse response = new CreateReplyResponse();
        response.setReplyId(savedReply.getId());
        response.setBody(savedReply.getBody());

        return response;
    }
    
}

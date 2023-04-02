package com.twetero.api.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.twetero.api.dto.TweetDTO;
import com.twetero.api.model.Tweet;
import com.twetero.api.model.Users;
import com.twetero.api.repository.TweetRepository;
import com.twetero.api.repository.UsersRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/tweet")

public class TweetController {

  @Autowired
  private TweetRepository tweetRepository;

  @Autowired
  private UsersRepository usersRepository;

  @PostMapping
  public ResponseEntity<String> create(@RequestBody @Valid TweetDTO req) {
    List<Users> users = usersRepository.findByUsername(req.username());

    if (users.isEmpty()) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario não encontrado");
    } else {
      tweetRepository.save(new Tweet(req, users.get(0).getAvatar()));
      return ResponseEntity.status(HttpStatus.OK).body("Ok");
    }

  }

  @GetMapping
  public List<Tweet> listAll(@RequestParam(required = false) String page) {
    List<Tweet> tweets = tweetRepository.findAllByOrderByIdDesc();
    List<Tweet> response = new ArrayList<>();
    int pageInt;

    if (tweets.isEmpty()) {
      return response;
    } else if (page == null) {
      pageInt = 1;
    } else {
      pageInt = Integer.parseInt(page);
    }

    int start = (pageInt - 1) * 5;

    if (start > tweets.size()) {
      return response;
    }

    int end = Math.min(start + 5, tweets.size());
    response = tweets.subList(start, end);

    return response;

  }

  @GetMapping("/{username}")
  public List<Tweet> listUserTweets(@PathVariable String username) {
    return tweetRepository.findByUsername(username);
  }

}

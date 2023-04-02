package com.twetero.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.twetero.api.model.Tweet;

public interface TweetRepository extends JpaRepository<Tweet, Long> {
  List<Tweet> findByUsername(String username);

  List<Tweet> findAllByOrderByIdDesc();

}

package com.twetero.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.twetero.api.model.Tweet;

public interface TweetRepository extends JpaRepository<Tweet, Long> {

}

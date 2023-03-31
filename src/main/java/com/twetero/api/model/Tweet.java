package com.twetero.api.model;

import com.twetero.api.dto.TweetDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Tweet {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(length = 100, nullable = false)
  private String username;

  @Column(length = 500, nullable = false)
  private String tweet;

  public Tweet(TweetDTO data) {
    this.username = data.username();
    this.tweet = data.tweet();
  }

}

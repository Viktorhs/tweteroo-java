package com.twetero.api.model;

import com.twetero.api.dto.UserDTO;

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
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(length = 100, nullable = false)
  private String username;

  @Column(length = 1000, nullable = false)
  private String avatar;

  public User(UserDTO data) {
    this.username = data.username();
    this.avatar = data.avatar();
  }

}

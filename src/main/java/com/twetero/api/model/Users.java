package com.twetero.api.model;

import com.twetero.api.dto.UsersDTO;

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
public class Users {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(length = 100, nullable = false)
  private String username;

  @Column(length = 200, nullable = true)
  private String avatar;

  public Users(UsersDTO data) {
    this.username = data.username();
    this.avatar = data.avatar();
  }

}

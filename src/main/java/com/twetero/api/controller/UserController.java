package com.twetero.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.twetero.api.dto.UserDTO;
import com.twetero.api.model.User;
import com.twetero.api.repository.UserRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/user")
public class UserController {

  @Autowired
  private UserRepository repository;

  @PostMapping
  public String create(@RequestBody @Valid UserDTO req) {

    repository.save(new User(req));

    return "OK";
  }

}

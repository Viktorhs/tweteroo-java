package com.twetero.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.twetero.api.dto.UsersDTO;
import com.twetero.api.model.Users;
import com.twetero.api.repository.UsersRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/user")

public class UsersController {

  @Autowired
  private UsersRepository repository;

  @PostMapping
  public ResponseEntity<String> create(@RequestBody @Valid UsersDTO req) {
    List<Users> users = repository.findByUsername(req.username());

    if (users.isEmpty()) {
      repository.save(new Users(req));
      return ResponseEntity.status(HttpStatus.OK).body("Ok");

    } else {
      return ResponseEntity.status(HttpStatus.CONFLICT).body("Nome ja utilizado");
    }

  }

  @GetMapping
  public List<Users> listAll() {
    return repository.findAll();
  }

}

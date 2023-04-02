package com.twetero.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.twetero.api.model.Users;

public interface UsersRepository extends JpaRepository<Users, Long> {
  List<Users> findByUsername(String username);
}
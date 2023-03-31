package com.twetero.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.twetero.api.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}

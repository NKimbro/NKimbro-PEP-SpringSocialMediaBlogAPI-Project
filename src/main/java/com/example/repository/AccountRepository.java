package com.example.repository;

import com.example.entity.*;

import org.springframework.data.jpa.repository.JpaRepository;


public interface AccountRepository extends JpaRepository<Account, Integer> {

  public Account findByUsername(String username);

  public Account findByUsernameAndPassword(String username, String password);
}

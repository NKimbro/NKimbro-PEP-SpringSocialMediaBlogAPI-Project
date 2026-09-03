package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.*;
import com.example.repository.*;

@Service
public class AccountService {
  @Autowired
  AccountRepository accountRepository;

  public Account persistAccount(Account account) {
    if (accountRepository.findByUsername(account.getUsername()) == null)
      return accountRepository.save(account);
    return null;
  }

  public Account getAccountByUsernameAndPassword(String username, String password) {
    return accountRepository.findByUsernameAndPassword(username, password);
  }
}

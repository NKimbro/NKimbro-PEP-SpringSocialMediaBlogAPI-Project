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
    return accountRepository.save(account);
  }

  public Account getAccountByUsernameAndPassword(String username, String password) {
    Optional<Account> optionalAccount = accountRepository.findByUsernameAndPassword(username, password)
  }
}

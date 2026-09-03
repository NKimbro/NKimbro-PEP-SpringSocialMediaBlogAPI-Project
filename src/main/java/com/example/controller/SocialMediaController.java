package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.entity.*;
import com.example.service.*;

/**
 * TODO: You will need to write your own endpoints and handlers for your controller using Spring. The endpoints you will need can be
 * found in readme.md as well as the test cases. You be required to use the @GET/POST/PUT/DELETE/etc Mapping annotations
 * where applicable as well as the @ResponseBody and @PathVariable annotations. You should
 * refer to prior mini-project labs and lecture materials for guidance on how a controller may be built.
 */
@RestController
public class SocialMediaController {

  @Autowired
  AccountService accountService;
  
  // @Autowired
  // MessageService messageService;

  @PostMapping("/register")
  public ResponseEntity<Account> createAccount(@RequestBody Account account) {
    if (account.getUsername().equals("") || account.getPassword().length() < 4)
      return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                            .body(null);

    Account attempt = accountService.persistAccount(account);
    if (attempt == null)
      return ResponseEntity.status(HttpStatus.CONFLICT)
                            .body(null);

    return ResponseEntity.status(HttpStatus.OK)
                          .body(attempt);
  }

  @PostMapping("/login")
  public ResponseEntity<Account> loginAccount(@RequestBody Account account) {
    Account attempt = accountService.getAccountByUsernameAndPassword(account.getUsername(), account.getPassword());
    if (attempt == null)
      return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                            .body(null);
    
    return ResponseEntity.status(HttpStatus.OK)
                          .body(attempt);
  }
}

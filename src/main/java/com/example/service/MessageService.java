package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import com.example.entity.*;
import com.example.repository.*;


public class MessageService {
  
  @Autowired
  MessageRepository messageRepository;

  
}

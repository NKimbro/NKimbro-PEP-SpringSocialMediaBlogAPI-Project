package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import com.example.entity.*;
import com.example.repository.*;

@Service
public class MessageService {
  
  @Autowired
  MessageRepository messageRepository;

  public Message persistMessage(Message message) {
    return messageRepository.save(message);
  }

  public List<Message> getAllMessages() {
    return messageRepository.findAll();
  }

  public Message getMessageById(Integer id) {
    Optional<Message> attempt = messageRepository.findById(id);
    if(attempt.isPresent())
      return attempt.get();
    return null;
  }

  public Integer deleteMessageById(Integer id) {
    Optional<Message> attempt = messageRepository.findById(id);
    messageRepository.deleteById(id);
    if(attempt.isPresent())
      return 1;
    return null;
  }

  public Integer updateMessageById(Integer id, String text) {
    Optional<Message> attempt = messageRepository.findById(id);
    if(attempt.isPresent()) {
      Message message = attempt.get();
      message.setMessageText(text);
      messageRepository.save(message);
      return 1;
    }
    return null;
  }

  public List<Message> getMessagesByAccountId(Integer id) {
    return messageRepository.findAllByPostedBy(id);
  }
}

package com.example.repository;

import com.example.entity.*;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface MessageRepository extends JpaRepository<Message, Integer> {

  public List<Message> findAllByPostedBy(Integer PostedBy);
}

package com.example.java_rabbitMQ;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MessageController {

  @Autowired
  private Consumer consumer;

  @GetMapping("/messages")
  public List<String> getMessages() {
    return consumer.getMessages();
  }
}

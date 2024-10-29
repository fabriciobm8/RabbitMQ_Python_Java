package com.example.java_rabbitMQ;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Consumer {

  private final List<String> messages = new ArrayList<>();

  @RabbitListener(queues = JavaRabbitMQConfig.QUEUE_NAME)
  public void receiveMessage(String message) {
    System.out.println(" [x] Received '" + message + "'");
    messages.add(message);
  }

  public List<String> getMessages() {
    return messages;
  }
}

package com.thymeleaf.demo.controller.chat;

import com.thymeleaf.demo.service.LineMessagingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/webhook")
public class LineWebhookController {
  @Autowired
  private LineMessagingService lineMessagingService;

  @PostMapping
  public void handleWebhook(@RequestBody Map<String, Object> payload) {
    List<Map<String, Object>> events = (List<Map<String, Object>>) payload.get("events");
    for (Map<String,Object> event : events) {
      String replyToken = (String) event.get("replyToken");
      String message = "Hello from LINE bot!";
      lineMessagingService.replyMessage(replyToken, message);
    }
  }
}

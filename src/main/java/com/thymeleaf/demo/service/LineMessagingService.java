package com.thymeleaf.demo.service;

import com.thymeleaf.demo.config.line.LineConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class LineMessagingService {
  private static final String REPLY_URL = "https://api.line.me/v2/bot/message/reply";
  private static final String PUSH_URL = "https://api.line.me/v2/bot/message/push";

  @Autowired
  private LineConfig lineConfig;

  public void replyMessage(String replyToken, String message) {
    Map<String, Object> body = new HashMap<>();
    body.put("replyToken", replyToken);
    body.put("messages", new Object[] {Map.of("type", "text", "text", message)});

    RestTemplate restTemplate = new RestTemplate();
    restTemplate.postForObject(REPLY_URL, body, String.class,
        Map.of("Authorization", "Bearer " + lineConfig.getChannelAccessToken()));
  }
}

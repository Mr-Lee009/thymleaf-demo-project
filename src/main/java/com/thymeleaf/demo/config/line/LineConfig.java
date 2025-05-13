package com.thymeleaf.demo.config.line;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LineConfig {
  @Value("${line.channel.access-token}")
  private String channelAccessToken;

  @Value("${line.channel.secret}")
  private String channelSecret;

  public String getChannelAccessToken() {
    return channelAccessToken;
  }

  public String getChannelSecret() {
    return channelSecret;
  }
}

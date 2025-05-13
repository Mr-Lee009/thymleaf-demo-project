package com.thymeleaf.demo.controller.chat;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LineChatController {
  @GetMapping("/chat")
  public String chat(){
    return "LINEChat";
  }
}

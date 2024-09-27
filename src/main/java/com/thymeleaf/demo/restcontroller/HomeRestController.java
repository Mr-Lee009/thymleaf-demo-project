package com.thymeleaf.demo.restcontroller;

import jakarta.websocket.server.PathParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/home")
public class HomeRestController {
    @GetMapping("/{name}")
    public String hello(@PathParam("name") String name) {
        return "Hello my friend" + name;
    }
}

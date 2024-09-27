package com.thymeleaf.demo.restcontroller;

import jakarta.websocket.server.PathParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/bill")
public class BillRestController {
    @GetMapping("/{salary}")
    public String hello(@PathParam("salary") String salary) {
        return "I have " + salary;
    }
}

package com.thymeleaf.demo.controller.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
@RequestMapping("/api/bill")
public class BillRestController {
    @GetMapping("/{salary}")
    public String hello(@PathVariable("salary") String salary) throws InterruptedException {
        Random random = new Random();
        Long second = 1000 * random.nextLong(1,20);
        System.out.printf("\nsecond = " + second + ", salary=" + salary);
        Thread.sleep(second);
        return "I have " + salary;
    }
}

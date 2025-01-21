package com.thymeleaf.demo.controller.S1002_TestingPage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/page/testing")
public class S1002_TestingController {

    @Autowired
    s1002_TestingHelper helper;

    @GetMapping("")
    public String testingPage(Model model){
        // init screen
        model.addAttribute("form",helper.initScreen());

        return "s1002_testing_page";
    }
}

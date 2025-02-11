package com.thymeleaf.demo.controller.S1002_TestingPage;

import com.thymeleaf.demo.dto.CommonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/page/testing")
public class S1002_TestingRestController {

  @Autowired
  s1002_TestingHelper helper;

  @GetMapping("/submit-test")
  public CommonResponse<String> testingPage(Model model) {
    // init screen
    model.addAttribute("form", helper.initScreen());
    try {
      return CommonResponse.successResponse("OK");
    } catch (Exception ex) {
      return CommonResponse.exceptionResponse(ex.getMessage());
    }
  }

}

package com.thymeleaf.demo.controller.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/product")
public class S2000_ProductPageController {

  @Autowired
  S2000_ProductHelper helper;

  @GetMapping("/list")
  public String listProduct(Model model){
    model.addAttribute("products",helper.findAll());
    return "s2000_productPage";
  }
}

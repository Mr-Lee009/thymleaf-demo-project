package com.thymeleaf.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Human {
    private String name;
    private int old;
    private String phone;
    private Double salary;
}

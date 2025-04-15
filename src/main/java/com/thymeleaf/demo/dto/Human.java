package com.thymeleaf.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Human {
    private String id;
    private String name;
    private int old;
    private String phone;
    private Double salary;
}


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
    private String type;
    private String classRoom;

    public Human(String id, String name, int old, String phone, Double salary) {
        this.id = id;
        this.name = name;
        this.old = old;
        this.phone = phone;
        this.salary = salary;
    }
}


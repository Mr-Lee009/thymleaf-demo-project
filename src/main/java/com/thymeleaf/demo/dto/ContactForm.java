package com.thymeleaf.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ContactForm {
    private String name;
    private String phoneNumber;
    private String sex;
    private String type;

    private String[] types;
    private String[] genderTypes;

    public void init() {
        types = new String[]{"S", "M", "L", "XL", "XXXL"};
        genderTypes = new String[]{"Male", "Female", "Gay", "Less"};
    }
}

package com.thymeleaf.demo.dto.s1002;

import lombok.*;

import java.util.Map;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class s1201_QuestionDto {
    private int id;
    private String question;
    private String image;
    private Map<String,String> anserts;
}

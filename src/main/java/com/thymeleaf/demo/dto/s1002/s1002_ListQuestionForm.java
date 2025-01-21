package com.thymeleaf.demo.dto.s1002;

import com.thymeleaf.demo.dto.Human;
import lombok.*;
import java.sql.Date;
import java.util.List;

@Builder
@Getter
@Setter
@AllArgsConstructor
public class s1002_ListQuestionForm {
    private String nameTest;
    private Date beginTime;
    private Date endTime;
    private List<s1201_QuestionDto> questions;
    private Human user;
}

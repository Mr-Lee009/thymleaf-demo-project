package com.thymeleaf.demo.controller.S1002_TestingPage;

import com.thymeleaf.demo.dto.Human;
import com.thymeleaf.demo.dto.s1002.s1002_ListQuestionForm;
import com.thymeleaf.demo.dto.s1002.s1201_QuestionDto;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class s1002_TestingHelper {

    public s1002_ListQuestionForm initScreen() {

        List<s1201_QuestionDto> questions = new ArrayList<>();

        questions.add(
                s1201_QuestionDto.builder()
                        .id(1)
                        .image("/default_image.jpg")
                        .question("1.I don't have time for u")
                        .anserts(
                                Map.of(
                                        "1", "dap an 1",
                                        "2", "dap an 2",
                                        "3", "dap an 3",
                                        "4", "dap an 4",
                                        "5", "dap an 5",
                                        "6", "dap an 6"
                                )
                        )
                        .build()
        );

        questions.add(
                s1201_QuestionDto.builder()
                        .id(2)
                        .image("/default_image.jpg")
                        .question("2.I don't have time for u")
                        .anserts(
                                Map.of(
                                        "1", "dap an 1",
                                        "2", "dap an 2",
                                        "3", "dap an 3"
                                )
                        )
                        .build()
        );

        questions.add(
                s1201_QuestionDto.builder()
                        .id(3)
                        .image("/default_image.jpg")
                        .question("2.I don't have time for u")
                        .anserts(
                                Map.of(
                                        "1", "dap an 1",
                                        "2", "dap an 2",
                                        "3", "dap an 3"
                                )
                        )
                        .build()
        );

        s1002_ListQuestionForm form = s1002_ListQuestionForm.builder()
                .nameTest("Test 1.")
                .user(new Human("ducla", 28, "0999999", 29d))
                .beginTime(new Date(System.currentTimeMillis()))
                .endTime(new Date(System.currentTimeMillis() + 60 * 60 * 1000))
                .questions(questions)
                .build();

        return form;
    }
}

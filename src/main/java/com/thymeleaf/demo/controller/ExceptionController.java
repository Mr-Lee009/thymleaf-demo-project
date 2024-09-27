package com.thymeleaf.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

    final Logger LOGGER = LoggerFactory.getLogger(ExceptionController.class);

    @ExceptionHandler(NullPointerException.class)
    public String handNullPointerException(NullPointerException exception) {
        LOGGER.error("[NullPointerException] => " + exception.getMessage());
        return "null-pointer-exception";
    }


    @ExceptionHandler({IllegalArgumentException.class,IllegalStateException.class})
    public String handIllegalAccessException(Exception exception) {
        LOGGER.error("[IllegalArgumentException] => " + exception.getMessage());
        return "illegal-argument-exception";
    }
}

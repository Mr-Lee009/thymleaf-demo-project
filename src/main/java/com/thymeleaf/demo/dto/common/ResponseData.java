package com.thymeleaf.demo.dto.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class ResponseData<T> {
    private int status;
    private String message;
    private T data;

    // Error response
    public static <T> ResponseData<T> error(int status, String message) {
        return ResponseData.<T>builder()
                .status(status)
                .message(message)
                .data(null)
                .build();
    }

    // Success response
    public static <T> ResponseData<T> success(int status, String message, T data) {
        return ResponseData.<T>builder()
                .status(status)
                .message(message)
                .data(data)
                .build();
    }
}

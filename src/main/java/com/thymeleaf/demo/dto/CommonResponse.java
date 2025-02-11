package com.thymeleaf.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CommonResponse<T> {
  private String responseCode;
  private String message;
  private T data;

  public static <T> CommonResponse<T> successResponse(T data) {
    return new CommonResponse<T>(Etype.SUCCESS.message, null, data);
  }

  public static <T> CommonResponse<T> failResponse(String message) {
    return new CommonResponse<T>(Etype.FALSE.message, message, null);
  }

  public static <T> CommonResponse<T> exceptionResponse(String message) {
    return new CommonResponse<T>(Etype.EXCEPTION.message, message, null);
  }

}

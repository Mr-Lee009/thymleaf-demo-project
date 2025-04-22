package com.thymeleaf.demo.config.datasource;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DataSourceAspect {
  @Before("@annotation(com.thymeleaf.demo.config.datasource.annotation.ReadOnly)")
  public void setReadDataSource() {
    System.out.printf("setReadDataSource");
    DataSourceContextHolder.setSlave();
  }

  @After("@annotation(com.thymeleaf.demo.config.datasource.annotation.ReadOnly)")
  public void clearDataSource() {
    DataSourceContextHolder.clear();
  }

//  @Before("execution(* com.example..*Service.*(..)) && !@annotation(com.thymeleaf.demo.config.datasource.annotation.ReadOnly)")
  @Before("@annotation(com.thymeleaf.demo.config.datasource.annotation.WriteOnly)")
  public void setWriteDataSource() {
    System.out.printf("setWriteDataSource");
    DataSourceContextHolder.set(DataSourceType.MASTER);
  }

  @After("execution(* com.thymeleaf.demo.service.*(..))")
  public void clearAfterService() {
    DataSourceContextHolder.clear();
  }
}

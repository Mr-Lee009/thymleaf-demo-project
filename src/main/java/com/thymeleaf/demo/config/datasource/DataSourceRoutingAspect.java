package com.thymeleaf.demo.config.datasource;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DataSourceRoutingAspect {
  @Before("@annotation(ReadOnly)")
  public void setReadOnlyDataSource(){
    ReplicationRoutingDataSource.setRead();
  }

  @Before("@annotation(Write)")
  public void setWriteOnlyDataSource(){
    ReplicationRoutingDataSource.setWrite();
  }

  @After("@annotation(ReadOnly) || @annotation(Write)")
  public void clearDataSourceContext() {
    ReplicationRoutingDataSource.clear();
  }
}

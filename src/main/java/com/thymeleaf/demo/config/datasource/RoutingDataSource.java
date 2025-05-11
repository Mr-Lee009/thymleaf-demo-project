package com.thymeleaf.demo.config.datasource;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class RoutingDataSource extends AbstractRoutingDataSource {
  @Override
  protected Object determineCurrentLookupKey() {
    return DataSourceContextHolder.get();
  }
}

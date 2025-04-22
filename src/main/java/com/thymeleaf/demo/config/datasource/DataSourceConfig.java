package com.thymeleaf.demo.config.datasource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class DataSourceConfig {

  @Bean
  @ConfigurationProperties("spring.datasource.write")
  public DataSource writeDataSource() {
    return DataSourceBuilder.create().build();
  }

  @Bean
  @ConfigurationProperties("spring.datasource.read1")
  public DataSource readDataSource1() {
    return DataSourceBuilder.create().build();
  }

  @Bean
  @ConfigurationProperties("spring.datasource.read2")
  public DataSource readDataSource2() {
    return DataSourceBuilder.create().build();
  }

  @Bean
  public DataSource routingDataSource() {
    RoutingDataSource routingDataSource = new RoutingDataSource();

    Map<Object, Object> dataSourceMap = new HashMap<>();
    dataSourceMap.put(DataSourceType.MASTER, writeDataSource());
    dataSourceMap.put(DataSourceType.SLAVE1, readDataSource1());
    dataSourceMap.put(DataSourceType.SLAVE2, readDataSource1());

    routingDataSource.setTargetDataSources(dataSourceMap);
    routingDataSource.setDefaultTargetDataSource(writeDataSource());

    return routingDataSource;
  }

  @Bean
  public PlatformTransactionManager transactionManager() {
    return new DataSourceTransactionManager(routingDataSource());
  }
}

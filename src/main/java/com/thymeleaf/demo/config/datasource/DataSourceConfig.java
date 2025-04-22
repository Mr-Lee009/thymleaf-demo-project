package com.thymeleaf.demo.config.datasource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableJpaRepositories(
    basePackages = "com.thymeleaf.demo.repo", // <-- repo package của bạn
    entityManagerFactoryRef = "entityManagerFactory",
    transactionManagerRef = "transactionManager"
)
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
    dataSourceMap.put(DataSourceType.SLAVE2, readDataSource2());

    routingDataSource.setTargetDataSources(dataSourceMap);
    routingDataSource.setDefaultTargetDataSource(writeDataSource());

    return routingDataSource;
  }

  @Bean
  @Primary
  public PlatformTransactionManager transactionManager(EntityManagerFactoryBuilder builder) {
    return new JpaTransactionManager(entityManagerFactory(builder).getObject());
  }

  @Bean
  @Primary
  public LocalContainerEntityManagerFactoryBean entityManagerFactory(
      EntityManagerFactoryBuilder builder) {
    return builder
        .dataSource(routingDataSource())
        .packages("com.thymeleaf.demo.entities") // <--- thay thế bằng package chứa entity
        .persistenceUnit("default")
        .build();
  }

  @Bean
  public EntityManagerFactoryBuilder entityManagerFactoryBuilder() {

    Map<String, Object> jpaProperties = new HashMap<>();
    jpaProperties.put("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");

    return new EntityManagerFactoryBuilder(
        new HibernateJpaVendorAdapter(),
        jpaProperties,
        null
    );
  }

}

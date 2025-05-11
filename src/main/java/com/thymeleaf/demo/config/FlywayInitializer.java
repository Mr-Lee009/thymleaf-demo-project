package com.thymeleaf.demo.config;

import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class FlywayInitializer {

    @Value("${spring.flyway.locations}")
    private String[] flywaylocations;

    @Value("${spring.datasource.write.jdbc-url}")
    private String datasourceUrl;

    @Value("${spring.datasource.write.username}")
    private String username;

    @Value("${spring.datasource.write.password}")
    private String password;

    @Bean
    public Flyway flywayConfig(){
        Flyway flyway = Flyway.configure()
                .dataSource(dataSource())
                .locations(flywaylocations)
                .baselineOnMigrate(true)
                .baselineVersion("0")
                .load();
        flyway.migrate();
        System.out.println("migrating.......");
        return flyway;
    }

    @Bean
    public DataSource dataSource(){
        System.out.println("set up flyway .......");
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl(datasourceUrl);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        System.out.println("setup done.......");

        return dataSource;
    }
}

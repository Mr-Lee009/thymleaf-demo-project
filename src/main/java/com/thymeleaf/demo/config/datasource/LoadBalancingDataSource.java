package com.thymeleaf.demo.config.datasource;

import org.springframework.jdbc.datasource.AbstractDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class LoadBalancingDataSource extends AbstractDataSource {

  private final List<DataSource> readDataSources;
  private final AtomicInteger index = new AtomicInteger(0);

  public LoadBalancingDataSource(List<DataSource> readDataSources) {
    this.readDataSources = readDataSources;
  }

  @Override
  public Connection getConnection() throws SQLException {
    return determineReadDataSource().getConnection();
  }

  @Override
  public Connection getConnection(String username, String password) throws SQLException {
    return determineReadDataSource().getConnection(username, password);
  }

  private DataSource determineReadDataSource() {
    int currentIndex = Math.abs(index.getAndIncrement() % readDataSources.size());
    return readDataSources.get(currentIndex);
  }

}

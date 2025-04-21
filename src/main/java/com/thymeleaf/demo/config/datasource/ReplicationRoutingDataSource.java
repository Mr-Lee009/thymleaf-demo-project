package com.thymeleaf.demo.config.datasource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class ReplicationRoutingDataSource extends AbstractRoutingDataSource {
  /**
   * Use ThreadLocal to make sure every thread has its own data source context
   * which won't be changed by other threads
   */
  private static final ThreadLocal<String> CONTEXT = new ThreadLocal<>();
  public static void setRead() {
    CONTEXT.set("READ");
  }

  public static void setWrite() {
    CONTEXT.set("WRITE");
  }

  public static void clear() {
    CONTEXT.remove();
  }
  @Override
  protected Object determineCurrentLookupKey() {
    return CONTEXT.get();
  }
}

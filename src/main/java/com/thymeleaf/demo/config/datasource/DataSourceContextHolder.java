package com.thymeleaf.demo.config.datasource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class DataSourceContextHolder {
  /**
   * Use ThreadLocal to make sure every thread has its own data source context
   * which won't be changed by other threads
   */
  private static final ThreadLocal<DataSourceType> CONTEXT_HOLDER = new ThreadLocal<>();
  private static final List<DataSourceType>
      SLAVES = Arrays.asList(DataSourceType.SLAVE1, DataSourceType.SLAVE2);
  private static final Random RANDOM = new Random();

  public static void set(DataSourceType type) {
    CONTEXT_HOLDER.set(type);
  }

  public static DataSourceType get() {
    return CONTEXT_HOLDER.get();
  }

  public static void clear() {
    CONTEXT_HOLDER.remove();
  }

  public static void setSlave() {
    int index = RANDOM.nextInt(SLAVES.size());
    set(SLAVES.get(index));
  }

}

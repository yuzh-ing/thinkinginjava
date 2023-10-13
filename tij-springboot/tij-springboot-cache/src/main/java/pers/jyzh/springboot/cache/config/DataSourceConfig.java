package pers.jyzh.springboot.cache.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import com.zaxxer.hikari.HikariDataSource;

/**
 * @author ZhengYu
 * @version 1.0 2023/10/13 14:17
 **/
@Configuration
public class DataSourceConfig {
  public static final String BEAN_VM_DATASOURCE_PROPERTIES = "vmDataSourceProperties";
  public static final String BEAN_VM_DATASOURCE = "vmDataSource";
  public static final String BEAN_VM_JDBC_TEMPLATE = "vmJdbcTemplate";
  public static final String BEAN_VM_TRANSACTION_MANAGER = "vmTxManager";

  @Primary
  @Bean(BEAN_VM_DATASOURCE)
  @ConditionalOnBean(VmDataSourceProperties.class)
  public DataSource vmDataSource(
      @Autowired @Qualifier(BEAN_VM_DATASOURCE_PROPERTIES) VmDataSourceProperties properties) {
    return properties.initializeDataSourceBuilder().type(HikariDataSource.class).build();
  }

  @Primary
  @Bean(BEAN_VM_JDBC_TEMPLATE)
  @ConditionalOnBean(value = DataSource.class, name = BEAN_VM_DATASOURCE)
  public JdbcTemplate vmJdbcTemplate(
      @Autowired @Qualifier(BEAN_VM_DATASOURCE) DataSource dataSource) {
    JdbcTemplate jdbcTemplate = new JdbcTemplate();
    jdbcTemplate.setDataSource(dataSource);
    return jdbcTemplate;
  }

  @Primary
  @Bean(BEAN_VM_TRANSACTION_MANAGER)
  @ConditionalOnBean(value = DataSource.class, name = BEAN_VM_DATASOURCE)
  public DataSourceTransactionManager vmTxManager(
      @Autowired @Qualifier(BEAN_VM_DATASOURCE) DataSource dataSource) {
    DataSourceTransactionManager txManager = new DataSourceTransactionManager();
    txManager.setDataSource(dataSource);
    return txManager;
  }
}

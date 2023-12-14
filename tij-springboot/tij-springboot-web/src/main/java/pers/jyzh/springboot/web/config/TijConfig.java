package pers.jyzh.springboot.web.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pers.jyzh.springboot.web.entity.order.Order;

/**
 * @author ZhengYu
 * @version 1.0 2023/12/14 15:19
 **/
@EnableConfigurationProperties(TijConfigProperties.class)
@Configuration(proxyBeanMethods = false)
public class TijConfig {

  @Bean
  public Order order(TijConfigProperties properties) {
    Order order = new Order();
    order.setFlowNo(properties.getK1());
    return order;
  }
}

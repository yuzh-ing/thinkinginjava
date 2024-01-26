package pers.jyzh.springcloud.openfeign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignContext;

import javax.annotation.PostConstruct;

/**
 * @author ZhengYu
 * @version 1.0 2023/11/16 20:56
 **/
@EnableFeignClients(basePackages = "pers.jyzh.springcloud.openfeign.remote")
@EnableEurekaClient
@SpringBootApplication
public class TijSpringCloudOpenFeignApplication {
  @Autowired
  private FeignContext feignContext;

  public static void main(String[] args) {
    SpringApplication.run(TijSpringCloudOpenFeignApplication.class, args);
  }

  @PostConstruct
  public void test() {
      System.out.println(feignContext);
  }
}

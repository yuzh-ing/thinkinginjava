package pers.jyzh.springcloud.openfeign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author ZhengYu
 * @version 1.0 2023/11/16 20:56
 **/
@EnableFeignClients(basePackages = "pers.jyzh.springcloud.openfeign.remote")
@EnableEurekaClient
@SpringBootApplication
public class TijSpringCloudOpenFeignApplication {
    public static void main(String[] args) {
        SpringApplication.run(TijSpringCloudOpenFeignApplication.class, args);
    }
}

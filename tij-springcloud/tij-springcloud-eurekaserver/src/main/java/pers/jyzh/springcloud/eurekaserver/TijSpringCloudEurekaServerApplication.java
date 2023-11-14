package pers.jyzh.springcloud.eurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author ZhengYu
 * @version 1.0 2023/11/14 20:04
 **/
@EnableEurekaServer
@SpringBootApplication
public class TijSpringCloudEurekaServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(TijSpringCloudEurekaServerApplication.class, args);
    }
}

package pers.jyzh.springboot.cache;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * @author ZhengYu
 * @version 1.0 2023/10/11 14:27
 **/
@EnableCaching
@SpringBootApplication
public class TijSpringBootCacheApplication {
  public static void main(String[] args) {
    SpringApplication.run(TijSpringBootCacheApplication.class, args);
  }
}
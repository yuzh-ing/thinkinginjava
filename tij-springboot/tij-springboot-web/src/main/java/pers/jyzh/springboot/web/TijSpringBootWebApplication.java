package pers.jyzh.springboot.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

/**
 * @author ZhengYu
 * @version 1.0 2023/10/11 14:27
 **/
@SpringBootApplication
public class TijSpringBootWebApplication {
  public static void main(String[] args) {
    System.out.println("args: " + Arrays.toString(args));
    SpringApplication.run(TijSpringBootWebApplication.class, args);
  }
}
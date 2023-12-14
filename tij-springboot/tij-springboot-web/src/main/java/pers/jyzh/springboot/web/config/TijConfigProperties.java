package pers.jyzh.springboot.web.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

/**
 * @author ZhengYu
 * @version 1.0 2023/12/14 15:18
 **/
@Getter
@Setter
@ConfigurationProperties(prefix = "tij.config")
public class TijConfigProperties {
  private String k1;
  private List<String> k2;
}

package pers.jyzh.springcloud.openfeign.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author ZhengYu
 * @version 1.0 2023/11/16 21:35
 **/
@Getter
@Setter
@Configuration(proxyBeanMethods = false)
@ConfigurationProperties(prefix = "remote.order")
public class OrderConfig {
    private String serverUrl;
    private String appKey;
    private String appSecret;
}
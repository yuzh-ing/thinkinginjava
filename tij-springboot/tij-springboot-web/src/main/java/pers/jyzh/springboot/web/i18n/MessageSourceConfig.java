package pers.jyzh.springboot.web.i18n;

import org.springframework.boot.autoconfigure.context.MessageSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;

import java.time.Duration;

/**
 * @author ZhengYu
 * @version 1.0 2023/12/5 14:15
 **/
@Configuration(proxyBeanMethods = false)
public class MessageSourceConfig {

  @Bean
  @ConfigurationProperties(prefix = "spring.messages")
  public MessageSourceProperties messageSourceProperties() {
    return new MessageSourceProperties();
  }

  @Bean
  public MessageSource messageSource(MessageSourceProperties properties) {
    SupportNoCacheMessageSource messageSource = new SupportNoCacheMessageSource();
    if (StringUtils.hasText(properties.getBasename())) {
      messageSource.setBasenames(StringUtils
        .commaDelimitedListToStringArray(StringUtils.trimAllWhitespace(properties.getBasename())));
    }
    if (properties.getEncoding() != null) {
      messageSource.setDefaultEncoding(properties.getEncoding().name());
    }
    messageSource.setFallbackToSystemLocale(properties.isFallbackToSystemLocale());
    Duration cacheDuration = properties.getCacheDuration();
    if (cacheDuration != null) {
      messageSource.setCacheMillis(cacheDuration.toMillis());
    }
    messageSource.setAlwaysUseMessageFormat(properties.isAlwaysUseMessageFormat());
    messageSource.setUseCodeAsDefaultMessage(properties.isUseCodeAsDefaultMessage());
    return messageSource;
  }
}

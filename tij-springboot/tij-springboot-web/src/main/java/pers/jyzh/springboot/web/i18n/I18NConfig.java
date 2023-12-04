package pers.jyzh.springboot.web.i18n;

import org.springframework.boot.autoconfigure.context.MessageSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.util.StringUtils;

import java.time.Duration;

/**
 * @author ZhengYu
 * @version 1.0 2023/12/4 16:05
 **/
@Configuration(proxyBeanMethods = false)
public class I18NConfig {

  @Bean
  @ConfigurationProperties(prefix = "spring.messages")
  public MessageSourceProperties messageSourceProperties() {
    return new MessageSourceProperties();
  }

  @Bean(AbstractApplicationContext.MESSAGE_SOURCE_BEAN_NAME)
  public DbMessageSource messageSource(MessageSourceProperties properties, I18NService i18NService) {
    DbMessageSource messageSource = new DbMessageSource(i18NService);
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

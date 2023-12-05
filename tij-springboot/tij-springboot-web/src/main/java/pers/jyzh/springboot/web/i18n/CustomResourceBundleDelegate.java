package pers.jyzh.springboot.web.i18n;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import pers.jyzh.springboot.web.service.I18NService;

import java.util.Locale;
import java.util.Set;

/**
 * 静态注入，再读取国际化配置，比如从数据库中/缓存中
 *
 * @author ZhengYu
 * @version 1.0 2023/12/5 13:52
 **/
@Component
public class CustomResourceBundleDelegate {

  private static I18NService i18NService;

  public static Set<String> getKeys(Locale locale) {
    return i18NService.getKeys(locale);
  }

  public static Object handleGetObject(Locale locale, @NonNull String key) {
    return i18NService.handleGetObject(locale, key);
  }

  @Autowired
  public void setI18NService(I18NService i18NService) {
    CustomResourceBundleDelegate.i18NService = i18NService;
  }
}

package pers.jyzh.springboot.web.service;

import org.springframework.lang.NonNull;

import java.util.Locale;
import java.util.Set;

/**
 * @author ZhengYu
 * @version 1.0 2023/12/4 15:48
 **/
public interface I18NService {

  Set<String> getKeys(Locale locale);

  Object handleGetObject(Locale locale, @NonNull String key);
}

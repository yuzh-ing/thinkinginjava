package pers.jyzh.springboot.web.i18n;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;

/**
 * @author ZhengYu
 * @version 1.0 2023/12/4 15:48
 **/
@Slf4j
@Service
public class I18NService {
  public static final Map<String, Map<Locale, String>> DB = new HashMap<>();

  static {
    Map<Locale, String> greetMap = new HashMap<>();
    greetMap.put(Locale.SIMPLIFIED_CHINESE, "你好，coder");
    greetMap.put(Locale.TRADITIONAL_CHINESE, "妳好，coder");

    DB.put("i18n.db.homepage.title", greetMap);
  }

  public String resolveCode(String code, Locale locale) {
    log.info("从数据库读取配置");
    // 从数据库读取配置
    return Optional.ofNullable(DB.get(code)) //
      .map(x -> x.get(locale)) //
      .orElse(null);
  }
}

package pers.jyzh.springboot.web.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pers.jyzh.springboot.web.service.I18NService;

import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

/**
 * @author ZhengYu
 * @version 1.0 2023/12/5 13:47
 **/
@Slf4j
@Service
public class I18NServiceImpl implements I18NService {

  public static final Map<Locale, Map<String, String>> DB = new HashMap<>();

  static {
    Map<String, String> simplifiedChinese = DB.computeIfAbsent(Locale.SIMPLIFIED_CHINESE, x -> new HashMap<>());
    Map<String, String> traditionalChinese = DB.computeIfAbsent(Locale.TRADITIONAL_CHINESE, x -> new HashMap<>());
    simplifiedChinese.put("i18n.db.homepage.title", "你好，码农");
    traditionalChinese.put("i18n.db.homepage.title", "你好，碼農");
  }

  @Override
  public Set<String> getKeys(Locale locale) {
    return DB.get(locale).keySet();
  }

  @Override
  public Object handleGetObject(Locale locale, String key) {
    String result = DB.get(locale).get(key);
    int idx = result.indexOf("$$");
    String newRes;
    if (idx >= 0) {
      newRes = result.substring(0, idx) + "$$_" + new Date();
    } else {
      newRes = result + "$$_" + new Date();
    }
    DB.get(locale).put(key, newRes);
    log.info("彼时彼刻，恰如此时此刻，key=<{}>的值从<{}>变为<{}>", key, result, newRes);
    return result;
  }
}

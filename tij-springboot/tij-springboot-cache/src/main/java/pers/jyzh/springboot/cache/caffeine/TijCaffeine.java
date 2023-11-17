package pers.jyzh.springboot.cache.caffeine;

import java.util.concurrent.TimeUnit;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;

import lombok.extern.slf4j.Slf4j;

/**
 * @author ZhengYu
 * @version 1.0 2023/11/17 15:19
 **/
@Slf4j
public class TijCaffeine {
  public static void main(String[] args) throws Exception {
    Cache<String, String> cache = Caffeine.newBuilder() //
        .maximumSize(2) //
        .expireAfterWrite(5, TimeUnit.SECONDS) //
        .build();
    String key1 = "k1";
    String key2 = "k2";
    String key3 = "k3";
    cache.get(key1, TijCaffeine::buildValue);
    new Thread(() -> {
      while (true) {
        log.info("读取{}结果: {}", key1, cache.getIfPresent(key1));
        log.info("读取{}结果: {}", key2, cache.getIfPresent(key2));
        log.info("读取{}结果: {}", key3, cache.getIfPresent(key3));
        log.info("==============================================");
        try {
          Thread.sleep(100);
        } catch (Exception e) {

        }
      }
    }).start();
    Thread.sleep(TimeUnit.SECONDS.toMillis(2));
    cache.get("k2", TijCaffeine::buildValue);
    Thread.sleep(TimeUnit.SECONDS.toMillis(2));
    cache.get("k3", TijCaffeine::buildValue);

    Thread.sleep(TimeUnit.MINUTES.toMillis(5));
  }

  private static final String buildValue(String key) {
    String value = "echo" + key;
    log.info("写入: {}", value);
    return value;
  }
}

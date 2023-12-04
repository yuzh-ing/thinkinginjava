package pers.jyzh.springboot.web;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import java.util.Locale;

/**
 * @author ZhengYu
 * @version 1.0 2023/12/4 16:08
 **/
@SpringBootTest
public class TestTijSpringBootWebApplication {
  @Autowired
  private ApplicationContext appCtx;

  @Test
  public void testMessageSource() {
    String msg1 = appCtx.getMessage("i18n.db.homepage.title", null, Locale.SIMPLIFIED_CHINESE);
    System.out.println(msg1);
    String msg2 = appCtx.getMessage("i18n.db.homepage.title", null, Locale.TRADITIONAL_CHINESE);
    System.out.println(msg2);
    String msg3 = appCtx.getMessage("i18n.db.homepage.title", null, Locale.SIMPLIFIED_CHINESE);
    System.out.println(msg3);
    String msg4 = appCtx.getMessage("i18n.db.homepage.title", null, Locale.TRADITIONAL_CHINESE);
    System.out.println(msg4);

    String msg5 = appCtx.getMessage("i18n.prop.homepage.title", null, Locale.SIMPLIFIED_CHINESE);
    System.out.println(msg5);
  }
}

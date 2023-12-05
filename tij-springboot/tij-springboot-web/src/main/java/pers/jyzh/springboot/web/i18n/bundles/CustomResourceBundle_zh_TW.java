package pers.jyzh.springboot.web.i18n.bundles;

import java.util.Locale;

/**
 * @author ZhengYu
 * @version 1.0 2023/12/5 11:42
 **/
public class CustomResourceBundle_zh_TW extends AbstractCustomResourceBundle {
  @Override
  protected Locale locale() {
    return Locale.TRADITIONAL_CHINESE;
  }
}

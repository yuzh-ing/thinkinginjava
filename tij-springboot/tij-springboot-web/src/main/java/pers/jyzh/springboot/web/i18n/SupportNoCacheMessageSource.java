package pers.jyzh.springboot.web.i18n;

import org.springframework.context.support.ResourceBundleMessageSource;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

/**
 * @author ZhengYu
 * @version 1.0 2023/12/5 14:04
 **/
public class SupportNoCacheMessageSource extends ResourceBundleMessageSource {

  @Override
  protected MessageFormat getMessageFormat(ResourceBundle bundle, String code, Locale locale) throws MissingResourceException {
    if (bundle instanceof Marker) {
      String msg = getStringOrNull(bundle, code);
      if (msg == null) {
        return null;
      }
      return createMessageFormat(msg, locale);
    }
    return super.getMessageFormat(bundle, code, locale);
  }

  /**
   * 支持不缓存ResourceBundle#getObject结果的ResourceBundle标记
   */
  public interface Marker {

  }
}

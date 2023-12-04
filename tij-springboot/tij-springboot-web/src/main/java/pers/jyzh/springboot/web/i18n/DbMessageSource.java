package pers.jyzh.springboot.web.i18n;

import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.util.ObjectUtils;

import java.util.Locale;

/**
 * @author ZhengYu
 * @version 1.0 2023/12/4 15:39
 **/
public class DbMessageSource extends ResourceBundleMessageSource {
  private final I18NService i18NService;

  public DbMessageSource(I18NService i18NService) {
    this.i18NService = i18NService;
  }

  @Override
  protected String getMessageInternal(String code, Object[] args, Locale locale) {
    if (code == null) {
      return null;
    }
    if (locale == null) {
      locale = Locale.getDefault();
    }
    if (!isAlwaysUseMessageFormat() && ObjectUtils.isEmpty(args)) {
      String message = i18NService.resolveCode(code, locale);
      if (message != null) {
        return message;
      }
    } else {
      Object[] argsToUse = resolveArguments(args, locale);
      String message = i18NService.resolveCode(code, locale);
      if (message != null) {
        return createMessageFormat(message, locale).format(argsToUse);
      }
    }
    return super.getMessageInternal(code, args, locale);
  }
}

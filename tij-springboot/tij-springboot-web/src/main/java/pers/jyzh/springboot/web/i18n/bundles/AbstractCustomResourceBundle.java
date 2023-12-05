package pers.jyzh.springboot.web.i18n.bundles;

import org.springframework.lang.NonNull;
import org.springframework.util.CollectionUtils;
import pers.jyzh.springboot.web.i18n.CustomResourceBundleDelegate;
import pers.jyzh.springboot.web.i18n.SupportNoCacheMessageSource;

import java.util.Enumeration;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.Vector;

/**
 * @author ZhengYu
 * @version 1.0 2023/12/5 14:59
 **/
public abstract class AbstractCustomResourceBundle extends ResourceBundle implements SupportNoCacheMessageSource.Marker {

  @Override
  protected Object handleGetObject(@NonNull String key) {
    return CustomResourceBundleDelegate.handleGetObject(locale(), key);
  }

  @Override
  public Enumeration<String> getKeys() {
    Vector<String> result = new Vector<>();
    Set<String> keys = CustomResourceBundleDelegate.getKeys(locale());
    if (!CollectionUtils.isEmpty(keys)) {
      result.addAll(keys);
    }
    return result.elements();
  }

  @Override
  protected Set<String> handleKeySet() {
    // 不使用ResourceBundle缓存
    return CustomResourceBundleDelegate.getKeys(locale());
  }

  protected abstract Locale locale();
}

package pers.jyzh.common.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * @author ZhengYu
 * @version 1.0 2023/11/29 23:32
 **/
@Getter
@Setter
public class ExtraItem {
  private String key;
  private String value;

  public ExtraItem(String key, String value) {
    this.key = key;
    this.value = value;
  }
}

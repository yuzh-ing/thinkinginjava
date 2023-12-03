package pers.jyzh.springboot.web.entity;

import lombok.Getter;
import lombok.Setter;
import pers.jyzh.common.entity.ExtraItem;

/**
 * @author ZhengYu
 * @version 1.0 2023/11/30 22:04
 **/
@Getter
@Setter
public class OwnerExtraItem extends ExtraItem {
  private String owner;

  public OwnerExtraItem(String key, String value) {
    super(key, value);
  }

  public OwnerExtraItem(String key, String value, String owner) {
    super(key, value);
    this.owner = owner;
  }
}

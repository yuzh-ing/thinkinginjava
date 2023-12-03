package pers.jyzh.common.entity.query;

import lombok.Getter;
import lombok.Setter;

/**
 * @author ZhengYu
 * @version 1.0 2023/11/29 22:22
 **/
@Getter
@Setter
public class FilterParam {
  private String property;
  private Object value;
}

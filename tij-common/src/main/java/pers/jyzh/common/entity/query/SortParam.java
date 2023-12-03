package pers.jyzh.common.entity.query;

import lombok.Getter;
import lombok.Setter;

/**
 * @author ZhengYu
 * @version 1.0 2023/11/29 22:23
 **/
@Getter
@Setter
public class SortParam {
  private String field;
  private boolean asc;
}

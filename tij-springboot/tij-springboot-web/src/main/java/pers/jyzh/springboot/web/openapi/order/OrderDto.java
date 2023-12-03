package pers.jyzh.springboot.web.openapi.order;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import pers.jyzh.common.entity.ExtraItem;

/**
 * @author ZhengYu
 * @version 1.0 2023/11/29 21:58
 **/
@Getter
@Setter
public class OrderDto {
  private Long id;
  private String flowNo;
  private List<ExtraItem> extraItems;
}

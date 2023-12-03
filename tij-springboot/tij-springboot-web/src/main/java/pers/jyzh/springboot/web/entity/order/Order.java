package pers.jyzh.springboot.web.entity.order;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import pers.jyzh.springboot.web.entity.OwnerExtraItem;

/**
 * @author ZhengYu
 * @version 1.0 2023/11/29 23:00
 **/
@Getter
@Setter
public class Order {
  public static final String PART_EXTRA_ITEMS = "extraItems";

  private Long id;
  private String flowNo;

  private List<OwnerExtraItem> extraItems;
}

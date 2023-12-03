package pers.jyzh.springboot.web.openapi.impl.converter;

import pers.jyzh.common.util.ReversibleConverter;
import pers.jyzh.springboot.web.entity.order.Order;
import pers.jyzh.springboot.web.openapi.order.OrderDto;

/**
 * @author ZhengYu
 * @version 1.0 2023/11/29 23:28
 **/
public class OrderDtoConverter implements ReversibleConverter<Order, OrderDto> {
  public static final OrderDtoConverter INSTANCE = new OrderDtoConverter();

  private OrderDtoConverter() {
  }

  @Override
  public OrderDto convert(Order source) {
    if (source == null) {
      return null;
    }
    OrderDto target = new OrderDto();
    target.setId(source.getId());
    target.setFlowNo(source.getFlowNo());
    return target;
  }

  @Override
  public Order reverse(OrderDto source) {
    if (source == null) {
      return null;
    }
    Order target = new Order();
    target.setId(source.getId());
    target.setFlowNo(source.getFlowNo());
    return target;
  }
}

package pers.jyzh.springboot.web.openapi.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import pers.jyzh.common.entity.query.QueryRequest;
import pers.jyzh.common.entity.query.QueryResult;
import pers.jyzh.common.http.TijResponse;
import pers.jyzh.springboot.web.entity.order.Order;
import pers.jyzh.springboot.web.openapi.impl.converter.OrderDtoConverter;
import pers.jyzh.springboot.web.openapi.order.OrderApi;
import pers.jyzh.springboot.web.openapi.order.OrderDto;
import pers.jyzh.springboot.web.service.OrderService;

/**
 * @author ZhengYu
 * @version 1.0 2023/11/29 22:06
 **/
@RestController
public class OrderApiController implements OrderApi {
  @Autowired
  private OrderService orderService;

  @Override
  public TijResponse<QueryResult<OrderDto>> query(QueryRequest request) {
    QueryResult<OrderDto> qr = QueryResult.of( //
        orderService.query(request), OrderDtoConverter.INSTANCE);
    return TijResponse.success(qr);
  }

  @Override
  public TijResponse<OrderDto> get(Long id) {
    Order order = orderService.get(id);
    return TijResponse.success(OrderDtoConverter.INSTANCE.convert(order));
  }

  @Override
  public TijResponse<Long> delete(Long id) {
    orderService.delete(id);
    return TijResponse.success(id);
  }
}

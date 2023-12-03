package pers.jyzh.springboot.web.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import pers.jyzh.common.entity.query.QueryRequest;
import pers.jyzh.common.entity.query.QueryResult;
import pers.jyzh.springboot.web.entity.order.Order;
import pers.jyzh.springboot.web.service.OrderService;

/**
 * @author ZhengYu
 * @version 1.0 2023/11/29 23:01
 **/
@Service
public class OrderServiceImpl implements OrderService {
  private final int size = 100;
  private List<Order> cacheOrders;

  @PostConstruct
  public void init() {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
    cacheOrders = new ArrayList<>(size);
    for (long i = 0; i < size; i++) {
      Order order = new Order();
      order.setId(i);
      order.setFlowNo(sdf.format(new Date()) + String.format("%05d", i));
      cacheOrders.add(order);
    }
  }

  @Override
  public QueryResult<Order> query(QueryRequest request) {
    QueryResult<Order> qr = new QueryResult<>();
    qr.setRecords(cacheOrders);
    qr.setTotal(cacheOrders.size());
    return qr;
  }

  @Override
  public Order get(Long id) {
    return cacheOrders.stream().filter(x -> Objects.equals(x.getId(), id)).findFirst().orElse(null);
  }

  @Override
  public void delete(Long id) {
    cacheOrders.removeIf(x -> Objects.equals(x.getId(), id));
  }
}

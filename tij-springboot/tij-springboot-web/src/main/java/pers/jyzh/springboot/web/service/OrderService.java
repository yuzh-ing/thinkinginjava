package pers.jyzh.springboot.web.service;

import pers.jyzh.common.entity.query.QueryRequest;
import pers.jyzh.common.entity.query.QueryResult;
import pers.jyzh.springboot.web.entity.order.Order;

/**
 * @author ZhengYu
 * @version 1.0 2023/11/29 22:05
 **/
public interface OrderService {

  /**
   * 查询订单
   *
   * @param request
   *          查询请求
   * @return 订单
   */
  QueryResult<Order> query(QueryRequest request);

  /**
   * 根据id查询订单
   *
   * @param id
   *          订单id
   * @return 订单
   */
  Order get(Long id);

  /**
   * 根据id删除订单
   *
   * @param id
   *          订单id
   */
  void delete(Long id);
}

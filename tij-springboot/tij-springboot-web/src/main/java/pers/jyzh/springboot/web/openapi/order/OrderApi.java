package pers.jyzh.springboot.web.openapi.order;

import org.springframework.web.bind.annotation.*;

import pers.jyzh.common.entity.query.QueryRequest;
import pers.jyzh.common.entity.query.QueryResult;
import pers.jyzh.common.http.TijResponse;

/**
 * @author ZhengYu
 * @version 1.0 2023/11/29 21:10
 **/
@RequestMapping("v1/order")
public interface OrderApi {

  @PostMapping("query")
  TijResponse<QueryResult<OrderDto>> query(@RequestBody QueryRequest request);

  @GetMapping("{id}")
  TijResponse<OrderDto> get(@PathVariable("id") Long id);

  @DeleteMapping("{id}")
  TijResponse<Long> delete(@PathVariable("id") Long id);
}

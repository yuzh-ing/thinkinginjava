package pers.jyzh.springcloud.openfeign.remote.order;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import pers.jyzh.springcloud.openfeign.remote.order.request.OrderQueryRequest;
import pers.jyzh.springcloud.openfeign.remote.order.response.OrderBaseResp;
import pers.jyzh.springcloud.openfeign.remote.order.response.OrderDto;

import java.util.List;

/**
 * @author ZhengYu
 * @version 1.0 2023/11/16 21:22
 **/
@FeignClient(name = "order", configuration = OrderFeignClientConfiguration.class)
public interface OrderClient {

    /**
     * 获取订单
     *
     * @param request 查询条件
     * @return 订单
     */
    @PostMapping(value = "/order/query", produces = MediaType.APPLICATION_FORM_URLENCODED_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    OrderBaseResp<List<OrderDto>> query(
            @RequestParam("access_token") String accessToken,
            @RequestBody OrderQueryRequest request);
}

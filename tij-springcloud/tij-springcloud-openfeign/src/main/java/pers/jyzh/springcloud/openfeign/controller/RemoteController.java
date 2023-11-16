package pers.jyzh.springcloud.openfeign.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pers.jyzh.springcloud.openfeign.remote.order.OrderClient;
import pers.jyzh.springcloud.openfeign.remote.order.request.OrderQueryRequest;
import pers.jyzh.springcloud.openfeign.remote.order.response.OrderBaseResp;
import pers.jyzh.springcloud.openfeign.remote.order.response.OrderDto;

import java.util.List;

/**
 * @author ZhengYu
 * @version 1.0 2023/11/16 21:41
 **/
@Slf4j
@RestController
public class RemoteController {
    @Autowired
    private OrderClient client;

    @GetMapping("/order/query")
    public void orderQuery() {
        OrderQueryRequest request = new OrderQueryRequest();
        OrderBaseResp<List<OrderDto>> rsp = client.query("", request);
        log.info("{}", rsp.getCode());
    }
}

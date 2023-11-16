package pers.jyzh.springcloud.openfeign.remote.order;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import pers.jyzh.springcloud.openfeign.config.OrderConfig;

import java.util.UUID;

/**
 * 1. Ordered/@Order 可指定RequestInterceptor顺序
 *
 * @author ZhengYu
 * @version 1.0 2023/11/16 21:24
 **/
@Slf4j
public class OrderFeignClientConfiguration {

    @Bean
    public RequestInterceptor traceIdInterceptor() {
        return new TraceIdInterceptor();
    }

    @Bean
    public RequestInterceptor signInterceptor(OrderConfig config) {
        return new OrderSignInterceptor(config);
    }

    @Order(0)
    static class TraceIdInterceptor implements RequestInterceptor {
        @Override
        public void apply(RequestTemplate requestTemplate) {
            MDC.put("trace_id", UUID.randomUUID().toString());
        }
    }

    @Order(1)
    static class OrderSignInterceptor implements RequestInterceptor {
        @Autowired
        private OrderConfig config;

        public OrderSignInterceptor(OrderConfig config) {
            this.config = config;
        }

        @Override
        public void apply(RequestTemplate template) {
            System.out.println(config.getServerUrl());
        }
    }
}

package pers.jyzh.springcloud.openfeign.remote.order;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import pers.jyzh.springcloud.openfeign.config.OrderConfig;

/**
 * @author ZhengYu
 * @version 1.0 2023/11/16 21:24
 **/
@Slf4j
public class OrderFeignClientConfiguration {

    @Bean
    public RequestInterceptor signInterceptor(OrderConfig config) {
        log.info("{}", config.getServerUrl());
        return new RequestInterceptor() {
            @Override
            public void apply(RequestTemplate template) {
                log.info("apply");
            }
        };
    }

    static class OrderSignInterceptor implements RequestInterceptor {
        @Autowired
        private OrderConfig config;

        public OrderSignInterceptor(OrderConfig config) {
            this.config = config;
        }

        @Override
        public void apply(RequestTemplate requestTemplate) {

        }
    }
}

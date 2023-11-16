package pers.jyzh.springcloud.openfeign.remote.order.response;

import lombok.Getter;
import lombok.Setter;

/**
 * @author ZhengYu
 * @version 1.0 2023/11/16 21:28
 **/
@Getter
@Setter
public class OrderDto {
    private String id;
    private String flowNo;
}

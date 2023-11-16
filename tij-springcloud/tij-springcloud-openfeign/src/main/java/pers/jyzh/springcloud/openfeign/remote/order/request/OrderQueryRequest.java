package pers.jyzh.springcloud.openfeign.remote.order.request;

import lombok.Getter;
import lombok.Setter;

/**
 * @author ZhengYu
 * @version 1.0 2023/11/16 21:30
 **/
@Getter
@Setter
public class OrderQueryRequest {
    private String idEq;
    private String flowNoEq;
}

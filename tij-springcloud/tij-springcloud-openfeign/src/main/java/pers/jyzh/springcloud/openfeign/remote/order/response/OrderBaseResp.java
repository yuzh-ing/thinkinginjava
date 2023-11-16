package pers.jyzh.springcloud.openfeign.remote.order.response;

import lombok.Getter;
import lombok.Setter;

/**
 * @author ZhengYu
 * @version 1.0 2023/11/16 21:26
 **/
@Getter
@Setter
public class OrderBaseResp<T> {
    private Integer code;
    private String msg;
    private String subCode;
    private String subMsg;
}

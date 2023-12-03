package pers.jyzh.common.http;

import java.text.MessageFormat;

import lombok.Getter;
import lombok.Setter;

/**
 * @author ZhengYu
 * @version 1.0 2023/11/29 21:17
 **/
@Getter
@Setter
public class TijResponse<T> {
  public static final String COMPONENT_ID = "tij";

  private String cmd_id = COMPONENT_ID;
  private int code;
  private String msg;
  private String subCode;
  private String subMsg;
  private T data;

  public static <T> TijResponse<T> of(ErrorCode errCode) {
    return of(errCode, null);
  }

  public static <T> TijResponse<T> of(ErrorCode errCode, T data) {
    TijResponse<T> rsp = new TijResponse<>();
    rsp.setCode(errCode.code());
    rsp.setMsg(errCode.msg());
    rsp.setSubCode(errCode.subCode());
    rsp.setSubMsg(errCode.subMsg());
    rsp.setData(data);
    return rsp;
  }

  public static <T> TijResponse<T> success(T data) {
    return of(ErrorCodes.SUCCESS, data);
  }

  public static <T> TijResponse<T> fail() {
    return of(ErrorCodes.FAILURE);
  }

  public static <T> TijResponse<T> fail(String msg, Object... args) {
    TijResponse<T> rsp = of(ErrorCodes.FAILURE);
    rsp.setMsg(MessageFormat.format(msg, args));
    return rsp;
  }

  public static <T> TijResponse<T> fail(int code, String msg, String subCode, String subMsg) {
    TijResponse<T> rsp = new TijResponse<>();
    rsp.setCode(code);
    rsp.setMsg(msg);
    rsp.setSubCode(subCode);
    rsp.setSubMsg(subMsg);
    return rsp;
  }
}

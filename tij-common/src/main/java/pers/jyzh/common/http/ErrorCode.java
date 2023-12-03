package pers.jyzh.common.http;

/**
 * @author ZhengYu
 * @version 1.0 2023/11/29 21:34
 **/
public interface ErrorCode {

  int code();

  String msg();

  default String subCode() {
    return null;
  }

  default String subMsg() {
    return null;
  }
}

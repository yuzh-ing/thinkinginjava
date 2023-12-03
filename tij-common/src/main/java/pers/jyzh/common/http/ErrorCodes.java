package pers.jyzh.common.http;

/**
 * @author ZhengYu
 * @version 1.0 2023/11/29 21:36
 **/
public enum ErrorCodes implements ErrorCode {
  SUCCESS {
    @Override
    public int code() {
      return 2000;
    }

    @Override
    public String msg() {
      return "SUCCESS";
    }
  },
  FAILURE {
    @Override
    public int code() {
      return 5000;
    }

    @Override
    public String msg() {
      return "系统繁忙, 请稍后再试";
    }
  }
}

package pers.jyzh.common.exception;

import java.text.MessageFormat;

/**
 * @author ZhengYu
 * @version 1.0 2023/11/29 21:25
 **/
public class TijException extends RuntimeException {

  public TijException(String msg, Object... args) {
    super(MessageFormat.format(msg, args));
  }
}

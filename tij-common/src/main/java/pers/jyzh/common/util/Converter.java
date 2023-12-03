package pers.jyzh.common.util;

/**
 * @author ZhengYu
 * @version 1.0 2023/11/29 23:19
 **/
public interface Converter<S, T> {

  T convert(S source);
}

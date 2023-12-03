package pers.jyzh.common.util;

/**
 * @author ZhengYu
 * @version 1.0 2023/11/29 23:21
 **/
public interface ReversibleConverter<S, T> extends Converter<S, T> {

  S reverse(T target);
}

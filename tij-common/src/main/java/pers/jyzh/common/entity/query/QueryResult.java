package pers.jyzh.common.entity.query;

import java.util.List;
import java.util.stream.Collectors;

import lombok.Getter;
import lombok.Setter;
import pers.jyzh.common.util.Converter;

/**
 * @author ZhengYu
 * @version 1.0 2023/11/29 22:01
 **/
@Getter
@Setter
public class QueryResult<T> {
  private int page;
  private int size;
  private List<T> records;
  private long total;
  private boolean more;

  public static <S, T> QueryResult<T> of(QueryResult<S> source, Converter<S, T> converter) {
    QueryResult<T> target = new QueryResult<>();
    target.setPage(source.getPage());
    target.setSize(source.getSize());
    if (source.getRecords() != null && !source.getRecords().isEmpty()) {
      target.setRecords( //
          source.getRecords().stream().map(converter::convert).collect(Collectors.toList()));
    }
    target.setTotal(source.getTotal());
    target.setMore(source.isMore());
    return target;
  }
}

package pers.jyzh.common.entity.query;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

/**
 * @author ZhengYu
 * @version 1.0 2023/11/29 22:01
 **/
@Getter
@Setter
public class QueryRequest {
  private int page;
  private int size = 10;
  private List<FilterParam> filters = new ArrayList<>();
  private List<SortParam> sorters = new ArrayList<>();
  private List<String> fetchParts = new ArrayList<>();
}

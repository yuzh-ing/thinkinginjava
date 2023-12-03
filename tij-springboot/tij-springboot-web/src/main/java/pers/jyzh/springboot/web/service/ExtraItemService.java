package pers.jyzh.springboot.web.service;

import java.util.List;

import pers.jyzh.common.entity.ExtraItem;

/**
 * @author ZhengYu
 * @version 1.0 2023/11/29 23:01
 **/
public interface ExtraItemService {

  void save(List<ExtraItem> extraItems);

  List<ExtraItem> list(String owner);
}

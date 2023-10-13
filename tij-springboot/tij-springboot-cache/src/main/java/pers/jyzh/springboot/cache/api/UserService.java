package pers.jyzh.springboot.cache.api;

import pers.jyzh.springboot.cache.entity.User;

/**
 * @author ZhengYu
 * @version 1.0 2023/10/13 10:58
 **/
public interface UserService {

  /**
   * 根据用户id获取用户
   *
   * @param id
   *          用户id
   * @return 用户
   */
  User get(Long id);
}

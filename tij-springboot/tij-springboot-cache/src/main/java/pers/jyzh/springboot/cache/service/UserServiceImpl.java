package pers.jyzh.springboot.cache.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import pers.jyzh.springboot.cache.api.UserService;
import pers.jyzh.springboot.cache.dao.UserDao;
import pers.jyzh.springboot.cache.entity.User;

/**
 * @author ZhengYu
 * @version 1.0 2023/10/13 14:08
 **/
@Service
public class UserServiceImpl implements UserService {

  @Autowired
  private UserDao userDao;

  @Cacheable(value = "users", key = "#id")
  @Override
  public User get(Long id) {
    Assert.notNull(id, "id");
    return userDao.get(id);
  }
}

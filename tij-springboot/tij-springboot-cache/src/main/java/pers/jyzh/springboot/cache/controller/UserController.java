package pers.jyzh.springboot.cache.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pers.jyzh.springboot.cache.api.UserService;
import pers.jyzh.springboot.cache.entity.User;

/**
 * @author ZhengYu
 * @version 1.0 2023/10/13 14:09
 **/
@RestController
@RequestMapping("/user/v1")
public class UserController {

  @Autowired
  private UserService userService;

  @GetMapping("{id}")
  public User get(@PathVariable("id") Long id) {
    return userService.get(id);
  }
}

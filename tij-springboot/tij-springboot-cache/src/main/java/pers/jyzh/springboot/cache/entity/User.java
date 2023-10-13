package pers.jyzh.springboot.cache.entity;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import pers.jyzh.springboot.cache.enums.Gender;

/**
 * @author ZhengYu
 * @version 1.0 2023/10/13 10:54
 **/
@Getter
@Setter
public class User implements Serializable {
  /** 用户id */
  private Long id;
  /** 名称 */
  private String name;
  /** 年龄 */
  private Integer age;
  /** 性别 */
  private Gender gender;
}

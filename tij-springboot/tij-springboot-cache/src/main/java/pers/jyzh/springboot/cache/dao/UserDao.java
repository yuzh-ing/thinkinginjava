package pers.jyzh.springboot.cache.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import lombok.extern.slf4j.Slf4j;
import pers.jyzh.springboot.cache.entity.User;
import pers.jyzh.springboot.cache.enums.Gender;

/**
 * @author ZhengYu
 * @version 1.0 2023/10/13 11:02
 **/
@Slf4j
@Repository
public class UserDao {
  public static class Schema {
    static final String TABLE_NAME = "tij_user";
    static final String TABLE_NAME_ALIAS = "_" + TABLE_NAME;

    static final String COLUMN_ID = "id";
    static final String COLUMN_NAME = "name";
    static final String COLUMN_AGE = "age";
    static final String COLUMN_GENDER = "gender";

    static final String[] ALL_COLUMN = new String[] {
        COLUMN_ID, COLUMN_NAME, COLUMN_AGE, COLUMN_GENDER };
  }

  public static RowMapper<User> ROW_MAPPER = (rs, rowNum) -> {
    User entity = new User();
    entity.setId(rs.getLong(Schema.COLUMN_ID));
    entity.setName(rs.getString(Schema.COLUMN_NAME));
    entity.setAge(rs.getInt(Schema.COLUMN_AGE));
    entity.setGender(Optional.ofNullable(rs.getString(Schema.COLUMN_GENDER)) //
        .map(Gender::valueOf) //
        .orElse(Gender.UNKNOWN));
    return entity;
  };

  @Autowired
  private JdbcTemplate jdbcTemplate;

  public User get(Long id) {
    String sql = "select * from tij_user where id = " + id;
    List<User> users = jdbcTemplate.query(sql, ROW_MAPPER);
    if (CollectionUtils.isEmpty(users)) {
      return null;
    }
    return users.get(0);
  }

}

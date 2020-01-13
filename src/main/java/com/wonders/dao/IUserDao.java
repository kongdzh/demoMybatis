package com.wonders.dao;

import com.wonders.domain.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IUserDao {

    /**
     * 查询所有
     */
    @Select("SELECT * FROM user;")
    List<User> findAll();
}

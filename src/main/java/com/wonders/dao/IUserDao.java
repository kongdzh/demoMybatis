package com.wonders.dao;

import com.wonders.domain.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IUserDao {

    /**
     * 查询所有
     */
    List<User> findAll();

    /**
     * 保存
     * @param user
     */
    void saveUser(User user);

    /**
     * 根据id更新
     * @param user
     */
    void updateUser(User user);
}

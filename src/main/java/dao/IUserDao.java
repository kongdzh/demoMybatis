package dao;

import com.wonders.domain.User;

import java.util.List;

public interface IUserDao {

    /**
     * 查询所有
     */
    List<User> findAll();
}

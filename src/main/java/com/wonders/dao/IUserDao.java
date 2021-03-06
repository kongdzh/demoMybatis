package com.wonders.dao;

import com.wonders.domain.QueryVo;
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

    /**
     * 根据id删除user
     * @param id
     */
    void deleteUser(Integer id);

    /**
     * 模糊查询
     * @param name
     * @return
     */
    List<User> findByName(String name);

    /**
     * 根据QueryVo中的查询条件查询
     * @param queryVo
     * @return
     */
    List<User> findUserByVo(QueryVo queryVo);

    /**
     * 根据传入的参数条件查询
     * @param user user可能有可能没有相关属性
     * @return
     */
    List<User> findUserByCondition(User user);

    /**
     * 根据查询条件中的id列表查询
     * @param queryVo
     * @return
     */
    List<User> findUserByIds(QueryVo queryVo);
}

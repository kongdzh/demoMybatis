package com.wonders.test;

import com.wonders.dao.IUserDao;
import com.wonders.domain.QueryVo;
import com.wonders.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MybatisTest {

    private InputStream in;
    private SqlSession sqlSession;
    private IUserDao userDao;

    @Before
    public void init() throws IOException {
        //1. 读取配置文件
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2. 创建SqlSessionFactory工厂
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        //3. 使用工厂生产sqlSession对象
        sqlSession = sqlSessionFactory.openSession();
        //4. 使用SQLSession创建Dao接口的代理对象
        userDao = sqlSession.getMapper(IUserDao.class);
    }

    @After
    public void close() throws IOException {
        // 提交事务
        sqlSession.commit();
        //6. 释放资源
        sqlSession.close();
        in.close();
    }

    @Test
    public void testFindAll() {

        //5. 使用代理对象执行方法
        List<User> users = userDao.findAll();
        for (User user :
                users) {
            System.out.println(user);
        }
    }

    @Test
    public void testSaveUser() {
        User user = new User();
        user.setUsername("Dennis");
        user.setAddress("汤臣一品");
        user.setSex("男");
        user.setBirthday(new Date());

        userDao.saveUser(user);
        System.out.println(user);
    }

    @Test
    public void testUpdateUser() {
        User user = new User();
        user.setUsername("kongdezhi");
        user.setAddress("汤臣一品");
        user.setSex("男");
        user.setBirthday(new Date());
        user.setId(51);

        userDao.updateUser(user);
        System.out.println(user);
    }

    @Test
    public void testDeleteUser(){
        userDao.deleteUser(43);
    }

    @Test
    public void testFindByName(){
        List<User> users = userDao.findByName("%王%");
        for (User user: users) {
            System.out.println(user);
        }
    }

    @Test
    public void testFindUserByVo(){
        QueryVo queryVo = new QueryVo();
        User user = new User();

        user.setUsername("kongdezhi");
        queryVo.setUser(user);

        List<User> users = userDao.findUserByVo(queryVo);
        for (User u: users) {
            System.out.println(u);
        }
    }

    @Test
    public void testFindUserByCondition(){
        User user = new User();
        user.setAddress("汤臣一品");
        user.setUsername("kongdezhi");

        List<User> users = userDao.findUserByCondition(user);
        for (User u: users) {
            System.out.println(u);
        }
    }

    @Test
    public void testFindUserByIds(){
        QueryVo queryVo = new QueryVo();
        List<Integer> ids = new ArrayList<Integer>();
        ids.add(41);
        ids.add(42);

        queryVo.setIds(ids);

        List<User> users = userDao.findUserByIds(queryVo);
        for (User u :
                users) {
            System.out.println(u);
        }
    }
}

package com.wonders.test;

import com.wonders.dao.IUserDao;
import com.wonders.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MybatisTest {

    public static void main(String[] args) throws IOException {
        //1. 读取配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2. 创建SqlSessionFactory工厂
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        //3. 使用工厂生产sqlsession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //4. 使用SQLSession创建Dao接口的代理对象
        IUserDao userDao = sqlSession.getMapper(IUserDao.class);
        //5. 使用代理对象执行方法
        List<User> users = userDao.findAll();
        System.out.println(users);
        for (User user :
                users) {
            System.out.println(user);
        }
        //6. 释放资源
        sqlSession.close();
        in.close();
    }
}

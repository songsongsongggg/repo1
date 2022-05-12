package com.lagou.test;

import com.lagou.domain.Orders;
import com.lagou.domain.User;
import com.lagou.mapper.OrderMapper;
import com.lagou.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class MybatisTest {

    private SqlSessionFactory sqlSessionFactory;
    private SqlSession sqlSession;

    @Before
    public void before() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        sqlSession = sqlSessionFactory.openSession();
    }

    @After
    public void after() {
        sqlSession.commit();
        sqlSession.close();
    }

    // 查询
    @Test
    public void testFindAll(){
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> list = userMapper.findAll();
        for (User user : list) {
            System.out.println(user);
        }
    }
    // 添加
    @Test
    public void testSave(){
//        username,birthday,sex,address
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setUsername("www");
        user.setBirthday(new Date());
        user.setSex("男");
        user.setAddress("广州");
        mapper.save(user);
    }
    // 更新
    @Test
    public void testUpdate() {
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setId(9);
        user.setUsername("郭德纲");
        user.setBirthday(new Date());
        user.setSex("男");
        user.setAddress("北京德云社");
        userMapper.update(user);
    }
    // 删除
    @Test
    public void testDelete(){
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        userMapper.delete(9);
    }

    /**
     * 一对一查询(注解方式)
     */
    @Test
    public void testOneToOne(){
        OrderMapper mapper = sqlSession.getMapper(OrderMapper.class);
        List<Orders> allWithUser = mapper.findAllWithUser();
        for (Orders orders : allWithUser) {
            System.out.println(orders);
        }
    }

}

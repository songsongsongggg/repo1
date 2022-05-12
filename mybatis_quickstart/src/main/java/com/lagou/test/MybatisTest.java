package com.lagou.test;

import com.lagou.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class MybatisTest {

    @Test
    //测试查询操作
    public void testFindAll() throws Exception {
        // 加载核心配置文件
        InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
        // 获取SqlSessionFactory工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        // 获取SqlSession会话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 执行sql
        List<User> list = sqlSession.selectList("UserMapper.findAll");
        for (User user : list) {
            System.out.println(user);
        }
        // 释放资源
        sqlSession.close();
    }

    @Test
    //测试添加操作
    public void testSave() throws IOException {
        // 1.加载核心配置文件
        InputStream is = Resources.getResourceAsStream("sqlMapConfig.xml");
        // 2.获取sqlSessionFactory工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        // 3.获取sqlSession会话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 4.执行sql
        User user = new User();
        user.setUsername("jack");
        user.setBirthday(new Date());
        user.setSex("男");
        user.setAddress("傻逼上海人");
        sqlSession.insert("UserMapper.saveUser",user);
        // 4.1DML语句，手动提交事务
        sqlSession.commit();
        // 5.打印结果
        System.out.println("添加成功");
        // 6.释放资源
        sqlSession.close();
    }

    @Test
    //测试修改操作
    public void testDateUser() throws IOException {
        // 1.加载核心配置文件
        InputStream is = Resources.getResourceAsStream("sqlMapConfig.xml");
        // 2.获取sqlSessionFactory工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        // 3.获取sqlSession会话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 4.执行sql
        User user = new User();
        user.setId(4);
        user.setUsername("lucy");
        user.setBirthday(new Date());
        user.setSex("女");
        user.setAddress("傻逼上海人");
        sqlSession.update("UserMapper.updateUser",user);
        // 4.1DML语句，手动提交事务
        sqlSession.commit();
        // 5.打印结果
        System.out.println("修改成功");
        // 6.释放资源
        sqlSession.close();
    }

    @Test
    //测试修改操作
    public void testDeleteUser() throws IOException {
        // 1.加载核心配置文件
        InputStream is = Resources.getResourceAsStream("sqlMapConfig.xml");
        // 2.获取sqlSessionFactory工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        // 3.获取sqlSession会话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 4.执行sql
        sqlSession.delete("UserMapper.deleteUser",4);
        // 4.1DML语句，手动提交事务
        sqlSession.commit();
        // 5.打印结果
        System.out.println("删除成功");
        // 6.释放资源
        sqlSession.close();
    }

}


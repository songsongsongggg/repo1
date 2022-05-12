package com.lagou.mapper;

import com.lagou.domain.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface UserMapper {

    @Select("SELECT * FROM user")
    public List<User> findAll();

    @Insert("INSERT INTO user(username,birthday,sex,address)VALUES(#{username},#{birthday},#{sex},#{address})")
    public void save(User user);

    @Update("UPDATE user SET username = #{username},birthday = #{birthday},sex = #{sex},address = #{address}WHERE id = #{id}")
    public void update(User user);

    @Delete("DELETE FROM user where id = #{id}")
    public void delete(Integer id);

    /**
     * 根据订单的uid 查询对应用户
     * @param uid
     * @return
     */
    @Select("SELECT * FROM `user` WHERE id = #{uid}")
    public User findById(Integer uid);
}

package com.lagou.mapper;

import com.lagou.domain.Orders;
import com.lagou.domain.User;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface OrderMapper {
    /**
     * 查询一个订单，与此同时查询出该订单所属的用户
     */
    @Select("SELECT * FROM orders")
    @Results({
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "ordertime", property = "ordertime"),
            @Result(column = "total", property = "total"),
            @Result(column = "uid",property = "uid"),
            @Result(property = "user", javaType = User.class,
                    column = "uid", one = @One(select =
                    "com.lagou.mapper.UserMapper.findById", fetchType = FetchType.EAGER))
    })
    public List<Orders> findAllWithUser();
}

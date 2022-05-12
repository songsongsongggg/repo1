package com.lagou.domain;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class User implements Serializable {

    private Integer id;
    private String username;
    private Date birthday;
    private String sex;
    private String address;
    // 代表当前用户具备的订单列表
    private List<Orders> orderList;

    // 代表当前用户具备的角色列表
    private List<Role> roleList;

    @Override
    public String toString() {
        return "User{" +
                "address='" + address + '\'' +
                ", birthday=" + birthday +
                ", id=" + id +
                ", orderList=" + orderList +
                ", roleList=" + roleList +
                ", sex='" + sex + '\'' +
                ", username='" + username + '\'' +
                '}';
    }

    public List<Role> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }

    public List<Orders> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Orders> orderList) {
        this.orderList = orderList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}

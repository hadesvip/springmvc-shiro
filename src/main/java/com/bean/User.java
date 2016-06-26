package com.bean;

import java.io.Serializable;
import java.util.Set;

/**
 * 用户信息
 * Created by wangyong on 2016/6/25.
 */
public class User implements Serializable {

    //序列化
    private static final long serialVersionUID = -87708426445257193L;

    //用户id
    private int userId;

    //用户名
    private String userName;

    //用户密码
    private String password;

    //用户描述
    private String desc;

    //用户年龄
    private int age;

    //用户邮箱
    private String email;

    //角色列表
    private Set<Role> roleSet;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Role> getRoleSet() {
        return roleSet;
    }

    public void setRoleSet(Set<Role> roleSet) {
        this.roleSet = roleSet;
    }
}

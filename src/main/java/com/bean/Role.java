package com.bean;

import java.io.Serializable;
import java.util.Set;

/**
 * 角色信息
 * Created by wangyong on 2016/6/25.
 */
public class Role implements Serializable {

    //序列化
    private static final long serialVersionUID = 6149314546430635645L;

    //角色id
    private int roleId;

    //角色名
    private String roleName;

    //角色描述
    private String desc;

    //资源列表
    private Set<Resource> resourceSet;

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Set<Resource> getResourceSet() {
        return resourceSet;
    }

    public void setResourceSet(Set<Resource> resourceSet) {
        this.resourceSet = resourceSet;
    }
}

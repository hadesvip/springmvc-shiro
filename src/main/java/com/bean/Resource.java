package com.bean;

import java.io.Serializable;

/**
 * 资源信息
 * Created by wangyong on 2016/6/25.
 */
public class Resource implements Serializable {

    //序列化
    private static final long serialVersionUID = 1876577811923431496L;

    //资源编号
    private int resourceId;

    //资源名
    private String resourceName;

    //资源描述
    private String desc;

    //资源url
    private String url;

    // 父级资源
    private Resource parent;

    public int getResourceId() {
        return resourceId;
    }

    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Resource getParent() {
        return parent;
    }

    public void setParent(Resource parent) {
        this.parent = parent;
    }
}

package com.solstice.melon.service.dto;

import com.google.common.collect.Lists;
import com.solstice.melon.domain.BaseDomain;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Intellij IDEA
 *
 * @Author solstice
 * @Date 2018/05/11 10:50
 * @Description 存放权限信息的节点
 */
public class Node extends BaseDomain implements Serializable {
    private static final long serialVersionUID = -7178131082566313665L;

    private Long parentId;
    private String parentIds;
    private String name;
    private String icon;
    private Integer type;
    private String url;
    private String permission;
    private Byte available;
    private Integer sort;

    private List<Node> children = Lists.newArrayList();

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getParentIds() {
        return parentIds;
    }

    public void setParentIds(String parentIds) {
        this.parentIds = parentIds;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public Byte getAvailable() {
        return available;
    }

    public void setAvailable(Byte available) {
        this.available = available;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public List<Node> getChildren() {
        return children;
    }

    public void setChildren(List<Node> children) {
        this.children = children;
    }

    public void addChild(Node node) {
        this.children.add(node);
    }
}

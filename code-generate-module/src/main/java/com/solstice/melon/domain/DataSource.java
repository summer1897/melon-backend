package com.solstice.melon.domain;

import java.io.Serializable;

/**
 * @ClassName DataSource
 * @Author solstice
 * @Date 2018/6/7 11:01
 * @Version 1.0
 * @Description 数据源实体类
 **/
public class DataSource implements Serializable {
    private static final long serialVersionUID = 8327404177055524035L;

    /**
     * 数据源连接Ip地址
     */
    private String ip;
    /**
     * 数据源连接服务器端口
     */
    private Integer port;
    /**
     * 连接数据库名称
     */
    private String dbName;
    /**
     * 连接数据源账户名
     */
    private String user;
    /**
     * 连接数据源密码
     */
    private String password;
    /**
     * 连接数据源驱动名称
     */
    private String driverClassName;

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public String getDbName() {
        return dbName;
    }

    public void setDbName(String dbName) {
        this.dbName = dbName;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDriverClassName() {
        return driverClassName;
    }

    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }
}

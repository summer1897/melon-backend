package com.solstice.melon.db;

import com.summer.base.utils.StringUtils;

/**
 * @ClassName SQL
 * @Author solstice
 * @Date 2018/6/7 9:50
 * @Version 1.0
 * @Description 数据库SQL语句接口定义
 **/
public interface SQL {

    /**
     *
     * @param tableName
     * @return {@link String}返回 show create table + 表名,SQL语句
     */
    default String showCreateTable(String tableName) {
        if (StringUtils.isNotEmpty(tableName)) {
            return "show create table " + tableName + ";";
        }
        return "";
    }

    /**
     * 格式化输出信息
     * @param tableName
     * @return {@link String}返回 show create table + 表名 + \G,SQL语句
     */
    default String showCreateTableFormat(String tableName) {
        if (StringUtils.isNotEmpty(tableName)) {
            return "show create table " + tableName + "\\G;";
        }
        return "";
    }

    /**
     *
     * @param tableName
     * @return {@link String}返回 desc table + 表名,SQL语句
     */
    default String descTable(String tableName) {
        if (StringUtils.isNotEmpty(tableName)) {
            return "desc " + tableName + ";";
        }
        return "";
    }

    /**
     * 格式化输出信息
     * @param tableName
     * @return {@link String}返回 desc table + 表名 + \G,SQL语句
     */
    default String descTableFormat(String tableName) {
        if (StringUtils.isNotEmpty(tableName)) {
            return "desc " + tableName + "\\G;";
        }
        return "";
    }

    /**
     * 获取数据库连接URL
     * @return {@link String}
     */
    String url();

    /**
     * 获取数据库连接驱动类全名
     * @return {@link String}
     */
    String driverClassName();

    /**
     * 获取当前数据库所有表明SQL语句
     * @param dbName
     * @return {@link String}
     */
    String allTableNames(String dbName);

    /**
     * 获取某表所有字段信息SQL
     * @param tableName
     * @return {@link String}
     */
    String allTableColumns(String tableName);
}

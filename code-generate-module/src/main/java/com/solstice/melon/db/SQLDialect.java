package com.solstice.melon.db;

import com.summer.base.utils.StringUtils;

import java.util.Map;

/**
 * @ClassName SQLDialect
 * @Author solstice
 * @Date 2018/6/7 9:50
 * @Version 1.0
 * @Description 数据库SQL语句接口定义
 **/
public interface SQLDialect {

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
     * 拼接sql查询字段
     * @param sql
     * @param columns
     * @return {@link String}
     */
    default String appendColumns(String sql,String...columns) {
        StringBuilder sb = new StringBuilder();
        if (StringUtils.isNotEmpty(sql) && StringUtils.isAllNotEmpty(columns)) {
            sb.append(sql);
            int i = 0;
            for (; i < columns.length - 1; ++i) {
                sb.append(columns[i]).append(",");
            }
            sb.append(columns[i]).append(" ");
        }
        return sb.toString();
    }

    /**
     * 获取数据库连接URL
     * @param ip
     * @param port
     * @param dbName
     * @return {@link String}
     */
    String url(String ip,Integer port,String dbName);

    /**
     * 获取数据库连接URL
     * @param ip
     * @param port
     * @param dbName
     * @param params
     * @return {@link String}
     */
    String url(String ip, Integer port, String dbName, Map<String,String> params);

    /**
     * 获取数据库连接驱动类全名
     * @return {@link String}
     */
    String driverClassName();

    /**
     * 获取当前数据库所有表明SQL语句
     * @param dbName
     * @param columns 指定返回表字段信息
     * @return {@link String}
     */
    String allTableNames(String dbName,String...columns);

    /**
     * 获取指定数据库某表所有字段信息SQL
     * @param dbName
     * @param tableName
     * @param columns 指定返回表字段信息
     * @return {@link String}
     */
    String allTableColumns(String dbName,String tableName,String...columns);
}

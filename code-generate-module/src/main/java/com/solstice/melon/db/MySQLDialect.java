package com.solstice.melon.db;

import com.alibaba.fastjson.JSON;
import com.summer.base.utils.ObjectUtils;
import com.summer.base.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import java.util.Map;

/**
 * Created by Intellij IDEA
 *
 * @Author solstice
 * @Date 2018/6/8 下午2:27
 * @Description MySQL SQL语言
 */
public class MySQLDialect implements SQLDialect {

    private static final Logger log = LoggerFactory.getLogger(MySQLDialect.class);

    public static final String MYSQL_DRIVER_CLASS_NAME = "com.mysql.jdbc.Driver";
    private static final String URL_TEMPLATE = "jdbc:mysql://ip:port/dbName";
    //默认查询表字段信息
    public static final String DEFAULT_SELECTED_TABLE_FIELDS = "table_name ";
    //默认查询表字段返回信息
    public static final String DEFAULT_SELECTED_COLUMNS_FIELDS = "column_name,data_type,column_comment ";


    @Override
    public String url(String ip, Integer port, String dbName) {
        log.info("MySQLDialect.url({},{},{})",ip,port,dbName);
        Assert.hasText(ip,"数据源ip地址为空");
        Assert.notNull(port,"数据源端口为空");
        Assert.hasText(dbName,"数据源数据库为空");
        String url = URL_TEMPLATE.replace("ip", ip)
                                .replace("port", port + "")
                                .replace("dbName", dbName);
        return url;
    }

    @Override
    public String url(String ip, Integer port, String dbName, Map<String, String> params) {
        log.info("MySQLDialect.url({},{},{},{})",ip,port,dbName, JSON.toJSONString(params,true));
        StringBuilder url = new StringBuilder(this.url(ip,port,dbName));
        if (ObjectUtils.isNotEmpty(params)) {
            url.append("?");
            for (String key : params.keySet()) {
                url.append(key).append("=").append(params.get(key)).append("&");
            }
        }
        //delete the last &
        url.deleteCharAt(url.length() - 1);
        return url.toString();
    }

    @Override
    public String driverClassName() {
        log.info("MySQLDialect.driverClassName({})",MYSQL_DRIVER_CLASS_NAME);
        return MYSQL_DRIVER_CLASS_NAME;
    }

    @Override
    public String allTableNames(String dbName,String...columns) {
        Assert.hasText(dbName,"数据库名称为空");
        StringBuilder sql = new StringBuilder();
        System.out.println(columns.length);
        if (StringUtils.isAllNotEmpty(columns)) {
            sql.append(this.appendColumns("select ",columns));
        } else {
            sql.append("select ").append(DEFAULT_SELECTED_TABLE_FIELDS);
        }
        sql.append("from information_schema.tables where table_schema = '")
                .append(dbName).append("';");
        log.info("MySQLDialect.allTableNames({})",sql.toString());
        return sql.toString();
    }

    @Override
    public String allTableColumns(String dbName, String tableName, String... columns) {
        Assert.hasText(dbName,"数据库名称为空");
        Assert.hasText(tableName,"数据库表名称为空");
        StringBuilder sql = new StringBuilder();
        if (StringUtils.isAllNotEmpty(columns)) {
            sql.append(this.appendColumns("select ",columns));
        } else {
            sql.append("select ").append(DEFAULT_SELECTED_COLUMNS_FIELDS);
        }
        sql.append("from information_schema.columns where table_schema = '")
            .append(dbName).append("' ")
            .append("and")
            .append("table_name = '")
            .append(tableName).append("';");
        log.info("MySQLDialect.allTableColumns({})",sql);
        return sql.toString();
    }

}

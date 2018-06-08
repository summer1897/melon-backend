package com.solstice.melon.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @ClassName DataSourceHolder
 * @Author solstice
 * @Date 2018/6/7 16:42
 * @Version 1.0
 * @Description 数据源线程池
 **/
public class DataSourceHolder {

    private static final ThreadLocal<String> contextHolder = new ThreadLocal<>();

    private static final Logger log = LoggerFactory.getLogger(DataSourceHolder.class);

    public static String getDataSource() {
        log.info("DynamicDataSource.getDataSource()");
        return contextHolder.get();
    }

    public static void setDataSource(String sourceName) {
        log.info("DynamicDataSource.setDataSource({})",sourceName);
        contextHolder.set(sourceName);
    }

    public static void clearDataSource() {
        log.info("DynamicDataSource.clearDataSource()");
        contextHolder.remove();
    }

}

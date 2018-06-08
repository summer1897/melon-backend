package com.solstice.melon.config.datasource;

import com.google.common.collect.Maps;
import com.solstice.melon.utils.DataSourceHolder;
import com.summer.base.utils.ObjectUtils;
import com.summer.base.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import javax.sql.DataSource;
import java.util.Map;

/**
 * @ClassName DynamicDataSource
 * @Author solstice
 * @Date 2018/6/7 11:32
 * @Version 1.0
 * @Description 动态数据源实体类
 **/
@Configuration
public class DynamicDataSource  extends AbstractRoutingDataSource {

    private static final Logger log = LoggerFactory.getLogger(DynamicDataSource.class);

    @Value("${spring.datasource.type}")
    private Class<? extends DataSource> dataSourceType;
    public static final String DEFAULT_DATASOURCE_KEY = "defaultDataSource";

    private Map<String,DataSource> dataSourceMap = Maps.newHashMap();

    public DynamicDataSource() {
        //初始化默认数据源
        DataSource defaultDataSource = DataSourceBuilder.create().type(dataSourceType).build();
        dataSourceMap.put(DEFAULT_DATASOURCE_KEY,defaultDataSource);
    }

    public void setDataSourceMap(Map<String, DataSource> dataSourceMap) {
        this.dataSourceMap = dataSourceMap;
    }

    @Override
    protected String determineCurrentLookupKey() {
        log.info("数据源切换:DynamicDataSource.determineCurrentLookupKey()");
        String dataSourceKey = DataSourceHolder.getDataSource();
       if (StringUtils.isEmpty(dataSourceKey)) {
           dataSourceKey = DEFAULT_DATASOURCE_KEY;
       }
        return dataSourceKey;
    }

    @Override
    protected DataSource determineTargetDataSource() {
        log.info("获取默认数据源:DynamicDataSource.determineTargetDataSource()");
        String dataSourceKey = this.determineCurrentLookupKey();
        return dataSourceMap.get(dataSourceKey);
    }


}

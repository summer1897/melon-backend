package com.solstice.melon.config.datasource;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.fastjson.JSON;
import com.google.common.collect.Maps;
import com.solstice.melon.db.SQLDialect;
import com.solstice.melon.domain.DataSourceEntity;
import com.solstice.melon.utils.DataSourceHolder;
import com.summer.base.utils.ObjectUtils;
import com.summer.base.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.util.Assert;

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

    /**
     * 数据源缓存
     */
    private Map<String,DataSource> dataSourceMap = Maps.newHashMap();
    /**
     * 存放数据源信息
     */
    private Map<DataSourceEntity,String> dataSourceMetaData = Maps.newHashMap();

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

    @Override
    public void afterPropertiesSet() {
    }

    public synchronized String addDataSource(String dataSourceKey, DataSourceEntity dataSourceEntity) {
        log.info("添加新数据源:DynamicDataSource.addDataSource({})", JSON.toJSONString(dataSourceEntity,true));
        Assert.notNull(dataSourceEntity,"添加的数据源信息为空");
        Assert.hasText(dataSourceKey,"数据源名称为空");

        String dsKey = dataSourceMetaData.get(dataSourceEntity);
        if (StringUtils.isNotEmpty(dataSourceKey)) {
            return dsKey;
        }

        DataSource dataSource = this.createDataSource(dataSourceEntity);
        dataSourceMap.put(dataSourceKey,dataSource);
        dataSourceMetaData.put(dataSourceEntity,dataSourceKey);

        return dataSourceKey;

    }

    public synchronized boolean deleteDataSource(String dataSourceKey) {
        log.info("DynamicDataSource.deleteDataSource({})",dataSourceKey);
        boolean flag = false;
        if (StringUtils.isNotEmpty(dataSourceKey)) {
            DataSourceHolder.clearDataSource();
            flag = ObjectUtils.isNotNull(dataSourceMap.remove(dataSourceKey));
        }
        return flag;
    }

    private DataSource createDataSource(DataSourceEntity dataSourceEntity) {
        DruidDataSource dataSource = new DruidDataSource();
        SQLDialect sqlDialect = dataSourceEntity.getSqlDialect();
        String url = sqlDialect.url(dataSourceEntity.getIp(),
                                    dataSourceEntity.getPort(),
                                    dataSourceEntity.getDbName());
        dataSource.setUrl(url);
        dataSource.setUsername(dataSourceEntity.getUser());
        dataSource.setPassword(dataSourceEntity.getPassword());
        dataSource.setDriverClassName(dataSourceEntity.getDriverClassName());
        return dataSource;
    }

}

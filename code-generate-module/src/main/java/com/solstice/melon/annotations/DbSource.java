package com.solstice.melon.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @ClassName DynamicDataSource
 * @Author solstice
 * @Date 2018/6/7 11:43
 * @Version 1.0
 * @Description 动态数据源注释
 **/
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface DbSource {
    /**
     * 切换数据源名称
     * @return {@link String}
     */
    String name();
}

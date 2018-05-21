package com.solstice.melon.enums;


import com.summer.base.utils.ObjectUtils;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;

/**
 * Created by Intellij IDEA
 *
 * @Projcet melon
 * @Author solstice
 * @Date 2018/5/18
 * @Time 15:20
 * @Description
 */
public interface BaseEnum {
    String DEFAULT_VALUE = "value";
    /**
     * 枚举中文描述
     */
    String DEFAULT_DESCRIPTION = "description";
    /**
     * 枚举英文描述
     */
    String DEFAULT_E_DESCRIPTION = "eDescription";

    default Integer getValue() {
        Field field = ReflectionUtils.findField(this.getClass(), DEFAULT_VALUE);
        if (ObjectUtils.isNull(field)) {
            return null;
        }
        try {
            field.setAccessible(true);
            return Integer.parseInt(field.get(this).toString());
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    default String getDescription() {
        return getString(DEFAULT_DESCRIPTION);
    }

    default String getString(String name) {
        Field field = ReflectionUtils.findField(this.getClass(), name);
        if (ObjectUtils.isNull(field)) {
            return null;
        }
        try {
            return field.get(this).toString();
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    default String getEDescription() {
       return getString(DEFAULT_E_DESCRIPTION);
    }
}

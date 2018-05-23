package com.solstice.melon.utils;

import com.google.common.collect.Maps;
import com.solstice.melon.enums.BaseEnum;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.converter.ConverterFactory;
import org.springframework.util.Assert;

import java.util.Map;
import java.util.WeakHashMap;

/**
 * Created by Intellij IDEA
 *
 * @Projcet melon
 * @Author solstice
 * @Date 2018/5/18
 * @Time 15:44
 * @Description 通用枚举类型到字符串类型转换工具类
 */
public class UniversalEnumConverterFactory implements ConverterFactory<String,BaseEnum> {

    private static final Map<Class, Converter> converterMap = new WeakHashMap<>();

    @Override
    public <T extends BaseEnum> Converter<String, T> getConverter(Class<T> targetType) {
        Converter result = converterMap.get(targetType);
        if(result == null) {
            result = new IntegerStrToEnum<>(targetType);
            converterMap.put(targetType, result);
        }
        return result;
    }

    class IntegerStrToEnum<T extends BaseEnum> implements Converter<String, BaseEnum> {
        private final Class<T> enumType;
        private Map<String, T> enumMap = Maps.newHashMap();

        public IntegerStrToEnum(Class<T> enumType) {
            this.enumType = enumType;
            T[] enums = enumType.getEnumConstants();
            for(T e : enums) {
                enumMap.put(e.getValue() + "", e);
            }
        }

        @Override
        public T convert(String key) {
            Assert.isNull(key,"No element matches " + key);
            return enumMap.get(key);
        }
    }
}

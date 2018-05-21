package com.solstice.melon.utils;

import com.baomidou.mybatisplus.enums.IEnum;
import com.google.common.collect.Maps;
import com.solstice.melon.enums.BaseEnum;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.converter.ConverterFactory;

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
public class UniversalEnumConverterFactory implements ConverterFactory<String,IEnum> {

    private static final Map<Class, Converter> converterMap = new WeakHashMap<>();

    @Override
    public <T extends IEnum> Converter<String, T> getConverter(Class<T> targetType) {
        Converter result = converterMap.get(targetType);
        if(result == null) {
            result = new IntegerStrToEnum<T>(targetType);
            converterMap.put(targetType, result);
        }
        return result;
    }

    class IntegerStrToEnum<T extends IEnum> implements Converter<String, T> {
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
        public T convert(String source) {
            T result = enumMap.get(source);
            if(result == null) {
                throw new IllegalArgumentException("No element matches " + source);
            }
            return result;
        }
    }
}

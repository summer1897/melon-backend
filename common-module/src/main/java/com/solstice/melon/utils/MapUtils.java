package com.solstice.melon.utils;

/**
 * Created by Intellij IDEA
 *
 * @Author solstice
 * @Date 2018/05/11
 * @Time 09:57
 * @Description MapBuilder工厂类
 */
public class MapUtils {

    public static <K,V> MapBuilder<K,V> builder() {
        return new MapBuilder<K,V>();
    }

}

package com.solstice.melon.utils;

import com.google.common.collect.Maps;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Intellij IDEA
 *
 * @Projcet melon
 * @Author solstice
 * @Date 2018/05/11
 * @Time 09:57
 * @Description Map<String,Object>对象构建工具
 */
public class MapBuilder<Key,Val> extends HashMap<Key,Val> {

    public MapBuilder<Key,Val> putVal(Key key,Val val) {
        super.put(key,val);
        return this;
    }
}

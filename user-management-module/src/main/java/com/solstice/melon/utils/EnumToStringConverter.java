package com.solstice.melon.utils;

import com.alibaba.fastjson.JSON;
import com.solstice.melon.enums.BaseEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.converter.Converter;
import org.springframework.util.Assert;

/**
 * Created by Intellij IDEA
 *
 * @Projcet melon
 * @Author solstice
 * @Date 2018/5/21
 * @Time 17:36
 * @Description
 */
public class EnumToStringConverter implements Converter<BaseEnum,String> {

    private static final Logger log = LoggerFactory.getLogger(EnumToStringConverter.class);

    @Override
    public String convert(BaseEnum baseEnum) {
        log.info("EnumToStringConverter.convert({})", JSON.toJSONString(baseEnum,true));
        Assert.isNull(baseEnum,"No element matches " + baseEnum);
        return baseEnum.getDescription();
    }
}

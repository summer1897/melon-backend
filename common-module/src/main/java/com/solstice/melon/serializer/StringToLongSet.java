package com.solstice.melon.serializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.google.common.collect.Sets;
import com.summer.base.utils.ConvertUtils;
import com.summer.base.utils.StringUtils;

import java.io.IOException;
import java.util.Set;

/**
 * Created by Intellij IDEA
 *
 * @Author solstice
 * @Date 2018/05/11 09:55
 * @Description
 */
public class StringToLongSet extends JsonDeserializer<Set<Long>> {
    @Override
    public Set<Long> deserialize(JsonParser jsonParser,
                                 DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        String text = jsonParser.getText();
        Set<Long> result = Sets.newHashSet();
        if (StringUtils.isNotEmpty(text)) {
            result.addAll(ConvertUtils.toSet(text,",",Long.class));
        }
        return result;
    }
}

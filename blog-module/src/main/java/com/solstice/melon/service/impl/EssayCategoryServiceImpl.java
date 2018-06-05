package com.solstice.melon.service.impl;

import com.solstice.melon.dao.EssayCategoryMapper;
import com.solstice.melon.domain.EssayCategory;
import com.solstice.melon.service.IEssayCategoryService;
import org.springframework.stereotype.Service;

/**
 * Created by Intellij IDEA
 *
 * @Projcet melon
 * @Author solstice
 * @Date 2018/6/1
 * @Time 14:35
 * @Description
 */
@Service("essayCategoryService")
public class EssayCategoryServiceImpl extends BaseServiceImpl<EssayCategoryMapper,EssayCategory> implements IEssayCategoryService {
}

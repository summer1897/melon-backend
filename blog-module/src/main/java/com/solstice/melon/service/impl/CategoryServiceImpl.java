package com.solstice.melon.service.impl;

import com.solstice.melon.dao.CategoryMapper;
import com.solstice.melon.domain.Category;
import com.solstice.melon.service.ICategoryService;
import org.springframework.stereotype.Service;

/**
 * Created by Intellij IDEA
 *
 * @Projcet melon
 * @Author yangyang
 * @Date 2018/6/1
 * @Time 14:35
 * @Description
 */
@Service("categoryService")
public class CategoryServiceImpl extends BaseServiceImpl<CategoryMapper,Category> implements ICategoryService {
}

package com.solstice.melon.service.impl;

import com.baomidou.mybatisplus.mapper.Condition;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.solstice.melon.dao.FamilyRelationshipMapper;
import com.solstice.melon.domain.FamilyRelationship;
import com.solstice.melon.service.IFamilyRelationshipService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Intellij IDEA
 *
 * @Projcet melon
 * @Author yangyang
 * @Date 2018/5/21
 * @Time 16:23
 * @Description
 */
@Service("familyRelationship")
public class FamilyRelationshipServiceImpl extends ServiceImpl<FamilyRelationshipMapper,FamilyRelationship>
        implements IFamilyRelationshipService {

    private static final Logger log = LoggerFactory.getLogger(FamilyRelationshipServiceImpl.class);

    @Override
    public List<FamilyRelationship> queryAll(Long userId) {
        log.info("Service Controller: queryAll({})",userId);
        return selectList(Condition.create().eq("user_id",userId));
    }

    @Override
    public Page<FamilyRelationship> queryAll(Long userId, Integer pageNum, Integer pageSize) {
        log.info("Service Controller: queryAll({},{},{})",userId,pageNum,pageSize);
        Page<FamilyRelationship> page = new Page<>(pageNum,pageSize);
        selectPage(page, Condition.create().eq("user_id",userId));
        return page;
    }
}

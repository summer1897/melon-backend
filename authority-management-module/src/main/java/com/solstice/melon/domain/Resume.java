package com.solstice.melon.domain;

import com.solstice.melon.enums.MaritalStatus;

import java.io.Serializable;

/**
 * Created by Intellij IDEA
 *
 * @Projcet melon
 * @Author solstice
 * @Date 2018/5/14
 * @Time 17:09
 * @Description 简历实体类
 */
public class Resume extends BaseDomain implements Serializable {

    /**
     * 简历所属者Id
     */
    private Long userId;
    private String name;
    private String resumePhotoUrl;
    private Byte sex;
    private MaritalStatus maritalStatus;
    private Integer politicalStatus;

}

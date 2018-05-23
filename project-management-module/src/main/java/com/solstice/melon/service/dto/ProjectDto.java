package com.solstice.melon.service.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.solstice.melon.enums.ProgressEnum;
import com.solstice.melon.enums.ProgressSituationEnum;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Intellij IDEA
 *
 * @Projcet melon
 * @Author solstice
 * @Date 2018/5/23
 * @Time 14:58
 * @Description
 */
public class ProjectDto implements Serializable {
    private static final long serialVersionUID = 5033932230537812644L;

    private Long id;
    /**
     * 项目所属部门
     */
    private String department;
    /**
     * 项目编号
     */
    private String number;
    /**
     * 项目甲方公司名称
     */
    private String employeName;
    private String name;
    /**
     * 项目类型
     */
    private String type;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date startTime;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endTime;
    private ProgressEnum progress;
    private ProgressSituationEnum progressSituation;
    /**
     * 项目负责组
     */
    private String group;

}

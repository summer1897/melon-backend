package com.solstice.melon.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Intellij IDEA
 *
 * @Projcet melon
 * @Author solstice
 * @Date 2018/5/15
 * @Time 15:47
 * @Description 在校获奖实体类
 */
public class SchoolReward extends BaseDomain implements Serializable {
    private static final long serialVersionUID = 6456804119786830791L;

    /**
     * 所属简历Id
     */
    private Long resumeId;
    /**
     * 获奖名称
     */
    private String reward;
    /**
     * 获奖地址
     */
    private String address;
    /**
     * 获奖证明人
     */
    private String reterence;
    /**
     * 获奖起始时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date startTime;
    /**
     * 获奖截止时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endTime;

    public Long getResumeId() {
        return resumeId;
    }

    public void setResumeId(Long resumeId) {
        this.resumeId = resumeId;
    }

    public String getReward() {
        return reward;
    }

    public void setReward(String reward) {
        this.reward = reward;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getReterence() {
        return reterence;
    }

    public void setReterence(String reterence) {
        this.reterence = reterence;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
}

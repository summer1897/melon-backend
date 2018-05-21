package com.solstice.melon.enums;

import com.baomidou.mybatisplus.enums.IEnum;

import java.io.Serializable;

/**
 * Created by Intellij IDEA
 *
 * @Projcet melon
 * @Author sosltice
 * @Date 2018/5/14
 * @Time 17:26
 * @Description 政治面貌枚举
 */
public enum PoliticalStatus implements IEnum {

    CHINESE_COMMUNIST_PARTY_MEMBER(1,"中共党员","Chinese Communist Party Member"),
    CHINESE_PROBATIONARY_COMMUNIST_PARTY_MEMBER(2,"中共预备党员","Chinese Probationary Communist Party Member"),
    COMMUNIST_YOUTH_LEAGUE_MEMBER(3,"共青团员","Communist Youth League Member"),
    PARTY_MEMBERS_OF_THE_CIVIL_REVOLUTION(4,"民革党员","Party Members Of The Civil Revolution"),
    LEAGUE_MEMBER_OF_THE_NLD(5," 民盟盟员","League Member Of The Nld"),
    CIVIL_CONSTRUCTION_MEMBERS(6,"民建会员","Civil Construction Members"),
    THE_MEMBERS_OF_THE_PEOPELS_REPUBLIC_CHINA(7,"民进会员","The Members Of The People's Republic China"),
    PARTY_MEMBERS_OF_THE_PEASANT_LABOUR_PARTY(8,"农工党党员","Party Members Of The Peasant Labour Party"),
    THE_PARTY_MEMBERS_OF_THE_ZHIGONG_PARTY(9,"致公党党员","The Party Members Of The ZhiGong Party"),
    JIUSAN_SOCIETY_MEMBER(10,"九三学社社员","93 Society Member"),
    LEAGUE_MEMBER_OF_THE_LEAGUE_OF_TAIWAN(11,"台盟盟员","League Member Of The League Of TaiWan"),
    NON_PARTY_PERSONAGE(12,"无党派人士","Non Party Personage"),
    MASSES(13,"13群众","Masses");


    int value;
    String description;
    String eDescription;

    PoliticalStatus(int value,String description,String eDescription) {
        this.value = value;
        this.description = description;
        this.eDescription = eDescription;
    }

    @Override
    public Serializable getValue() {
        return value;
    }

    @Override
    public String toString() {
        return this.description + "--" + this.eDescription;
    }
}

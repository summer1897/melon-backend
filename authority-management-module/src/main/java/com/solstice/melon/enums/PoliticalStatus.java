package com.solstice.melon.enums;

/**
 * Created by Intellij IDEA
 *
 * @Projcet melon
 * @Author sosltice
 * @Date 2018/5/14
 * @Time 17:26
 * @Description 政治面貌枚举
 */
public enum PoliticalStatus {

    CHINESE_COMMUNIST_PARTY_MEMBER(1,"中共党员"),
    CHINESE_PROBATIONARY_COMMUNIST_PARTY_MEMBER(2,"中共预备党员");
    /*CHINESE_COMMUNIST_PARTY_MEMBER(3,"中共党员"),
    CHINESE_COMMUNIST_PARTY_MEMBER(4,"中共党员"),
    CHINESE_COMMUNIST_PARTY_MEMBER(5,"中共党员"),
    CHINESE_COMMUNIST_PARTY_MEMBER(6,"中共党员"),
    CHINESE_COMMUNIST_PARTY_MEMBER(7,"中共党员"),
    CHINESE_COMMUNIST_PARTY_MEMBER(8,"中共党员"),
    CHINESE_COMMUNIST_PARTY_MEMBER(9,"中共党员"),
    CHINESE_COMMUNIST_PARTY_MEMBER(10,"中共党员"),
    CHINESE_COMMUNIST_PARTY_MEMBER(11,"中共党员"),
    CHINESE_COMMUNIST_PARTY_MEMBER(12,"中共党员"),
    CHINESE_COMMUNIST_PARTY_MEMBER(13,"中共党员"),*/


    private int status;
    private String description;

    PoliticalStatus(int status,String description) {
        this.status = status;
        this.description = description;
    }

    public int getStatus() {
        return this.status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

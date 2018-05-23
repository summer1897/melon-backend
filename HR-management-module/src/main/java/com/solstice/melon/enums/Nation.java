package com.solstice.melon.enums;

import com.baomidou.mybatisplus.enums.IEnum;

import java.io.Serializable;

/**
 * Created by Intellij IDEA
 *
 * @Projcet melon
 * @Author solstice
 * @Date 2018/5/15
 * @Time 14:18
 * @Description 56个民族枚举
 */
public enum Nation implements BaseEnum {

    HAN_NATIONNALITY(0,"汉族","Han Nationality"),
    ZHUANG_NATIONNALITY(1,"壮族","Zhuang Nationality"),
    MAN_NATIONNALITY(2,"满族","Man Nationality"),
    HUI_NATIONNALITY(3,"回族","Hui Nationality"),
    MIAO_NATIONNALITY(4,"苗族","Miao Nationality"),
    UYGUR_NATIONNALITY(5,"维吾尔族","Uygur Nationality"),
    DUJIA_NATIONNALITY(6,"土家族","TuJia Nationality"),
    YI_NATIONNALITY(7,"彝族","Yi Nationality"),
    MONGOLIAN_NATIONNALITY(8,"蒙古族","Mongolian Nationality"),
    ZANG_NATIONNALITY(9,"藏族","Zang Nationality"),
    BUYI_NATIONNALITY(10,"布依族","BuYi Nationality"),
    DONG_NATIONNALITY(11,"侗族","Dong Nationality"),
    YAO_NATIONNALITY(12,"瑶族","Yao Nationality"),
    KOREAN_NATIONNALITY(13,"朝鲜族","Korean  Nationality"),
    BAI_NATIONNALITY(14,"白族","Bai Nationality"),
    HANI_NATIONNALITY(15,"哈尼族","HaNi Nationality"),
    KAZAKH_NATIONNALITY(16,"哈萨克族","Kazakh Nationality"),
    LI_NATIONNALITY(17,"黎族","Li Nationality"),
    DAI_NATIONNALITY(18,"傣族","Dai Nationality"),
    SHE_NATIONNALITY(19,"畲族","She Nationality"),
    LISU_NATIONNALITY(20,"傈僳族","LiSu Nationality"),
    GELAO_NATIONNALITY(21,"仡佬族","GeLao Nationality"),
    DONGXIANG_NATIONNALITY(22,"东乡族","DongXiang Nationality"),
    GAOSHAN_NATIONNALITY(23,"高山族","GaoShan Nationality"),
    LAHU_NATIONNALITY(24,"拉祜族","LaHu Nationality"),
    SHUI_NATIONNALITY(25,"水族","Shui Nationality"),
    WA_NATIONNALITY(26,"佤族","Wa Nationality"),
    NAXI_NATIONNALITY(27,"纳西族","NaXi Nationality"),
    QIANG_NATIONNALITY(28,"羌族","Qiang Nationality"),
    TU_NATIONNALITY(29,"土族","Tu Nationality"),
    MULAO_NATIONNALITY(30,"仫佬族","MuLao Nationality"),
    XIBO_NATIONNALITY(31,"锡伯族","XiBo Nationality"),
    KEERKEZI_NATIONNALITY(32,"柯尔克孜族","KeErKeZi Nationality"),
    DAUR_NATIONNALITY(33,"达斡尔族","Daur Nationality"),
    JINGPO_NATIONNALITY(34,"景颇族","JingPo Nationality"),
    MAONAN_NATIONNALITY(35,"毛南族","MaoNan"),
    SALA_NATIONNALITY(36,"撒拉族","SaLa Nationality"),
    TAJIK_NATIONNALITY(37,"塔吉克族","TaJiK Nationality"),
    ACHANG_NATIONNALITY(38,"阿昌族","AChang Nationality"),
    PUMI_NATIONNALITY(39,"普米族","PuMi Nationality"),
    EWENKE_NATIONNALITY(40,"鄂温克族","EWenKe Nationality"),
    NU_NATIONNALITY(41,"怒族","Nu Nationality"),
    JING_NATIONNALITY(42,"京族","Jing Nationality"),
    JINUO_NATIONNALITY(43,"基诺族","JiNuo Nationality"),
    DEANG_NATIONNALITY(44,"德昂族","DeAng Nationality"),
    BAOANATIONNALITY(45,"保安族","BaoAn Nationality"),
    RUSSIAN_NATIONNALITY(46,"俄罗斯族","Russian Nationality"),
    YUGU_NATIONNALITY(47,"裕固族","YuGu Nationality"),
    UZBEL_NATIONNALITY(48,"乌兹别克族","Uzbek Nationality"),
    MENBA_NATIONNALITY(49,"门巴族","MenBa Nationality"),
    OROQEN_NATIONNALITY(50,"鄂伦春族","Oroqen Nationality"),
    DULONG_NATIONNALITY(51,"独龙族","Dulong Nationality"),
    TATAR_NATIONNALITY(52,"塔塔尔族","TaTar Nationality"),
    HEZHE_NATIONNALITY(53,"赫哲族","HeZhe Nationality"),
    LBOBA_NATIONNALITY(54,"珞巴族","Lhoba Nationality"),
    BROWN_NATIONNALITY(55,"布朗族","Brown Nationality");

    int value;
    String description;
    String eDescription;

    Nation(int value, String description, String eDescription) {
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

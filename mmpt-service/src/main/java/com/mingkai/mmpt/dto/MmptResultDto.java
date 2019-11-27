package com.mingkai.mmpt.dto;

/**
 * @Author [mingkai]
 * @create 2019/11/18 17:22
 */
public class MmptResultDto {

    private Long id;

    private Long mmptId;

    private Integer mmptScore;

    private String mmptDescribe;

    private String mmptIntroduction;


    public Long getMmptId() {
        return mmptId;
    }

    public void setMmptId(Long mmptId) {
        this.mmptId = mmptId;
    }

    public Integer getMmptScore() {
        return mmptScore;
    }

    public void setMmptScore(Integer mmptScore) {
        this.mmptScore = mmptScore;
    }

    public String getMmptDescribe() {
        return mmptDescribe;
    }

    public void setMmptDescribe(String mmptDescribe) {
        this.mmptDescribe = mmptDescribe;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMmptIntroduction() {
        return mmptIntroduction;
    }

    public void setMmptIntroduction(String mmptIntroduction) {
        this.mmptIntroduction = mmptIntroduction;
    }
}

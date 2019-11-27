package com.mingkai.mmpt.model;

import java.util.Date;

public class MmptResult {
    private Long id;

    private Long mmptId;

    private Integer mmptScore;

    private String mmptIntroduction;

    private Date createTime;

    private Date updateTime;

    private String mmptDescribe;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public String getMmptIntroduction() {
        return mmptIntroduction;
    }

    public void setMmptIntroduction(String mmptIntroduction) {
        this.mmptIntroduction = mmptIntroduction == null ? null : mmptIntroduction.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getMmptDescribe() {
        return mmptDescribe;
    }

    public void setMmptDescribe(String mmptDescribe) {
        this.mmptDescribe = mmptDescribe == null ? null : mmptDescribe.trim();
    }
}
package com.mingkai.mmpt.dto;

/**
 * @Author [mingkai]
 * @create 2019/11/18 17:22
 */
public class MmptQueryDto {

    private Long mmptId;

    private Integer type;

    private Integer orderBy;


    public Long getMmptId() {
        return mmptId;
    }

    public void setMmptId(Long mmptId) {
        this.mmptId = mmptId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(Integer orderBy) {
        this.orderBy = orderBy;
    }
}

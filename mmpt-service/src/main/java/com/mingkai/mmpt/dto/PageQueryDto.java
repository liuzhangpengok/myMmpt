package com.mingkai.mmpt.dto;

/**
 * @Author [mingkai]
 * @create 2019/11/28 10:58
 */
public class PageQueryDto {


    private Integer pageNum;

    private Integer pageSize;


    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}

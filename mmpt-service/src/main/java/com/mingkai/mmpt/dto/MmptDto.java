package com.mingkai.mmpt.dto;

import java.util.List;

/**
 * @Author [mingkai]
 * @create 2019/11/18 17:22
 */
public class MmptDto {

    private Long id;

    private String title;

    private String introduce;

    private String image;

    private Long clickNum;

    private Long buyNum;

    private Integer type;

    private Long price;

    private String mmptQuestions;

    private List<MmptResultDto> mmptResultDtoList;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Long getClickNum() {
        return clickNum;
    }

    public void setClickNum(Long clickNum) {
        this.clickNum = clickNum;
    }

    public Long getBuyNum() {
        return buyNum;
    }

    public void setBuyNum(Long buyNum) {
        this.buyNum = buyNum;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public String getMmptQuestions() {
        return mmptQuestions;
    }

    public void setMmptQuestions(String mmptQuestions) {
        this.mmptQuestions = mmptQuestions;
    }

    public List<MmptResultDto> getMmptResultDtoList() {
        return mmptResultDtoList;
    }

    public void setMmptResultDtoList(List<MmptResultDto> mmptResultDtoList) {
        this.mmptResultDtoList = mmptResultDtoList;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

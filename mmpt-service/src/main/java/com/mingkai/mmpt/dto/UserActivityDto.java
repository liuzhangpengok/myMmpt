package com.mingkai.mmpt.dto;

import java.util.List;

/**
 * @Author [mingkai]
 * @create 2019/11/18 17:22
 */
public class UserActivityDto {

    private Long userId;

    private Integer type;

    private Long balance;

    private String shareKey;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }


    public Long getBalance() {
        return balance;
    }

    public void setBalance(Long balance) {
        this.balance = balance;
    }

    public String getShareKey() {
        return shareKey;
    }

    public void setShareKey(String shareKey) {
        this.shareKey = shareKey;
    }
}

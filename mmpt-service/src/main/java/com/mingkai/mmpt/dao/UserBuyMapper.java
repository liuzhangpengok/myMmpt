package com.mingkai.mmpt.dao;

import com.mingkai.mmpt.model.UserBuy;
import com.mingkai.mmpt.model.UserBuyExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserBuyMapper {
    long countByExample(UserBuyExample example);

    int deleteByExample(UserBuyExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UserBuy record);

    int insertSelective(UserBuy record);

    List<UserBuy> selectByExample(UserBuyExample example);

    UserBuy selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") UserBuy record, @Param("example") UserBuyExample example);

    int updateByExample(@Param("record") UserBuy record, @Param("example") UserBuyExample example);

    int updateByPrimaryKeySelective(UserBuy record);

    int updateByPrimaryKey(UserBuy record);
}
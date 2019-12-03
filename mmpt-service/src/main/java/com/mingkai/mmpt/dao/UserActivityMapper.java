package com.mingkai.mmpt.dao;

import com.mingkai.mmpt.model.UserActivity;
import com.mingkai.mmpt.model.UserActivityExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserActivityMapper {
    long countByExample(UserActivityExample example);

    int deleteByExample(UserActivityExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UserActivity record);

    int insertSelective(UserActivity record);

    List<UserActivity> selectByExample(UserActivityExample example);

    UserActivity selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") UserActivity record, @Param("example") UserActivityExample example);

    int updateByExample(@Param("record") UserActivity record, @Param("example") UserActivityExample example);

    int updateByPrimaryKeySelective(UserActivity record);

    int updateByPrimaryKey(UserActivity record);
}
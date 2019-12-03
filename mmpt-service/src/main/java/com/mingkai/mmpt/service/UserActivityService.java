package com.mingkai.mmpt.service;


import com.mingkai.mmpt.dao.UserActivityMapper;
import com.mingkai.mmpt.dao.UserBuyMapper;
import com.mingkai.mmpt.dao.UserMapper;
import com.mingkai.mmpt.dto.UserActivityDto;
import com.mingkai.mmpt.model.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


/**
 * @author: mingkai
 * @Date: 2019/6/13
 */
@Service
public class UserActivityService {


    @Autowired
    private UserActivityMapper userActivityMapper;

    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;

    public void saveUserActivity(UserActivityDto userActivityDto) {

        String shareKey = userActivityDto.getShareKey();
        UserActivityExample e = new UserActivityExample();
        UserActivityExample.Criteria c = e.createCriteria();
        c.andShareKeyEqualTo(shareKey);
        List<UserActivity> userActivities = userActivityMapper.selectByExample(e);
        if (!userActivities.isEmpty()){
            return;
        }

        UserActivity userActivity = new UserActivity();
        BeanUtils.copyProperties(userActivityDto,userActivity);
        userActivity.setCreateTime(new Date());
        userActivityMapper.insertSelective(userActivity);

        User user = userService.queryUserById(userActivityDto.getUserId());
        user.setBalance(user.getBalance() + userActivityDto.getBalance());
        userMapper.updateByPrimaryKeySelective(user);

    }
}

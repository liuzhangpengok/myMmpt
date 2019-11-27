package com.mingkai.mmpt.service;


import com.mingkai.mmpt.dao.UserMapper;
import com.mingkai.mmpt.model.User;
import com.mingkai.mmpt.model.UserExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


/**
 * @author: mingkai
 * @Date: 2019/6/13
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public void saveUser(User user) {
        user.setCreateTime(new Date());
        userMapper.insertSelective(user);
    }

    public User queryUser(String wxId) {
        UserExample e = new UserExample();
        UserExample.Criteria c = e.createCriteria();
        c.andWxIdEqualTo(wxId);
        List<User> users = userMapper.selectByExample(e);
        if (!users.isEmpty()){
            return users.get(0);
        }
        return null;
    }
}

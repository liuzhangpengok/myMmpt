package com.mingkai.mmpt.service;


import com.mingkai.mmpt.dao.UserMmptMapper;
import com.mingkai.mmpt.model.User;
import com.mingkai.mmpt.model.UserMmpt;
import com.mingkai.mmpt.model.UserMmptExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


/**
 * @author: mingkai
 * @Date: 2019/6/13
 */
@Service
public class UserMmptService {

    @Autowired
    private UserService userService;

    @Autowired
    private UserMmptMapper userMmptMapper;


    public void saveUserMmpt(String wxId, Long mmptId, Integer score) {
        User user = userService.queryUser(wxId);
        if (null != user){
            UserMmpt userMmpt = new UserMmpt();
            userMmpt.setUserId(user.getId());
            userMmpt.setMmptId(mmptId);
            userMmpt.setSocre(score);
            userMmpt.setCreateTime(new Date());
            userMmptMapper.insertSelective(userMmpt);
        }


    }

    public List<UserMmpt> queryUserMmpt(String wxId, Long mmptId) {
        User user = userService.queryUser(wxId);
        if (null != user){
            UserMmptExample e = new UserMmptExample();
            UserMmptExample.Criteria c = e.createCriteria();
            if (null != wxId){
                c.andUserIdEqualTo(user.getId());
            }
            if (null != mmptId){
                c.andMmptIdEqualTo(mmptId);
            }
            return userMmptMapper.selectByExample(e);
        }else {
            return null;
        }

    }
}

package com.mingkai.mmpt.service;


import com.mingkai.mmpt.dao.UserBuyMapper;
import com.mingkai.mmpt.model.User;
import com.mingkai.mmpt.model.UserBuy;
import com.mingkai.mmpt.model.UserBuyExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


/**
 * @author: mingkai
 * @Date: 2019/6/13
 */
@Service
public class UserBuyService {

    @Autowired
    private UserBuyMapper userBuyMapper;

    @Autowired
    private UserService userService;


    public void saveUserBuy(String wxId, Long mmptId,Long price) {
        User user = userService.queryUser(wxId);
        if (null != user){
            UserBuy userBuy = new UserBuy();
            userBuy.setUserId(user.getId());
            userBuy.setMmptId(mmptId);
            userBuy.setPrice(price);
            userBuy.setCreateTime(new Date());
            userBuyMapper.insertSelective(userBuy);
        }


    }

    public UserBuy queryUserBuy(String wxId, Long mmptId) {

        User user = userService.queryUser(wxId);
        if (null != user){
            UserBuyExample e = new UserBuyExample();
            UserBuyExample.Criteria c = e.createCriteria();
            c.andUserIdEqualTo(user.getId());
            c.andMmptIdEqualTo(mmptId);
            List<UserBuy> userBuys = userBuyMapper.selectByExample(e);
            if (userBuys.isEmpty()){
                return null;
            }else {
                return userBuys.get(0);
            }

        }else {
            return null;
        }


    }
}

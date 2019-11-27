package com.mingkai.mmpt.controller;



import com.mingkai.mmpt.dto.CommonResp;
import com.mingkai.mmpt.model.User;
import com.mingkai.mmpt.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/user")
@CrossOrigin(origins = "*")
public class UserController {

    private static Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;


    @RequestMapping("/saveUser")
    @ResponseBody
    public CommonResp saveUser(@RequestBody User user){
        CommonResp commonResp = new CommonResp();
        commonResp.setErrorCode(CommonResp.SUCCESS_CODE);
        try {
            User oldUser = userService.queryUser(user.getWxId());
            if (null != oldUser){
                commonResp.setErrorCode(CommonResp.PARAMETER_CODE);
                commonResp.setErrorMsg("saveUser失败，该用户已进行过保存");
                return commonResp;
            }
            userService.saveUser(user);
        }catch (Exception e){
            log.error("saveUser异常",e);
            commonResp.setErrorCode(CommonResp.COMMON_FAIL_CODE);
            commonResp.setErrorMsg("saveUser异常，联系mingkai");
        }
        return commonResp;
    }


    @RequestMapping("/queryUser")
    @ResponseBody
    public CommonResp<User> queryUser(String wxId){
        CommonResp<User> commonResp = new CommonResp<>();
        commonResp.setErrorCode(CommonResp.SUCCESS_CODE);
        try {
            User user = userService.queryUser(wxId);
            commonResp.setRespObject(user);
        }catch (Exception e){
            log.error("queryUser异常",e);
            commonResp.setErrorCode(CommonResp.COMMON_FAIL_CODE);
            commonResp.setErrorMsg("queryUser异常，联系mingkai");
        }
        return commonResp;
    }


}

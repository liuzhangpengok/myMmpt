package com.mingkai.mmpt.controller;



import com.mingkai.mmpt.dto.CommonResp;
import com.mingkai.mmpt.dto.UserActivityDto;
import com.mingkai.mmpt.service.UserActivityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/activity")
@CrossOrigin(origins = "*")
public class UserActivityController {

    private static Logger log = LoggerFactory.getLogger(UserActivityController.class);

    @Autowired
    private UserActivityService userActivityService;


        @RequestMapping("/saveUserActivity")
        @ResponseBody
        public CommonResp saveUserActivity(@RequestBody UserActivityDto userActivityDto){
        CommonResp commonResp = new CommonResp();
        commonResp.setErrorCode(CommonResp.SUCCESS_CODE);

        if (null == userActivityDto.getUserId() || null == userActivityDto.getBalance() || null == userActivityDto.getType() || null == userActivityDto.getShareKey()){
            commonResp.setErrorCode(CommonResp.PARAMETER_CODE);
            commonResp.setErrorMsg("saveUserActivity参数异常，自己瞅瞅");
            return commonResp;
        }
        try {
            userActivityService.saveUserActivity(userActivityDto);
        }catch (Exception e){
            log.error("saveUserActivity异常",e);
            commonResp.setErrorCode(CommonResp.COMMON_FAIL_CODE);
            commonResp.setErrorMsg("saveUserActivity异常，联系mingkai");
        }
        return commonResp;
    }






}

package com.mingkai.mmpt.controller;



import com.mingkai.mmpt.dto.CommonResp;
import com.mingkai.mmpt.model.UserMmpt;
import com.mingkai.mmpt.service.UserMmptService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
@RequestMapping("/userMmpt")
@CrossOrigin(origins = "*")
public class UserMmptController {

    private static Logger log = LoggerFactory.getLogger(UserMmptController.class);

    @Autowired
    private UserMmptService userMmptService;


    @RequestMapping("/saveUserMmpt")
    @ResponseBody
        public CommonResp saveUserMmpt(String wxId,Long mmptId,Integer score){
        CommonResp commonResp = new CommonResp();
        commonResp.setErrorCode(CommonResp.SUCCESS_CODE);
        try {
            userMmptService.saveUserMmpt(wxId,mmptId,score);
        }catch (Exception e){
            log.error("saveUserMmpt异常",e);
            commonResp.setErrorCode(CommonResp.COMMON_FAIL_CODE);
            commonResp.setErrorMsg("saveUserMmpt异常，联系mingkai");
        }
        return commonResp;
    }


    @RequestMapping("/queryUserMmpt")
    @ResponseBody
    public CommonResp<List<UserMmpt>> saveUserMmpt(String wxId, Long mmptId){
        CommonResp<List<UserMmpt>> commonResp = new CommonResp<>();
        commonResp.setErrorCode(CommonResp.SUCCESS_CODE);
        try {
            List<UserMmpt> mmpts = userMmptService.queryUserMmpt(wxId,mmptId);
            commonResp.setRespObject(mmpts);
        }catch (Exception e){
            log.error("queryUserMmpt异常",e);
            commonResp.setErrorCode(CommonResp.COMMON_FAIL_CODE);
            commonResp.setErrorMsg("queryUserMmpt异常，联系mingkai");
        }
        return commonResp;
    }






}

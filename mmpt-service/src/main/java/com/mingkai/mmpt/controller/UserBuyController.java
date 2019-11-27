package com.mingkai.mmpt.controller;



import com.mingkai.mmpt.dto.CommonResp;
import com.mingkai.mmpt.model.UserBuy;
import com.mingkai.mmpt.service.UserBuyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/userBuy")
@CrossOrigin(origins = "*")
public class UserBuyController {

    private static Logger log = LoggerFactory.getLogger(UserBuyController.class);

    @Autowired
    private UserBuyService userBuyService;


    @RequestMapping("/saveUserBuy")
    @ResponseBody
        public CommonResp saveUser(String wxId, Long mmptId, Long price){
        CommonResp commonResp = new CommonResp();
        commonResp.setErrorCode(CommonResp.SUCCESS_CODE);
        try {
             userBuyService.saveUserBuy(wxId,mmptId,price);
        }catch (Exception e){
            log.error("saveUserBuy异常",e);
            commonResp.setErrorCode(CommonResp.COMMON_FAIL_CODE);
            commonResp.setErrorMsg("saveUserBuy异常，联系mingkai");
        }
        return commonResp;
    }


    @RequestMapping("/queryUserBuy")
    @ResponseBody
    public CommonResp<Boolean> queryUserBuy(String wxId, Long mmptId){
        CommonResp<Boolean> commonResp = new CommonResp<>();
        commonResp.setErrorCode(CommonResp.SUCCESS_CODE);
        try {
            UserBuy userBuy = userBuyService.queryUserBuy(wxId,mmptId);
            if (null == userBuy){
                commonResp.setRespObject(false);
            }else {
                commonResp.setRespObject(true);
            }
        }catch (Exception e){
            log.error("queryUserBuy异常",e);
            commonResp.setErrorCode(CommonResp.COMMON_FAIL_CODE);
            commonResp.setErrorMsg("queryUserBuy异常，联系mingkai");
        }
        return commonResp;
    }




}

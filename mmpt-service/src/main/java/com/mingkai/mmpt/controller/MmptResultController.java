package com.mingkai.mmpt.controller;


import com.mingkai.mmpt.dto.CommonResp;
import com.mingkai.mmpt.model.MmptResult;
import com.mingkai.mmpt.service.MmptResultService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/mmptResult")
@CrossOrigin(origins = "*")
public class MmptResultController {

    private static Logger log = LoggerFactory.getLogger(MmptResultController.class);

    @Autowired
    private MmptResultService mmptResultService;

    @RequestMapping("/queryMmptResult")
    @ResponseBody
    public CommonResp<MmptResult> queryMmptResult(Long mmptId, Integer score){
        CommonResp<MmptResult> commonResp = new CommonResp<>();
        commonResp.setErrorCode(CommonResp.SUCCESS_CODE);
        try {
            MmptResult mmptResult = mmptResultService.queryMmptResult(mmptId,score);
            commonResp.setRespObject(mmptResult);
        }catch (Exception e){
            log.error("queryMmptResult异常",e);
            commonResp.setErrorCode(CommonResp.COMMON_FAIL_CODE);
            commonResp.setErrorMsg("queryMmptResult异常，联系mingkai");
        }
        return commonResp;
    }





}

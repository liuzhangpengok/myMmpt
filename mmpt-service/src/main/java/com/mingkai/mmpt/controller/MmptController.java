package com.mingkai.mmpt.controller;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mingkai.mmpt.dto.CommonResp;
import com.mingkai.mmpt.dto.MmptDto;
import com.mingkai.mmpt.dto.MmptQueryDto;
import com.mingkai.mmpt.service.MmptService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
@RequestMapping("/mmpt1")
@CrossOrigin(origins = "*")
public class MmptController {

    private static Logger log = LoggerFactory.getLogger(MmptController.class);

    @Autowired
    private MmptService mmptService;


    @RequestMapping("/saveMmpt")
    @ResponseBody
    public CommonResp saveMmpt(@RequestBody MmptDto saveMmptDto){
        CommonResp commonResp = new CommonResp();
        commonResp.setErrorCode(CommonResp.SUCCESS_CODE);
        try {
            mmptService.saveMmpt(saveMmptDto);
        }catch (Exception e){
            log.error("saveMmpt异常",e);
            commonResp.setErrorCode(CommonResp.COMMON_FAIL_CODE);
            commonResp.setErrorMsg("saveMmpt异常，联系mingkai");
        }
        return commonResp;
    }


    @RequestMapping("/updateMmpt")
    @ResponseBody
    public CommonResp updateMmpt(@RequestBody MmptDto mmptDto){
        CommonResp commonResp = new CommonResp();
        commonResp.setErrorCode(CommonResp.SUCCESS_CODE);
        try {
            mmptService.update(mmptDto);
        }catch (Exception e){
            log.error("updateMmpt异常",e);
            commonResp.setErrorCode(CommonResp.COMMON_FAIL_CODE);
            commonResp.setErrorMsg("updateMmpt异常，联系mingkai");
        }
        return commonResp;
    }


    @RequestMapping("/queryMmpt")
    @ResponseBody
    public CommonResp<PageInfo<MmptDto>> queryMmpt(@RequestBody MmptQueryDto mmptQueryDto){
        Page page = PageHelper.startPage(mmptQueryDto.getPageNum(), mmptQueryDto.getPageSize());

        CommonResp<PageInfo<MmptDto>> commonResp = new CommonResp<>();
        commonResp.setErrorCode(CommonResp.SUCCESS_CODE);
        try {
            List<MmptDto> mmptDtos = mmptService.queryByMmptDto(mmptQueryDto);
            PageInfo<MmptDto> mmptDtoPageInfo = new PageInfo<>(mmptDtos);
            mmptDtoPageInfo.setTotal(page.getTotal());

//            Page<MmptDto> mmptDtoPage = new Page<MmptDto>();

          //  Page<MmptDto> mmptDtoPage = new Page<>(mmptDtoPageInfo);
            commonResp.setRespObject(mmptDtoPageInfo);
        }catch (Exception e){
            log.error("queryMmpt异常",e);
            commonResp.setErrorCode(CommonResp.COMMON_FAIL_CODE);
            commonResp.setErrorMsg("queryMmpt异常，联系mingkai");
        }
        return commonResp;
    }





}

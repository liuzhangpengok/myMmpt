package com.mingkai.mmpt.controller;


import com.mingkai.mmpt.dto.CommonResp;
import com.mingkai.mmpt.service.MmptService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.UUID;


@Controller
@RequestMapping("/file")
@CrossOrigin(origins = "*")
public class FileController {

    private static Logger log = LoggerFactory.getLogger(FileController.class);

    @Autowired
    private MmptService mmptService;



    @RequestMapping("/uploadFile")
    @ResponseBody
    public CommonResp<String> uploadFile(HttpServletRequest request, @RequestParam("file") MultipartFile file, HttpServletResponse response){

        log.info("uploadFile start");

        CommonResp<String> commonResp = new CommonResp<>();
        // 获取文件名
        String fileName = file.getOriginalFilename();

        // 获取文件的后缀名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));

        // 解决中文问题，liunx下中文路径，图片显示问题
        fileName = UUID.randomUUID().toString().replace("-", "") + suffixName;

        // 返回客户端 文件地址 URL
//        String url = "http://47.100.204.62:8080/advermachine"+"/upload/" + fileName;

         String filePath = "D://temp-rainy//"; // 上传后的路径
         String url = "http://localhost:8090/mmpt/temp-rainy/" + fileName;

//        File dest = new File(ApiConstant.UPLOAD_PATH + fileName);

//        log.info(request.getServletContext().getRealPath(""));

         File dest = new File(filePath + fileName);



        // 检测是否存在目录
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }

        try {
            file.transferTo(dest);
        } catch (IOException e) {
            e.printStackTrace();
        }
        commonResp.setRespObject(url);
        return commonResp;

    }





}

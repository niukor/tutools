package com.tutools.tutools.controller;

import com.tutools.tutools.service.AccurateService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

@Controller
public class AccurateController {
    private static final Logger LOGGER = LoggerFactory.getLogger(AccurateController.class);
    @Autowired
    private AccurateService accurateService;

    @GetMapping(value = "/hello")
    public String hello(){
        return accurateService.handleAccurate("Jim");
    }


    @PostMapping("/upload")
    @ResponseBody
    public String upload(@RequestParam(value = "file",required=false) MultipartFile file) throws FileNotFoundException {
        if (file.isEmpty()) {
            System.out.println("kong...................");
            return "上传失败，请选择文件";
        }
        

        String fileName = file.getOriginalFilename();
        String path = ClassUtils.getDefaultClassLoader().getResource("").getPath();
        System.out.println("==================="+path);
        File filePath = new File(path,"resources/temp");
        File dest = new File(filePath + fileName);
        System.out.println(dest.getAbsolutePath());
        try {
            file.transferTo(dest);
            LOGGER.info("上传成功, niukor@qq.com");
            return "上传成功";
        } catch (IOException e) {
            LOGGER.error(e.toString(), e);
        }
        return "上传失败！";
    }

}

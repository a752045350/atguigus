package com.atguigu.oss.controller;

import com.atguigu.commonUtils.R;
import com.atguigu.oss.service.OssService;
import com.atguigu.servicebase.exception.GuliException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
@Api(description = "阿里云OSS")
@RestController
@RequestMapping("/eduoss/fileoss")
@CrossOrigin
public class OssController {

    @Autowired
    private OssService ossService;

    @ApiOperation("文件上传")
    @PostMapping("/upload")
    public R uploadOssFile(@RequestParam("file")MultipartFile multipartFile){
        try {
            String url = ossService.uploadFileAvatar(multipartFile);
            return R.ok().data("url",url);
        }catch (GuliException e){
            e.printStackTrace();
            return R.error().data("message",e.getMsg());
        }

    }

    @GetMapping("/Test")
    public R get(){
        return R.ok().data("ss","sss");
    }


}

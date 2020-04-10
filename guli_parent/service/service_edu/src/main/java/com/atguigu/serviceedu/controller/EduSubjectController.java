package com.atguigu.serviceedu.controller;


import com.atguigu.commonUtils.R;
import com.atguigu.serviceedu.entity.VO.OneSubject;
import com.atguigu.serviceedu.service.EduSubjectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * <p>
 * 课程科目 前端控制器
 * </p>
 *
 * @author atguigu
 * @since 2020-03-27
 */
@Api("课程分类")
@RestController
@RequestMapping("/eduService/subject")
@CrossOrigin
public class EduSubjectController {

    @Autowired
    private EduSubjectService eduSubjectService;

    @ApiOperation("Excel导入")
    @PostMapping("/addSubject")
    public R addSubject(@RequestParam("file") MultipartFile file){
        eduSubjectService.saveSubject(file,eduSubjectService);
        return R.ok();
    }

    @ApiOperation("树形结构")
    @GetMapping("getTree")
    public R getTreeSubject(){
        List<OneSubject> list = eduSubjectService.nestedList();
        return R.ok().data("items",list);
    }

}


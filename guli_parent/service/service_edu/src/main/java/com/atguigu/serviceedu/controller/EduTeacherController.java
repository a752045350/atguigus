package com.atguigu.serviceedu.controller;


import com.atguigu.commonUtils.R;
import com.atguigu.serviceedu.entity.EduTeacher;
import com.atguigu.serviceedu.entity.VO.TeacherQuery;
import com.atguigu.serviceedu.service.EduTeacherService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author atguigu
 * @since 2020-03-27
 */
@Api(description = "讲师管理")
@RestController
@RequestMapping("/eduService/teacher")
@CrossOrigin
public class EduTeacherController {

    @Autowired
    private EduTeacherService eduTeacherService;

    @ApiOperation("讲师列表")
    @GetMapping("/findAll")
    public R findAllTeacher(){

        List<EduTeacher> list = eduTeacherService.list(null);

        return R.ok().data("item",list);

    }

    @ApiOperation("根据ID删除讲师")
    @DeleteMapping("{id}")
    public R removeTeacher(@ApiParam(name = "id",value = "讲师Id",required = true) @PathVariable String id){
        eduTeacherService.removeById(id);
        return R.ok();
    }

    @ApiOperation("分页条件查询")
    @PostMapping("/pageTeacher/{current}/{limit}")
    public R pageListTeacher(@ApiParam(name = "current",value = "页码",required = true)@PathVariable long current,
                             @ApiParam(name = "limit",value = "每页数量",required = true) @PathVariable long limit,
                             @RequestBody(required = false) TeacherQuery teacherQuery){

        Page<EduTeacher> pageParam = new Page<>(current, limit);
        eduTeacherService.pageQuery(pageParam, teacherQuery);
        List<EduTeacher> records = pageParam.getRecords();
        long total = pageParam.getTotal();
        return  R.ok().data("total", total).data("rows", records);
    }

    @ApiOperation("增加讲师")
    @PostMapping("/addTeacher")
    public R addTeacher(@RequestBody EduTeacher eduTeacher){

        boolean flag = eduTeacherService.save(eduTeacher);
        if(flag){
            return R.ok();
        }else {
            return R.error();
        }
    }

    @GetMapping("getTeacher/{id}")
    public R getTeacher(@PathVariable String id){
        EduTeacher eduTeacher = eduTeacherService.getById(id);
        return R.ok().data("teacher",eduTeacher);
    }

    @PostMapping("updateTeacher")
    public R updateTeacher(@RequestBody EduTeacher eduTeacher){
        boolean flag = eduTeacherService.updateById(eduTeacher);
        if(flag){
            return R.ok();
        }else {
            return R.error();
        }
    }
}


package com.atguigu.serviceedu.controller;


import com.atguigu.commonUtils.R;
import com.atguigu.serviceedu.entity.EduCourse;
import com.atguigu.serviceedu.entity.EduTeacher;
import com.atguigu.serviceedu.entity.VO.CourseInfoVo;
import com.atguigu.serviceedu.entity.VO.CoursePublishVo;
import com.atguigu.serviceedu.entity.VO.CourseQuery;
import com.atguigu.serviceedu.service.EduCourseService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 课程 前端控制器
 * </p>
 *
 * @author atguigu
 * @since 2020-03-27
 */
@Api("课程管理")
@RestController
@RequestMapping("/eduService/course")
@CrossOrigin
public class EduCourseController {

    @Autowired
    private EduCourseService eduCourseService;

    @ApiOperation("添加课程")
    @PostMapping("/addCourse")
    public R addCourse(@RequestBody CourseInfoVo courseInfoVo){
        String id;
        try{
           id =  eduCourseService.saveCourseInfo(courseInfoVo);
        }catch (Exception e){
            System.out.print(e.getMessage());
            return R.error().data("message","添加失败");
        }
        return R.ok().data("id",id);
    }

    @PostMapping("/updateCourse")
    public R updateCourse(@RequestBody CourseInfoVo courseInfoVo){

        eduCourseService.updateCourseById(courseInfoVo);

        return R.ok();
    }


    @ApiOperation("根据课程Id获取信息")
    @GetMapping("/getCourseInfo/{id}")
    public R getCourseInfoById(@PathVariable String id){
        CourseInfoVo courseInfoVo = eduCourseService.getCourseInfoById(id);
        return R.ok().data("courseInfo",courseInfoVo);
    }

    @ApiOperation("获取课程所有信息")
    @GetMapping("/getPublishCourseInfo/{courseId}")
    public R getPublishCourseInfo(@PathVariable String courseId){
        try{
            CoursePublishVo coursePublishVo = eduCourseService.getCoursePublishVoById(courseId);
            if(coursePublishVo!=null) return R.ok().data("publishVideo",coursePublishVo);
        }catch (Exception e){
           e.printStackTrace();
        }
        return R.error();
    }

    @GetMapping("/publishCourse/{id}")
    public R publishCourse(@PathVariable String id){
        try{
            boolean bool = eduCourseService.publishCourse(id);
            if(bool) return  R.ok();
        }catch (Exception e){
            e.printStackTrace();
        }
       return R.error();
    }

    @ApiOperation("分页查询课程")
    @PostMapping("/listCourse/{current}/{limit}")
    public R pageListTeacher(@PathVariable long current, @PathVariable long limit,
                             @RequestBody CourseQuery courseQuery){
        Page<EduCourse> pageParam = new Page<>(current,limit);
        eduCourseService.pageQuery(pageParam,courseQuery);
        List<EduCourse> list = pageParam.getRecords();
        return R.ok().data("rows",list).data("total",pageParam.getTotal());
    }

    @ApiOperation("删除课程")
    @DeleteMapping("/deleteCourse/{id}")
    public R deleteCourse(@PathVariable String id){
       try{
           boolean bool =  eduCourseService.deleteCourseById(id);
           if(bool) return  R.ok();
       }catch (Exception e){
           e.printStackTrace();
       }
       return R.error();

    }
}


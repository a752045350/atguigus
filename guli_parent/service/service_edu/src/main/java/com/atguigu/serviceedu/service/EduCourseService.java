package com.atguigu.serviceedu.service;

import com.atguigu.serviceedu.entity.EduCourse;
import com.atguigu.serviceedu.entity.VO.CourseInfoVo;
import com.atguigu.serviceedu.entity.VO.CoursePublishVo;
import com.atguigu.serviceedu.entity.VO.CourseQuery;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 课程 服务类
 * </p>
 *
 * @author atguigu
 * @since 2020-03-27
 */
public interface EduCourseService extends IService<EduCourse> {

    String saveCourseInfo(CourseInfoVo courseInfoVo);

    void updateCourseById(CourseInfoVo courseInfoVo);

    CourseInfoVo getCourseInfoById(String courseId);

    CoursePublishVo getCoursePublishVoById(String id);

    boolean publishCourse(String id);

    void pageQuery(Page<EduCourse> pageParam, CourseQuery courseQuery);

    boolean deleteCourseById(String id);
}

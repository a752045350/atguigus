package com.atguigu.serviceedu.service;

import com.atguigu.serviceedu.entity.EduChapter;
import com.atguigu.serviceedu.entity.VO.ChapterVO;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 课程 服务类
 * </p>
 *
 * @author atguigu
 * @since 2020-03-27
 */
public interface EduChapterService extends IService<EduChapter> {

    List<ChapterVO> nestedList(String courseId);

    boolean deleteChapter(String Id);

    boolean removeByCourseId(String Id);
}

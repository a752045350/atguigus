package com.atguigu.serviceedu.service;

import com.atguigu.serviceedu.entity.EduVideo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 课程视频 服务类
 * </p>
 *
 * @author atguigu
 * @since 2020-03-27
 */
public interface EduVideoService extends IService<EduVideo> {

    List<EduVideo> getVideoByChapterId(String chapterId);

    boolean removeByCourseId(String Id);
}

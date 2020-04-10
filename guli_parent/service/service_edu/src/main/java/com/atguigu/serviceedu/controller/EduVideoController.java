package com.atguigu.serviceedu.controller;


import com.atguigu.commonUtils.R;
import com.atguigu.serviceedu.entity.EduVideo;
import com.atguigu.serviceedu.service.EduChapterService;
import com.atguigu.serviceedu.service.EduVideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 课程视频 前端控制器
 * </p>
 *
 * @author atguigu
 * @since 2020-03-27
 */
@RestController
@RequestMapping("/eduService/video")
@CrossOrigin
public class EduVideoController {
    @Autowired
    EduVideoService eduVideoService;

    @GetMapping("/getVideo/{chapterId}")
    public R getVideoByChapter(@PathVariable String chapterId){
        try{
            List<EduVideo> list = eduVideoService.getVideoByChapterId(chapterId);

            if(list!=null) return R.ok().data("videos",list);
        }catch (Exception e){
            e.printStackTrace();
        }
        return R.error();
    }

    @PostMapping("/addVideo")
    public R addVideo(@RequestBody EduVideo eduVideo){
        try{
            boolean bool = eduVideoService.save(eduVideo);
            if(bool) return R.ok();
        }catch (Exception e){
            e.printStackTrace();
        }
        return R.error();

    }

    @PostMapping("/update")
    public R updateVideo(@RequestBody EduVideo eduVideo){
        try{
          boolean bool = eduVideoService.updateById(eduVideo);
           if(bool) return R.ok();
        }catch (Exception e){
            e.printStackTrace();
        }
        return R.error();
    }

    //TODO 删除小节时，需要把视频也删除
    @DeleteMapping("/deleteVideo/{id}")
    public R deleteById(@PathVariable String id){
        try{
            boolean bool = eduVideoService.removeById(id);
            if(bool) return R.ok();
        }catch (Exception e){
            e.printStackTrace();
        }
       return R.error();
    }

    @GetMapping("/getVideoById/{id}")
    public R getVideoById(@PathVariable String id){
        try{
            EduVideo eduVideo = eduVideoService.getById(id);

            if(eduVideo!=null) return R.ok().data("videos",eduVideo);
        }catch (Exception e){
            e.printStackTrace();
        }
        return R.error();

    }
}


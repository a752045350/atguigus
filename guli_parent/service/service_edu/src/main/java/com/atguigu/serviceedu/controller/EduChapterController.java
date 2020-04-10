package com.atguigu.serviceedu.controller;


import com.atguigu.commonUtils.R;
import com.atguigu.serviceedu.entity.EduChapter;
import com.atguigu.serviceedu.entity.VO.ChapterVO;
import com.atguigu.serviceedu.service.EduChapterService;
import com.atguigu.serviceedu.service.EduCourseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
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
@Api("课程大纲")
@RestController
@RequestMapping("/eduService/chapter")
@CrossOrigin
@Slf4j
public class EduChapterController {

            @Autowired
            private EduChapterService eduChapterService;

            @ApiOperation("获取课程大纲")
            @GetMapping("/getChapterVideo/{courseId}")
            public R getChapterVideo(@PathVariable String courseId){

                List<ChapterVO> list = eduChapterService.nestedList(courseId);

                return R.ok().data("items",list);
            }

            /**
             *
             * @param eduChapter
             * @return
             */
            @ApiOperation("增加章节")
            @PostMapping("/addChapter")
            @Transactional
            public R addChapter(@RequestBody EduChapter eduChapter){
                    try {
                      boolean bool= eduChapterService.save(eduChapter);
                      if(bool){
                          return R.ok();
                      }
                    }catch (Exception e){
                        log.error(e.getMessage());
                        return  R.error();
                    }
                    return R.error();
            }

            /**
             *
             * @param chapterId
             * @return
             */
                @ApiOperation("查询章节")
                @GetMapping("/getChapterInfo/{chapterId}")
                public R getChapterInfo(@PathVariable String chapterId){
                    try{
                            EduChapter eduChapter = eduChapterService.getById(chapterId);
                            return R.ok().data("eduChapter",eduChapter);
                    }catch (Exception e){
                            log.error(e.getMessage());
                            return R.error();
                        }
                    }

            /**
             *
              * @param eduChapter
             * @return
             */
            @ApiOperation("修改章节")
            @PostMapping("/updateChapter")
                public R updateChapter(@RequestBody EduChapter eduChapter){
                    try{
                        boolean bool =  eduChapterService.updateById(eduChapter);
                        if(bool){
                            return R.ok();
                        }
                    }catch (Exception e){
                        log.error(e.getMessage());
                    }
                    return R.error();
                }

            @ApiOperation("删除章节")
            @DeleteMapping("/deleteChapter/{id}")
            public R deleteChapter(@PathVariable String id){
                try {
                 boolean bool = eduChapterService.deleteChapter(id);
                 if(bool) return R.ok();
                }catch (Exception e){
                    return R.error().data("error","存在小节");
                }
                return R.error();
            }
}


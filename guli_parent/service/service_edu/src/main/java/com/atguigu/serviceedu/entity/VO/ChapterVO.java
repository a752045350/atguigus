package com.atguigu.serviceedu.entity.VO;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;


@Data
public class ChapterVO {

    private static final long serialVersionUID = 1L;

    private String id;
    private String title;
    private List<VideoVO> children = new ArrayList<>();
}

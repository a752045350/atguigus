package com.atguigu.serviceedu.entity.VO;

import lombok.Data;

import java.util.List;

@Data
public class OneSubject {

    private String id;
    private String title;

    private List<TwoSubject> children;
}

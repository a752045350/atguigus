package com.atguigu.serviceedu.controller;

import com.atguigu.commonUtils.R;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/eduService/user")
@CrossOrigin
public class EduLoginController {


    @PostMapping("/login")
    public R login(){
        return R.ok().data("token","admin");
    }

    @GetMapping("/info")
    public R info(){
        return R.ok().data("roles","[admin]").data("name","admin")
                .data("avatar","https://f.sinaimg.cn/tech/transform/749/w480h269/20200402/e7af-irpunai4921946.gif");
    }

}

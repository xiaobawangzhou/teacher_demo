package com.yunzhi.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {

    @GetMapping("/sayHello")
    public String sayHello(){

        return "Hello yunzhi";
    }

    //查询
   // @GetMapping

    //添加
    @PostMapping("/add")
    public void add(){
        System.out.println("add");
    }

    //修改
    //@PutMapping

    //删除
    //@DeleteMapping


}

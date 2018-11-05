package com.topiea.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: kent long
 * @Date: 2018/11/5 上午 10:16
 */
@RestController
public class HelloController {
    @GetMapping("/index")
    public String sayHello() {
        return "hello";
    }
    @GetMapping("/testThrow")
    public String testThrow (){
        System.out.println(1/0);
        return "end";
    }
}

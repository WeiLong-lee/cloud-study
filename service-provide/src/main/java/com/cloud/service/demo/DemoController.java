package com.cloud.service.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

  @RequestMapping("/provide")
  public String provide(@RequestParam("name")String name){
    return name+":你好呀这里是producer服务 1 ";
  }
}

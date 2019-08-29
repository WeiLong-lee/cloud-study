package com.cloud.nacos;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@EnableDiscoveryClient
@SpringBootApplication
public class NacosClientApplication {

  public static void main(String[] args) {
    SpringApplication.run(NacosClientApplication.class, args);
  }

  @RestController
  public class TestController {

    @Value("${from}")
    private String from;

    @RequestMapping(value = "/echo", method = RequestMethod.GET)
    public String echo() {
      return this.from;
    }
  }

}

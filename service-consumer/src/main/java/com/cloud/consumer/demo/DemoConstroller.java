package com.cloud.consumer.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class DemoConstroller {

  @Autowired
  private RestTemplate restTemplate;

  @Autowired
  private ServiceClient serviceClient;

  @GetMapping("/consumer")
  public String consumerProduce(@RequestParam("name") String name){
    ResponseEntity<String> result =  restTemplate.exchange("http://service-provide/provide?name="+name,HttpMethod.GET,null,String.class);
    return result.toString();
  }

  @GetMapping("/consumer-feign")
  public String consumerFeign(@RequestParam("name") String name){
      return  serviceClient.provide(name);
  }


}

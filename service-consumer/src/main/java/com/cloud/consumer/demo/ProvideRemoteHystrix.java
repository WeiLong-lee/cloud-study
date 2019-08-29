package com.cloud.consumer.demo;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

@Component
public class ProvideRemoteHystrix implements ServiceClient {

  @Override
  public String provide(@RequestParam("name") String name) {
    return "hello :" +name +", this service msg send failed";
  }
}

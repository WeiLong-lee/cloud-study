package com.cloud.consumer.demo;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "service-provide",fallback = ProvideRemoteHystrix.class)
public interface ServiceClient {

  @RequestMapping(value = "/provide",method = RequestMethod.GET)
  String provide(@RequestParam("name") String name);

}

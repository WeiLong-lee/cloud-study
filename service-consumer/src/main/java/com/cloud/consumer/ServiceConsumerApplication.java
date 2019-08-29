package com.cloud.consumer;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;


@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class ServiceConsumerApplication {

  /**
   * ribbon  loadBalanced 默认的负载均衡策略为轮询
   * @return
   */
  @Bean
  @LoadBalanced
  RestTemplate restTemplate(){
    return new RestTemplate();
  }

  @Bean
  public IRule myRule() {

    //return new RoundRobinRule(); // 显式的指定使用轮询算法
    return new RandomRule();
  }

  public static void main(String[] args) {
    SpringApplication.run(ServiceConsumerApplication.class, args);
  }


}

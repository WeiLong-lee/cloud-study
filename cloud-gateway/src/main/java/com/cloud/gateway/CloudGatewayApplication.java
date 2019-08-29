package com.cloud.gateway;


import com.cloud.gateway.filter.AuthorizeGateWayFilter;
import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;

import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;


@EnableDiscoveryClient
@SpringBootApplication
public class CloudGatewayApplication {

  public static void main(String[] args) {
    SpringApplication.run(CloudGatewayApplication.class, args);
  }

  @Bean
  public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
    return builder.routes()
                .route(r ->
                    r.path("/consumer-feign")
                    .uri("http://www.google.com")
//                    .filters(new AuthorizeGateWayFilter())
                )
                .route(r -> r.path("/open-api/**")
                    //.filters(f -> f.addResponseHeader("X-AnotherHeader", "OurLimitHeader"))
                    .uri("lb://SERVICE-CONSUMER")
                )
        .build();
  }

}

package com.cloud.gateway.filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 *  token校验全局过滤器
 */
//@Component
public class AuthorizeGateWayFilter implements GlobalFilter, Ordered {

  private static final String AUTHORIZE_TOKEN = "token";
  private static final String AUTHORIZE_UID = "uid";



  @Override
  public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
    ServerHttpRequest request = exchange.getRequest();
    HttpHeaders headers = request.getHeaders();
    String token = headers.getFirst(AUTHORIZE_TOKEN);
    String uid = headers.getFirst(AUTHORIZE_UID);
    if (token == null) {
      token = request.getQueryParams().getFirst(AUTHORIZE_TOKEN);
    }
    if (uid == null) {
      uid = request.getQueryParams().getFirst(AUTHORIZE_UID);
    }

    ServerHttpResponse response = exchange.getResponse();
    if (StringUtils.isEmpty(token) || StringUtils.isEmpty(uid)) {
      response.setStatusCode(HttpStatus.UNAUTHORIZED);
      return response.setComplete();
    }
    String authToken = null;
        //stringRedisTemplate.opsForValue().get(uid);
    if (authToken == null || !authToken.equals(token)) {
      response.setStatusCode(HttpStatus.UNAUTHORIZED);
      return response.setComplete();
    }

    return chain.filter(exchange);
  }

  @Override
  public int getOrder() {
    return 0;
  }
}

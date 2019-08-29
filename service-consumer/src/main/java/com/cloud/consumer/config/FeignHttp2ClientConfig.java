package com.cloud.consumer.config;

import feign.Feign;
import feign.http2client.Http2Client;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.cloud.openfeign.FeignAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
//@ConditionalOnClass(Feign.class)
//@AutoConfigureBefore(FeignAutoConfiguration.class)
public class FeignHttp2ClientConfig {


  @Bean
  public Http2Client http2Client(){
    return new Http2Client();
  }

}

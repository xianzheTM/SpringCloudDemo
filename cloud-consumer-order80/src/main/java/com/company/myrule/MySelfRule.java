package com.company.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author xianzheTM
 * @date 2020/8/3 23:02
 */
//ribbon的负载均衡策略配置,不能放在@ComponentScan扫描的包下(@SpringApplication),
//否则会被所有的ribbon客户端共享,达不到特殊化定制的目的
//这里就新建了一个包
 @Configuration
public class MySelfRule {
  @Bean
 public IRule myRule(){
   //改为随机策略,默认是轮询
   return new RandomRule();
  }
}

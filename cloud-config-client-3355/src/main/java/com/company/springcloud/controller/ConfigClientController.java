package com.company.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xianzheTM
 * @date 2020/8/7 11:58
 */
@RestController
@RefreshScope
public class ConfigClientController {
    @Value("${config.info}")//读取配置文件中的config.info信息(此处指的是从3344中得到的配置文件,因为Git上的配置信息会和本地的配置信息合并)
    private String configInfo;

    @GetMapping("/configInfo")
    public String getConfigInfo() {
        return configInfo;
    }
}

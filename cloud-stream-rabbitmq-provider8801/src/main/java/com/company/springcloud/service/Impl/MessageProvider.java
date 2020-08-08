package com.company.springcloud.service.Impl;

import com.company.springcloud.service.IMessageProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @author xianzheTM
 * @date 2020/8/8 12:23
 */
@Slf4j
@EnableBinding(Source.class)//定义笑死推送管道
public class MessageProvider implements IMessageProvider {
    @Resource
    private MessageChannel output;

    //发送消息到RabbitMQ
    @Override
    public String send() {
        String serial = UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(serial).build());
        log.info("-->serial:" + serial);
        return null;
    }
}

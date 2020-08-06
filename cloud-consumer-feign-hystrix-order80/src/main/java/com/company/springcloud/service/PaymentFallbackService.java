package com.company.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @author xianzheTM
 * @date 2020/8/5 19:58
 */
@Component
public class PaymentFallbackService implements PaymentHystrixService {
    @Override
    public String paymentInfo_OK(Integer id) {
        return "-->PaymentFallbackService" + "paymentInfo_OK";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "PaymentFallbackService" + "paymentInfo_TimeOut";
    }
}

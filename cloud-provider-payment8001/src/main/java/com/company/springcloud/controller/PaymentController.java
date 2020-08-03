package com.company.springcloud.controller;

import com.company.springcloud.entities.CommonResult;
import com.company.springcloud.entities.Payment;
import com.company.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author xianzheTM
 * @date 2020/8/2 11:43
 */
@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping(value = "/payment/create")
    public CommonResult<Integer> create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info("-->插入结果:" + result);
        if (result > 0) {
            return new CommonResult<>(200, "插入数据成功,serverPort"+serverPort, result);
        } else {
            return new CommonResult<>(444, "插入数据失败", null);
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        log.info("===查询结果:" + payment);
        if (payment != null) {
            return new CommonResult<>(200, "查询数据成功,serverPort"+serverPort, payment);
        } else {
            return new CommonResult<>(444, "没有记录,查询Id:" + id, null);
        }
    }
}

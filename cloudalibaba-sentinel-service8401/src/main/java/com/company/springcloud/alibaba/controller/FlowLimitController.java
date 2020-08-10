package com.company.springcloud.alibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.company.springcloud.alibaba.myhandler.CustomerBlockHandler;
import com.company.springcloud.entities.CommonResult;
import com.company.springcloud.entities.Payment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xianzheTM
 * @date 2020/8/9 21:15
 */
@RestController
public class FlowLimitController {
    @GetMapping("/testA")
    public String testA() {
        return "testA";
    }

    @GetMapping("/testB")
    public String testB() {
        return "testB";
    }

    @GetMapping("/testHotKey")
    @SentinelResource(value = "testHotKey", blockHandler = "deal_testHotKey")
    public String testHotKey(@RequestParam(value = "p1", required = false) String p1,
                             @RequestParam(value = "p2", required = false) String p2) {
        return "testHotKey";
    }

    public String deal_testHotKey(String p1, String p2, BlockException exception) {
        return "deal_testHotKey";
    }

    @GetMapping("/rateLimit/customerBlockHandler")
    @SentinelResource(value = "customerBlockHandler",
            blockHandlerClass = CustomerBlockHandler.class,
            blockHandler = "handlerException1")
    public CommonResult<Payment> customerBlockHandler() {
        return new CommonResult<Payment>(200, "按客户自定义", new Payment(2020L, "Serial003"));
    }
}

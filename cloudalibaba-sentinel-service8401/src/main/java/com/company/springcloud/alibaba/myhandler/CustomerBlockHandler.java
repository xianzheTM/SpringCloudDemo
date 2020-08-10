package com.company.springcloud.alibaba.myhandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.company.springcloud.entities.CommonResult;
import com.company.springcloud.entities.Payment;

/**
 * @author xianzheTM
 * @date 2020/8/10 14:30
 */
public class CustomerBlockHandler {
    public static CommonResult<Payment> handlerException1(BlockException exception) {
        return new CommonResult<Payment>(444, "按客户自定义,global1", null);
    }
    public static CommonResult<Payment> handlerException2(BlockException exception) {
        return new CommonResult<Payment>(444, "按客户自定义,global2", null);
    }
}

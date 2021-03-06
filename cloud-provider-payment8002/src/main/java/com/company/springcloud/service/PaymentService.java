package com.company.springcloud.service;

import com.company.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @author xianzheTM
 * @date 2020/8/2 11:34
 */
public interface PaymentService {
    int create(Payment payment);

    Payment getPaymentById(@Param("id") Long id);
}

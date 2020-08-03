package com.company.springcloud.service.impl;

import com.company.springcloud.dao.PaymentDao;
import com.company.springcloud.entities.Payment;
import com.company.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author xianzheTM
 * @date 2020/8/2 11:35
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    @Resource
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}

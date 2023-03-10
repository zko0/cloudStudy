package cn.zko0.springcloud.controller;

import cn.zko0.springcloud.entities.CommonResult;
import cn.zko0.springcloud.entities.Payment;
import cn.zko0.springcloud.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Slf4j
@RestController
public class OrderFeignController {

    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        return paymentFeignService.getPaymentById(id);
    }

    @GetMapping("/consumer/payment/feign/timeout")
    public String paymetFeignTimeout(){
        //openfeign-ribbon，客户端一般默认等待1s
        return paymentFeignService.paymentFeignTimeOut();
    }
}

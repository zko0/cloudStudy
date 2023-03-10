package cn.zko0.springcloud.dao;

import cn.zko0.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author duanfuqiang
 * @date 2023/1/11 15:51
 * @description
 */
@Mapper
public interface PaymentDao {
    //增
    int create(Payment payment);

    //改     加上@Param注解，mapper中就可以采用#{}的方式把@Param注解括号内的参数进行引用
    Payment getPaymentById(@Param("id") Long id);

}

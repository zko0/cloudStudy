package cn.zko0.springcloud.controller;

import cn.zko0.springcloud.domain.CommonResult;
import cn.zko0.springcloud.service.AccountService;
import io.seata.core.context.RootContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;

@RestController
public class AccountController {

    @Resource
    private AccountService accountService;

    @RequestMapping("/account/decrease")
    public CommonResult decrease(@RequestParam("userId") Long userId, @RequestParam("money") BigDecimal money){
        //xid检查
        String xid = RootContext.getXID();
        System.out.println("xid_order:" +xid );
        accountService.decrease(userId, money);
        return new CommonResult(200, "扣减库存成功!");
    }

}

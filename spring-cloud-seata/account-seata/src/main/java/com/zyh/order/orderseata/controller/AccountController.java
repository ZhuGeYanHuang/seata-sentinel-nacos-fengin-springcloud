package com.zyh.order.orderseata.controller;

import com.alibaba.fastjson.JSONObject;
import com.zyh.database.util.ResultUtil;
import com.zyh.order.orderseata.entity.Account;
import com.zyh.order.orderseata.server.AccountServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>订单处理</p>
 *
 * @author : zyh
 **/
@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountServer accountServer;

    @PutMapping("/reduceAccount")
    public ResultUtil reduceAcount(@RequestBody JSONObject param) {
        Account account = new Account();
        account.setId(param.getLong("accountId"));
        account.setUserId(param.getInteger("userId"));
        account.setMoney(param.getInteger("money"));
        return accountServer.reduceAcount(account);
    }


}

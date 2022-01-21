package com.zyh.order.orderseata.server.impl;

import com.zyh.database.util.ResultUtil;
import com.zyh.order.orderseata.dao.AccountDao;
import com.zyh.order.orderseata.entity.Account;
import com.zyh.order.orderseata.server.AccountServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>订单处理实现类</p>
 *
 * @author : zyh
 **/
@Service
public class AccountServerImpl implements AccountServer {

    @Autowired
    private AccountDao accountDao;


    @Override
    public ResultUtil reduceAcount(Account param) {
        int upcount=accountDao.reduceStock(param.getId(),param.getMoney());
        if (upcount==0){
            throw new RuntimeException("更新账户失败！");
        }
        return ResultUtil.ok();
    }
}

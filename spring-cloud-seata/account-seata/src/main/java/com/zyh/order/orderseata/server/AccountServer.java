package com.zyh.order.orderseata.server;

import com.alibaba.fastjson.JSONObject;
import com.zyh.database.util.ResultUtil;
import com.zyh.order.orderseata.entity.Account;

/**
 * <p>订单处理</p>
 *
 * @author : zyh
 **/
public interface AccountServer {

    ResultUtil reduceAcount(Account param);
}

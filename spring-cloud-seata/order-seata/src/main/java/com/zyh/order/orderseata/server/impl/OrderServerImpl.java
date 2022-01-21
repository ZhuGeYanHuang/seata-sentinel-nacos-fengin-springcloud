package com.zyh.order.orderseata.server.impl;

import com.alibaba.fastjson.JSONObject;
import com.zyh.database.util.ResultUtil;
import com.zyh.order.orderseata.FeginServer.AccountFeginServer;
import com.zyh.order.orderseata.FeginServer.StockFeginServer;
import com.zyh.order.orderseata.dao.OrderDao;
import com.zyh.order.orderseata.entity.Order;
import com.zyh.order.orderseata.server.OrderServer;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>订单处理实现类</p>
 *
 * @author : zyh
 **/
@Service
public class OrderServerImpl implements OrderServer {

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private StockFeginServer stockFeginServer;

    @Autowired
    private AccountFeginServer accountFeginServer;

    @Override
    @Transactional
    @GlobalTransactional
    public ResultUtil createOrder(Order order) {

        JSONObject object = new JSONObject();
        object.put("stockId", order.getStockId());
        object.put("count", order.getCount());

        //创建订单
        orderDao.insert(order);

        //扣钱
        JSONObject account = new JSONObject();
        account.put("userId",1);
        account.put("money",10);
        account.put("accountId",1);

        accountFeginServer.reduceStock(account);

        ResultUtil result = stockFeginServer.reduceStock(object);

        return result;
    }

    @Override
    public ResultUtil del(Order order) {
        orderDao.deleteById(order.getId());
        return ResultUtil.ok();
    }
}

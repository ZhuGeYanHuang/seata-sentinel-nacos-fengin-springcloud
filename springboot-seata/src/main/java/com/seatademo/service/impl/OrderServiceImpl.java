package com.seatademo.service.impl;

import com.seatademo.common.OperationResponse;
import com.seatademo.common.order.Order;
import com.seatademo.common.order.OrderStatus;
import com.seatademo.common.order.PlaceOrderRequestVO;
import com.seatademo.config.DataSourceKey;
import com.seatademo.config.DynamicDataSourceContextHolder;
import com.seatademo.dao.OrderDao;
import com.seatademo.service.OrderService;
import com.seatademo.service.PayService;
import com.seatademo.service.StockService;
import io.seata.core.context.RootContext;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author HelloWoodes
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private PayService payService;

    @Autowired
    private StockService stockService;

    //@GlobalTransactional
    @Transactional
    @Override
    public OperationResponse placeOrder(PlaceOrderRequestVO placeOrderRequestVO) throws Exception {
        log.info("=============ORDER=================");
        DynamicDataSourceContextHolder.setDataSourceKey(DataSourceKey.ORDER);
        log.info("当前 XID: {}", RootContext.getXID());

        Integer amount = 1;
        Integer price = placeOrderRequestVO.getPrice();

        Order order = Order.builder().userId(placeOrderRequestVO.getUserId()).productId(
                placeOrderRequestVO.getProductId()).status(OrderStatus.INIT).payAmount(price).build();

        Integer saveOrderRecord = orderDao.saveOrder(order);

        log.info("保存订单{}", saveOrderRecord > 0 ? "成功" : "失败");

        // 扣减库存
        DynamicDataSourceContextHolder.setDataSourceKey(DataSourceKey.STOCK);
        boolean operationStockResult = stockService.reduceStock(placeOrderRequestVO.getProductId(), amount);

        // 扣减余额
        DynamicDataSourceContextHolder.setDataSourceKey(DataSourceKey.PAY);
        boolean operationBalanceResult = payService.reduceBalance(placeOrderRequestVO.getUserId(), price);

        log.info("=============ORDER=================");
        DynamicDataSourceContextHolder.setDataSourceKey(DataSourceKey.ORDER);

        Integer updateOrderRecord = orderDao.updateOrder(order.getId(), OrderStatus.SUCCESS);
        log.info("更新订单:{} {}", order.getId(), updateOrderRecord > 0 ? "成功" : "失败");

        return OperationResponse.builder().success(operationStockResult && operationBalanceResult).build();
    }
}

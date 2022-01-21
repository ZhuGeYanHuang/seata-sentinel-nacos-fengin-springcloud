package com.seatademo.service;


import com.seatademo.common.OperationResponse;
import com.seatademo.common.order.PlaceOrderRequestVO;

/**
 * @author HelloWoodes
 */
public interface OrderService {

    /**
     * 下单
     *
     * @param placeOrderRequestVO 请求参数
     * @return 下单结果
     */
    OperationResponse placeOrder(PlaceOrderRequestVO placeOrderRequestVO) throws Exception;
}

package com.zyh.order.orderseata.controller;

import com.zyh.database.util.ResultUtil;
import com.zyh.order.orderseata.entity.Order;
import com.zyh.order.orderseata.server.OrderServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <p>订单处理</p>
 *
 * @author : zyh
 **/
@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderServer orderServer;

    @PostMapping("/createOrder")
    public ResultUtil createOrder(@RequestBody Order order){
       return orderServer.createOrder(order);
    }

    @DeleteMapping("/delOrder")
    public ResultUtil delOrder(@RequestBody Order order){
        return orderServer.del(order);
    }




}

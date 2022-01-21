package com.zyh.order.orderseata.FeginServer;

import com.alibaba.fastjson.JSONObject;
import com.zyh.database.util.ResultUtil;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <p>库存服务</p>
 *
 * @author : zyh
 **/
@FeignClient(value = "seata-stock",path = "stock")
public interface StockFeginServer {

    @GetMapping("/getStock")
    ResultUtil getStock(@RequestBody JSONObject param);

    @PutMapping("/reduceStock")
    ResultUtil reduceStock(@RequestBody JSONObject param);
}

package com.zyh.order.orderseata.FeginServer;

import com.alibaba.fastjson.JSONObject;
import com.zyh.database.util.ResultUtil;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * <p>库存服务</p>
 *
 * @author : zyh
 **/
@FeignClient(value = "seata-account",path = "account")
public interface AccountFeginServer {


    @PutMapping("/reduceAccount")
    ResultUtil reduceAccount(@RequestBody JSONObject param);
}

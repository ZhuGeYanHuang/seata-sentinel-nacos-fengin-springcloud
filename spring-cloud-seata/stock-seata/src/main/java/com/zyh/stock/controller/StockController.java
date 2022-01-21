package com.zyh.stock.controller;

import com.alibaba.fastjson.JSONObject;
import com.zyh.database.util.ResultUtil;
import com.zyh.stock.server.StockServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>库存</p>
 *
 * @author : zyh
 **/
@RestController
@RequestMapping("/stock")
public class StockController {

    @Autowired
    private StockServer stockServer;


    @GetMapping("/getStock")
    public ResultUtil getStock(@RequestBody JSONObject param) {
        return stockServer.getStock(param.getLong("stockId"));
    }

    @PutMapping("/reduceStock")
    public ResultUtil reduceStock(@RequestBody JSONObject param) {
        return stockServer.reduceStock(param);
    }

}

package com.zyh.stock.server.Impl;

import com.alibaba.fastjson.JSONObject;
import com.zyh.database.util.ResultUtil;
import com.zyh.stock.dao.StockDao;
import com.zyh.stock.entity.Stock;
import com.zyh.stock.server.StockServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>库存实现类</p>
 *
 * @author : zyh
 **/
@Service
public class StockServerImpl implements StockServer {

    @Autowired
    private StockDao stockDao;

    @Override
    public ResultUtil getStock(long stockId) {
        Stock stock = stockDao.findById(stockId);
        return ResultUtil.ok(stock);
    }

    @Override
    public ResultUtil reduceStock(JSONObject param) {

        int count = param.getInteger("count");
        Long id = param.getLong("stockId");

        int upCount = stockDao.reduceStock(id, count);

        if (upCount == 0) {
            throw new RuntimeException("库存不足，更新失败！");
        }

        return ResultUtil.ok();
    }
}

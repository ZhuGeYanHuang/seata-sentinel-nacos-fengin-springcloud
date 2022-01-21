package com.zyh.stock.server;

import com.alibaba.fastjson.JSONObject;
import com.zyh.database.util.ResultUtil;

public interface StockServer {

   ResultUtil getStock(long stockId);

   ResultUtil reduceStock(JSONObject param);
}

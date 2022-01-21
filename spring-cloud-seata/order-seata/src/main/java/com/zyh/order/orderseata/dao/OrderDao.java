package com.zyh.order.orderseata.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zyh.order.orderseata.entity.Order;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface OrderDao extends BaseMapper<Order> {

    @Insert("INSERT INTO `order` (user_id, count,stock_id) VALUES (#{userId}, #{count}, #{stockId})")
    @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
    int insert(Order record);

}

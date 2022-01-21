package com.zyh.stock.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zyh.stock.entity.Stock;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

/**
 * <p>库存数据处理类</p>
 *
 * @author : zyh
 **/
@Repository
@Mapper
public interface StockDao extends BaseMapper<Stock> {

    @Update("UPDATE stock SET stock=stock-#{count} WHERE stock-#{count}>=0 AND id = #{stockId} ")
    int reduceStock(@Param("stockId")Long stockId,@Param("count")int count);

    @Select("select id, name, stock from stock WHERE id = #{stockId}")
    Stock findById(@Param("stockId")Long stockId);
}

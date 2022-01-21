package com.zyh.order.orderseata.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.zyh.order.orderseata.entity.Account;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface AccountDao extends BaseMapper<Account> {

    @Update("UPDATE `account` SET money=money-#{pay} WHERE money-#{pay}>=0 AND id = #{accountId} ")
    int reduceStock(@Param("accountId")Long userId, @Param("pay")int pay);
}

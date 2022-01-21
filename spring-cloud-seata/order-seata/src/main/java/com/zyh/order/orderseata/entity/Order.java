package com.zyh.order.orderseata.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>订单实体</p>
 *
 * @author : zyh
 **/
@Data
@Accessors(chain = true)
@TableName("order")
public class Order implements Serializable {
    @TableId(type = IdType.AUTO)
    private Long id;
    private int count;
    private long stockId;
    private long userId;
}

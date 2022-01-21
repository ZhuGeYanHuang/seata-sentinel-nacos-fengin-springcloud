package com.zyh.stock.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>库存类</p>
 *
 * @author : zyh
 **/
@Data
@Accessors(chain = true)
@TableName("stock")
public class Stock implements Serializable {
    private Long id;
    private String name;
    private int stock;
}

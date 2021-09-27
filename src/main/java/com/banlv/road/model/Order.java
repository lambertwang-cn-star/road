package com.banlv.road.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author ：Lambert Wang
 * @date ：Created in 2021/2/10 9:38
 * @description：
 * @modified By：
 * @version: 1.0.0
 */
@Data
@TableName("order")
public class Order extends BaseModel {

    /**
     * 路径ID
     */
    int roadId;


}

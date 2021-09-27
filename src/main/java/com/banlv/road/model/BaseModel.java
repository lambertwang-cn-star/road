package com.banlv.road.model;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import javax.persistence.Transient;
import lombok.Data;

import java.util.Date;

/**
 * @author ：Lambert Wang
 * @date ：Created in 2021/2/10 9:38
 * @description：
 * @modified By：
 * @version: 1.0.0
 */
@Data
public class BaseModel extends Model {
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    int id;

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    long createTime;

    /**
     * 创建人
     */
    @TableField(fill = FieldFill.INSERT)
    long creatorId;

    /**
     * 更新人
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)

    long updateId;
    /**
     * 更新时间
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    long updateTime;

    @Transient
    private Date createDate;

    @Transient
    private Date updateDate;
}

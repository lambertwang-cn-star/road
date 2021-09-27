package com.banlv.road.service.base;

import com.banlv.road.model.BaseModel;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import java.util.List;
import org.springframework.validation.annotation.Validated;

/**
 * @author ：Lambert Wang
 * @date ：Created in 2021/8/31 15:36
 * @description：
 * @modified By：
 * @version: 1.0.0
 */
@Validated
public class BaseServiceImpl<M extends BaseMapper<T>, T extends BaseModel> extends ServiceImpl<M, T> implements BaseService<T> {
    @Override
    public boolean deleteLogic(List<Long> ids){
        return super.removeByIds(ids);
    }
}

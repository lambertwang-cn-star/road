package com.banlv.road.service.base;

import com.baomidou.mybatisplus.extension.service.IService;
import java.util.List;

/**
 * @author Lambert
 * @param <T>
 */
public interface BaseService<T> extends IService<T> {
    /**
     * 逻辑删除
     *
     * @param ids id集合(逗号分隔)
     * @return boolean
     */
    boolean deleteLogic(List<Long> ids);
}

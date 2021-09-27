package com.banlv.road.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.banlv.road.model.${entity};
import com.banlv.road.dao.${entity}Mapper;


/**
   * ${tableComment} Vo
   *
   * @author {author}
   * @date {date}
   */
@Service
public class ${entity}ServiceImpl extends BaseServiceImpl<${entity}Mapper, ${entity}}> implements ${entity}Service {
    @Autowired
    private ${entity}Mapper ${entityFirstToLowerCase}Mapper;
}
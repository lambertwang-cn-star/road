package com.banlv.road.${entityToLowerCase}.controller;

import com.banlv.road.common.controller.CommonController;
import com.banlv.road.model.${entityToLowerCase}.${entity};
import com.banlv.road.service.${entityToLowerCase}.${entity}Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
   * ${tableComment} Controller
   * @author {author}
   * @date {date}
   */

@RestController
@RequestMapping("/road/${entityToLowerCase}")
public class ${entity}Controller extends CommonController<${entity}Vo, ${entity}, ${priDataType}> {
    @AutoWired
    private ${entity}Service ${entityToLowerCase}Service;

    @GetMapping("index")
    public void index {
        return;
    }
}
package com.banlv.road.model;

import lombok.Data;
import com.banlv.road.common.pojo.PageCondition
import java.io.Serializable;
import java.util.Date;

/**
   * ${tableComment} Vo
   *
   * @author {author}
   * @date {date}
   */

@Data
public class ${entity}Vno extends BaseModel implements Serializable {
    #for
        private ${tableInfo.dataType} ${tableInfo.columnName};
    #end
}
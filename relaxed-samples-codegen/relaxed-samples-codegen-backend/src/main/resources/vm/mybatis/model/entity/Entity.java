package ${packageName}.${moduleName}.model.entity;


import lombok.Data;

import java.time.LocalDateTime;


/**
 * ${comments}
 *
 * @author ${author}
 * @since ${currentTime}
 */
@Data
public class ${className} {

#foreach($column in $columns)
    /**
     * $column.comments
     */
    private $column.attrType $column.attrName;
#end
}
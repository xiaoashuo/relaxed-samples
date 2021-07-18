package ${packageName}.${moduleName}.mapper;


import ${packageName}.${moduleName}.model.entity.${className};

import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * ${comments} Mapper 接口
 * </p>
 *
 * @author ${author}
 * @since ${currentTime}
 */
public interface ${className}Mapper {
    /**
     * delete by primary key
     * @param id primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(Integer ${pk.columnName});

    /**
     * insert record to table
     * @param record the record
     * @return insert count
     */
    int insert(${className} record);


    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(${className} record);

    /**
     * select by primary key
     * @param id primary key
     * @return object by primary key
     */
    ${className} selectByPrimaryKey(Integer id);

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(${className} record);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(${className} record);



    int batchInsert(@Param("list") List<${className}> list);
}
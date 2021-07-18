package ${packageName}.${moduleName}.service;

import ${packageName}.${moduleName}.model.entity.${className};

import java.util.List;

/**
 * <p>
 * ${comments} 业务层
 * </p>
 *
 * @author ${author}
 * @since  ${currentTime}
 */
public interface ${className}Service {


      int deleteByPrimaryKey(Integer id);

      int insert(${className} record);

      int insertOrUpdate(${className} record);

      int insertOrUpdateSelective(${className} record);

      int insertSelective(${className} record);

      ${className} selectByPrimaryKey(Integer id);

      int updateByPrimaryKeySelective(${className} record);

      int updateByPrimaryKey(${className} record);

      int updateBatch(List<${className}> list);

      int updateBatchSelective(List<${className}> list);

      int batchInsert(List<${className}> list);

}

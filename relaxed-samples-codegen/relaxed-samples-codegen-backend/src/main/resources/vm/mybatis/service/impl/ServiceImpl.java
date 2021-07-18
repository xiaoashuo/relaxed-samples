package ${packageName}.${moduleName}.service.impl;

import ${packageName}.${moduleName}.mapper.${className}Mapper;
import ${packageName}.${moduleName}.service.${className}Service;
import ${packageName}.${moduleName}.model.entity.${className};

import java.util.List;

/**
 * <p>
 * ${comments} 业务层实现
 * </p>
 *
 * @author ${author}
 * @since ${currentTime}
 */
@RequiredArgsConstructor
@Service
public class ${className}ServiceImpl implements ${className}Service{

    private final  ${className}Mapper ${lowerClassName}Mapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return ${lowerClassName}Mapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(${className} record) {
        return ${lowerClassName}Mapper.insert(record);
    }

    @Override
    public int insertOrUpdate(${className} record) {
        return ${lowerClassName}Mapper.insertOrUpdate(record);
    }

    @Override
    public int insertOrUpdateSelective(${className} record) {
        return ${lowerClassName}Mapper.insertOrUpdateSelective(record);
    }

    @Override
    public int insertSelective(${className} record) {
        return ${lowerClassName}Mapper.insertSelective(record);
    }

    @Override
    public GenDataSourceConfig selectByPrimaryKey(Integer id) {
        return ${lowerClassName}Mapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(${className} record) {
        return ${lowerClassName}Mapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(${className} record) {
        return ${lowerClassName}Mapper.updateByPrimaryKey(record);
    }

    @Override
    public int updateBatch(List<${className}> list) {
        return ${lowerClassName}Mapper.updateBatch(list);
    }

    @Override
    public int updateBatchSelective(List<${className}> list) {
        return ${lowerClassName}Mapper.updateBatchSelective(list);
    }

    @Override
    public int batchInsert(List<${className}> list) {
        return ${lowerClassName}Mapper.batchInsert(list);
    }

}

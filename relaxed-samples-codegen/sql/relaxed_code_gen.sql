/*
SQLyog Enterprise v12.09 (64 bit)
MySQL - 5.7.34 : Database - relaxed_code_gen
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`relaxed_code_gen` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `relaxed_code_gen`;

/*Table structure for table `gen_data_source_config` */

DROP TABLE IF EXISTS `gen_data_source_config`;

CREATE TABLE `gen_data_source_config` (
                                          `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
                                          `name` varchar(50) DEFAULT NULL COMMENT '数据源名称',
                                          `username` varchar(50) NOT NULL COMMENT '数据库用户名',
                                          `password` varchar(100) NOT NULL COMMENT '数据库密码',
                                          `url` varchar(255) DEFAULT NULL COMMENT '数据库连接',
                                          `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
                                          `update_time` timestamp NULL DEFAULT NULL COMMENT '删除时间',
                                          PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COMMENT='数据源';

/*Data for the table `gen_data_source_config` */

insert  into `gen_data_source_config`(`id`,`name`,`username`,`password`,`url`,`create_time`,`update_time`) values (1,'national-uat','root','0tLle/4UrPjRGKNMvEF8Es2Cozrja39K','jdbc:mysql://212.129.138.160:3306/national_stamp_uat?useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai','2021-03-16 13:37:12','2021-07-12 10:59:07');

/*Table structure for table `gen_template_directory` */

DROP TABLE IF EXISTS `gen_template_directory`;

CREATE TABLE `gen_template_directory` (
                                          `id` int(11) NOT NULL AUTO_INCREMENT,
                                          `group_id` int(11) DEFAULT NULL COMMENT '模板组Id',
                                          `file_name` varchar(255) DEFAULT NULL COMMENT '文件夹路径|模板文件名称(支持占位符)',
                                          `type` tinyint(1) DEFAULT NULL COMMENT '文件类型 1:文件夹 2:模板文件',
                                          `parent_id` int(11) DEFAULT NULL COMMENT '父级Id',
                                          `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                                          `update_time` datetime DEFAULT NULL COMMENT '更新时间',
                                          PRIMARY KEY (`id`) USING BTREE,
                                          UNIQUE KEY `uk_name_parent_id` (`group_id`,`parent_id`,`file_name`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb4 COMMENT='模板文件目录项';

/*Data for the table `gen_template_directory` */

insert  into `gen_template_directory`(`id`,`group_id`,`file_name`,`type`,`parent_id`,`create_time`,`update_time`) values (1,3,'relaxed.src.main',1,0,'2021-03-18 09:02:24',NULL),(2,3,'java',1,1,'2021-03-18 09:02:58',NULL),(3,3,'resources',1,1,'2021-03-18 09:03:10',NULL),(4,3,'mapper',1,3,'2021-03-18 09:03:31',NULL),(5,3,'{packageName}.{moduleName}',1,2,'2021-03-18 09:04:13',NULL),(6,3,'controller',1,5,'2021-03-18 09:04:41',NULL),(7,3,'mapper',1,5,'2021-03-18 09:04:57',NULL),(8,3,'model',1,5,'2021-03-18 09:05:04',NULL),(9,3,'service',1,5,'2021-03-18 09:05:09',NULL),(10,3,'{className}Controller.java',2,6,'2021-03-18 09:06:57',NULL),(11,3,'{className}Mapper.java',2,7,'2021-03-18 09:07:32',NULL),(12,3,'qo',1,8,NULL,NULL),(13,3,'vo',1,8,NULL,NULL),(14,3,'dto',1,8,NULL,NULL),(15,3,'entity',1,8,NULL,NULL),(16,3,'converter',1,8,NULL,NULL),(17,3,'{className}QO.java',2,12,NULL,NULL),(18,3,'{className}VO.java',2,13,NULL,NULL),(19,3,'{className}DTO.java',2,14,NULL,NULL),(20,3,'{className}.java',2,15,NULL,NULL),(21,3,'{className}Converter.java',2,16,NULL,NULL),(22,3,'impl',1,9,NULL,NULL),(23,3,'{className}Service.java',2,9,NULL,NULL),(24,3,'{className}ServiceImpl.java',2,22,NULL,NULL),(25,3,'{className}Mapper.xml',2,4,NULL,NULL);

/*Table structure for table `gen_template_group` */

DROP TABLE IF EXISTS `gen_template_group`;

CREATE TABLE `gen_template_group` (
                                      `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
                                      `name` varchar(50) DEFAULT NULL COMMENT '名称',
                                      `remarks` varchar(255) DEFAULT NULL COMMENT '备注',
                                      `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                                      `update_time` datetime DEFAULT NULL COMMENT '修改时间',
                                      PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COMMENT='模板组';

/*Data for the table `gen_template_group` */

insert  into `gen_template_group`(`id`,`name`,`remarks`,`create_time`,`update_time`) values (3,'Relaxed项目','Relaxed个人项目','2021-03-17 13:56:14',NULL);

/*Table structure for table `gen_template_info` */

DROP TABLE IF EXISTS `gen_template_info`;

CREATE TABLE `gen_template_info` (
                                     `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
                                     `directory_id` bigint(20) DEFAULT NULL COMMENT '目录id',
                                     `group_id` int(11) DEFAULT NULL COMMENT '模板组ID',
                                     `title` varchar(50) DEFAULT NULL COMMENT '模板标题',
                                     `content` longtext COMMENT '模板内容',
                                     `engine_type` tinyint(1) DEFAULT NULL COMMENT '模板引擎类型 1velocity',
                                     `remarks` varchar(255) DEFAULT NULL COMMENT '备注',
                                     `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                                     `update_time` datetime DEFAULT NULL COMMENT '修改时间',
                                     PRIMARY KEY (`id`),
                                     UNIQUE KEY `idx_directory_id` (`directory_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COMMENT='模板信息';

/*Data for the table `gen_template_info` */

insert  into `gen_template_info`(`id`,`directory_id`,`group_id`,`title`,`content`,`engine_type`,`remarks`,`create_time`,`update_time`) values (1,20,3,'Entity','package ${packageName}.${moduleName}.model.entity;\n\nimport java.time.LocalDateTime;\n\nimport com.baomidou.mybatisplus.annotation.*;\nimport com.baomidou.mybatisplus.extension.activerecord.Model;\nimport io.swagger.annotations.ApiModel;\nimport io.swagger.annotations.ApiModelProperty;\nimport lombok.Data;\nimport lombok.EqualsAndHashCode;\nimport lombok.experimental.Accessors;\n\n/**\n * ${comments}\n *\n * @author ${author}\n * @since ${currentTime}\n */\n@ApiModel(value = \"${comments}\")\n@Data\n@EqualsAndHashCode(callSuper = true)\n@Accessors(chain = true)\n@TableName(\"${tableName}\")\npublic class ${className} extends Model<${className}> {\n\n#foreach($column in $columns)\n    /**\n     * $column.comments\n     */\n    #if($column.columnName==$pk.columnName)\n       @TableId(value=\"${column.columnName}\")\n    #elseif($column.columnName ==\'create_time\')\n       @TableField(value = \"$column.columnName\" , fill = FieldFill.INSERT)\n    #elseif($column.columnName== \'update_time\')\n       @TableField(value = \"$column.columnName\" , fill = FieldFill.INSERT_UPDATE)\n    #end\n    @ApiModelProperty(value = \"$column.comments\")\n    private $column.attrType $column.attrName;\n#end\n\n}\n\n',1,'实体类Entity','2021-03-17 16:29:44',NULL),(3,11,3,'Mapper','package ${packageName}.${moduleName}.mapper;\n\nimport ${packageName}.${moduleName}.model.entity.${className};\n\nimport com.relaxed.extend.mybatis.plus.mapper.ExtendMapper;\n\n/**\n * <p>\n * ${comments} Mapper 接口\n * </p>\n *\n * @author ${author}\n * @since ${currentTime}\n */\npublic interface ${className}Mapper extends ExtendMapper<${className}> {\n\n}\n',1,'Mapper','2021-03-17 17:46:53',NULL),(4,25,3,'Mapper.xml','<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n<!DOCTYPE mapper PUBLIC \"-//mybatis.org//DTD Mapper 3.0//EN\" \"http://mybatis.org/dtd/mybatis-3-mapper.dtd\">\r\n<mapper namespace=\"${packageName}.${moduleName}.mapper.${className}Mapper\">\r\n  <resultMap id=\"${lowerClassName}Map\" type=\"${packageName}.${moduleName}.model.entity.${className}\">\r\n    #foreach($column in $columns)\r\n      #if($column.attrName==$pk.attrName)\r\n        <id property=\"${pk.attrName}\" column=\"${pk.columnName}\"/>\r\n      #else\r\n        <result property=\"${column.attrName}\" column=\"${column.columnName}\"/>\r\n      #end\r\n    #end\r\n  </resultMap>\r\n</mapper>',1,'Mybatis Mapper Xml','2021-03-17 17:52:37',NULL),(5,23,3,'Service','package ${packageName}.${moduleName}.service;\n\nimport ${packageName}.${moduleName}.model.dto.${className}DTO;\nimport ${packageName}.${moduleName}.model.vo.${className}VO;\nimport ${packageName}.${moduleName}.model.entity.${className};\n\nimport com.relaxed.extend.mybatis.plus.service.ExtendService;\nimport com.relaxed.common.core.domain.PageParam;\nimport com.relaxed.common.core.domain.PageResult;\n\n/**\n * <p>\n * ${comments} 业务层 \n * </p>\n *\n * @author ${author}\n * @since  ${currentTime}\n */\npublic interface ${className}Service extends ExtendService<${className}> {\n\n    /**\n     * 分页查询\n     * @param pageParam {@link PageParam}\n     * @param ${lowerClassName}QO {@link ${className}QO}\n     * @return {@link PageResult<${className}VO>}\n     */\n    PageResult<${className}VO> selectByPage(PageParam pageParam, ${className}QO ${lowerClassName}QO);\n        \n}',1,'业务层接口Service','2021-03-17 18:03:52',NULL),(6,24,3,'ServiceImpl','package ${packageName}.${moduleName}.service.impl;\n\n\nimport cn.hutool.core.util.ObjectUtil;\nimport com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;\nimport com.baomidou.mybatisplus.core.metadata.IPage;\nimport com.baomidou.mybatisplus.core.toolkit.Wrappers;\nimport com.relaxed.extend.mybatis.plus.service.impl.ExtendServiceImpl;\n\nimport ${packageName}.${moduleName}.mapper.${className}Mapper;\nimport ${packageName}.${moduleName}.service.${className}Service;\nimport ${packageName}.${moduleName}.model.dto.${className}DTO;\nimport ${packageName}.${moduleName}.model.entity.${className};\nimport ${packageName}.${moduleName}.model.vo.${className}VO;\nimport ${packageName}.${moduleName}.model.converter.${className}Converter;\nimport com.relaxed.common.core.domain.PageParam;\nimport com.relaxed.common.core.domain.PageResult;\nimport com.relaxed.extend.mybatis.plus.toolkit.PageUtil;\nimport lombok.RequiredArgsConstructor;\nimport org.springframework.stereotype.Service;\n\n/**\n * <p>\n * ${comments} 业务层实现\n * </p>\n *\n * @author ${author}\n * @since ${currentTime}\n */\n@RequiredArgsConstructor\n@Service\npublic class ${className}ServiceImpl extends ExtendServiceImpl<${className}Mapper, ${className}> implements ${className}Service {\n\n    @Override\n    public PageResult<${className}VO> selectByPage(PageParam pageParam, ${className}QO ${lowerClassName}QO) {\n        IPage<${className}> page = PageUtil.prodPage(pageParam);\n        LambdaQueryWrapper<${className}> wrapper = Wrappers.lambdaQuery(${className}.class)\n            .eq(ObjectUtil.isNotNull(${lowerClassName}QO.getId()),${className}::getId, ${lowerClassName}QO.getId());\n        this.baseMapper.selectPage(page,wrapper);\r\n        IPage<${className}VO> pageVo = page.convert(${className}Converter.INSTANCE::poToVo);\n        return new PageResult<>(pageVo.getRecords(),pageVo.getTotal());\n    }\n\n}\n',1,'业务层接口实现Service','2021-03-17 18:15:58',NULL),(7,10,3,'Controller','package ${packageName}.${moduleName}.controller;\n\n\nimport ${packageName}.${moduleName}.model.entity.${className};\nimport ${packageName}.${moduleName}.model.qo.${className}QO;\nimport ${packageName}.${moduleName}.model.vo.${className}VO;\n\nimport ${packageName}.${moduleName}.service.${className}Service;\n\nimport com.relaxed.common.core.domain.PageParam;\nimport com.relaxed.common.core.domain.PageResult;\nimport com.relaxed.common.core.result.BaseResultCode;\nimport com.relaxed.common.core.result.R;\nimport io.swagger.annotations.Api;\nimport io.swagger.annotations.ApiOperation;\nimport lombok.RequiredArgsConstructor;\nimport org.springframework.web.bind.annotation.*;\n\n/**\n * <p>\n * ${comments} 控制器\n * </p>\n *\n * @author ${author}\n * @since ${currentTime}\n */\n@RequiredArgsConstructor\n@RestController\n@RequestMapping\n@Api( tags = \"${comments}\")\npublic class ${className}Controller {\n\n    private final ${className}Service ${lowerClassName}Service;\n\n     /**\n      * 分页查询\n      * @param pageParam {@link PageParam} 分页参数\n      * @param ${lowerClassName}QO {@link ${className}QO} 查询条件\n      * @return @{code R<PageResult<${className}VO>>} 通用返回体\n      */\n      @ApiOperation(value = \"分页查询\", notes = \"分页查询\")\n      @GetMapping(\"/page\" )\n      public R<PageResult<${className}VO>> page(PageParam pageParam, ${className}QO ${lowerClassName}QO) {\n          return R.ok(${lowerClassName}Service.selectByPage(pageParam, ${lowerClassName}QO));\n      }\n \n\n     /**\n      * 新增数据\n      * @param ${lowerClassName} {@link ${className}} 数据参数\n      * @return {@code R<?>} 通用返回体\n      */\n     @ApiOperation(value = \"新增数据\", notes = \"新增数据\")\n     @PostMapping\n     public R<?> save(@RequestBody ${className} ${lowerClassName}) {\n      return ${lowerClassName}Service.save(${lowerClassName}) ?\n              R.ok() : R.failed(BaseResultCode.UPDATE_DATABASE_ERROR, \"新增数据失败\");\n     }\n\n\n    /**\n     * 更新数据\n     * @param ${lowerClassName} {@link ${className}} 更新数据\n     * @return {@code R<?>}通用返回体\n     */\n    @ApiOperation(value = \"更新数据\", notes = \"更新数据\")\n    @PutMapping\n    public R<?> updateById(@RequestBody ${className} ${lowerClassName}) {\n        return ${lowerClassName}Service.updateById(${lowerClassName}) ?\n            R.ok() : R.failed(BaseResultCode.UPDATE_DATABASE_ERROR, \"更新数据失败\");\n    }\n\n    /**\n     * 根据${pk.attrName}删除数据\n     * @param ${pk.attrName} {@code ${pk.attrName}} ${pk.attrName}\n     * @return {@code R<?>} 通用返回体\n     */\n    @ApiOperation(value = \"根据${pk.attrName}删除数据\", notes = \"根据${pk.attrName}删除数据\")\n    @DeleteMapping(\"/{${pk.attrName}}\" )\n    public R<?> removeById(@PathVariable ${pk.attrType} ${pk.attrName}) {\n        return ${lowerClassName}Service.removeById(${pk.attrName}) ?\n               R.ok() : R.failed(BaseResultCode.UPDATE_DATABASE_ERROR, \"根据${pk.attrName}删除数据失败\");\n    } \n        \n}\n',1,'控制器Controller','2021-03-17 18:39:15',NULL),(8,17,3,'QO','package ${packageName}.${moduleName}.model.qo;\n\nimport java.io.Serializable;\n\n\nimport io.swagger.annotations.ApiModel;\nimport io.swagger.annotations.ApiModelProperty;\nimport lombok.Data;\nimport lombok.experimental.Accessors;\n\n/**\n * ${comments} 查询对象\n *\n * @author ${author}\n * @since ${currentTime}\n */\n@ApiModel(value = \"${comments}\")\n@Data\n@Accessors(chain = true)\npublic class ${className}QO implements Serializable {\n\n#foreach($column in $columns)\n   \n    #if($column.columnName==$pk.columnName)\r\n     /**\r\n      * $column.comments\r\n      */\n     @ApiModelProperty(value = \"$column.comments\")\n     private $column.attrType $column.attrName;\n    #end\n#end\n\n}\n\n',1,'查询条件QO','2021-03-17 18:46:31',NULL),(9,18,3,'VO','package ${packageName}.${moduleName}.model.vo;\n\nimport java.time.LocalDateTime;\nimport java.io.Serializable;\n\n\nimport io.swagger.annotations.ApiModel;\nimport io.swagger.annotations.ApiModelProperty;\nimport lombok.Data;\n\nimport lombok.experimental.Accessors;\n\n/**\n * ${comments} 视图层\n *\n * @author ${author}\n * @since ${currentTime}\n */\n@ApiModel(value = \"${comments}\")\n@Data\n@Accessors(chain = true)\npublic class ${className}VO implements Serializable  {\n\n#foreach($column in $columns)\n    /**\n     * $column.comments\n     */\n    @ApiModelProperty(value = \"$column.comments\")\n    private $column.attrType $column.attrName;\n#end\n\n}\n\n',1,'视图展示VO','2021-03-17 18:50:03',NULL),(10,21,3,'Converter','package ${packageName}.${moduleName}.model.converter;\n\nimport ${packageName}.${moduleName}.model.dto.${className}DTO;\nimport ${packageName}.${moduleName}.model.entity.${className};\nimport ${packageName}.${moduleName}.model.vo.${className}VO;\n\nimport org.mapstruct.Mapper;\nimport org.mapstruct.factory.Mappers;\n\nimport java.util.List;\n\n/**\n * <p>\n * ${comments} 转换器\n * </p>\n *\n * @author ${author}\n * @since ${currentTime}\n */\n@Mapper\npublic interface ${className}Converter {\n\n    ${className}Converter INSTANCE= Mappers.getMapper(${className}Converter.class);\n\n    /**\n     * po -> vo\n     * @param ${lowerClassName} {@link ${className}}\n     * @return {@link ${className}VO}\n     */\n    ${className}VO poToVo(${className} ${lowerClassName});\n\n    /**\n     * dto -> po\n     * @param ${lowerClassName}DTO {@link ${className}DTO}\n     * @return {@link ${className}}\n     */\n    ${className} dtoToPo(${className}DTO ${lowerClassName}DTO);\n\n    /**\n     * po -> vos\n     * @param ${lowerClassName}Properties {@link List<${className}>}\n     * @return  {@link  List<${className}VO>}\n     */\n     List<${className}VO> poToVOs(List<${className}> ${lowerClassName}Properties);\n            \n}\n',1,'Mapper Struct转换器','2021-03-17 18:56:38',NULL),(11,19,3,'DTO','package ${packageName}.${moduleName}.model.dto;\n\nimport java.time.LocalDateTime;\nimport java.io.Serializable;\n\nimport io.swagger.annotations.ApiModel;\nimport io.swagger.annotations.ApiModelProperty;\nimport lombok.Data;\n\nimport lombok.experimental.Accessors;\n\n/**\n * ${comments} 数据传输对象\n *\n * @author ${author}\n * @since ${currentTime}\n */\n@ApiModel(value = \"${comments}\")\n@Data\n@Accessors(chain = true)\npublic class ${className}DTO implements Serializable  {\n\n#foreach($column in $columns)\n    /**\n     * $column.comments\n     */\n    @ApiModelProperty(value = \"$column.comments\")\n    private $column.attrType $column.attrName;\n#end\n\n}\n\n',1,'数据传输对象DTO','2021-03-17 18:59:03',NULL);

/*Table structure for table `gen_template_property` */

DROP TABLE IF EXISTS `gen_template_property`;

CREATE TABLE `gen_template_property` (
                                         `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
                                         `group_id` int(11) DEFAULT NULL COMMENT '模板组ID',
                                         `title` varchar(50) DEFAULT NULL COMMENT '标题',
                                         `prop_key` varchar(50) DEFAULT NULL COMMENT '属性键',
                                         `default_value` varchar(255) DEFAULT NULL COMMENT '默认值',
                                         `required` tinyint(1) DEFAULT NULL COMMENT '必填,1:是,0:否',
                                         `remarks` varchar(255) DEFAULT NULL COMMENT '备注信息',
                                         `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                                         `update_time` datetime DEFAULT NULL COMMENT '修改时间',
                                         PRIMARY KEY (`id`) USING BTREE,
                                         UNIQUE KEY `uk_group_id_prop_key` (`group_id`,`prop_key`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COMMENT='模板属性配置';

/*Data for the table `gen_template_property` */

insert  into `gen_template_property`(`id`,`group_id`,`title`,`prop_key`,`default_value`,`required`,`remarks`,`create_time`,`update_time`) values (1,3,'包名','packageName','com.relaxed',1,'包名','2021-03-17 15:18:48',NULL),(2,3,'作者','author','Yakir',1,'作者','2021-03-17 15:19:43',NULL),(3,3,'模块名','moduleName','',1,'模块名','2021-03-17 15:20:23',NULL);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

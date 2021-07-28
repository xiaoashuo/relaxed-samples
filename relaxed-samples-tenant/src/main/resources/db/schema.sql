-- 主库 统一租户配置
CREATE DATABASE `relaxed` /*!40100 DEFAULT CHARACTER SET utf8mb4 */
-- 租户数据源配置
CREATE TABLE `tenant_data_source_config` (
      `id` INT(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
      `name` VARCHAR(50) DEFAULT NULL COMMENT '数据源名称',
      `username` VARCHAR(50) NOT NULL COMMENT '数据库用户名',
      `password` VARCHAR(100) NOT NULL COMMENT '数据库密码',
      `url` VARCHAR(255) DEFAULT NULL COMMENT '数据库连接',
      `create_time` TIMESTAMP NULL DEFAULT NULL COMMENT '创建时间',
      `update_time` TIMESTAMP NULL DEFAULT NULL COMMENT '删除时间',
      PRIMARY KEY (`id`) USING BTREE
) ENGINE=INNODB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8mb4 COMMENT='数据源';
-- 租户配置  主要配置 schema  若启用共享schema 租户列也可以在这配置  我这里租户列直接代码写死
CREATE TABLE `tenant_config` (
                                 `id` INT(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
                                 tenant_name VARCHAR(50) COMMENT'租户名称',
                                 tenant_schema VARCHAR(50) COMMENT '数据库名称',
                                 PRIMARY KEY (`id`) USING BTREE
) ENGINE=INNODB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8mb4 COMMENT='租户配置';
-- 创建租户1 数据库
CREATE DATABASE `relaxed_bj` /*!40100 DEFAULT CHARACTER SET utf8mb4 */
CREATE TABLE `address` (
                           `id` BIGINT(20) NOT NULL COMMENT '主键ID',
                           `user_id` BIGINT(20) NOT NULL COMMENT 'user.id',
                           `address_name` VARCHAR(30) DEFAULT NULL COMMENT '地址名称',
                           PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8mb4;



CREATE TABLE `t_user` (
                          `id` BIGINT(20) NOT NULL COMMENT '主键ID',
                          `username` VARCHAR(30) DEFAULT NULL COMMENT '姓名',
                          `tenant_id` BIGINT(20) NOT NULL COMMENT '租户id',
                          PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8mb4;


-- 创建租户2 数据库
CREATE DATABASE `relaxed_sh` /*!40100 DEFAULT CHARACTER SET utf8mb4 */

CREATE TABLE `address` (
         `id` BIGINT(20) NOT NULL COMMENT '主键ID',
         `user_id` BIGINT(20) NOT NULL COMMENT 'user.id',
         `address_name` VARCHAR(30) DEFAULT NULL COMMENT '地址名称',
         PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8mb4;



CREATE TABLE `t_user` (
          `id` BIGINT(20) NOT NULL COMMENT '主键ID',
          `username` VARCHAR(30) DEFAULT NULL COMMENT '姓名',
          `tenant_id` BIGINT(20) NOT NULL COMMENT '租户id',
          PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8mb4;






CREATE DATABASE `relaxed` /*!40100 DEFAULT CHARACTER SET utf8mb4 */

CREATE TABLE `address` (
                           `id` BIGINT(20) NOT NULL COMMENT '主键ID',
                           `user_id` BIGINT(20) NOT NULL COMMENT 'user.id',
                           `address_name` VARCHAR(30) DEFAULT NULL COMMENT '地址名称',
                           PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8mb4



CREATE TABLE `t_user` (
                          `id` BIGINT(20) NOT NULL COMMENT '主键ID',
                          `username` VARCHAR(30) DEFAULT NULL COMMENT '姓名',
                          `tenant_id` BIGINT(20) NOT NULL COMMENT '租户id',
                          PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8mb4

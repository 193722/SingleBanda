/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50717
Source Host           : 127.0.0.1:3306
Source Database       : banda

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2017-11-26 14:47:51
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user_details
-- ----------------------------
DROP TABLE IF EXISTS `user_details`;
CREATE TABLE `user_details` (
  `id` bigint(24) NOT NULL AUTO_INCREMENT COMMENT '主键，自增',
  `user_id` varchar(20) NOT NULL COMMENT '用户编号',
  `real_name` varchar(20) DEFAULT NULL COMMENT '真实姓名',
  `phone` varchar(11) DEFAULT NULL COMMENT '绑定手机号',
  `email` varchar(65) DEFAULT NULL COMMENT '绑定邮件',
  `birth_date` datetime DEFAULT NULL COMMENT '出生日期',
  `nationality` varchar(20) DEFAULT NULL COMMENT '国籍',
  `province` varchar(65) DEFAULT NULL COMMENT '省份',
  `city` varchar(65) DEFAULT NULL COMMENT '城市',
  `address` varchar(255) DEFAULT NULL COMMENT '详细地址',
  `sex` char(1) DEFAULT 'N' COMMENT '性别：{M:男 F:女 N:未知}',
  `head_img` varchar(255) DEFAULT NULL COMMENT '显示头像',
  `raw_add_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `raw_update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uniq_user_id` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户详细信息表';

-- ----------------------------
-- Records of user_details
-- ----------------------------

-- ----------------------------
-- Table structure for user_info
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info` (
  `id` varchar(24) NOT NULL COMMENT '用户编号，主键',
  `name` varchar(25) DEFAULT NULL COMMENT '用户昵称',
  `login_name` varchar(50) NOT NULL COMMENT '用户登录名',
  `login_password` varchar(64) NOT NULL COMMENT '用户登录密码',
  `status` char(10) NOT NULL DEFAULT 'NORMAL' COMMENT '用户状态：{NORAML：正常，DISABLE：冻结，DELETE：删除}',
  `login_status` char(10) DEFAULT 'OFF' COMMENT '登录状态：{OFF：离线，ON：在线}',
  `register_time` datetime NOT NULL COMMENT '注册时间',
  `raw_add_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `raw_update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uniq_login_name` (`login_name`) COMMENT '用户登录名唯一'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户注册信息表';

-- ----------------------------
-- Records of user_info
-- ----------------------------

-- ----------------------------
-- Table structure for user_log
-- ----------------------------
DROP TABLE IF EXISTS `user_log`;
CREATE TABLE `user_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(24) DEFAULT NULL,
  `ip` varchar(45) DEFAULT NULL COMMENT '用户登录IP地址',
  `ip_address` varchar(128) DEFAULT NULL COMMENT '解析IP地址',
  `raw_add_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `raw_update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_log
-- ----------------------------

-- ----------------------------
-- Table structure for user_portrait
-- ----------------------------
DROP TABLE IF EXISTS `user_portrait`;
CREATE TABLE `user_portrait` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(24) DEFAULT NULL COMMENT '用户编号',
  `head_img` varchar(255) DEFAULT NULL COMMENT '使用头像信息',
  `raw_add_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `raw_update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户头像使用信息表';

-- ----------------------------
-- Records of user_portrait
-- ----------------------------

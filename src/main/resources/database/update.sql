CREATE TABLE `sys_region` (
  `region_id` varchar(6) NOT NULL COMMENT '区域编码',
  `parent_id` varchar(6) NOT NULL COMMENT '父地域编码',
  `name` varchar(64) NOT NULL COMMENT '地域名称',
  `merger_name` varchar(128) NOT NULL COMMENT '地域组合名称',
  `short_name` varchar(64) NOT NULL COMMENT '简称',
  `merger_short_name` varchar(128) NOT NULL COMMENT '地域组合简称',
  `level_type` varchar(2) NOT NULL COMMENT '地域等级',
  `city_code` varchar(6) DEFAULT NULL COMMENT '城市编码',
  `zip_code` varchar(6) DEFAULT NULL COMMENT '邮编',
  `pinyin` varchar(32) DEFAULT NULL COMMENT '拼音',
  `jianpin` varchar(16) DEFAULT NULL COMMENT '简拼',
  `first_char` char(1) NOT NULL COMMENT '首字母',
  `lng` varchar(32) DEFAULT NULL COMMENT '经度',
  `lat` varchar(32) DEFAULT NULL COMMENT '纬度',
  `remarks` varchar(128) DEFAULT NULL COMMENT '备注',
  `raw_add_time` datetime DEFAULT NULL,
  `raw_update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`region_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='中国地域信息';

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

CREATE TABLE `user_info` (
  `id` varchar(24) NOT NULL COMMENT '用户编号，主键',
  `name` varchar(25) DEFAULT NULL COMMENT '用户昵称',
  `login_name` varchar(50) NOT NULL COMMENT '用户登录名',
  `login_password` varchar(64) NOT NULL COMMENT '用户登录密码',
  `status` char(10) NOT NULL DEFAULT 'NORMAL' COMMENT '用户状态：{NORAML：正常，DISABLE：冻结，DELETE：删除}',
  `login_status` char(10) DEFAULT 'OFF' COMMENT '登录状态：{OFF：离线，ON：在线}',
  `login_fail_number` int(2) NOT NULL DEFAULT '0' COMMENT '登录错误次数',
  `register_time` datetime NOT NULL COMMENT '注册时间',
  `raw_add_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `raw_update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uniq_login_name` (`login_name`) COMMENT '用户登录名唯一'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户注册信息表';

CREATE TABLE `user_portrait` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(24) DEFAULT NULL COMMENT '用户编号',
  `head_img` varchar(255) DEFAULT NULL COMMENT '使用头像信息',
  `raw_add_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `raw_update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户头像使用信息表';


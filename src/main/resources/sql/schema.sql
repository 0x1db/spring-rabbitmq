#用户表
DROP TABLE IF EXISTS sys_user;
CREATE TABLE sys_user
(
    id          INT(11)     NOT NULL AUTO_INCREMENT COMMENT 'ID',
    nick_name   varchar(64) COMMENT '用户昵称',
    username    varchar(64) NOT NULL UNIQUE COMMENT '用户账号',
    password    varchar(64) NOT NULL COMMENT '密码',
    sex         CHAR(2) COMMENT '性别',
    age         INT(3) COMMENT '年龄',
    email       VARCHAR(64) COMMENT '邮箱',
    address     VARCHAR(128) COMMENT '地址',
    id_card     VARCHAR(18) UNIQUE COMMENT '身份证号',
    phone       VARCHAR(12) UNIQUE COMMENT '联系方式',
    create_date DATETIME COMMENT '创建时间',
    modify_date DATETIME comment '修改时间',
    del_flag    BIT DEFAULT 0 COMMENT '删除标识 1：删除 0：正常',
    PRIMARY KEY (`id`)
) ENGINE = InNoDB
  AUTO_INCREMENT = 1000
  DEFAULT CHARSET = utf8 COMMENT ='用户信息表';

#角色表
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`
(
    id          bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
    name        varchar(20)  DEFAULT NULL COMMENT '名称',
    flag        varchar(20)  DEFAULT NULL COMMENT '标识',
    description varchar(100) DEFAULT NULL COMMENT '描述',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1000
  DEFAULT CHARSET = utf8 COMMENT ='角色表';
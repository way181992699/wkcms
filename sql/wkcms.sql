/*
Navicat MySQL Data Transfer

Source Server         : MySQL3306
Source Server Version : 50536
Source Host           : localhost:3306
Source Database       : wkcms

Target Server Type    : MYSQL
Target Server Version : 50536
File Encoding         : 65001

Date: 2017-07-26 10:35:27
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sys_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_permission`;
CREATE TABLE `sys_permission` (
  `permission_id` bigint(20) NOT NULL,
  `permission_name` varchar(50) NOT NULL,
  `create_uid` bigint(20) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  PRIMARY KEY (`permission_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_permission
-- ----------------------------

-- ----------------------------
-- Table structure for sys_permissionrole
-- ----------------------------
DROP TABLE IF EXISTS `sys_permissionrole`;
CREATE TABLE `sys_permissionrole` (
  `prid` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `permission_id` bigint(20) NOT NULL COMMENT '权限id',
  `role_id` bigint(20) NOT NULL COMMENT '角色id',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`prid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_permissionrole
-- ----------------------------

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `rid` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '角色id',
  `role_name` varchar(50) NOT NULL COMMENT '角色名称',
  `create_uid` bigint(20) DEFAULT NULL COMMENT '创建角色用户id',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `modify_uid` bigint(20) DEFAULT NULL COMMENT '修改角色用户id',
  `modify_date` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`rid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role
-- ----------------------------

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `uid` bigint(20) NOT NULL,
  `user_name` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `sex` int(1) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `last_updaet_time` datetime DEFAULT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', 'admin', 'admin', '1', '2017-07-20', '2017-07-20 17:32:30', null);
INSERT INTO `sys_user` VALUES ('2', 'admin', 'admin', '1', '2017-07-20', '2017-07-20 17:36:25', null);
INSERT INTO `sys_user` VALUES ('3', 'admin', 'admin', '1', '2017-07-21', '2017-07-21 10:38:16', null);

-- ----------------------------
-- Table structure for sys_userrole
-- ----------------------------
DROP TABLE IF EXISTS `sys_userrole`;
CREATE TABLE `sys_userrole` (
  `urid` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `uid` bigint(20) NOT NULL COMMENT '用户id',
  `rid` bigint(20) NOT NULL COMMENT '角色id',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`urid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_userrole
-- ----------------------------

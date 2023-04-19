/*
 Navicat Premium Data Transfer

 Source Server         : local
 Source Server Type    : MySQL
 Source Server Version : 80032
 Source Host           : localhost:3306
 Source Schema         : db_admin

 Target Server Type    : MySQL
 Target Server Version : 80032
 File Encoding         : 65001

 Date: 19/04/2023 23:12:23
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
  `pid` bigint DEFAULT NULL COMMENT '上级ID，一级菜单为0',
  `name` varchar(200) DEFAULT NULL COMMENT '菜单名称',
  `url` varchar(200) DEFAULT NULL COMMENT '菜单URL',
  `authority` varchar(500) DEFAULT NULL COMMENT '授权标识(多个用逗号分隔，如：sys:menu:list,sys:menu:save)',
  `type` tinyint DEFAULT NULL COMMENT '类型   0：菜单   1：按钮   2：接口',
  `open_style` tinyint DEFAULT NULL COMMENT '打开方式   0：内部   1：外部',
  `icon` varchar(50) DEFAULT NULL COMMENT '菜单图标',
  `sort` int DEFAULT NULL COMMENT '排序',
  `deleted` tinyint DEFAULT NULL COMMENT '删除标识  0：正常   1：已删除',
  `creator` bigint DEFAULT NULL COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `updater` bigint DEFAULT NULL COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `idx_pid` (`pid`)
) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='菜单管理';

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
BEGIN;
INSERT INTO `sys_menu` VALUES (1, 0, '系统设置', NULL, NULL, 0, 0, 'icon-setting', 1, 0, 10000, '2023-04-09 17:33:13', 10000, '2023-04-09 17:33:13');
INSERT INTO `sys_menu` VALUES (2, 1, '菜单管理', 'sys/menu/index', NULL, 0, 0, 'icon-menu', 0, 0, 10000, '2023-04-09 17:33:13', 10000, '2023-04-09 17:33:13');
INSERT INTO `sys_menu` VALUES (3, 2, '查看', '', 'sys:menu:list', 1, 0, '', 0, 0, 10000, '2023-04-09 17:33:13', 10000, '2023-04-09 17:33:13');
INSERT INTO `sys_menu` VALUES (4, 2, '新增', '', 'sys:menu:save', 1, 0, '', 1, 0, 10000, '2023-04-09 17:33:13', 10000, '2023-04-09 17:33:13');
INSERT INTO `sys_menu` VALUES (5, 2, '修改', '', 'sys:menu:update,sys:menu:info', 1, 0, '', 2, 0, 10000, '2023-04-09 17:33:13', 10000, '2023-04-09 17:33:13');
INSERT INTO `sys_menu` VALUES (6, 2, '删除', '', 'sys:menu:delete', 1, 0, '', 3, 0, 10000, '2023-04-09 17:33:13', 10000, '2023-04-09 17:33:13');
INSERT INTO `sys_menu` VALUES (7, 0, '权限管理', '', '', 0, 0, 'icon-safetycertificate', 0, 0, 10000, '2023-04-09 17:33:13', 10000, '2023-04-09 17:33:13');
INSERT INTO `sys_menu` VALUES (8, 7, '角色管理', 'sys/role/index', '', 0, 0, 'icon-team', 3, 0, 10000, '2023-04-09 17:33:13', 10000, '2023-04-09 17:33:13');
INSERT INTO `sys_menu` VALUES (9, 8, '查询', '', 'sys:role:page', 1, 0, '', 0, 0, 10000, '2023-04-09 17:33:13', 10000, '2023-04-09 17:33:13');
INSERT INTO `sys_menu` VALUES (10, 8, '新增', '', 'sys:role:save,sys:role:menu,sys:org:list', 1, 0, '', 1, 0, 10000, '2023-04-09 17:33:13', 10000, '2023-04-09 17:33:13');
INSERT INTO `sys_menu` VALUES (11, 8, '修改', '', 'sys:role:update,sys:role:info,sys:role:menu,sys:org:list,sys:user:page', 1, 0, '', 2, 0, 10000, '2023-04-09 17:33:13', 10000, '2023-04-09 17:33:13');
INSERT INTO `sys_menu` VALUES (12, 8, '删除', '', 'sys:role:delete', 1, 0, '', 3, 0, 10000, '2023-04-09 17:33:13', 10000, '2023-04-09 17:33:13');
INSERT INTO `sys_menu` VALUES (13, 7, '用户管理', 'sys/user/index', '', 0, 0, 'icon-user', 0, 0, 10000, '2023-04-09 17:33:13', 10000, '2023-04-09 17:33:13');
INSERT INTO `sys_menu` VALUES (14, 13, '查询', '', 'sys:user:page', 1, 0, '', 0, 0, 10000, '2023-04-09 17:33:13', 10000, '2023-04-09 17:33:13');
INSERT INTO `sys_menu` VALUES (15, 13, '新增', '', 'sys:user:save,sys:role:list', 1, 0, '', 1, 0, 10000, '2023-04-09 17:33:13', 10000, '2023-04-09 17:33:13');
INSERT INTO `sys_menu` VALUES (16, 13, '修改', '', 'sys:user:update,sys:user:info,sys:role:list', 1, 0, '', 2, 0, 10000, '2023-04-09 17:33:13', 10000, '2023-04-09 17:33:13');
INSERT INTO `sys_menu` VALUES (17, 13, '删除', '', 'sys:user:delete', 1, 0, '', 3, 0, 10000, '2023-04-09 17:33:13', 10000, '2023-04-09 17:33:13');
INSERT INTO `sys_menu` VALUES (18, 13, '导入', '', 'sys:user:import', 1, 0, '', 4, 0, 10000, '2023-04-09 17:33:13', 10000, '2023-04-09 17:33:13');
INSERT INTO `sys_menu` VALUES (19, 13, '导出', '', 'sys:user:export', 1, 0, '', 5, 0, 10000, '2023-04-09 17:33:13', 10000, '2023-04-09 17:33:13');
INSERT INTO `sys_menu` VALUES (20, 0, '接口文档', '{{apiUrl}}/doc.html', NULL, 0, 1, 'icon-file-text-fill', 10, 0, 10000, '2023-04-09 17:33:13', 10000, '2023-04-09 17:33:13');
INSERT INTO `sys_menu` VALUES (21, 0, '商品管理', 'goods/index', NULL, 0, 0, 'icon-menu', 0, 0, 10000, '2023-04-18 20:12:43', 10000, '2023-04-18 20:12:49');
INSERT INTO `sys_menu` VALUES (22, 0, '订单管理', 'order/index', NULL, 0, 0, 'icon-menu', 0, 0, 10000, '2023-04-18 20:13:26', 10000, '2023-04-18 20:13:31');
COMMIT;

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(50) DEFAULT NULL COMMENT '角色名称',
  `remark` varchar(100) DEFAULT NULL COMMENT '备注',
  `deleted` tinyint DEFAULT NULL COMMENT '删除标识  0：正常   1：已删除',
  `creator` bigint DEFAULT NULL COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `updater` bigint DEFAULT NULL COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='角色管理';

-- ----------------------------
-- Records of sys_role
-- ----------------------------
BEGIN;
INSERT INTO `sys_role` VALUES (1, '超级管理员', '超级管理员', 0, NULL, '2023-04-09 18:02:31', NULL, '2023-04-09 18:02:31');
INSERT INTO `sys_role` VALUES (2, '销售管理员', '销售管理员', 0, 10000, '2023-04-18 19:30:54', 10000, '2023-04-18 19:30:59');
INSERT INTO `sys_role` VALUES (3, '仓储管理员', '仓储管理员', 0, 10000, '2023-04-18 19:39:30', 10000, '2023-04-18 19:39:35');
INSERT INTO `sys_role` VALUES (4, '普通员工', '普通员工', 0, 10000, '2023-04-18 20:15:31', 10000, '2023-04-18 20:15:35');
COMMIT;

-- ----------------------------
-- Table structure for sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
  `role_id` bigint DEFAULT NULL COMMENT '角色ID',
  `menu_id` bigint DEFAULT NULL COMMENT '菜单ID',
  `deleted` tinyint DEFAULT NULL COMMENT '删除标识  0：正常   1：已删除',
  `creator` bigint DEFAULT NULL COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `updater` bigint DEFAULT NULL COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `idx_role_id` (`role_id`),
  KEY `idx_menu_id` (`menu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='角色菜单关系';

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------
BEGIN;
INSERT INTO `sys_role_menu` VALUES (1, 1, 1, 0, 10000, '2023-04-09 18:02:02', 10000, '2023-04-09 18:02:12');
INSERT INTO `sys_role_menu` VALUES (2, 1, 2, 0, 10000, '2023-04-09 18:02:02', 10000, '2023-04-09 18:02:12');
INSERT INTO `sys_role_menu` VALUES (3, 1, 3, 0, 10000, '2023-04-09 18:02:02', 10000, '2023-04-09 18:02:12');
INSERT INTO `sys_role_menu` VALUES (4, 1, 4, 0, 10000, '2023-04-09 18:02:02', 10000, '2023-04-09 18:02:12');
INSERT INTO `sys_role_menu` VALUES (5, 1, 5, 0, 10000, '2023-04-09 18:02:02', 10000, '2023-04-09 18:02:12');
INSERT INTO `sys_role_menu` VALUES (6, 1, 6, 0, 10000, '2023-04-09 18:02:02', 10000, '2023-04-09 18:02:12');
INSERT INTO `sys_role_menu` VALUES (7, 1, 7, 0, 10000, '2023-04-09 18:02:02', 10000, '2023-04-09 18:02:12');
INSERT INTO `sys_role_menu` VALUES (8, 1, 8, 0, 10000, '2023-04-09 18:02:02', 10000, '2023-04-09 18:02:12');
INSERT INTO `sys_role_menu` VALUES (9, 1, 9, 0, 10000, '2023-04-09 18:02:02', 10000, '2023-04-09 18:02:12');
INSERT INTO `sys_role_menu` VALUES (10, 1, 10, 0, 10000, '2023-04-09 18:02:02', 10000, '2023-04-09 18:02:12');
INSERT INTO `sys_role_menu` VALUES (11, 1, 11, 0, 10000, '2023-04-09 18:02:02', 10000, '2023-04-09 18:02:12');
INSERT INTO `sys_role_menu` VALUES (12, 1, 12, 0, 10000, '2023-04-09 18:02:02', 10000, '2023-04-09 18:02:12');
INSERT INTO `sys_role_menu` VALUES (13, 1, 13, 0, 10000, '2023-04-09 18:02:02', 10000, '2023-04-09 18:02:12');
INSERT INTO `sys_role_menu` VALUES (14, 1, 14, 0, 10000, '2023-04-09 18:02:02', 10000, '2023-04-09 18:02:12');
INSERT INTO `sys_role_menu` VALUES (15, 1, 15, 0, 10000, '2023-04-09 18:02:02', 10000, '2023-04-09 18:02:12');
INSERT INTO `sys_role_menu` VALUES (16, 1, 16, 0, 10000, '2023-04-09 18:02:02', 10000, '2023-04-09 18:02:12');
INSERT INTO `sys_role_menu` VALUES (17, 1, 17, 0, 10000, '2023-04-09 18:02:02', 10000, '2023-04-09 18:02:12');
INSERT INTO `sys_role_menu` VALUES (18, 1, 18, 0, 10000, '2023-04-09 18:02:02', 10000, '2023-04-09 18:02:12');
INSERT INTO `sys_role_menu` VALUES (19, 1, 19, 0, 10000, '2023-04-09 18:02:02', 10000, '2023-04-09 18:02:12');
INSERT INTO `sys_role_menu` VALUES (20, 1, 20, 0, 10000, '2023-04-09 18:02:02', 10000, '2023-04-09 18:02:12');
INSERT INTO `sys_role_menu` VALUES (21, 1, 21, 0, 10000, '2023-04-09 18:02:02', 10000, '2023-04-09 18:02:12');
INSERT INTO `sys_role_menu` VALUES (22, 1, 22, 0, 10000, '2023-04-09 18:02:02', 10000, '2023-04-09 18:02:12');
INSERT INTO `sys_role_menu` VALUES (23, 2, 21, 0, 10000, '2023-04-18 20:17:57', 10000, '2023-04-18 20:18:01');
INSERT INTO `sys_role_menu` VALUES (24, 3, 22, 0, 10000, '2023-04-18 20:18:22', 10000, '2023-04-18 20:18:24');
COMMIT;

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
  `username` varchar(50) NOT NULL COMMENT '用户名',
  `password` varchar(100) DEFAULT NULL COMMENT '密码',
  `real_name` varchar(50) DEFAULT NULL COMMENT '姓名',
  `avatar` varchar(200) DEFAULT NULL COMMENT '头像',
  `gender` tinyint DEFAULT NULL COMMENT '性别   0：男   1：女   2：未知',
  `email` varchar(100) DEFAULT NULL COMMENT '邮箱',
  `mobile` varchar(20) DEFAULT NULL COMMENT '手机号',
  `super_admin` tinyint DEFAULT NULL COMMENT '超级管理员   0：否   1：是',
  `status` tinyint DEFAULT NULL COMMENT '状态  0：停用   1：正常',
  `deleted` tinyint DEFAULT NULL COMMENT '删除标识  0：正常   1：已删除',
  `creator` bigint DEFAULT NULL COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `updater` bigint DEFAULT NULL COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10006 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='用户管理';

-- ----------------------------
-- Records of sys_user
-- ----------------------------
BEGIN;
INSERT INTO `sys_user` VALUES (10000, 'admin', '{bcrypt}$2a$10$SX4wjbgJlrLNjOeUb2e92e/93Mt6LZqvvGl5HPYZpHnkh9ogTNEwq', 'InfinityX7', 'https://i2.100024.xyz/2023/01/26/3e727b.webp', 1, '16422802@qq.com', '13951905171', 1, 1, 0, NULL, '2023-04-09 17:33:13', 10000, '2023-04-09 17:33:13');
INSERT INTO `sys_user` VALUES (10001, 'admin1', '{bcrypt}$2a$10$nzAtTDzAGwwnOwY/ObXLQ.tHujTH8H7Xoq/feAre.XXn.UzjThrmW', 'admin1', 'https://i2.100024.xyz/2023/01/26/3exzjl.webp', 2, 'admin1@qq.com', '13911112222', 0, 1, 0, 10000, '2023-04-09 18:03:51', 10000, '2023-04-09 18:03:51');
INSERT INTO `sys_user` VALUES (10002, 'admin2', '{bcrypt}$2a$10$SX4wjbgJlrLNjOeUb2e92e/93Mt6LZqvvGl5HPYZpHnkh9ogTNEwq', 'admin2', 'https://i2.100024.xyz/2023/01/26/3ey3yb.webp', 0, 'admin2@qq.com', '13900001111', 0, 1, 0, 10000, '2023-04-18 19:27:17', 10000, '2023-04-18 19:27:22');
INSERT INTO `sys_user` VALUES (10003, 'bbb', '{bcrypt}$2a$10$SX4wjbgJlrLNjOeUb2e92e/93Mt6LZqvvGl5HPYZpHnkh9ogTNEwq', 'bbb', 'https://i2.100024.xyz/2023/01/26/3eyd0m.webp', 1, 'bbb@qq.com', '13911112222', 0, 1, 0, 10000, '2023-04-18 19:28:14', 10000, '2023-04-18 19:28:20');
INSERT INTO `sys_user` VALUES (10004, 'ccc', '{bcrypt}$2a$10$SX4wjbgJlrLNjOeUb2e92e/93Mt6LZqvvGl5HPYZpHnkh9ogTNEwq', 'ccc', 'https://i2.100024.xyz/2023/01/26/3eyjfo.webp', 0, 'ccc@qq.com', '13933334444', 0, 1, 0, 10000, '2023-04-18 19:35:04', 10000, '2023-04-18 19:35:10');
INSERT INTO `sys_user` VALUES (10005, 'ddd', '{bcrypt}$2a$10$SX4wjbgJlrLNjOeUb2e92e/93Mt6LZqvvGl5HPYZpHnkh9ogTNEwq', 'ddd', 'https://i2.100024.xyz/2023/01/26/3eyiq7.webp', 1, 'ddd@qq.com', '13955556666', 0, 1, 0, 10000, '2023-04-18 19:35:56', 10000, '2023-04-18 19:36:02');
COMMIT;

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
  `role_id` bigint DEFAULT NULL COMMENT '角色ID',
  `user_id` bigint DEFAULT NULL COMMENT '用户ID',
  `deleted` tinyint DEFAULT NULL COMMENT '删除标识  0：正常   1：已删除',
  `creator` bigint DEFAULT NULL COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `updater` bigint DEFAULT NULL COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `idx_role_id` (`role_id`),
  KEY `idx_user_id` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='用户角色关系';

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
BEGIN;
INSERT INTO `sys_user_role` VALUES (1, 1, 10000, 0, 10000, '2023-04-09 18:03:51', 10000, '2023-04-09 18:03:51');
INSERT INTO `sys_user_role` VALUES (2, 2, 10001, 0, 10000, '2023-04-18 19:40:33', 10000, '2023-04-18 19:40:38');
INSERT INTO `sys_user_role` VALUES (3, 3, 10002, 0, 10000, '2023-04-18 19:40:59', 10000, '2023-04-18 19:41:04');
INSERT INTO `sys_user_role` VALUES (4, 4, 10003, 0, 10000, '2023-04-18 19:42:13', 10000, '2023-04-18 19:42:18');
INSERT INTO `sys_user_role` VALUES (5, 4, 10004, 0, 10000, '2023-04-18 19:42:49', 10000, '2023-04-18 19:42:53');
INSERT INTO `sys_user_role` VALUES (6, 4, 10005, 0, 10000, '2023-04-18 19:43:13', 10000, '2023-04-18 19:43:19');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;

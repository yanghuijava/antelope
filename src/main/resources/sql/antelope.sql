/*
Navicat MySQL Data Transfer

Source Server         : 阿里云mysql
Source Server Version : 50561
Source Host           : 120.77.152.143:3306
Source Database       : antelope

Target Server Type    : MYSQL
Target Server Version : 50561
File Encoding         : 65001

Date: 2018-09-01 14:16:16
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for dept
-- ----------------------------
DROP TABLE IF EXISTS `dept`;
CREATE TABLE `dept` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `num` int(11) DEFAULT NULL,
  `pid` int(11) DEFAULT NULL,
  `simplename` varchar(45) DEFAULT NULL,
  `fullname` varchar(255) DEFAULT NULL,
  `remark` varchar(1000) DEFAULT NULL,
  `create_by` bigint(20) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_by` bigint(20) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `yn` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dept
-- ----------------------------

-- ----------------------------
-- Table structure for resource
-- ----------------------------
DROP TABLE IF EXISTS `resource`;
CREATE TABLE `resource` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `pid` int(11) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `code` varchar(50) DEFAULT NULL,
  `index_` int(11) DEFAULT NULL,
  `action` varchar(100) DEFAULT NULL,
  `url` varchar(100) DEFAULT NULL,
  `icon` varchar(50) DEFAULT NULL,
  `remark` varchar(1024) DEFAULT NULL,
  `create_by` bigint(128) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_by` bigint(128) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `yn` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=139 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of resource
-- ----------------------------
INSERT INTO `resource` VALUES ('17', '0', '0', '界面', 'JM', null, '', '', '', null, '3', '2017-06-19 21:12:22', '3', '2017-06-19 21:12:22', '1');
INSERT INTO `resource` VALUES ('18', '17', '1', '系统管理', 'SM', '1', '', '', '', null, '3', '2017-06-22 00:06:24', '3', '2017-06-22 00:06:24', '1');
INSERT INTO `resource` VALUES ('21', '18', '2', '系统资源', 'system_resource', '1', '/resource/listUI.html', '/resource/listUI.html', '', null, '3', '2017-06-22 00:24:05', '3', '2017-06-22 00:24:05', '1');
INSERT INTO `resource` VALUES ('22', '21', '3', '新增', '', '1', 'add', '', 'icon-add', null, '3', '2017-06-22 11:10:33', '3', '2017-06-22 11:10:33', '1');
INSERT INTO `resource` VALUES ('23', '21', '3', '保存', '', '2', 'save', '/resoure/save_res.json', 'icon-save', null, '3', '2017-06-22 11:10:34', '3', '2017-06-22 11:10:34', '1');
INSERT INTO `resource` VALUES ('24', '21', '3', '取消', '', '3', 'cancel', '', 'icon-cancel', null, '3', '2017-06-22 11:10:36', '3', '2017-06-22 11:10:36', '1');
INSERT INTO `resource` VALUES ('25', '21', '3', '删除', '', '4', 'destroy', '/resource/delete_res.json', 'icon-remove', null, '3', '2017-06-22 11:10:37', '3', '2017-06-22 11:10:37', '1');
INSERT INTO `resource` VALUES ('26', '21', '0', '更新', '', '5', '', '/reource/update_res.json', '', null, '3', '2017-06-22 11:10:39', '3', '2017-06-22 11:10:39', '1');
INSERT INTO `resource` VALUES ('28', '18', '2', '角色管理', 'role_manage', '2', '/role/listUI.html', '/role/listUI.html', '', null, '3', '2017-06-22 00:24:08', '3', '2017-06-22 00:24:08', '1');
INSERT INTO `resource` VALUES ('29', '28', '3', '新增', '', '1', 'add', '', 'icon-add', null, '3', '2017-06-21 22:21:18', '3', '2017-06-21 22:21:18', '1');
INSERT INTO `resource` VALUES ('30', '28', '3', '保存', '', '2', 'save', '/role/save.json', 'icon-ok', null, '3', '2017-06-21 22:21:20', '3', '2017-06-21 22:21:20', '1');
INSERT INTO `resource` VALUES ('31', '28', '3', '取消', '', '3', 'cancel', '', 'icon-cancel', null, '3', '2017-06-21 22:21:22', '3', '2017-06-21 22:21:22', '1');
INSERT INTO `resource` VALUES ('32', '28', '3', '删除', '', '4', 'destroy', '/role/delete.json', 'icon-remove', null, '3', '2017-06-21 22:21:25', '3', '2017-06-21 22:21:25', '1');
INSERT INTO `resource` VALUES ('33', '28', '0', '更新', '', '6', '', '/role/update.json', '', null, '3', '2017-06-22 11:13:09', '3', '2017-06-22 11:13:09', '1');
INSERT INTO `resource` VALUES ('34', '28', '3', '保存权限', '', '5', 'saveAuth', '/resource/saveRoleResource.json', 'icon-save', null, '3', '2017-06-21 22:21:28', '3', '2017-06-21 22:21:28', '1');
INSERT INTO `resource` VALUES ('35', '18', '2', '用户管理', 'user_manage', '3', '/user/listUI.html', '/user/listUI.html', '', null, '3', '2017-06-22 00:24:11', '3', '2017-06-22 00:24:11', '1');
INSERT INTO `resource` VALUES ('36', '35', '3', '新增', '', '1', 'add', '', 'icon-add', null, '3', '2017-06-21 21:20:57', '3', '2017-06-21 21:20:57', '1');
INSERT INTO `resource` VALUES ('37', '35', '3', '保存', '', '2', 'save', '/user/save.json', 'icon-save', null, '3', '2017-06-21 21:20:59', '3', '2017-06-21 21:20:59', '1');
INSERT INTO `resource` VALUES ('38', '35', '3', '取消', '', '3', 'cancel', '', 'icon-cancel', null, '3', '2017-06-21 21:21:25', '3', '2017-06-21 21:21:25', '1');
INSERT INTO `resource` VALUES ('39', '35', '3', '删除', '', '4', 'destroy', '/user/delete.json', 'icon-remove', null, '3', '2017-06-21 21:22:32', '3', '2017-06-21 21:22:32', '1');
INSERT INTO `resource` VALUES ('40', '35', '0', '更新', '', '7', '', '/user/update.json', '', null, '3', '2017-06-22 11:14:54', '3', '2017-06-22 11:14:54', '1');
INSERT INTO `resource` VALUES ('41', '35', '3', '冻结用户', '', '5', 'frozen', '/user/frozen.json', 'icon-lock', null, '3', '2017-06-21 21:23:42', '3', '2017-06-21 21:23:42', '1');
INSERT INTO `resource` VALUES ('42', '35', '3', '解冻用户', '', '6', 'unfrozen', '/user/unfrozen.json', 'icon-redo', null, '3', '2017-06-21 21:24:20', '3', '2017-06-21 21:24:20', '1');
INSERT INTO `resource` VALUES ('47', '17', '0', '首页', '', null, '', '/index.html', '', null, '3', '2017-06-22 10:17:55', '3', '2017-06-22 10:17:55', '1');
INSERT INTO `resource` VALUES ('48', '17', '0', '右边页', '', null, '', '/rightUI.html', '', null, '3', '2017-06-22 10:18:21', '3', '2017-06-22 10:18:21', '1');
INSERT INTO `resource` VALUES ('49', '21', '0', '资源子节点列表', '', '6', '', '/resource/subres.json', '', null, '3', '2017-06-22 11:11:35', '3', '2017-06-22 11:11:35', '1');
INSERT INTO `resource` VALUES ('50', '21', '0', '资源树', '', '7', '', '/resource/resourceTree.json', '', null, '3', '2017-06-22 11:12:33', '3', '2017-06-22 11:12:33', '1');
INSERT INTO `resource` VALUES ('51', '28', '0', '角色列表', '', '7', '', '/role/list.json', '', null, '3', '2017-06-22 11:13:30', '3', '2017-06-22 11:13:30', '1');
INSERT INTO `resource` VALUES ('53', '35', '0', '用户列表', '', '8', '', '/user/list.json', '', null, '3', '2017-06-22 11:15:25', '3', '2017-06-22 11:15:25', '1');
INSERT INTO `resource` VALUES ('54', '28', '0', '查询角色名称', '', '9', '', '/role/queryRoleNames.json', '', null, '3', '2017-06-22 11:16:52', '3', '2017-06-22 11:16:52', '1');
INSERT INTO `resource` VALUES ('55', '21', '0', '查询角色资源', '', '8', '', '/resource/queryRoleResource.json', '', null, '3', '2017-06-22 11:17:28', '3', '2017-06-22 11:17:28', '1');
INSERT INTO `resource` VALUES ('56', '28', '0', '查询所有角色', '', '10', '', '/role/listAll.json', '', null, '3', '2017-06-22 11:18:17', '3', '2017-06-22 11:18:17', '1');
INSERT INTO `resource` VALUES ('57', '17', '1', '我的', 'ME', '2', '', '', '', null, '3', '2017-06-22 12:53:55', '3', '2017-06-22 12:53:55', '1');
INSERT INTO `resource` VALUES ('58', '57', '2', '我的资料', 'me_personal', '1', '/me/personalUI.html', '/me/personalUI.html', '', null, '3', '2017-06-22 12:56:37', '3', '2017-06-22 12:56:37', '1');
INSERT INTO `resource` VALUES ('59', '57', '2', '修改密码', 'update_pwd', '2', '/me/updatePwdUI.html', '/me/updatePwdUI.html', '', null, '3', '2017-06-22 21:40:06', '3', '2017-06-22 21:40:06', '1');
INSERT INTO `resource` VALUES ('60', '58', '3', '保存', 'personal_save', null, '', '/me/updatePersonal.json', 'icon-save', null, '3', '2017-06-22 22:22:34', '3', '2017-06-22 22:22:34', '1');
INSERT INTO `resource` VALUES ('61', '58', '0', '获取个人资料', '', null, '/me/getUserAllMsg.json', '/me/getUserAllMsg.json', '', null, '3', '2017-06-22 22:15:32', '3', '2017-06-22 22:15:32', '1');
INSERT INTO `resource` VALUES ('62', '59', '3', '保存', 'update_pwd', '1', '', '/me/updatePwd.json', 'icon-save', null, '3', '2017-06-22 22:16:53', '3', '2017-06-22 22:16:53', '1');
INSERT INTO `resource` VALUES ('63', null, null, 'fffffff', null, null, null, null, null, null, null, '2017-06-23 20:08:30', null, '2017-06-23 20:08:30', '1');
INSERT INTO `resource` VALUES ('64', '17', '1', '信贷基本业务', 'CREDIT', '3', '', '', '', null, '3', '2017-06-23 20:10:42', '3', '2017-06-23 20:10:42', '1');
INSERT INTO `resource` VALUES ('65', '64', '2', '客户资料', 'customer_manager', '1', '/customer/listUI.html', '/customer/listUI.html', '', null, '3', '2018-08-16 15:31:14', '3', '2018-08-16 15:31:14', '1');
INSERT INTO `resource` VALUES ('67', '17', '0', '没有修改密码', 'NOUPDATEPWD', null, null, '/noUpdatePwd.html', null, null, '3', '2017-07-03 18:14:08', '3', '2017-07-03 18:14:08', '1');
INSERT INTO `resource` VALUES ('68', null, null, 'fffffff', null, null, null, null, null, null, null, '2017-07-06 17:27:22', null, '2017-07-06 17:27:22', '1');
INSERT INTO `resource` VALUES ('69', null, null, 'fffffff', null, null, null, null, null, null, null, '2018-07-03 14:33:04', null, '2018-07-03 14:33:04', '1');
INSERT INTO `resource` VALUES ('70', '65', '3', '录入客户', 'add_customer', '1', 'add', '/customerInput/indexUI.html', 'icon-add', null, '3', '2018-08-16 15:36:52', '3', '2018-08-16 15:36:52', '1');
INSERT INTO `resource` VALUES ('71', '78', '0', '下一步', 'customer_input_next_bt', '1', null, null, null, null, '3', '2018-08-29 11:40:05', '3', '2018-08-29 11:40:05', '1');
INSERT INTO `resource` VALUES ('72', '65', '3', '删除', 'delete_customer', '2', 'del', '/customer/delete.json', 'icon-remove', null, '3', '2018-08-29 11:28:41', '3', '2018-08-29 11:28:41', '1');
INSERT INTO `resource` VALUES ('73', '65', '3', '查看详情', 'lookDetail_customer', '3', 'lookDetail', '/customerInput/customerDetailsUI.html', 'icon-search', null, '3', '2018-08-29 11:29:54', '3', '2018-08-29 11:29:54', '1');
INSERT INTO `resource` VALUES ('74', '78', '0', '完成', 'customer_input_finish_bt', '2', null, null, null, null, '3', '2018-08-29 11:40:09', '3', '2018-08-29 11:40:09', '1');
INSERT INTO `resource` VALUES ('75', '78', '0', '取消', 'customer_input_cancel_bt', '3', null, '/customer/listUI.html', null, null, '3', '2018-08-29 11:40:18', '3', '2018-08-29 11:40:18', '1');
INSERT INTO `resource` VALUES ('76', '78', '0', '保存', 'customer_save', '4', null, 'customer/save.json', null, null, '3', '2018-08-29 11:40:30', '3', '2018-08-29 11:40:30', '1');
INSERT INTO `resource` VALUES ('77', '78', '0', '更新', 'customer_update', '5', null, 'customer/update.json', null, null, '3', '2018-08-29 11:40:33', '3', '2018-08-29 11:40:33', '1');
INSERT INTO `resource` VALUES ('78', '70', '4', '个人资料', 'customer', '1', null, '/customerInput/indexUI.html', null, null, '3', '2018-09-01 05:46:08', '3', '2018-09-01 05:46:08', '1');
INSERT INTO `resource` VALUES ('79', '70', '4', '职业资料', 'profession', '2', null, '/profession/professionUI.html', null, null, '3', '2018-09-01 05:46:39', '3', '2018-09-01 05:46:39', '1');
INSERT INTO `resource` VALUES ('80', '79', '0', '上一步', 'profession_lastpage_bt', '1', null, '/profession/lastPageUI.html', null, null, '3', '2018-08-29 11:42:14', '3', '2018-08-29 11:42:14', '1');
INSERT INTO `resource` VALUES ('81', '79', '0', '下一步', 'profession_next_bt', '2', null, null, null, null, '3', '2018-08-29 11:42:45', '3', '2018-08-29 11:42:45', '1');
INSERT INTO `resource` VALUES ('82', '79', '0', '跳过', 'profession_skip_bt', '3', null, '/profession/nextUI.html', null, null, '3', '2018-08-29 11:57:39', '3', '2018-08-29 11:57:39', '1');
INSERT INTO `resource` VALUES ('83', '79', '0', '完成', 'profession_finish_bt', '4', null, null, null, null, '3', '2018-08-29 11:47:19', '3', '2018-08-29 11:47:19', '1');
INSERT INTO `resource` VALUES ('85', '79', '0', '保存', 'profession_save', '5', null, '/profession/save.json', null, null, '3', '2018-08-29 11:47:34', '3', '2018-08-29 11:47:34', '1');
INSERT INTO `resource` VALUES ('86', '79', '0', '更新', 'profession_update', '6', null, '/profession/update.json', null, null, '3', '2018-08-29 11:57:36', '3', '2018-08-29 11:57:36', '1');
INSERT INTO `resource` VALUES ('87', '70', '4', '企业资料', 'business', '3', null, '/business/businessUI.html', null, null, '3', '2018-09-01 05:47:14', '3', '2018-09-01 05:47:14', '1');
INSERT INTO `resource` VALUES ('88', '87', '0', '上一步', 'business_lastpage_bt', '1', null, '/business/lastPageUI.html', null, null, '3', '2018-08-29 11:56:07', '3', '2018-08-29 11:56:07', '1');
INSERT INTO `resource` VALUES ('89', '87', '0', '下一步', 'business_next_bt', '2', null, '/business/nextUI.html', null, null, '3', '2018-08-29 11:56:16', '3', '2018-08-29 11:56:16', '1');
INSERT INTO `resource` VALUES ('90', '87', '0', '跳过', 'business_skip_bt', '3', null, '/business/nextUI.html', null, null, '3', '2018-08-29 11:56:30', '3', '2018-08-29 11:56:30', '1');
INSERT INTO `resource` VALUES ('91', '87', '0', '完成', 'business_finish_bt', '4', null, null, null, null, '3', '2018-08-29 11:51:37', '3', '2018-08-29 11:51:37', '1');
INSERT INTO `resource` VALUES ('92', '87', '0', '列表', 'business_list', '5', null, '/business/list.json', null, null, '3', '2018-08-29 11:56:40', '3', '2018-08-29 11:56:40', '1');
INSERT INTO `resource` VALUES ('93', '87', '0', '保存', 'business_save', '6', null, '/business/save.json', null, null, '3', '2018-08-29 11:56:46', '3', '2018-08-29 11:56:46', '1');
INSERT INTO `resource` VALUES ('94', '87', '0', '更新', 'business_update', '7', null, '/business/update.json', null, null, '3', '2018-08-29 11:56:53', '3', '2018-08-29 11:56:53', '1');
INSERT INTO `resource` VALUES ('95', '87', '0', '删除', 'business_del', '8', null, '/business/delete.json', null, null, '3', '2018-08-29 11:59:29', '3', '2018-08-29 11:59:29', '1');
INSERT INTO `resource` VALUES ('96', '79', '0', '加载一个', 'profession_load', '7', null, '/profession/load.json', null, null, '3', '2018-08-29 11:57:49', '3', '2018-08-29 11:57:49', '1');
INSERT INTO `resource` VALUES ('97', null, null, 'fffffff', null, null, null, null, null, null, null, '2018-08-31 15:16:36', null, '2018-08-31 15:16:36', '1');
INSERT INTO `resource` VALUES ('98', '70', '4', '房产资料', 'estate', '4', null, '/estate/estateUI.html', null, null, '3', '2018-09-01 05:47:54', '3', '2018-09-01 05:47:54', '1');
INSERT INTO `resource` VALUES ('99', '98', '0', '上一页', 'estate_last_page_bt', '1', null, '/estate/lastPageUI.html', null, null, '3', '2018-09-01 05:49:57', '3', '2018-09-01 05:49:57', '1');
INSERT INTO `resource` VALUES ('100', '98', '0', '下一页', 'estate_next_page_bt', '2', null, '/estate/nextUI.html', null, null, '3', '2018-09-01 05:50:10', '3', '2018-09-01 05:50:10', '1');
INSERT INTO `resource` VALUES ('101', '98', '0', '列表', 'estate_list', '3', null, '/estate/list.json', null, null, '3', '2018-09-01 05:50:55', '3', '2018-09-01 05:50:55', '1');
INSERT INTO `resource` VALUES ('102', '98', '0', '加载', 'estate_load', '4', null, '/estate/load.json', null, null, '3', '2018-09-01 05:51:26', '3', '2018-09-01 05:51:26', '1');
INSERT INTO `resource` VALUES ('103', '98', '0', '保存', 'estate_save', '5', null, '/eatate/save.json', null, null, '3', '2018-09-01 05:52:08', '3', '2018-09-01 05:52:08', '1');
INSERT INTO `resource` VALUES ('104', '98', '0', '更新', 'eatate_update', '6', null, '/eatate/update.json', null, null, '3', '2018-09-01 05:53:18', '3', '2018-09-01 05:53:18', '1');
INSERT INTO `resource` VALUES ('105', '98', '0', '删除', 'eatate_delete', '7', null, '/eatate/delete.json', null, null, '3', '2018-09-01 05:53:47', '3', '2018-09-01 05:53:47', '1');
INSERT INTO `resource` VALUES ('106', '70', '4', '保险资料', 'policy', '5', null, '/policy/policyUI.html', null, null, '3', '2018-09-01 05:59:17', '3', '2018-09-01 05:59:17', '1');
INSERT INTO `resource` VALUES ('107', '106', '0', '上一页', 'policy_last_bt', '1', null, '/policy/lastPageUI.html', null, null, '3', '2018-09-01 05:57:16', '3', '2018-09-01 05:57:16', '1');
INSERT INTO `resource` VALUES ('108', '106', '0', '下一页', 'policy_next_bt', '2', null, '/policy/nextUI.html', null, null, '3', '2018-09-01 05:57:32', '3', '2018-09-01 05:57:32', '1');
INSERT INTO `resource` VALUES ('109', '106', '0', '列表', 'policy_list', '3', null, '/policy/list.json', null, null, '3', '2018-09-01 05:57:37', '3', '2018-09-01 05:57:37', '1');
INSERT INTO `resource` VALUES ('110', '106', '0', '加载', 'policy_load', '4', null, '/policy/load.json', null, null, '3', '2018-09-01 05:57:43', '3', '2018-09-01 05:57:43', '1');
INSERT INTO `resource` VALUES ('111', '106', '0', '保存', 'policy_save', '5', null, '/policy/save.json', null, null, '3', '2018-09-01 05:57:47', '3', '2018-09-01 05:57:47', '1');
INSERT INTO `resource` VALUES ('112', '106', '0', '更新', 'policy_update', '6', null, '/policy/update.json', null, null, '3', '2018-09-01 05:57:51', '3', '2018-09-01 05:57:51', '1');
INSERT INTO `resource` VALUES ('113', '106', '0', '删除', 'policy_delet', '7', null, '/policy/delete.json', null, null, '3', '2018-09-01 05:57:56', '3', '2018-09-01 05:57:56', '1');
INSERT INTO `resource` VALUES ('114', '70', '4', '车辆资料', 'vehicle', '6', null, '/vehicle/vehicleUI.html', null, null, '3', '2018-09-01 05:59:19', '3', '2018-09-01 05:59:19', '1');
INSERT INTO `resource` VALUES ('115', '114', '0', '上一页', 'vehicle_last_bt', '1', null, '/vehicle/lastPageUI.html', null, null, '3', '2018-09-01 06:01:52', '3', '2018-09-01 06:01:52', '1');
INSERT INTO `resource` VALUES ('116', '114', '0', '下一页', 'vehicle_next_bt', '2', null, '/vehicle/nextUI.html', null, null, '3', '2018-09-01 06:02:01', '3', '2018-09-01 06:02:01', '1');
INSERT INTO `resource` VALUES ('117', '114', '0', '加载', 'vehicle_load', '4', null, '/vehicle/load.json', null, null, '3', '2018-09-01 06:02:08', '3', '2018-09-01 06:02:08', '1');
INSERT INTO `resource` VALUES ('118', '114', '0', '保存', 'vehicle_save', '5', null, '/vehicle/save.json', null, null, '3', '2018-09-01 06:02:15', '3', '2018-09-01 06:02:15', '1');
INSERT INTO `resource` VALUES ('119', '114', '0', '更新', 'vehicle_update', '6', null, '/vehicle/update.json', null, null, '3', '2018-09-01 06:02:19', '3', '2018-09-01 06:02:19', '1');
INSERT INTO `resource` VALUES ('120', '114', '0', '删除', 'vehicle_delete', '7', null, '/vehicle/delete.json', null, null, '3', '2018-09-01 06:02:23', '3', '2018-09-01 06:02:23', '1');
INSERT INTO `resource` VALUES ('121', '114', '0', '列表', 'vehicle_list', '3', null, '/vehicle/list.json', null, null, '3', '2018-09-01 06:02:05', '3', '2018-09-01 06:02:05', '1');
INSERT INTO `resource` VALUES ('122', '70', '4', '负债资料', 'liability', '7', null, '/liability/liabilityUI.html', null, null, '3', '2018-09-01 06:03:24', '3', '2018-09-01 06:03:24', '1');
INSERT INTO `resource` VALUES ('123', '122', '0', '上一页', 'liability_last_bt', '1', null, '/liability/lastPageUI.html', null, null, '3', '2018-09-01 06:06:16', '3', '2018-09-01 06:06:16', '1');
INSERT INTO `resource` VALUES ('124', '122', '0', '下一页', 'liability_next_bt', '2', null, '/liability/nextUI.html', null, null, '3', '2018-09-01 06:06:23', '3', '2018-09-01 06:06:23', '1');
INSERT INTO `resource` VALUES ('125', '122', '0', '加载', 'liability_load', '3', null, '/liability/load.json', null, null, '3', '2018-09-01 06:06:36', '3', '2018-09-01 06:06:36', '1');
INSERT INTO `resource` VALUES ('127', '122', '0', '保存', 'liability_save', '5', null, '/liability/save.json', null, null, '3', '2018-09-01 06:06:41', '3', '2018-09-01 06:06:41', '1');
INSERT INTO `resource` VALUES ('128', '122', '0', '更新', 'liability_update', '6', null, '/liability/update.json', null, null, '3', '2018-09-01 06:06:46', '3', '2018-09-01 06:06:46', '1');
INSERT INTO `resource` VALUES ('130', '70', '4', '客户需求', 'demand', '8', null, '/demand/demandUI.html', null, null, '3', '2018-09-01 06:07:47', '3', '2018-09-01 06:07:47', '1');
INSERT INTO `resource` VALUES ('131', '130', '0', '上一页', 'demand_last_bt', '1', null, '/demand/lastPageUI.html', null, null, '3', '2018-09-01 06:10:44', '3', '2018-09-01 06:10:44', '1');
INSERT INTO `resource` VALUES ('132', '130', '0', '下一页', 'demand_next_bt', '2', null, '/demand/nextUI.html', null, null, '3', '2018-09-01 06:10:49', '3', '2018-09-01 06:10:49', '1');
INSERT INTO `resource` VALUES ('133', '130', '0', '保存', 'demand_save', '3', null, '/demand/save.json', null, null, '3', '2018-09-01 06:10:52', '3', '2018-09-01 06:10:52', '1');
INSERT INTO `resource` VALUES ('134', '130', '0', '更新', 'demand_update', '4', null, '/demand/update.json', null, null, '3', '2018-09-01 06:10:55', '3', '2018-09-01 06:10:55', '1');
INSERT INTO `resource` VALUES ('135', '130', '0', '加载', 'demand_load', '5', null, '/demand/load.json', null, null, '3', '2018-09-01 06:11:00', '3', '2018-09-01 06:11:00', '1');
INSERT INTO `resource` VALUES ('136', '70', '4', '客户方案', 'programme', '9', null, '/programme/programmeUI.html', null, null, '3', '2018-09-01 06:12:13', '3', '2018-09-01 06:12:13', '1');
INSERT INTO `resource` VALUES ('137', '136', '0', '上一页', 'programme_last_bt', null, null, '/programme/lastPageUI.html', null, null, '3', '2018-09-01 06:13:20', '3', '2018-09-01 06:13:20', '1');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(50) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `description` varchar(80) DEFAULT NULL,
  `remark` varchar(1024) DEFAULT NULL,
  `create_by` bigint(128) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_by` bigint(128) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `yn` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('15', 'administrator', '超级管理员', '最高权限拥有者', null, '3', '2017-06-20 10:06:55', '3', '2017-06-20 21:34:30', '1');
INSERT INTO `role` VALUES ('27', 'kehujingli', '客户经理', '业务人员', null, '3', '2017-06-21 22:27:13', '3', '2017-06-22 12:50:41', '1');
INSERT INTO `role` VALUES ('32', 'zhuguan', '主管', '主管', null, '3', '2018-08-27 17:53:17', '3', '2018-08-27 17:53:17', '1');
INSERT INTO `role` VALUES ('33', 'zongjingli', '总经理', '总经理', null, '3', '2018-08-27 17:53:52', '3', '2018-08-27 17:53:52', '1');

-- ----------------------------
-- Table structure for role_resource
-- ----------------------------
DROP TABLE IF EXISTS `role_resource`;
CREATE TABLE `role_resource` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) DEFAULT NULL,
  `res_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=457 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role_resource
-- ----------------------------
INSERT INTO `role_resource` VALUES ('332', '15', '17');
INSERT INTO `role_resource` VALUES ('333', '15', '47');
INSERT INTO `role_resource` VALUES ('334', '15', '48');
INSERT INTO `role_resource` VALUES ('335', '15', '18');
INSERT INTO `role_resource` VALUES ('336', '15', '21');
INSERT INTO `role_resource` VALUES ('337', '15', '22');
INSERT INTO `role_resource` VALUES ('338', '15', '23');
INSERT INTO `role_resource` VALUES ('339', '15', '24');
INSERT INTO `role_resource` VALUES ('340', '15', '25');
INSERT INTO `role_resource` VALUES ('341', '15', '26');
INSERT INTO `role_resource` VALUES ('342', '15', '49');
INSERT INTO `role_resource` VALUES ('343', '15', '50');
INSERT INTO `role_resource` VALUES ('344', '15', '55');
INSERT INTO `role_resource` VALUES ('345', '15', '28');
INSERT INTO `role_resource` VALUES ('346', '15', '29');
INSERT INTO `role_resource` VALUES ('347', '15', '30');
INSERT INTO `role_resource` VALUES ('348', '15', '31');
INSERT INTO `role_resource` VALUES ('349', '15', '32');
INSERT INTO `role_resource` VALUES ('350', '15', '34');
INSERT INTO `role_resource` VALUES ('351', '15', '33');
INSERT INTO `role_resource` VALUES ('352', '15', '51');
INSERT INTO `role_resource` VALUES ('353', '15', '54');
INSERT INTO `role_resource` VALUES ('354', '15', '56');
INSERT INTO `role_resource` VALUES ('355', '15', '35');
INSERT INTO `role_resource` VALUES ('356', '15', '36');
INSERT INTO `role_resource` VALUES ('357', '15', '37');
INSERT INTO `role_resource` VALUES ('358', '15', '38');
INSERT INTO `role_resource` VALUES ('359', '15', '39');
INSERT INTO `role_resource` VALUES ('360', '15', '41');
INSERT INTO `role_resource` VALUES ('361', '15', '42');
INSERT INTO `role_resource` VALUES ('362', '15', '40');
INSERT INTO `role_resource` VALUES ('363', '15', '53');
INSERT INTO `role_resource` VALUES ('364', '15', '57');
INSERT INTO `role_resource` VALUES ('365', '15', '58');
INSERT INTO `role_resource` VALUES ('366', '15', '60');
INSERT INTO `role_resource` VALUES ('367', '15', '61');
INSERT INTO `role_resource` VALUES ('368', '15', '59');
INSERT INTO `role_resource` VALUES ('369', '15', '62');
INSERT INTO `role_resource` VALUES ('435', '27', '17');
INSERT INTO `role_resource` VALUES ('436', '27', '47');
INSERT INTO `role_resource` VALUES ('437', '27', '48');
INSERT INTO `role_resource` VALUES ('438', '27', '67');
INSERT INTO `role_resource` VALUES ('439', '27', '18');
INSERT INTO `role_resource` VALUES ('440', '27', '21');
INSERT INTO `role_resource` VALUES ('441', '27', '49');
INSERT INTO `role_resource` VALUES ('442', '27', '50');
INSERT INTO `role_resource` VALUES ('443', '27', '54');
INSERT INTO `role_resource` VALUES ('444', '27', '56');
INSERT INTO `role_resource` VALUES ('445', '27', '35');
INSERT INTO `role_resource` VALUES ('446', '27', '36');
INSERT INTO `role_resource` VALUES ('447', '27', '53');
INSERT INTO `role_resource` VALUES ('448', '27', '57');
INSERT INTO `role_resource` VALUES ('449', '27', '58');
INSERT INTO `role_resource` VALUES ('450', '27', '60');
INSERT INTO `role_resource` VALUES ('451', '27', '61');
INSERT INTO `role_resource` VALUES ('452', '27', '59');
INSERT INTO `role_resource` VALUES ('453', '27', '62');
INSERT INTO `role_resource` VALUES ('454', '27', '64');
INSERT INTO `role_resource` VALUES ('455', '27', '65');
INSERT INTO `role_resource` VALUES ('456', '27', '70');

-- ----------------------------
-- Table structure for td_business
-- ----------------------------
DROP TABLE IF EXISTS `td_business`;
CREATE TABLE `td_business` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `customer_id` bigint(20) DEFAULT NULL COMMENT '客户id',
  `company_name` varchar(100) DEFAULT NULL COMMENT '公司名称',
  `setup_date` datetime DEFAULT NULL COMMENT '成立时间',
  `employees_num` int(11) DEFAULT NULL COMMENT '员工人数',
  `corporation` int(11) DEFAULT NULL COMMENT '是否公司法人 1：是 2：不是',
  `share_stock` decimal(12,6) DEFAULT NULL COMMENT '占股',
  `industry_type` varchar(255) DEFAULT NULL COMMENT '行业类别',
  `half_year_ticket` decimal(12,2) DEFAULT NULL COMMENT '近半年开票额',
  `taxes` decimal(12,2) DEFAULT NULL COMMENT '年纳税额',
  `personal_water` varchar(255) DEFAULT NULL COMMENT '个人流水',
  `compa_address` varchar(100) DEFAULT NULL COMMENT '公司地址',
  `area` varchar(100) DEFAULT NULL COMMENT '公司面积',
  `turnover` decimal(12,3) DEFAULT NULL COMMENT '营业额',
  `fixed_equipment` varchar(1000) DEFAULT NULL COMMENT '固定设备',
  `rent` decimal(12,3) DEFAULT NULL COMMENT '租金',
  `lease_contract` varchar(100) DEFAULT NULL COMMENT '租赁合同',
  `remark` varchar(1024) DEFAULT NULL,
  `create_by` bigint(20) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL,
  `update_by` bigint(20) DEFAULT NULL COMMENT '更新人',
  `update_time` datetime DEFAULT NULL,
  `yn` int(11) DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='生意资料';

-- ----------------------------
-- Records of td_business
-- ----------------------------
INSERT INTO `td_business` VALUES ('1', '29', '2312321', '2018-08-07 00:00:00', null, '1', '12.000000', 'dede', '23212.00', '13122.00', '1232132', null, null, null, null, null, null, null, '3', '2018-08-23 14:05:27', '3', '2018-08-23 14:05:27', '1');
INSERT INTO `td_business` VALUES ('3', '29', '2321323', '2018-07-30 00:00:00', null, '1', '22.000000', '123', '31232.00', '232.00', '2132132', null, null, null, null, null, null, null, '3', '2018-08-26 22:58:57', '3', '2018-08-26 22:58:57', '1');

-- ----------------------------
-- Table structure for td_contacts
-- ----------------------------
DROP TABLE IF EXISTS `td_contacts`;
CREATE TABLE `td_contacts` (
  `id` bigint(20) NOT NULL,
  `customer_id` bigint(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL COMMENT '姓名',
  `relation` varchar(255) DEFAULT NULL COMMENT '关系',
  `phone` varchar(255) DEFAULT NULL COMMENT '联系电话',
  `identity_card` varchar(18) DEFAULT NULL COMMENT '身份证号',
  `address` varchar(1024) DEFAULT NULL COMMENT '联系地址',
  `verify` int(11) DEFAULT NULL COMMENT '是否核实 1：否 2：是',
  `verify_person` varchar(255) DEFAULT NULL COMMENT '核实人',
  `verify_time` datetime DEFAULT NULL COMMENT '核实时间',
  `remark` varchar(1024) DEFAULT NULL,
  `create_by` bigint(20) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL,
  `update_by` bigint(20) DEFAULT NULL COMMENT '更新人',
  `update_time` datetime DEFAULT NULL,
  `yn` int(11) DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of td_contacts
-- ----------------------------

-- ----------------------------
-- Table structure for td_customer
-- ----------------------------
DROP TABLE IF EXISTS `td_customer`;
CREATE TABLE `td_customer` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `name` varchar(100) DEFAULT NULL COMMENT '姓名',
  `sex` int(11) DEFAULT NULL COMMENT '性别',
  `educational_level` varchar(255) DEFAULT NULL COMMENT '教育程度',
  `identity_card` varchar(18) DEFAULT NULL COMMENT '身份证号',
  `phone_number` varchar(11) DEFAULT NULL COMMENT '手机号码',
  `account_manager` bigint(20) DEFAULT NULL COMMENT '客户经理',
  `source` varchar(100) DEFAULT NULL COMMENT '客户来源',
  `home_address` varchar(500) DEFAULT NULL COMMENT '家庭住址',
  `native_place` varchar(20) DEFAULT NULL COMMENT '籍贯',
  `address` varchar(500) DEFAULT NULL COMMENT '住址',
  `marriage_status` int(11) DEFAULT NULL COMMENT '婚姻状况(1:未婚,2:已婚,3:离异)',
  `come_shenzhen_date` date DEFAULT NULL COMMENT '来深时间',
  `type` int(11) DEFAULT NULL COMMENT '客户类别',
  `credit_report` varchar(500) DEFAULT NULL COMMENT '征信报告',
  `flow_file` varchar(500) DEFAULT NULL COMMENT '流水附件',
  `status` int(11) DEFAULT NULL COMMENT '状态 100：待提交 101：待审核 102：审核不通过\r\n103：待批款 104：已放款',
  `remark` varchar(1024) DEFAULT NULL,
  `create_by` bigint(20) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL,
  `update_by` bigint(20) DEFAULT NULL COMMENT '更新人',
  `update_time` datetime DEFAULT NULL,
  `yn` int(11) DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8 COMMENT='客户资料表';

-- ----------------------------
-- Records of td_customer
-- ----------------------------
INSERT INTO `td_customer` VALUES ('29', '杨辉', '1', '大专', '360782198807312218', '13725530664', '3', null, '广东省深圳市福田区', '江西省南康市', '广东省深圳龙华新区', '2', null, '1', null, null, '100', null, '3', '2018-08-20 10:33:54', '3', '2018-09-01 05:43:24', '1');
INSERT INTO `td_customer` VALUES ('30', '11', '1', '大专', '111111111111111111', '22212333323', '3', null, 'cdc', 'wdewd', 'csdcdcdc', '1', null, '1', null, null, '100', null, '3', '2018-08-20 11:12:15', '3', '2018-08-20 11:12:15', '1');
INSERT INTO `td_customer` VALUES ('31', 'ee', '1', '大学', '213231122323232222', '23231222222', '3', null, 'ew', 'weqwe', 'wew', '1', null, '1', null, null, '100', null, '3', '2018-08-20 11:40:58', '3', '2018-08-20 11:40:58', '1');
INSERT INTO `td_customer` VALUES ('32', '11', '1', '本科', '111111111111111113', '21222222222', '3', null, '呃呃呃鹅鹅鹅鹅鹅鹅饿', '33333333333', '哒哒哒哒哒哒', '1', null, '1', null, null, '100', null, '3', '2018-08-23 09:29:26', '3', '2018-08-23 09:29:26', '1');
INSERT INTO `td_customer` VALUES ('33', '哈哈', '1', '232', '000000000000000211', '90290222222', '3', null, '我的胃', '3123213', '我的文档', '1', null, '1', null, null, '100', null, '3', '2018-08-23 09:58:16', '3', '2018-08-23 09:58:52', '1');
INSERT INTO `td_customer` VALUES ('37', '21212', '1', '212', '212121212121212222', '21212121111', '3', null, '212', '212', '12121', '1', null, '2', null, null, '100', null, '3', '2018-08-23 12:56:52', '3', '2018-08-23 12:56:52', '1');
INSERT INTO `td_customer` VALUES ('38', '3231', '1', '222', '212121212121211111', '21212122222', '3', null, '2323', '32323', '23232', '1', null, '2', null, null, '100', null, '3', '2018-08-23 12:57:31', '3', '2018-08-23 12:57:31', '1');

-- ----------------------------
-- Table structure for td_demand
-- ----------------------------
DROP TABLE IF EXISTS `td_demand`;
CREATE TABLE `td_demand` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `customer_id` bigint(20) DEFAULT NULL,
  `amount` decimal(12,2) DEFAULT NULL COMMENT '实际额度',
  `interest` decimal(12,2) DEFAULT NULL COMMENT '利息',
  `loan_method` int(11) DEFAULT NULL COMMENT '贷款方式（1：信贷 2：抵押 3：转按）',
  `other` varchar(1024) DEFAULT NULL COMMENT '其他需求',
  `remark` varchar(1024) DEFAULT NULL,
  `create_by` bigint(20) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL,
  `update_by` bigint(20) DEFAULT NULL COMMENT '更新人',
  `update_time` datetime DEFAULT NULL,
  `yn` int(11) DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of td_demand
-- ----------------------------
INSERT INTO `td_demand` VALUES ('1', '29', '122.00', '21.00', '2', '仓单的是打成', null, '3', '2018-08-27 17:44:28', '3', '2018-09-01 06:09:57', '1');

-- ----------------------------
-- Table structure for td_estate
-- ----------------------------
DROP TABLE IF EXISTS `td_estate`;
CREATE TABLE `td_estate` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `customer_id` bigint(20) DEFAULT NULL,
  `address` varchar(1024) DEFAULT NULL COMMENT '地址',
  `area` decimal(12,4) DEFAULT NULL COMMENT '面积',
  `purchase_time` datetime DEFAULT NULL COMMENT '购买时间',
  `pledge_bank` varchar(255) DEFAULT NULL COMMENT '质押银行',
  `pledge_time` datetime DEFAULT NULL COMMENT '质押时间',
  `loan_term` int(11) DEFAULT NULL COMMENT '贷款年限',
  `loan_limit` decimal(12,2) DEFAULT NULL COMMENT '贷款额度',
  `monthly_supply` decimal(10,0) DEFAULT NULL COMMENT '月供',
  `proof_data_file` varchar(255) DEFAULT NULL COMMENT '证明资料原件',
  `remark` varchar(1024) DEFAULT NULL,
  `create_by` bigint(20) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL,
  `update_by` bigint(20) DEFAULT NULL COMMENT '更新人',
  `update_time` datetime DEFAULT NULL,
  `yn` int(11) DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of td_estate
-- ----------------------------
INSERT INTO `td_estate` VALUES ('1', '29', '是第四份的范德萨发', '213.0000', '2018-05-09 00:00:00', '工商', '2018-08-07 00:00:00', '122', '3123213.00', '2321', null, '试点示范东方', '3', '2018-08-23 16:48:16', '3', '2018-08-26 22:01:14', '1');

-- ----------------------------
-- Table structure for td_liability
-- ----------------------------
DROP TABLE IF EXISTS `td_liability`;
CREATE TABLE `td_liability` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `customer_id` bigint(20) DEFAULT NULL COMMENT '客户ID',
  `credit_loan` varchar(255) DEFAULT NULL COMMENT '银行或者金融公司信用贷款',
  `credit_card_number` int(11) DEFAULT NULL COMMENT '信用卡张数',
  `credit_card_amount` decimal(12,2) DEFAULT NULL COMMENT '信用卡总额度',
  `credit_card_half_use` decimal(12,2) DEFAULT NULL COMMENT '信用卡近半年使用额度',
  `credit_card_current_use` decimal(12,2) DEFAULT NULL COMMENT '信用卡当前使用额度',
  `not_small_loan` decimal(12,2) DEFAULT NULL COMMENT '未结清小额贷款',
  `query_times_text` varchar(255) DEFAULT NULL COMMENT '近2个月查询次数简单说明（贷款，信用卡，个人查询）',
  `credit_investigation` varchar(255) DEFAULT NULL COMMENT '征信',
  `remark` varchar(1024) DEFAULT NULL,
  `create_by` bigint(20) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL,
  `update_by` bigint(20) DEFAULT NULL COMMENT '更新人',
  `update_time` datetime DEFAULT NULL,
  `yn` int(11) DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of td_liability
-- ----------------------------
INSERT INTO `td_liability` VALUES ('1', '29', '2323223', '3', '213.00', '11.00', '1.00', '1.00', '2323', '233', null, '3', '2018-08-27 17:05:09', '3', '2018-09-01 06:07:02', '1');

-- ----------------------------
-- Table structure for td_policy
-- ----------------------------
DROP TABLE IF EXISTS `td_policy`;
CREATE TABLE `td_policy` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `customer_id` bigint(20) DEFAULT NULL,
  `insurance_company` varchar(255) DEFAULT NULL COMMENT '保险公司',
  `insurance_name` varchar(255) DEFAULT NULL COMMENT '保险名称',
  `buy_time` datetime DEFAULT NULL COMMENT '购买时间',
  `buy_price` decimal(12,2) DEFAULT NULL COMMENT '购买价格',
  `remark` varchar(1024) DEFAULT NULL,
  `create_by` bigint(20) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL,
  `update_by` bigint(20) DEFAULT NULL COMMENT '更新人',
  `update_time` datetime DEFAULT NULL,
  `yn` int(11) DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of td_policy
-- ----------------------------
INSERT INTO `td_policy` VALUES ('1', '29', '平安保险', '平安福', '2018-08-08 00:00:00', '10000.00', null, '3', '2018-08-26 22:30:58', '3', '2018-08-27 15:23:23', '1');
INSERT INTO `td_policy` VALUES ('3', '29', '人寿保险', '重疾险', '2018-05-16 00:00:00', '32122.00', null, '3', '2018-08-26 22:33:13', '3', '2018-08-27 15:23:31', '1');

-- ----------------------------
-- Table structure for td_profession
-- ----------------------------
DROP TABLE IF EXISTS `td_profession`;
CREATE TABLE `td_profession` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `customer_id` bigint(20) DEFAULT NULL COMMENT '客户id',
  `company_name` varchar(100) DEFAULT NULL COMMENT '单位名称',
  `company_nature` varchar(50) DEFAULT NULL COMMENT '单位性质',
  `telephone` varchar(20) DEFAULT NULL COMMENT '单位电话',
  `company_address` varchar(100) DEFAULT NULL COMMENT '单位地址',
  `dept_name` varchar(50) DEFAULT NULL COMMENT '部门',
  `wage_model` int(11) DEFAULT NULL COMMENT '工资模式',
  `industry` varchar(255) DEFAULT NULL COMMENT '行业',
  `company_size` varchar(255) DEFAULT NULL COMMENT '公司规模',
  `social_security_years` int(11) DEFAULT NULL COMMENT '社保年限',
  `social_security_base` decimal(12,3) DEFAULT NULL COMMENT '社保基数',
  `position` varchar(50) DEFAULT NULL COMMENT '职位',
  `working_life` int(11) DEFAULT '0' COMMENT '工作年限',
  `month_income` decimal(12,3) DEFAULT NULL COMMENT '月收入',
  `payday` date DEFAULT NULL COMMENT '发薪日',
  `remark` varchar(1024) DEFAULT NULL,
  `create_by` bigint(20) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL,
  `update_by` bigint(20) DEFAULT NULL COMMENT '更新人',
  `update_time` datetime DEFAULT NULL,
  `yn` int(11) DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=utf8 COMMENT='客户职业资料';

-- ----------------------------
-- Records of td_profession
-- ----------------------------
INSERT INTO `td_profession` VALUES ('43', '31', 'fdfdfd', null, null, null, 'sfsdfsd', '1', 'sdfd', null, null, '20000.000', 'sdfds', '0', '20000.000', null, null, '3', '2018-08-20 11:41:35', '3', '2018-08-20 11:41:35', '1');
INSERT INTO `td_profession` VALUES ('44', '32', '反反复复凤飞飞', null, null, null, '发的额', '1', '烦烦烦', '丰富的', '2', '32122.000', '的房地产', '0', '213213.000', null, null, '3', '2018-08-23 09:36:33', '3', '2018-08-23 09:36:33', '1');
INSERT INTO `td_profession` VALUES ('45', '33', '54', null, null, null, '333', '1', '额', '43243', '23', '33.000', '备份', '0', '32.000', null, null, '3', '2018-08-23 09:58:33', '3', '2018-08-23 09:59:34', '1');
INSERT INTO `td_profession` VALUES ('47', '29', 'wqewewewe', null, null, null, 'qeqwe', '2', 'wewqe', 'qeqwe', '22', '2122.000', '221', '0', '213.000', null, null, '3', '2018-08-26 22:27:54', '3', '2018-09-01 05:43:27', '1');

-- ----------------------------
-- Table structure for td_programme
-- ----------------------------
DROP TABLE IF EXISTS `td_programme`;
CREATE TABLE `td_programme` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `customer_id` bigint(20) DEFAULT NULL,
  `customer_manager_proposal` varchar(1024) DEFAULT NULL COMMENT '客户经理建议',
  `director_programme` varchar(1024) DEFAULT NULL COMMENT '主管方案',
  `appropriation_result` varchar(1024) DEFAULT NULL COMMENT '批款结果',
  `follow_up_proposal` varchar(1024) DEFAULT NULL COMMENT '跟进建议',
  `remark` varchar(1024) DEFAULT NULL,
  `create_by` bigint(20) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL,
  `update_by` bigint(20) DEFAULT NULL COMMENT '更新人',
  `update_time` datetime DEFAULT NULL,
  `yn` int(11) DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of td_programme
-- ----------------------------

-- ----------------------------
-- Table structure for td_vehicle
-- ----------------------------
DROP TABLE IF EXISTS `td_vehicle`;
CREATE TABLE `td_vehicle` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `customer_id` bigint(20) DEFAULT NULL COMMENT '客户ID',
  `brand` varchar(255) DEFAULT NULL COMMENT '品牌',
  `car_number` varchar(255) DEFAULT NULL COMMENT '车牌号',
  `buy_time` datetime DEFAULT NULL COMMENT '购买时间',
  `buy_price` decimal(12,2) DEFAULT NULL COMMENT '购买价格',
  `buy_mothod` varchar(255) DEFAULT NULL COMMENT '购买方式',
  `pledge_bank` varchar(255) DEFAULT NULL COMMENT '质押银行',
  `pledge_time` datetime DEFAULT NULL COMMENT '质押时间',
  `monthly_supply` decimal(12,2) DEFAULT NULL COMMENT '月供',
  `vehicle_registration` varchar(255) DEFAULT NULL COMMENT '车辆登记证',
  `remark` varchar(1024) DEFAULT NULL,
  `create_by` bigint(20) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL,
  `update_by` bigint(20) DEFAULT NULL COMMENT '更新人',
  `update_time` datetime DEFAULT NULL,
  `yn` int(11) DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of td_vehicle
-- ----------------------------
INSERT INTO `td_vehicle` VALUES ('1', '29', '大众', '粤B-ded33', '2018-08-06 00:00:00', '150000.00', '全款', '无', '2018-07-31 00:00:00', '0.00', null, null, '3', '2018-08-27 15:20:19', '3', '2018-08-27 15:22:24', '1');
INSERT INTO `td_vehicle` VALUES ('2', '29', '现代', '粤B-ewd3we3', '2018-07-29 00:00:00', '200000.00', '贷款', '交通银行', '2018-08-08 00:00:00', '32000.00', null, null, '3', '2018-08-27 15:21:09', '3', '2018-08-27 15:21:09', '1');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `dept_id` int(11) DEFAULT NULL,
  `account` varchar(50) DEFAULT NULL,
  `password` varchar(64) DEFAULT NULL,
  `name` varchar(80) DEFAULT NULL,
  `telephone` varchar(15) DEFAULT NULL,
  `mobile` varchar(20) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `remark` varchar(1024) DEFAULT NULL,
  `create_by` bigint(128) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_by` bigint(128) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `yn` int(11) DEFAULT NULL,
  `account_msg` varchar(1000) DEFAULT NULL COMMENT '帐户信息',
  `hostel_name` varchar(1000) DEFAULT NULL COMMENT '客栈名称',
  `royalty_rate` decimal(5,4) DEFAULT NULL COMMENT '提成率',
  `online_time` datetime DEFAULT NULL COMMENT '上线时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('3', null, 'admin', '21232f297a57a5a743894a0e4a801fc3', '路建军', '0755-87654321', '13725530664', '672859954@qq.com', null, '1', null, '3', '2017-06-18 21:16:48', '3', '2017-06-23 00:29:35', '1', null, null, null, null);
INSERT INTO `user` VALUES ('17', null, 'zhangsan', '21218cca77804d2ba1922c33e0151105', '张三', '0755-90909090', '13409870000', '908723416@qq.com', null, '2', null, '3', '2017-06-21 21:08:40', '17', '2017-06-22 23:01:02', '1', null, null, null, null);
INSERT INTO `user` VALUES ('21', null, 'wangwu', '96e79218965eb72c92a549dd5a330112', '王五', '0755-90909090', '13454323345', '586746352@qq.com', null, '2', null, '3', '2017-07-03 17:34:34', '3', '2018-08-29 10:40:53', '1', null, null, null, null);
INSERT INTO `user` VALUES ('23', null, 'lisi', '21218cca77804d2ba1922c33e0151105', '李四', '0755-80876789', '13245657890', '34657898652@qq.com', null, '1', null, '3', '2018-08-29 10:41:33', '3', '2018-08-29 10:41:33', '1', null, null, null, null);

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES ('21', '3', '15');
INSERT INTO `user_role` VALUES ('28', '17', '27');
INSERT INTO `user_role` VALUES ('35', '21', '32');
INSERT INTO `user_role` VALUES ('36', '23', '33');

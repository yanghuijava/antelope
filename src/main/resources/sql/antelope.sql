/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50626
Source Host           : localhost:3306
Source Database       : antelope

Target Server Type    : MYSQL
Target Server Version : 50626
File Encoding         : 65001

Date: 2018-07-03 12:01:23
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
) ENGINE=InnoDB AUTO_INCREMENT=69 DEFAULT CHARSET=utf8;

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
INSERT INTO `resource` VALUES ('65', '64', '2', '客户资料', 'customer', '1', '/customer/listUI.html', '/customer/listUI.html', '', null, '3', '2017-06-23 20:13:57', '3', '2017-06-23 20:13:57', '1');
INSERT INTO `resource` VALUES ('67', '17', '0', '没有修改密码', 'NOUPDATEPWD', null, null, '/noUpdatePwd.html', null, null, '3', '2017-07-03 18:14:08', '3', '2017-07-03 18:14:08', '1');
INSERT INTO `resource` VALUES ('68', null, null, 'fffffff', null, null, null, null, null, null, null, '2017-07-06 17:27:22', null, '2017-07-06 17:27:22', '1');

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
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('15', 'administrator', '超级管理员', '最高权限拥有者', null, '3', '2017-06-20 10:06:55', '3', '2017-06-20 21:34:30', '1');
INSERT INTO `role` VALUES ('27', 'kehujingli', '客户经理', '业务人员', null, '3', '2017-06-21 22:27:13', '3', '2017-06-22 12:50:41', '1');
INSERT INTO `role` VALUES ('31', 'clerk', '文员', '', null, '3', '2017-06-22 12:51:38', '3', '2017-06-22 12:51:38', '1');

-- ----------------------------
-- Table structure for role_resource
-- ----------------------------
DROP TABLE IF EXISTS `role_resource`;
CREATE TABLE `role_resource` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) DEFAULT NULL,
  `res_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=435 DEFAULT CHARSET=utf8;

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
INSERT INTO `role_resource` VALUES ('412', '31', '17');
INSERT INTO `role_resource` VALUES ('413', '31', '47');
INSERT INTO `role_resource` VALUES ('414', '31', '48');
INSERT INTO `role_resource` VALUES ('415', '31', '67');
INSERT INTO `role_resource` VALUES ('416', '27', '17');
INSERT INTO `role_resource` VALUES ('417', '27', '47');
INSERT INTO `role_resource` VALUES ('418', '27', '48');
INSERT INTO `role_resource` VALUES ('419', '27', '67');
INSERT INTO `role_resource` VALUES ('420', '27', '18');
INSERT INTO `role_resource` VALUES ('421', '27', '21');
INSERT INTO `role_resource` VALUES ('422', '27', '49');
INSERT INTO `role_resource` VALUES ('423', '27', '50');
INSERT INTO `role_resource` VALUES ('424', '27', '54');
INSERT INTO `role_resource` VALUES ('425', '27', '56');
INSERT INTO `role_resource` VALUES ('426', '27', '35');
INSERT INTO `role_resource` VALUES ('427', '27', '36');
INSERT INTO `role_resource` VALUES ('428', '27', '53');
INSERT INTO `role_resource` VALUES ('429', '27', '57');
INSERT INTO `role_resource` VALUES ('430', '27', '58');
INSERT INTO `role_resource` VALUES ('431', '27', '60');
INSERT INTO `role_resource` VALUES ('432', '27', '61');
INSERT INTO `role_resource` VALUES ('433', '27', '59');
INSERT INTO `role_resource` VALUES ('434', '27', '62');

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='生意资料';

-- ----------------------------
-- Records of td_business
-- ----------------------------

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
  `remark` varchar(1024) DEFAULT NULL,
  `create_by` bigint(20) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL,
  `update_by` bigint(20) DEFAULT NULL COMMENT '更新人',
  `update_time` datetime DEFAULT NULL,
  `yn` int(11) DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8 COMMENT='客户资料表';

-- ----------------------------
-- Records of td_customer
-- ----------------------------
INSERT INTO `td_customer` VALUES ('19', 'we', 'wqswqs232132132122', '23232323232', '3', '223', '22', '23232', '2w22', '1', '2018-06-25', '1', null, null, null, '3', '2018-07-02 21:38:03', '3', '2018-07-03 11:23:56', '1');
INSERT INTO `td_customer` VALUES ('20', 'qw2', '23232321312323222X', '23213213232', '3', '2e2', 'e3e', 'ee', '2e32e', '1', '2018-06-24', '1', null, null, null, '3', '2018-07-02 21:40:02', '3', '2018-07-02 21:40:02', '1');
INSERT INTO `td_customer` VALUES ('21', '343', '343232323223333333', '33223232132', '3', '22', 'e2e12', '2w2w', '21e21e21e1', '2', '2018-06-24', '2', null, null, null, '3', '2018-07-02 22:22:59', '3', '2018-07-02 22:22:59', '1');
INSERT INTO `td_customer` VALUES ('22', '23', '232233323232323332', '32323233222', '3', 'wewe', 'wewe', 'ewq', 'weewe', '1', '2018-06-24', '3', null, null, null, '3', '2018-07-03 09:47:47', '3', '2018-07-03 09:47:47', '1');
INSERT INTO `td_customer` VALUES ('24', '3423', '324244232323423434', '23423432222', '3', '23', '242', '24', '24242', '2', '2018-06-26', '1', null, null, null, '3', '2018-07-03 10:07:08', '3', '2018-07-03 10:07:08', '1');
INSERT INTO `td_customer` VALUES ('25', '132', '131232323231231113', '12323123311', '3', '123', '1312', '12332', '13131', '1', '2018-06-28', '1', null, null, null, '3', '2018-07-03 11:18:33', '3', '2018-07-03 11:18:33', '1');
INSERT INTO `td_customer` VALUES ('26', '423423', '234242424242423233', '33322222233', '3', '332', '饿2', '233', '饿额恶心', '2', '2018-06-24', '1', null, null, null, '3', '2018-07-03 11:20:51', '3', '2018-07-03 11:20:51', '1');
INSERT INTO `td_customer` VALUES ('27', '4545', '353535353535344444', '45455445433', '3', '34', '4334', '34', '3434', '3', '2018-07-04', '3', null, null, null, '3', '2018-07-03 11:26:06', '3', '2018-07-03 11:26:06', '1');

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
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=utf8 COMMENT='客户职业资料';

-- ----------------------------
-- Records of td_profession
-- ----------------------------
INSERT INTO `td_profession` VALUES ('40', '22', 'ewewe', 'wew', 'werw', 'weew', 'weew', 'wewew', '1', '212.000', '2018-06-23', null, '3', '2018-07-03 09:48:05', '3', '2018-07-03 09:53:42', '1');

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
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('3', null, 'admin', '21232f297a57a5a743894a0e4a801fc3', '路建军', '0755-87654321', '13725530664', '672859954@qq.com', null, '1', null, '3', '2017-06-18 21:16:48', '3', '2017-06-23 00:29:35', '1', null, null, null, null);
INSERT INTO `user` VALUES ('17', null, 'zhangsan', '21218cca77804d2ba1922c33e0151105', '张三', '0755-90909090', '13409870000', '908723416@qq.com', null, '2', null, '3', '2017-06-21 21:08:40', '17', '2017-06-22 23:01:02', '1', null, null, null, null);
INSERT INTO `user` VALUES ('20', null, 'lisi', '21218cca77804d2ba1922c33e0151105', '李四', '0755-00000090', '13523457654', '324564321@qq.com', null, '1', null, '3', '2017-06-23 00:31:28', '3', '2017-06-23 00:32:11', '1', null, null, null, null);
INSERT INTO `user` VALUES ('21', null, 'wangwu', '96e79218965eb72c92a549dd5a330112', '王五', '0755-90909090', '13454323345', '586746352@qq.com', null, '2', null, '3', '2017-07-03 17:34:34', '3', '2017-07-03 18:41:13', '1', null, null, null, null);
INSERT INTO `user` VALUES ('22', null, 'hujunzhong', '21218cca77804d2ba1922c33e0151105', '老胡', '0755-98765432', '13267890987', ' 765321231@qq.com', null, '1', null, '3', '2017-07-04 20:38:45', '3', '2017-07-04 20:38:45', '1', null, null, null, null);

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES ('21', '3', '15');
INSERT INTO `user_role` VALUES ('28', '17', '27');
INSERT INTO `user_role` VALUES ('31', '20', '31');
INSERT INTO `user_role` VALUES ('33', '21', '27');
INSERT INTO `user_role` VALUES ('34', '22', '27');

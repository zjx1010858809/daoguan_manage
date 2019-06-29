/*
Navicat MySQL Data Transfer

Source Server         : root
Source Server Version : 50133
Source Host           : localhost:3306
Source Database       : daoguan_manage

Target Server Type    : MYSQL
Target Server Version : 50133
File Encoding         : 65001

Date: 2019-06-29 22:13:50
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `course`
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `parent_id` int(11) NOT NULL,
  `comments` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES ('1', '武术', '0', '阿萨德发');
INSERT INTO `course` VALUES ('2', '跆拳道', '0', 'asdfsdfsad');

-- ----------------------------
-- Table structure for `operator`
-- ----------------------------
DROP TABLE IF EXISTS `operator`;
CREATE TABLE `operator` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nike` varchar(32) NOT NULL,
  `pass` varchar(32) NOT NULL,
  `name` varchar(32) NOT NULL,
  `sex` int(11) NOT NULL,
  `age` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of operator
-- ----------------------------
INSERT INTO `operator` VALUES ('1', '13127033965', '123', '张家祥', '0', '22');
INSERT INTO `operator` VALUES ('7', '13386421106', '123', '祥子', '0', '22');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nike` varchar(32) NOT NULL,
  `pass` varchar(32) NOT NULL,
  `name` varchar(32) NOT NULL,
  `sex` int(11) NOT NULL,
  `age` int(11) NOT NULL,
  `birthday` varchar(32) NOT NULL,
  `course_id` int(11) NOT NULL,
  `status` int(11) NOT NULL,
  `dress` varchar(255) NOT NULL,
  `times` int(11) NOT NULL,
  `comments` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '13127033965', '123', '家祥', '0', '22', '04-06', '1', '0', '青岛农业大学西苑', '0', '表现很好');
INSERT INTO `user` VALUES ('2', '123', '123', '123', '1', '12', '11-24', '2', '0', '123', '0', '1123');
INSERT INTO `user` VALUES ('3', '22222', '123', '1111', '1', '3333', '444', '1', '0', '5555', '0', '6666');
INSERT INTO `user` VALUES ('4', '222222', '123', '111111', '1', '33333', '444444', '1', '0', '5555', '0', '666666');
INSERT INTO `user` VALUES ('5', '123', '123', 'sdfg', '0', '22', '11-06', '2', '0', '123', '0', '123');
INSERT INTO `user` VALUES ('7', '888', '123', '8888', '1', '20', '10-12', '2', '0', '888', '0', '8888');

/*
 Navicat Premium Data Transfer

 Source Server         : 192.168.6.128
 Source Server Type    : MySQL
 Source Server Version : 50651
 Source Host           : 192.168.6.128:3306
 Source Schema         : seata_order

 Target Server Type    : MySQL
 Target Server Version : 50651
 File Encoding         : 65001

 Date: 21/01/2022 11:04:40
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NULL DEFAULT NULL,
  `stock_id` int(11) NULL DEFAULT NULL,
  `count` int(10) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 22 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of order
-- ----------------------------
INSERT INTO `order` VALUES (13, 1, 1, 100);


-- ----------------------------
-- Table structure for undo_log
-- ----------------------------
DROP TABLE IF EXISTS `undo_log`;
CREATE TABLE `undo_log`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `branch_id` bigint(20) NOT NULL,
  `xid` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `context` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `rollback_info` longblob NOT NULL,
  `log_status` int(11) NOT NULL,
  `log_created` datetime NOT NULL,
  `log_modified` datetime NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `ux_undo_log`(`xid`, `branch_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 28 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of undo_log
-- ----------------------------
INSERT INTO `undo_log` VALUES (3, 1324279361779597314, '172.25.128.1:8091:1324279361779597313', 'serializer=jackson&compressorType=NONE', 0x7B7D, 1, '2022-01-17 18:26:03', '2022-01-17 18:26:03');
INSERT INTO `undo_log` VALUES (6, 1324279361779597317, '172.25.128.1:8091:1324279361779597316', 'serializer=jackson&compressorType=NONE', 0x7B7D, 1, '2022-01-17 18:26:19', '2022-01-17 18:26:19');
INSERT INTO `undo_log` VALUES (9, 1324279361779597320, '172.25.128.1:8091:1324279361779597319', 'serializer=jackson&compressorType=NONE', 0x7B7D, 1, '2022-01-17 18:26:25', '2022-01-17 18:26:25');
INSERT INTO `undo_log` VALUES (12, 1324279361779597323, '172.25.128.1:8091:1324279361779597322', 'serializer=jackson&compressorType=NONE', 0x7B7D, 1, '2022-01-17 18:27:34', '2022-01-17 18:27:34');
INSERT INTO `undo_log` VALUES (15, 1324279361779597326, '172.25.128.1:8091:1324279361779597325', 'serializer=jackson&compressorType=NONE', 0x7B7D, 1, '2022-01-17 18:33:52', '2022-01-17 18:33:52');
INSERT INTO `undo_log` VALUES (18, 1324279361779597331, '172.25.128.1:8091:1324279361779597328', 'serializer=jackson&compressorType=NONE', 0x7B7D, 1, '2022-01-17 18:39:54', '2022-01-17 18:39:54');
INSERT INTO `undo_log` VALUES (19, 1324279361779597329, '172.25.128.1:8091:1324279361779597328', 'serializer=jackson&compressorType=NONE', 0x7B7D, 1, '2022-01-17 18:39:54', '2022-01-17 18:39:54');
INSERT INTO `undo_log` VALUES (22, 1099100111504207880, '172.25.128.1:8091:1099100111504207877', 'serializer=jackson&compressorType=NONE', 0x7B7D, 1, '2022-01-20 16:55:28', '2022-01-20 16:55:28');
INSERT INTO `undo_log` VALUES (23, 1099100111504207878, '172.25.128.1:8091:1099100111504207877', 'serializer=jackson&compressorType=NONE', 0x7B7D, 1, '2022-01-20 16:55:28', '2022-01-20 16:55:28');
INSERT INTO `undo_log` VALUES (26, 1099100111504207885, '172.25.128.1:8091:1099100111504207882', 'serializer=jackson&compressorType=NONE', 0x7B7D, 1, '2022-01-20 17:05:42', '2022-01-20 17:05:42');
INSERT INTO `undo_log` VALUES (27, 1099100111504207883, '172.25.128.1:8091:1099100111504207882', 'serializer=jackson&compressorType=NONE', 0x7B7D, 1, '2022-01-20 17:05:42', '2022-01-20 17:05:42');

SET FOREIGN_KEY_CHECKS = 1;

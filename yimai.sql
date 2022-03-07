/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50725
 Source Host           : localhost:3306
 Source Schema         : yimai

 Target Server Type    : MySQL
 Target Server Version : 50725
 File Encoding         : 65001

 Date: 07/03/2022 10:37:12
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for easybuy_comment
-- ----------------------------
DROP TABLE IF EXISTS `easybuy_comment`;
CREATE TABLE `easybuy_comment`  (
  `EC_ID` int(10) NOT NULL,
  `EC_CONTENT` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `EC_CREATE_TIME` date NOT NULL,
  `EC_REPLY` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `EC_REPLY_TIME` date NULL DEFAULT NULL,
  `EC_NICK_NAME` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`EC_ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of easybuy_comment
-- ----------------------------
INSERT INTO `easybuy_comment` VALUES (1, '刚订了台IPod，很是期待啊', '2012-12-12', 'qq', '2020-09-09', '小乖');
INSERT INTO `easybuy_comment` VALUES (2, '垃圾网站', '2012-12-02', 'zz', '2022-03-01', 'jack');
INSERT INTO `easybuy_comment` VALUES (3, '123', '2022-03-02', NULL, NULL, 'qw');
INSERT INTO `easybuy_comment` VALUES (4, 'hklhksdf', '2022-03-07', NULL, NULL, 'user');
INSERT INTO `easybuy_comment` VALUES (5, '123', '2022-03-07', NULL, NULL, 'user');
INSERT INTO `easybuy_comment` VALUES (6, '123', '2022-03-07', 'f123', '2022-03-07', 'user');

-- ----------------------------
-- Table structure for easybuy_news
-- ----------------------------
DROP TABLE IF EXISTS `easybuy_news`;
CREATE TABLE `easybuy_news`  (
  `EN_ID` int(10) NOT NULL,
  `EN_TITLE` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `EN_CONTENT` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `EN_CREATE_TIME` date NOT NULL,
  PRIMARY KEY (`EN_ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of easybuy_news
-- ----------------------------
INSERT INTO `easybuy_news` VALUES (1, '最新酷睿笔记本', 'IBME系列全场促销中，最新酷睿双核处理器，保证CPU更高效的运转。', '2010-03-12');
INSERT INTO `easybuy_news` VALUES (2, '团购无忧', 'hgdbi', '2022-03-07');
INSERT INTO `easybuy_news` VALUES (3, '会员特惠月开始了', '会员特惠月开始了', '2010-02-12');
INSERT INTO `easybuy_news` VALUES (4, '迎双旦促销大酬宾', '迎双旦促销大酬宾', '2010-03-12');
INSERT INTO `easybuy_news` VALUES (7, '123', '123', '2022-03-01');
INSERT INTO `easybuy_news` VALUES (8, 'hgfbnwko', 'bfihnckl', '2022-03-07');

-- ----------------------------
-- Table structure for easybuy_order
-- ----------------------------
DROP TABLE IF EXISTS `easybuy_order`;
CREATE TABLE `easybuy_order`  (
  `EO_ID` int(10) NOT NULL,
  `EO_USER_ID` int(10) NOT NULL,
  `EO_USER_NAME` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `EO_USER_ADDRESS` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `EO_CREATE_TIME` date NOT NULL,
  `EO_COST` decimal(10, 2) NOT NULL,
  `EO_STATUS` int(6) NOT NULL,
  `EO_TYPE` int(6) NOT NULL,
  PRIMARY KEY (`EO_ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of easybuy_order
-- ----------------------------
INSERT INTO `easybuy_order` VALUES (12, 12, 'tom', 'sfd球村', '2022-03-01', 100.22, 2, 2);
INSERT INTO `easybuy_order` VALUES (65, 12, 'jack', 'sfd球村', '2022-03-01', 100.22, 2, 2);
INSERT INTO `easybuy_order` VALUES (66, 16, 'user', '321', '2022-03-03', 200.00, 1, 2);

-- ----------------------------
-- Table structure for easybuy_order_detail
-- ----------------------------
DROP TABLE IF EXISTS `easybuy_order_detail`;
CREATE TABLE `easybuy_order_detail`  (
  `EOD_ID` int(10) NOT NULL,
  `EO_ID` int(10) NOT NULL,
  `EP_ID` int(10) NOT NULL,
  `EOD_QUANTITY` int(6) NOT NULL,
  `EOD_COST` decimal(10, 2) NOT NULL,
  PRIMARY KEY (`EOD_ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of easybuy_order_detail
-- ----------------------------

-- ----------------------------
-- Table structure for easybuy_product
-- ----------------------------
DROP TABLE IF EXISTS `easybuy_product`;
CREATE TABLE `easybuy_product`  (
  `EP_ID` int(10) NOT NULL AUTO_INCREMENT,
  `EP_NAME` varchar(55) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `EP_DESCRIPTION` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `EP_PRICE` decimal(10, 2) NOT NULL,
  `EP_STOCK` int(10) NOT NULL,
  `EPC_ID` int(10) NULL DEFAULT NULL,
  `EPC_CHILD_ID` int(10) NULL DEFAULT NULL,
  `EP_FILE_NAME` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`EP_ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 788 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of easybuy_product
-- ----------------------------
INSERT INTO `easybuy_product` VALUES (591, '画册', '画册', 100.00, 9999, 654, 542, '591.jpg');
INSERT INTO `easybuy_product` VALUES (592, '饭盒', '韩国风格', 200.00, 1997, 545, 545, '592.jpg');
INSERT INTO `easybuy_product` VALUES (593, '护肤王', '女士专用', 300.00, 29998, 542, 542, '596.jpg');
INSERT INTO `easybuy_product` VALUES (601, '奶粉', '三元', 20.00, 199, NULL, 545, '601.jpg');
INSERT INTO `easybuy_product` VALUES (639, '旅行包', '旅行包', 2.00, 0, 545, 545, '641.jpg');
INSERT INTO `easybuy_product` VALUES (643, '项链', '饰品', 300.00, 2996, 545, 545, '643.jpg');
INSERT INTO `easybuy_product` VALUES (645, '丝袜', '女士', 50.00, 500, 545, 545, '645.jpg');
INSERT INTO `easybuy_product` VALUES (660, '显示器', '三星', 20.00, 2000, 545, 545, '660.jpg');
INSERT INTO `easybuy_product` VALUES (663, '液晶屏', '纯平液晶显示器', 590.00, 3, 545, 545, '663.jpg');
INSERT INTO `easybuy_product` VALUES (666, '法国德菲丝松露精品巧克力500g/盒', '法国德菲丝松露精品巧克力500g/盒', 108.00, 4000, 630, 545, '1.jpg');
INSERT INTO `easybuy_product` VALUES (667, '乐扣普通型保鲜盒圣诞7件套', '乐扣普通型保鲜盒圣诞7件套', 67.00, 10000, 545, 545, '2.jpg');
INSERT INTO `easybuy_product` VALUES (668, '欧珀莱均衡保湿四件套', '欧珀莱均衡保湿四件套', 279.00, 23600, 545, 545, '3.jpg');
INSERT INTO `easybuy_product` VALUES (669, '联想笔记本电脑 高速独立显存', '联想笔记本电脑 高速独立显存', 4199.00, 8000, 545, 545, '4.jpg');
INSERT INTO `easybuy_product` VALUES (671, '法姿韩版显瘦彩边时尚牛仔铅笔裤', '法姿韩版显瘦彩边时尚牛仔铅笔裤', 68.00, 6000, 548, 545, '5.jpg');
INSERT INTO `easybuy_product` VALUES (673, '多美滋金装金盾3阶段幼儿配方奶粉', '多美滋金装金盾3阶段幼儿配方奶粉', 186.00, 5880, 548, 545, '10.jpg');
INSERT INTO `easybuy_product` VALUES (676, 'Genius925纯银施华洛世奇水晶吊坠', 'Genius925纯银施华洛世奇水晶吊坠', 1000.00, 1000, 650, 545, '6.jpg');
INSERT INTO `easybuy_product` VALUES (677, '利仁2018M福满堂电饼铛 好用实惠', '利仁2018M福满堂电饼铛 好用实惠', 459.00, 2000, 651, 545, '7.jpg');
INSERT INTO `easybuy_product` VALUES (678, '达派高档拉杆箱20寸 经典款式', '达派高档拉杆箱20寸 经典款式', 300.00, 4600, 545, 545, '8.jpg');
INSERT INTO `easybuy_product` VALUES (679, '铁三角  银色 挂耳式耳机', '铁三角 Audio-Technica ATH-EQ300M-SV 银色 挂耳式耳机', 1000.00, 5400, 658, 545, '0.jpg');
INSERT INTO `easybuy_product` VALUES (680, '法国德菲丝松露精品巧克力500g/盒', '法国德菲丝松露精品巧克力500g/盒', 108.00, 4000, 630, 545, '1.jpg');
INSERT INTO `easybuy_product` VALUES (681, '联想笔记本电脑 高速独立显存II1', '联想笔记本电脑 高速独立显存', 7890.00, 3000, 653, 545, '12 (1).jpg');
INSERT INTO `easybuy_product` VALUES (682, '联想笔记本电脑 高速独立显存II2', '联想笔记本电脑 高速独立显存', 7890.00, 3000, 653, 545, '12 (2).jpg');
INSERT INTO `easybuy_product` VALUES (683, '联想笔记本电脑 高速独立显存II3', '联想笔记本电脑 高速独立显存', 7890.00, 3000, 653, 545, '12 (3).jpg');
INSERT INTO `easybuy_product` VALUES (684, '联想笔记本电脑 高速独立显存II4', '联想笔记本电脑 高速独立显存', 7890.00, 3000, 652, 545, '12 (4).jpg');
INSERT INTO `easybuy_product` VALUES (685, '达派高档拉杆箱20寸 经典款式', '联想笔记本电脑 高速独立显存', 7890.00, 3000, 652, 545, '12 (5).jpg');
INSERT INTO `easybuy_product` VALUES (686, '联想笔记本电脑 高速独立显存II6', '联想笔记本电脑 高速独立显存', 7890.00, 3000, 652, 545, '12 (6).jpg');
INSERT INTO `easybuy_product` VALUES (687, '联想笔记本电脑 高速独立显存II7', '联想笔记本电脑 高速独立显存', 7890.00, 3000, 652, 545, '12 (7).jpg');
INSERT INTO `easybuy_product` VALUES (688, '联想笔记本电脑 高速独立显存II8', '联想笔记本电脑 高速独立显存', 7890.00, 3000, 652, 545, '12 (8).jpg');
INSERT INTO `easybuy_product` VALUES (689, '法姿韩版显瘦彩边时尚牛仔铅笔裤II16', '联想笔记本电脑 高速独立显存', 7890.00, 3000, 652, 545, '12 (9).jpg');
INSERT INTO `easybuy_product` VALUES (690, '联想笔记本电脑 高速独立显存II10', '联想笔记本电脑 高速独立显存', 7890.00, 3000, 652, 545, '12 (10).jpg');
INSERT INTO `easybuy_product` VALUES (691, '联想笔记本电脑 高速独立显存II11', '联想笔记本电脑 高速独立显存', 7890.00, 3000, 652, 545, '12 (11).jpg');
INSERT INTO `easybuy_product` VALUES (692, '达派高档拉杆箱20寸 经典款式', '联想笔记本电脑 高速独立显存', 7890.00, 3000, 652, 545, '12 (12).jpg');
INSERT INTO `easybuy_product` VALUES (693, '达派高档拉杆箱20寸 经典款式', '联想笔记本电脑 高速独立显存', 7890.00, 3000, 652, 545, '12 (13).jpg');
INSERT INTO `easybuy_product` VALUES (694, '联想笔记本电脑 高速独立显存II14', '联想笔记本电脑 高速独立显存', 7890.00, 3000, 652, 545, '12 (14).jpg');
INSERT INTO `easybuy_product` VALUES (695, '联想笔记本电脑 高速独立显存II15', '联想笔记本电脑 高速独立显存', 7890.00, 3000, 652, 545, '12 (15).jpg');
INSERT INTO `easybuy_product` VALUES (696, '法姿韩版显瘦彩边时尚牛仔铅笔裤II16', '法姿韩版显瘦彩边时尚牛仔铅笔裤', 400.00, 3900, 640, 545, '12 (16).jpg');
INSERT INTO `easybuy_product` VALUES (697, '法姿韩版显瘦彩边时尚牛仔铅笔裤II17', '法姿韩版显瘦彩边时尚牛仔铅笔裤', 400.00, 3900, 640, 545, '12 (17).jpg');
INSERT INTO `easybuy_product` VALUES (698, '法姿韩版显瘦彩边时尚牛仔铅笔裤II18', '法姿韩版显瘦彩边时尚牛仔铅笔裤', 671.96, 3900, 640, 545, '12 (18).jpg');
INSERT INTO `easybuy_product` VALUES (699, '法姿韩版显瘦彩边时尚牛仔铅笔裤II19', '法姿韩版显瘦彩边时尚牛仔铅笔裤', 671.96, 3900, 640, 545, '12 (19).jpg');
INSERT INTO `easybuy_product` VALUES (700, '达派高档拉杆箱20寸 经典款式', '法姿韩版显瘦彩边时尚牛仔铅笔裤', 671.96, 3900, 640, 545, '12 (20).jpg');
INSERT INTO `easybuy_product` VALUES (701, '达派高档拉杆箱20寸 经典款式', '法姿韩版显瘦彩边时尚牛仔铅笔裤', 671.96, 3900, 640, 545, '12 (21).jpg');
INSERT INTO `easybuy_product` VALUES (702, '法姿韩版显瘦彩边时尚牛仔铅笔裤II22', '法姿韩版显瘦彩边时尚牛仔铅笔裤', 671.96, 3900, 640, 545, '12 (22).jpg');
INSERT INTO `easybuy_product` VALUES (703, '法姿韩版显瘦彩边时尚牛仔铅笔裤II23', '法姿韩版显瘦彩边时尚牛仔铅笔裤', 400.00, 3900, 640, 545, '12 (23).jpg');
INSERT INTO `easybuy_product` VALUES (704, '法姿韩版显瘦彩边时尚牛仔铅笔裤II24', '法姿韩版显瘦彩边时尚牛仔铅笔裤', 400.00, 3900, 640, 545, '12 (24).jpg');
INSERT INTO `easybuy_product` VALUES (705, '法姿韩版显瘦彩边时尚牛仔铅笔裤II25', '法姿韩版显瘦彩边时尚牛仔铅笔裤', 499.99, 3900, 640, 545, '12 (25).jpg');
INSERT INTO `easybuy_product` VALUES (706, '达派高档拉杆箱20寸 经典款式', '法姿韩版显瘦彩边时尚牛仔铅笔裤', 499.99, 3900, 640, 545, '12 (26).jpg');
INSERT INTO `easybuy_product` VALUES (707, '法姿韩版显瘦彩边时尚牛仔铅笔裤II27', '法姿韩版显瘦彩边时尚牛仔铅笔裤', 499.99, 3900, 640, 545, '12 (27).jpg');
INSERT INTO `easybuy_product` VALUES (708, '法姿韩版显瘦彩边时尚牛仔铅笔裤II28', '法姿韩版显瘦彩边时尚牛仔铅笔裤', 400.00, 3900, 640, 545, '12 (28).jpg');
INSERT INTO `easybuy_product` VALUES (709, '法姿韩版显瘦彩边时尚牛仔铅笔裤II29', '法姿韩版显瘦彩边时尚牛仔铅笔裤', 400.00, 3900, 640, 545, '12 (29).jpg');
INSERT INTO `easybuy_product` VALUES (710, '法姿韩版显瘦彩边时尚牛仔铅笔裤II30', '法姿韩版显瘦彩边时尚牛仔铅笔裤', 400.00, 3900, 653, 545, '12 (30).jpg');
INSERT INTO `easybuy_product` VALUES (711, '欧珀莱均衡保湿四件套II31', '欧珀莱均衡保湿四件套', 399.99, 5100, 653, 545, '12 (31).jpg');
INSERT INTO `easybuy_product` VALUES (712, '欧珀莱均衡保湿四件套II32', '欧珀莱均衡保湿四件套', 399.99, 5100, 653, 545, '12 (32).jpg');
INSERT INTO `easybuy_product` VALUES (713, '欧珀莱均衡保湿四件套II33', '欧珀莱均衡保湿四件套', 399.99, 5100, 653, 545, '12 (33).jpg');
INSERT INTO `easybuy_product` VALUES (714, '欧珀莱均衡保湿四件套II34', '欧珀莱均衡保湿四件套', 399.99, 5100, 548, 545, '12 (34).jpg');
INSERT INTO `easybuy_product` VALUES (715, '达派高档拉杆箱20寸 经典款式', '欧珀莱均衡保湿四件套', 399.99, 5100, 548, 545, '12 (35).jpg');
INSERT INTO `easybuy_product` VALUES (716, '欧珀莱均衡保湿四件套II36', '欧珀莱均衡保湿四件套', 399.99, 5100, 548, 545, '12 (36).jpg');
INSERT INTO `easybuy_product` VALUES (717, '欧珀莱均衡保湿四件套II37', '欧珀莱均衡保湿四件套', 399.99, 5100, 548, 545, '12 (37).jpg');
INSERT INTO `easybuy_product` VALUES (718, '达派高档拉杆箱20寸 经典款式', '欧珀莱均衡保湿四件套', 200.00, 5100, 548, 545, '12 (38).jpg');
INSERT INTO `easybuy_product` VALUES (719, '欧珀莱均衡保湿四件套II39', '欧珀莱均衡保湿四件套', 200.00, 5100, 548, 545, '12 (39).jpg');
INSERT INTO `easybuy_product` VALUES (720, '欧珀莱均衡保湿四件套II40', '欧珀莱均衡保湿四件套', 200.00, 5100, 548, 545, '12 (40).jpg');
INSERT INTO `easybuy_product` VALUES (721, '欧珀莱均衡保湿四件套II41', '欧珀莱均衡保湿四件套', 200.00, 5100, 548, 545, '12 (41).jpg');
INSERT INTO `easybuy_product` VALUES (722, '欧珀莱均衡保湿四件套II42', '欧珀莱均衡保湿四件套', 200.00, 5100, 548, 545, '12 (42).jpg');
INSERT INTO `easybuy_product` VALUES (723, '利仁2018M福满堂电饼铛 好用实惠II43', '利仁2018M福满堂电饼铛 好用实惠', 220.00, 12200, 626, 545, '12 (43).jpg');
INSERT INTO `easybuy_product` VALUES (724, '利仁2018M福满堂电饼铛 好用实惠II44', '利仁2018M福满堂电饼铛 好用实惠', 220.00, 12200, 626, 545, '12 (44).jpg');
INSERT INTO `easybuy_product` VALUES (725, '达派高档拉杆箱20寸 经典款式', '利仁2018M福满堂电饼铛 好用实惠', 220.00, 12200, 626, 545, '12 (45).jpg');
INSERT INTO `easybuy_product` VALUES (726, '利仁2018M福满堂电饼铛 好用实惠II46', '利仁2018M福满堂电饼铛 好用实惠', 220.00, 12200, 626, 545, '12 (46).jpg');
INSERT INTO `easybuy_product` VALUES (727, '利仁2018M福满堂电饼铛 好用实惠II47', '利仁2018M福满堂电饼铛 好用实惠', 220.00, 12200, 626, 545, '12 (47).jpg');
INSERT INTO `easybuy_product` VALUES (728, '利仁2018M福满堂电饼铛 好用实惠II48', '利仁2018M福满堂电饼铛 好用实惠', 220.00, 12200, 626, 545, '12 (48).jpg');
INSERT INTO `easybuy_product` VALUES (729, '达派高档拉杆箱20寸 经典款式', '利仁2018M福满堂电饼铛 好用实惠', 220.00, 12200, 626, 545, '12 (49).jpg');
INSERT INTO `easybuy_product` VALUES (730, '利仁2018M福满堂电饼铛 好用实惠II50', '利仁2018M福满堂电饼铛 好用实惠', 220.00, 12200, 626, 545, '12 (50).jpg');
INSERT INTO `easybuy_product` VALUES (731, '液晶屏II51', '液晶屏 好用实惠', 1500.99, 12200, 657, 545, '12 (51).jpg');
INSERT INTO `easybuy_product` VALUES (732, '液晶屏II52', '液晶屏 好用实惠', 1500.99, 12200, 657, 545, '12 (52).jpg');
INSERT INTO `easybuy_product` VALUES (733, '液晶屏II53', '液晶屏 好用实惠', 1500.99, 12200, 653, 545, '12 (53).jpg');
INSERT INTO `easybuy_product` VALUES (734, '液晶屏II54', '液晶屏 好用实惠', 1500.99, 12200, 657, 545, '12 (54).jpg');
INSERT INTO `easybuy_product` VALUES (735, '液晶屏II55', '液晶屏 好用实惠', 1500.99, 12200, 657, 545, '12 (55).jpg');
INSERT INTO `easybuy_product` VALUES (736, '达派高档拉杆箱20寸 经典款式', '液晶屏 好用实惠', 1500.99, 12200, 657, 545, '12 (56).jpg');
INSERT INTO `easybuy_product` VALUES (737, '液晶屏II57', '液晶屏 好用实惠', 1500.99, 12200, 653, 545, '12 (57).jpg');
INSERT INTO `easybuy_product` VALUES (738, '液晶屏II58', '液晶屏 好用实惠', 1500.99, 12200, 657, 545, '12 (58).jpg');
INSERT INTO `easybuy_product` VALUES (739, '液晶屏II59', '液晶屏 好用实惠', 999.99, 12200, 657, 545, '12 (59).jpg');
INSERT INTO `easybuy_product` VALUES (740, '液晶屏II60', '液晶屏 好用实惠', 999.99, 12200, 543, 545, '12 (60).jpg');
INSERT INTO `easybuy_product` VALUES (741, '液晶屏II61', '液晶屏 好用实惠', 999.99, 12200, 543, 545, '12 (61).jpg');
INSERT INTO `easybuy_product` VALUES (742, '液晶屏II62', '液晶屏 好用实惠', 999.99, 12200, 543, 545, '12 (62).jpg');
INSERT INTO `easybuy_product` VALUES (743, '液晶屏II63', '液晶屏 好用实惠', 999.99, 12200, 657, 545, '12 (63).jpg');
INSERT INTO `easybuy_product` VALUES (744, '达派高档拉杆箱20寸 经典款式', '液晶屏 好用实惠', 999.99, 12200, 657, 545, '12 (64).jpg');
INSERT INTO `easybuy_product` VALUES (745, '液晶屏II65', '液晶屏 好用实惠', 999.99, 12200, 657, 545, '12 (65).jpg');
INSERT INTO `easybuy_product` VALUES (746, '液晶屏II66', '液晶屏 好用实惠', 220.00, 12200, 657, 545, '12 (66).jpg');
INSERT INTO `easybuy_product` VALUES (747, 'Genius925纯银施华洛世奇水晶吊坠II67', 'Genius925纯银施华洛世奇水晶吊坠 好用实惠', 220.00, 5260, 650, 545, '12 (67).jpg');
INSERT INTO `easybuy_product` VALUES (748, 'Genius925纯银施华洛世奇水晶吊坠II68', 'Genius925纯银施华洛世奇水晶吊坠 好用实惠', 220.00, 5260, 650, 545, '12 (68).jpg');
INSERT INTO `easybuy_product` VALUES (749, 'Genius925纯银施华洛世奇水晶吊坠II69', 'Genius925纯银施华洛世奇水晶吊坠 好用实惠', 220.00, 5260, 650, 545, '12 (69).jpg');
INSERT INTO `easybuy_product` VALUES (750, 'Genius925纯银施华洛世奇水晶吊坠II70', 'Genius925纯银施华洛世奇水晶吊坠 好用实惠', 342.99, 5260, 650, 545, '12 (70).jpg');
INSERT INTO `easybuy_product` VALUES (751, 'Genius925纯银施华洛世奇水晶吊坠II71', 'Genius925纯银施华洛世奇水晶吊坠 好用实惠', 342.99, 5260, 650, 545, '12 (71).jpg');
INSERT INTO `easybuy_product` VALUES (752, '达派高档拉杆箱20寸 经典款式', 'Genius925纯银施华洛世奇水晶吊坠 好用实惠', 342.99, 5260, 650, 545, '12 (72).jpg');
INSERT INTO `easybuy_product` VALUES (753, 'Genius925纯银施华洛世奇水晶吊坠II73', 'Genius925纯银施华洛世奇水晶吊坠 好用实惠', 342.99, 5260, 630, 545, '12 (73).jpg');
INSERT INTO `easybuy_product` VALUES (754, 'Genius925纯银施华洛世奇水晶吊坠II74', 'Genius925纯银施华洛世奇水晶吊坠 好用实惠', 220.00, 5260, 630, 545, '12 (74).jpg');
INSERT INTO `easybuy_product` VALUES (755, 'Genius925纯银施华洛世奇水晶吊坠II75', 'Genius925纯银施华洛世奇水晶吊坠 好用实惠', 220.00, 5260, 630, 545, '12 (75).jpg');
INSERT INTO `easybuy_product` VALUES (756, 'Genius925纯银施华洛世奇水晶吊坠II76', 'Genius925纯银施华洛世奇水晶吊坠 好用实惠', 220.00, 5260, 650, 545, '12 (76).jpg');
INSERT INTO `easybuy_product` VALUES (757, 'Genius925纯银施华洛世奇水晶吊坠II77', 'Genius925纯银施华洛世奇水晶吊坠 好用实惠', 220.00, 23432, 630, 545, 'clip_image002.gif');
INSERT INTO `easybuy_product` VALUES (758, '奶粉II78', '奶粉 好用实惠', 220.00, 12360, 656, 545, '12 (78).jpg');
INSERT INTO `easybuy_product` VALUES (759, '奶粉II79', '奶粉 好用实惠', 460.00, 12360, 656, 545, '12 (79).jpg');
INSERT INTO `easybuy_product` VALUES (760, '奶粉II80', '奶粉 好用实惠', 460.00, 12360, 656, 545, '12 (80).jpg');
INSERT INTO `easybuy_product` VALUES (761, '奶粉II81', '奶粉 好用实惠', 460.00, 12360, 656, 545, '12 (81).jpg');
INSERT INTO `easybuy_product` VALUES (762, '奶粉II82', '奶粉 好用实惠', 460.00, 12360, 656, 545, '12 (82).jpg');
INSERT INTO `easybuy_product` VALUES (763, '奶粉II83', '奶粉 好用实惠', 460.00, 12360, 656, 545, '12 (83).jpg');
INSERT INTO `easybuy_product` VALUES (764, '奶粉II84', '奶粉 好用实惠', 220.00, 12360, 656, 545, '12 (84).jpg');
INSERT INTO `easybuy_product` VALUES (765, '奶粉II85', '奶粉 好用实惠', 220.00, 12360, 656, 545, '12 (85).jpg');
INSERT INTO `easybuy_product` VALUES (766, '奶粉II86', '奶粉 好用实惠', 220.00, 12360, 656, 545, '12 (86).jpg');
INSERT INTO `easybuy_product` VALUES (767, '汽车坐垫2II87', '汽车坐垫 好用实惠', 230.00, 20000, 655, 545, '12 (87).jpg');
INSERT INTO `easybuy_product` VALUES (768, '汽车坐垫2II88', '汽车坐垫 好用实惠', 230.00, 20000, 655, 545, '12 (88).jpg');
INSERT INTO `easybuy_product` VALUES (769, '汽车坐垫2II89', '汽车坐垫 好用实惠', 348.56, 20000, 655, 545, '12 (89).jpg');
INSERT INTO `easybuy_product` VALUES (770, '汽车坐垫2II90', '汽车坐垫 好用实惠', 348.56, 20000, 655, 545, '12 (90).jpg');
INSERT INTO `easybuy_product` VALUES (771, '汽车坐垫2II91', '汽车坐垫 好用实惠', 348.56, 20000, 655, 545, '12 (91).jpg');
INSERT INTO `easybuy_product` VALUES (772, '汽车坐垫2II92', '汽车坐垫 好用实惠', 230.00, 20000, 655, 545, '12 (92).jpg');
INSERT INTO `easybuy_product` VALUES (773, '汽车坐垫2II93', '汽车坐垫 好用实惠', 230.00, 20000, 655, 545, '12 (93).jpg');
INSERT INTO `easybuy_product` VALUES (774, '汽车坐垫2II94', '汽车坐垫 好用实惠', 230.00, 20000, 655, 545, '12 (94).jpg');
INSERT INTO `easybuy_product` VALUES (775, '汽车坐垫2II95', '汽车坐垫 好用实惠', 230.00, 20000, 655, 545, '12 (95).jpg');
INSERT INTO `easybuy_product` VALUES (776, '爱马仕II96', '爱马仕 好用实惠', 99999.00, 20000, 659, 545, '12 (96).jpg');
INSERT INTO `easybuy_product` VALUES (777, '爱马仕II97', '爱马仕 好用实惠', 99999.00, 20000, 659, 545, '12 (97).jpg');
INSERT INTO `easybuy_product` VALUES (778, '爱马仕II98', '爱马仕 好用实惠', 99999.00, 20000, 659, 545, '12 (98).jpg');
INSERT INTO `easybuy_product` VALUES (779, '爱马仕II99', '爱马仕 好用实惠', 99999.00, 20000, 659, 545, '12 (99).jpg');
INSERT INTO `easybuy_product` VALUES (780, '爱马仕II100', '爱马仕 好用实惠', 99999.00, 20000, 659, 545, '12 (100).jpg');
INSERT INTO `easybuy_product` VALUES (781, '爱马仕II101', '爱马仕 好用实惠', 99999.00, 20000, 659, 545, '12 (101).jpg');
INSERT INTO `easybuy_product` VALUES (782, '爱马仕II102', '爱马仕 好用实惠', 99999.00, 20000, 888, 888, '12 (102).jpg');
INSERT INTO `easybuy_product` VALUES (783, '爱马仕II103', '爱马仕 好用实惠', 99999.00, 20000, 888, 888, '12 (103).jpg');
INSERT INTO `easybuy_product` VALUES (784, '爱马仕II104', '爱马仕 好用实惠', 99999.00, 20000, 888, 888, '12 (104).jpg');
INSERT INTO `easybuy_product` VALUES (785, '爱马仕II105', '爱马仕 好用实惠', 99999.00, 20000, 888, 888, '12 (105).jpg');
INSERT INTO `easybuy_product` VALUES (786, '爱马仕II106', '爱马仕 好用实惠', 99999.00, 20000, 888, 888, '12 (106).jpg');
INSERT INTO `easybuy_product` VALUES (787, '音响', '史蒂夫', 12.00, 12, 555, NULL, 'clip_image002.gif');

-- ----------------------------
-- Table structure for easybuy_product_category
-- ----------------------------
DROP TABLE IF EXISTS `easybuy_product_category`;
CREATE TABLE `easybuy_product_category`  (
  `EPC_ID` int(10) NOT NULL,
  `EPC_NAME` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `EPC_PARENT_ID` int(10) NOT NULL,
  PRIMARY KEY (`EPC_ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of easybuy_product_category
-- ----------------------------
INSERT INTO `easybuy_product_category` VALUES (543, '音像', 542);
INSERT INTO `easybuy_product_category` VALUES (545, '生活用品', 545);
INSERT INTO `easybuy_product_category` VALUES (546, '少儿图书', 542);
INSERT INTO `easybuy_product_category` VALUES (548, '化妆品', 545);
INSERT INTO `easybuy_product_category` VALUES (555, '其他', 555);
INSERT INTO `easybuy_product_category` VALUES (626, '厨房用品', 545);
INSERT INTO `easybuy_product_category` VALUES (628, '家用电器', 545);
INSERT INTO `easybuy_product_category` VALUES (630, '食品', 545);
INSERT INTO `easybuy_product_category` VALUES (640, '衣服', 545);
INSERT INTO `easybuy_product_category` VALUES (650, '首饰', 545);
INSERT INTO `easybuy_product_category` VALUES (651, '鞋包', 545);
INSERT INTO `easybuy_product_category` VALUES (652, '家电', 545);
INSERT INTO `easybuy_product_category` VALUES (653, '电脑办公', 545);
INSERT INTO `easybuy_product_category` VALUES (654, '玩具文具', 545);
INSERT INTO `easybuy_product_category` VALUES (655, '汽车用品', 545);
INSERT INTO `easybuy_product_category` VALUES (656, '母婴', 545);
INSERT INTO `easybuy_product_category` VALUES (657, '手机数码', 545);
INSERT INTO `easybuy_product_category` VALUES (658, '医护', 555);
INSERT INTO `easybuy_product_category` VALUES (666, '促销', 666);
INSERT INTO `easybuy_product_category` VALUES (668, 'bweifnjkco', 667);

-- ----------------------------
-- Table structure for easybuy_user
-- ----------------------------
DROP TABLE IF EXISTS `easybuy_user`;
CREATE TABLE `easybuy_user`  (
  `EU_USER_ID` int(10) NOT NULL AUTO_INCREMENT,
  `EU_USER_NAME` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `EU_PASSWORD` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `EU_SEX` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `EU_BIRTHDAY` date NULL DEFAULT NULL,
  `EU_IDENTITY_CODE` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `EU_EMAIL` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `EU_MOBILE` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `EU_ADDRESS` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `EU_STATUS` int(6) NOT NULL,
  PRIMARY KEY (`EU_USER_ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 18 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of easybuy_user
-- ----------------------------
INSERT INTO `easybuy_user` VALUES (1, 'admin', 'admin', 'T', NULL, NULL, NULL, NULL, '北京市海淀区成府路207号', 0);
INSERT INTO `easybuy_user` VALUES (6, '哈哈', '123321', '男', '2021-03-01', '1645840809485', 'haha@com', '168999934', '火星', 3);
INSERT INTO `easybuy_user` VALUES (8, '武松', '用户', '男', '2022-02-26', '1645840896152', 'wuson@qq.com', '1380809090', '地球村', 2);
INSERT INTO `easybuy_user` VALUES (9, '高球', '用户', '男', '2022-02-26', '1645840925726', 'gaoqiu@qq.com', '1380809090', '地球村', 2);
INSERT INTO `easybuy_user` VALUES (10, '李世民', '用户', '男', '2022-02-26', '1645840948680', 'lishim@qq.com', '1380809090', '地球村', 2);
INSERT INTO `easybuy_user` VALUES (11, '赵匡胤', '用户', '男', '2022-02-26', '1645840987595', 'zhaokuangyi@qq.com', '1380809090', '地球村', 2);
INSERT INTO `easybuy_user` VALUES (12, '皇太极', '用户', '男', '2022-02-26', '1645841029689', 'huataijia@qq.com', '1380809090', '地球村', 2);
INSERT INTO `easybuy_user` VALUES (13, '纣王', '用户', '男', '2022-02-26', '1645841093926', 'zhouwanghuataijia@qq.com', '1380809090', '地球村', 2);
INSERT INTO `easybuy_user` VALUES (14, '王五', '123', '男', '2022-02-07', NULL, NULL, '1380809092', '火星村', 2);
INSERT INTO `easybuy_user` VALUES (15, '王五', '123', '男', '2022-02-07', NULL, NULL, '1380809092', '火星村', 2);
INSERT INTO `easybuy_user` VALUES (16, 'user', '123', '女', '2021-04-27', NULL, NULL, '111', '123', 2);

SET FOREIGN_KEY_CHECKS = 1;

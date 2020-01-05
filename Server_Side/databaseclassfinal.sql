/*
Navicat MySQL Data Transfer

Source Server         : bendi
Source Server Version : 80017
Source Host           : localhost:3306
Source Database       : databaseclassfinal

Target Server Type    : MYSQL
Target Server Version : 80017
File Encoding         : 65001

Date: 2020-01-05 14:02:30
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `comment`
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `commentid` int(11) NOT NULL AUTO_INCREMENT,
  `postid` int(11) NOT NULL,
  `username` varchar(20) DEFAULT NULL,
  `content` varchar(200) NOT NULL,
  `p_like` int(11) NOT NULL DEFAULT '0',
  `c_time` datetime DEFAULT NULL,
  PRIMARY KEY (`commentid`),
  KEY `comment_fk1` (`postid`),
  KEY `comment_fk2` (`username`),
  CONSTRAINT `comment_fk1` FOREIGN KEY (`postid`) REFERENCES `post` (`postid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `comment_fk2` FOREIGN KEY (`username`) REFERENCES `user` (`username`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=76 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES ('25', '5', 'QinKuai', '算法', '3', '2019-12-24 23:20:50');
INSERT INTO `comment` VALUES ('51', '44', 'QinKuai', '访问', '1', '2019-12-25 04:05:49');
INSERT INTO `comment` VALUES ('52', '44', 'QinKuai', '发的', '1', '2019-12-25 04:10:55');
INSERT INTO `comment` VALUES ('53', '44', 'QinKuai', 'dsf', '0', '2019-12-25 04:11:39');
INSERT INTO `comment` VALUES ('54', '3', 'DYB', 'fs', '0', '2019-12-25 04:30:47');
INSERT INTO `comment` VALUES ('55', '44', 'DYB', 'ssssssssssssssssadsadasdsadasdasdsadas', '1', '2019-12-25 05:28:52');
INSERT INTO `comment` VALUES ('56', '57', 'DYB', '萨芬', '2', '2019-12-25 06:43:16');
INSERT INTO `comment` VALUES ('57', '81', 'DYB', '132', '1', '2019-12-25 06:53:12');
INSERT INTO `comment` VALUES ('58', '59', 'DYB', '852', '1', '2019-12-25 06:57:29');
INSERT INTO `comment` VALUES ('59', '46', 'DYB', 'vd人', '1', '2019-12-25 06:58:16');
INSERT INTO `comment` VALUES ('60', '67', 'DYB', '法撒旦', '3', '2019-12-25 07:00:48');
INSERT INTO `comment` VALUES ('61', '67', 'DYB', '发', '0', '2019-12-25 07:00:57');
INSERT INTO `comment` VALUES ('62', '67', 'DYB', '五七人', '0', '2019-12-25 07:01:03');
INSERT INTO `comment` VALUES ('63', '67', 'DYB', '是的服务器', '0', '2019-12-25 07:01:08');
INSERT INTO `comment` VALUES ('64', '5', 'DYB', '给分', '0', '2019-12-25 07:02:02');
INSERT INTO `comment` VALUES ('65', '67', 'DYB', '发', '0', '2019-12-25 11:47:26');
INSERT INTO `comment` VALUES ('66', '67', 'DYB', '法撒旦', '0', '2019-12-25 12:13:13');
INSERT INTO `comment` VALUES ('67', '57', 'DYB', 'fsdfsafad', '0', '2019-12-25 13:00:31');
INSERT INTO `comment` VALUES ('68', '57', 'DYB', 'fsdfsafad', '0', '2019-12-25 13:00:40');
INSERT INTO `comment` VALUES ('69', '5', 'DYB', 'f', '0', '2019-12-25 15:08:23');
INSERT INTO `comment` VALUES ('70', '5', 'DYB', 'hello,wordld', '0', '2019-12-25 15:11:08');
INSERT INTO `comment` VALUES ('71', '67', 'DYB', 'fef', '0', '2019-12-25 17:41:27');
INSERT INTO `comment` VALUES ('72', '67', 'DYB', 'gggg', '0', '2019-12-29 10:50:26');
INSERT INTO `comment` VALUES ('73', '67', 'DYB', 'gggg', '1', '2019-12-29 10:50:26');
INSERT INTO `comment` VALUES ('74', '67', 'ZWH', '他吞吞吐吐', '0', '2020-01-05 10:36:13');
INSERT INTO `comment` VALUES ('75', '67', 'ZWH', '他吞吞吐吐', '0', '2020-01-05 10:36:29');

-- ----------------------------
-- Table structure for `favorite`
-- ----------------------------
DROP TABLE IF EXISTS `favorite`;
CREATE TABLE `favorite` (
  `username` varchar(20) NOT NULL,
  `resourceid` int(11) NOT NULL,
  `favo_date` date DEFAULT NULL,
  `cancel_date` date DEFAULT NULL,
  PRIMARY KEY (`username`,`resourceid`),
  KEY `favorite_fk2` (`resourceid`),
  CONSTRAINT `favorite_fk1` FOREIGN KEY (`username`) REFERENCES `user` (`username`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `favorite_fk2` FOREIGN KEY (`resourceid`) REFERENCES `resource` (`resourceid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of favorite
-- ----------------------------
INSERT INTO `favorite` VALUES ('DYB', '2', '2019-12-04', null);
INSERT INTO `favorite` VALUES ('QinKuai', '3', '2019-12-04', null);
INSERT INTO `favorite` VALUES ('ZWH', '5', '2020-01-01', null);
INSERT INTO `favorite` VALUES ('ZWH', '8', '2019-12-26', null);

-- ----------------------------
-- Table structure for `feedback`
-- ----------------------------
DROP TABLE IF EXISTS `feedback`;
CREATE TABLE `feedback` (
  `feedid` int(11) NOT NULL AUTO_INCREMENT,
  `resourceid` int(11) NOT NULL,
  `fdtype` varchar(1) DEFAULT NULL,
  `content` varchar(200) NOT NULL,
  `isfinished` int(11) DEFAULT NULL,
  `username` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`feedid`),
  KEY `feed_back_fk1` (`username`),
  KEY `feedback_fk2` (`resourceid`),
  CONSTRAINT `feed_back_fk1` FOREIGN KEY (`username`) REFERENCES `user` (`username`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `feedback_fk2` FOREIGN KEY (`resourceid`) REFERENCES `resource` (`resourceid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `feedback_chk_1` CHECK ((`fdtype` in (_utf8mb4'm',_utf8mb4'o',_utf8mb4'e'))),
  CONSTRAINT `feedback_chk_2` CHECK ((`isfinished` in (_utf8mb3'1',_utf8mb3'0')))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of feedback
-- ----------------------------

-- ----------------------------
-- Table structure for `field`
-- ----------------------------
DROP TABLE IF EXISTS `field`;
CREATE TABLE `field` (
  `fieldid` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(20) NOT NULL,
  `foundate` date NOT NULL,
  `resamount` int(11) NOT NULL,
  PRIMARY KEY (`fieldid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of field
-- ----------------------------
INSERT INTO `field` VALUES ('1', '游戏', '2019-12-24', '4');
INSERT INTO `field` VALUES ('2', '影视', '2019-12-24', '6');
INSERT INTO `field` VALUES ('3', '其他', '2019-12-24', '4');

-- ----------------------------
-- Table structure for `income_record`
-- ----------------------------
DROP TABLE IF EXISTS `income_record`;
CREATE TABLE `income_record` (
  `in_id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `fee` float NOT NULL,
  `teetype` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `in_date` datetime NOT NULL,
  PRIMARY KEY (`in_id`),
  KEY `income_record_ibfk_1` (`username`),
  CONSTRAINT `income_record_ibfk_1` FOREIGN KEY (`username`) REFERENCES `user` (`username`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `income_record_chk_1` CHECK ((`teetype` in (_utf8mb4'v',_utf8mb4'p')))
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of income_record
-- ----------------------------
INSERT INTO `income_record` VALUES ('1', 'QinKuai', '1000', 'v', '2019-12-12 00:00:00');
INSERT INTO `income_record` VALUES ('2', 'QinKuai', '250', 'p', '2019-12-25 00:00:00');
INSERT INTO `income_record` VALUES ('3', 'QinKuai', '648', 'v', '2019-12-20 20:10:25');

-- ----------------------------
-- Table structure for `manager_record`
-- ----------------------------
DROP TABLE IF EXISTS `manager_record`;
CREATE TABLE `manager_record` (
  `r_id` int(11) NOT NULL AUTO_INCREMENT,
  `managername` varchar(20) DEFAULT NULL,
  `r_brieftype` char(1) DEFAULT NULL,
  `r_date` date DEFAULT NULL,
  `r_info` varchar(20) DEFAULT NULL,
  `r_detailedtype` char(1) DEFAULT NULL,
  PRIMARY KEY (`r_id`),
  KEY `manager_record_ibfk_1` (`managername`),
  CONSTRAINT `manager_record_ibfk_1` FOREIGN KEY (`managername`) REFERENCES `user` (`username`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `manager_record_chk_1` CHECK ((`r_brieftype` in (_utf8mb4'u',_utf8mb4'r',_utf8mb4'p'))),
  CONSTRAINT `manager_record_chk_2` CHECK ((`r_brieftype` in (_utf8mb4'1',_utf8mb4'2',_utf8mb4'3',_utf8mb4'4')))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of manager_record
-- ----------------------------

-- ----------------------------
-- Table structure for `post`
-- ----------------------------
DROP TABLE IF EXISTS `post`;
CREATE TABLE `post` (
  `postid` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `posttitle` varchar(100) NOT NULL,
  `p_like` int(11) DEFAULT '0',
  `commentamount` int(11) DEFAULT '0',
  `fieldid` int(11) NOT NULL,
  `createdate` datetime NOT NULL,
  `content` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '鏉╂瑤閲滅€规湹绱禒鈧稊鍫滅瘍濞屄ゎ嚛',
  PRIMARY KEY (`postid`),
  KEY `username` (`username`),
  KEY `post_fk2` (`fieldid`),
  CONSTRAINT `post_fk1` FOREIGN KEY (`username`) REFERENCES `user` (`username`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `post_fk2` FOREIGN KEY (`fieldid`) REFERENCES `field` (`fieldid`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=100 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of post
-- ----------------------------
INSERT INTO `post` VALUES ('3', 'XJ', '西游记之大圣归来吧', '24', '1', '1', '2019-12-02 00:00:00', '大圣脆桃手办！出坑回血了');
INSERT INTO `post` VALUES ('5', 'ZWH', '【每日推荐】', '206', '3', '3', '2019-12-04 00:00:00', 'NO.1《受益人》\r\n\r\nNO.2《中国机长》\r\n\r\nNO.3《少年的你》\r\n');
INSERT INTO `post` VALUES ('44', 'QinKuai', '\r\n西游降魔篇，高清度盘', '4', '4', '1', '2019-12-25 00:00:00', '西游降魔篇，高清度盘');
INSERT INTO `post` VALUES ('45', 'QinKuai', '西游降魔篇《武林群侠传》 开局V12 金庸卡牌RPG', '0', '0', '1', '2019-12-25 00:00:00', '经典侠客RPG');
INSERT INTO `post` VALUES ('46', 'QinKuai', 'Eternal°崇萧「原创」暮冬', '1', '1', '1', '2019-12-25 00:00:00', '这里夏至，本文微甜无虐');
INSERT INTO `post` VALUES ('57', 'QinKuai', '\r\nEternal°崇萧「关于唠嗑」', '3', '3', '3', '2019-12-25 00:00:00', '很久没来这里看看了. 我是雨馨，不知道吧里人还有没有眼熟我的了');
INSERT INTO `post` VALUES ('58', 'QinKuai', '为什么还有的贴不能看', '0', '0', '2', '2019-12-25 00:00:00', '为什么还有的贴不能看但是');
INSERT INTO `post` VALUES ('59', 'QinKuai', '\r\n《我的熊猫男友》', '0', '1', '1', '2019-12-25 00:00:00', '《我的熊猫男友》甜文（原创） 这里是乐大大，初来驾到，请多关照！');
INSERT INTO `post` VALUES ('60', 'QinKuai', '熊出没之夺宝熊兵吧\r\n熊出没之夺宝熊兵吧', '0', '0', '1', '2019-12-25 00:00:00', '本吧是熊迷们的聚集地');
INSERT INTO `post` VALUES ('61', 'QinKuai', '大鱼海棠吧', '0', '0', '1', '2019-12-04 00:00:00', '动画电影《大鱼海棠》粉丝聚集地');
INSERT INTO `post` VALUES ('62', 'QinKuai', '【抬头园林】绚丽,冬红,红丽,亚当,草原之火', '0', '0', '1', '2019-11-22 00:00:00', '【抬头园林】供应绚丽,冬红,红丽,凯尔斯,草原之火,草莓果冻等多个品种.');
INSERT INTO `post` VALUES ('63', 'QinKuai', '\r\n罗小黑电影中的某福兰省渔民', '0', '0', '2', '2019-12-05 00:00:00', '罗小黑电影中的某福兰省渔民');
INSERT INTO `post` VALUES ('64', 'QinKuai', '每天更新最新电影 抢先看', '0', '0', '2', '2019-12-12 00:00:00', '狂暴者CX');
INSERT INTO `post` VALUES ('66', 'QinKuai', '\r\n叶问4，误杀来喽', '0', '0', '3', '2019-12-20 00:00:00', '叶问4，误杀来喽');
INSERT INTO `post` VALUES ('67', 'QinKuai', '\r\n【老九门全集】1-48集在线观看 回1发网盘', '2', '11', '2', '2019-12-25 12:25:25', '\r\n【老九门全集】1-48集在线观看 回1发网盘');
INSERT INTO `post` VALUES ('68', 'QinKuai', '\r\n《庆余年》百度云资源.终于找到了(已整理完毕)请来取吧~', '0', '0', '3', '2019-12-05 00:00:00', '资源-需要-威信- 关注:【今晚影迷】 関驻后进入公众后台影院观看');
INSERT INTO `post` VALUES ('70', 'DYB', '\r\n《盗墓：摸金校尉》', '111', '0', '2', '2019-12-07 00:00:00', '《盗墓：摸金校尉》【游戏简介】');
INSERT INTO `post` VALUES ('72', 'DYB', '熊出没之熊二与团子', '0', '0', '2', '2019-12-07 00:00:00', '自己写的小说');
INSERT INTO `post` VALUES ('73', 'DYB', '熊出没', '0', '0', '2', '2019-12-15 00:00:00', '我打算写文了，熊出没电影文');
INSERT INTO `post` VALUES ('74', 'DYB', '\r\n第一章 彼此的思念！', '0', '0', '2', '2019-12-13 00:00:00', '第一章 彼此的思念');
INSERT INTO `post` VALUES ('80', 'DYB', '\r\n召唤失踪人口回归', '1', '0', '2', '2019-12-25 00:00:00', '\r\n召唤失踪人口回归');
INSERT INTO `post` VALUES ('81', 'DYB', '在甘肃武威农村现在创业,做什么前景比较好??', '2', '1', '1', '2019-12-25 00:00:00', '在甘肃武威农村现在创业,做什么前景比较好??');
INSERT INTO `post` VALUES ('82', 'DYB', '想看啥电影留言告诉我', '0', '0', '3', '2019-12-25 00:00:00', '想看啥电影留言告诉我');
INSERT INTO `post` VALUES ('83', 'DYB', '\r\n看完就记住这一句台词\r\n我觉得林晨太漂亮', '0', '0', '2', '2019-12-25 00:00:00', '\r\n看完就记住这一句台词');
INSERT INTO `post` VALUES ('84', 'DYB', '\r\n很垃圾一个电影。特别是万国鹏我看着都恶心', '0', '0', '1', '2019-12-25 00:00:00', '\r\n很垃圾一个电影。特别是万国鹏我看着都恶心');
INSERT INTO `post` VALUES ('85', 'DYB', '优酷还有电视剧版，', '0', '0', '3', '2019-12-25 00:00:00', '优酷还有电视剧版，');
INSERT INTO `post` VALUES ('86', 'DYB', '\r\n横店影视城，有没有一起出发的', '0', '0', '2', '2019-12-25 00:00:00', '\r\n横店影视城，有没有一起出发的');
INSERT INTO `post` VALUES ('87', 'DYB', '\r\n我的横店我的漂（剧照贴）', '0', '0', '2', '2019-12-25 00:00:00', '\r\n我的横店我的漂（剧照贴）');
INSERT INTO `post` VALUES ('88', 'DYB', '白浅醉卧桃林的音乐，自弹', '0', '0', '2', '2019-12-25 00:00:00', '白浅醉卧桃林的音乐，自弹');
INSERT INTO `post` VALUES ('89', 'DYB', '\r\n有人知道夜华死的时候的BGM吗？超好听的', '0', '0', '2', '2019-12-25 00:00:00', '有人知道夜华死的时候的BGM吗？ 超好听的');
INSERT INTO `post` VALUES ('90', 'DYB', '\r\n一些对于三生的感想', '0', '0', '2', '2019-12-25 00:00:00', '\r\n一些对于三生的感想');
INSERT INTO `post` VALUES ('91', 'DYB', '不知道还有没有人？', '0', '0', '2', '2019-12-25 00:00:00', '我觉得这个，我应该带过来给大家看看。');
INSERT INTO `post` VALUES ('92', 'DYB', '\r\n票根久了会褪色，你们想怎么样保存三生票根呢？', '0', '0', '2', '2019-12-25 00:00:00', '我之前保存过票根无一例外的字都看不清楚了 ');
INSERT INTO `post` VALUES ('93', 'DYB', '\r\n蓝光碟收到了', '0', '0', '1', '2019-12-25 00:00:00', '\r\n蓝光碟收到了');
INSERT INTO `post` VALUES ('94', 'DYB', '\r\n我之前见过一版不是电视剧也不是杨洋刘亦菲版的预告片', '0', '0', '2', '2019-12-25 00:00:00', 'RT 不知道吧里有别人见过么 好像是在');
INSERT INTO `post` VALUES ('95', 'QinKuai', '我愿未来有你，写给以电影三生三世为代表的中国仙幻电影', '0', '0', '1', '2019-12-25 00:00:00', '题记：我这一楼开得比较正规。');
INSERT INTO `post` VALUES ('99', 'DYB', 'ffff', '0', '0', '2', '2019-12-29 00:00:00', 'ddddd');

-- ----------------------------
-- Table structure for `resource`
-- ----------------------------
DROP TABLE IF EXISTS `resource`;
CREATE TABLE `resource` (
  `resourceid` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `restype` int(11) DEFAULT NULL,
  `URL` varchar(80) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `picaddr` varchar(500) NOT NULL,
  `title` varchar(100) NOT NULL,
  `content` varchar(500) NOT NULL,
  `r_like` int(11) NOT NULL DEFAULT '0',
  `r_point` int(11) DEFAULT '20',
  `r_time` datetime DEFAULT NULL,
  PRIMARY KEY (`resourceid`),
  KEY `restype` (`restype`),
  KEY `resource_fk1` (`username`),
  CONSTRAINT `resource_fk1` FOREIGN KEY (`username`) REFERENCES `user` (`username`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `resource_fk2` FOREIGN KEY (`restype`) REFERENCES `field` (`fieldid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of resource
-- ----------------------------
INSERT INTO `resource` VALUES ('2', 'ZWH', '2', 'http://www.foxiys.com/a-4fjm.html', 'static/image/png/2.png', '星球大战8：最后的绝地武士', '别名:星球大战：豆瓣评分: 7.1导演:莱恩·约翰逊演员:黛西·雷德利 / 约翰·博耶加 / 亚当·德赖弗', '200', '20', '2019-12-18 00:19:06');
INSERT INTO `resource` VALUES ('3', 'ZWH', '2', 'http://www.foxiys.com/a-7tn9.html', 'static/image/png/3.png', '富滇风云', '豆瓣评分: 未知导演:鄢颇演员:潘粤明 / 李小冉 / 高一玮', '22', '20', '2019-12-18 00:19:06');
INSERT INTO `resource` VALUES ('4', 'ZWH', '2', 'http://www.foxiys.com/a-5xo5.html', 'static/image/png/4.png', '新情义无价', '豆瓣评分: 6.4\r\n导演:赖水清\r\n演员:黄海波 / 潘粤明 / 陈莎莉', '123', '20', '2019-12-18 00:19:06');
INSERT INTO `resource` VALUES ('5', 'DYB', '2', 'http://www.foxiys.com/a-6g40.html', 'static/image/png/5.png', '沉星档案', '豆瓣评分: 未知导演:丁黑 / 张晓光演员:郭金 / 李煜 / 张鹭', '23', '20', '2019-12-18 00:19:06');
INSERT INTO `resource` VALUES ('6', 'DYB', '1', 'http://www.foxiys.com/a-4305.html', 'static/image/png/6.png', '盘龙卧虎高山顶', '豆瓣评分: 7.3\r\n导演:延艺\r\n演员:潘粤明 / 刘涛', '123333', '20', '2019-12-18 00:19:06');
INSERT INTO `resource` VALUES ('7', 'XJ', '1', 'http://dl.pcgames.com.cn/download/75157.html', 'static/image/png/7.png', '《劲舞团》“舞所不能”精简版客户端', '玩家可以在游戏中通过装扮与培育，打造出独一无二的宝贝，个性装扮都由自己来决定。', '10023', '20', '2019-12-18 00:19:06');
INSERT INTO `resource` VALUES ('8', 'XJ', '1', 'http://dl.pcgames.com.cn/download/75153.html', 'static/image/png/8.png', '古剑奇谭网络版》公测版本客户端', '八大门派、自由飞行、云上家园、阵营对战、秘境探险、云海遨游、挖宝探秘、青灯引渡', '354', '20', '2019-12-18 00:19:06');
INSERT INTO `resource` VALUES ('9', 'XJ', '1', 'http://dl.pcgames.com.cn/download/72454.html', 'static/image/png/9.png', '格斗刀魂OL热血公测客户端_安卓版下载', '新一代自研3D“速鲨”引擎，极度流畅的操作手感，给你最热血、最激爽的格斗体验', '102', '20', '2019-12-18 00:19:06');
INSERT INTO `resource` VALUES ('11', 'QinKuai', '3', 'https://home.meishichina.com/recipe-501508.html', 'static/image/png/11.png', '酱焖豆皮', '“酱焖豆皮滋味浓厚，口感软嫩，吃起来更是下饭。”无论大人还是小孩,都可以放心地吃豆皮', '323', '20', '2019-12-18 00:19:06');
INSERT INTO `resource` VALUES ('12', 'QinKuai', '3', 'https://home.meishichina.com/recipe-501304.html', 'static/image/png/12.png', '金针菇拌菠菜', '简单又快手的家常小菜，健康又低脂，金针菇:活血化瘀菠菜:活血化瘀醋:活血化瘀', '253', '20', '2019-12-03 01:50:51');
INSERT INTO `resource` VALUES ('14', 'QinKuai', '3', 'https://aba.cncn.com/jingdian/jianzhuhai/', 'static/image/png/13fgo.png', '箭竹海', '景点地址：四川阿坝 四川省九寨沟县境内.九寨沟箭竹海海拔2618米，深6米，面积17万平方米，', '0', '20', '2019-12-25 12:58:37');
INSERT INTO `resource` VALUES ('15', 'QinKuai', '3', 'www', 'static/image/png/14fgo.png', 'aa', 'ggggg', '0', '20', '2019-12-25 13:52:22');
INSERT INTO `resource` VALUES ('16', 'qinkuai', '2', 'www', 'static/image/png/15三彩载乐骆驼俑.jpg', 'aaa', 'ffffffff', '0', '20', '2019-12-25 14:21:26');
INSERT INTO `resource` VALUES ('17', 'qinkuai', '2', 'www.baidu.com', 'static/image/png/1613fgo.png', 'sdasd', 'sdsadasd', '0', '20', '2019-12-25 16:08:16');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `username` varchar(20) NOT NULL,
  `u_password` varchar(20) NOT NULL,
  `u_sex` varchar(1) NOT NULL,
  `u_birthday` date DEFAULT NULL,
  `u_registertime` date NOT NULL,
  `u_email` varchar(40) NOT NULL,
  `u_rank` smallint(6) NOT NULL DEFAULT '0',
  `u_type` varchar(1) NOT NULL,
  `u_exp` int(11) NOT NULL DEFAULT '0',
  `u_point` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`username`),
  KEY `u_rank` (`u_rank`),
  CONSTRAINT `user_ibfk_1` FOREIGN KEY (`u_rank`) REFERENCES `user_rank` (`u_rank`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `user_chk_1` CHECK ((`u_sex` in (_utf8mb4'f',_utf8mb4'm',_utf8mb4'n'))),
  CONSTRAINT `user_chk_2` CHECK ((`u_type` in (_utf8mb4'n',_utf8mb4'v',_utf8mb4'm')))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('DYB', '123456', 'm', '2019-12-12', '2019-12-12', '2566663', '8', 'm', '1430', '9930');
INSERT INTO `user` VALUES ('QinKuai', '123123', 'm', '2019-12-12', '2019-12-12', '2609935221@qq.com', '15', 'm', '50260', '99932');
INSERT INTO `user` VALUES ('QinKuai10', '123456', 'n', null, '2019-12-30', '12312312', '0', 'n', '0', '0');
INSERT INTO `user` VALUES ('t', '123456', 'n', null, '2019-12-30', '12433', '0', 'n', '10', '80');
INSERT INTO `user` VALUES ('test', '123456', 'n', null, '2019-12-30', '1243', '0', 'n', '0', '0');
INSERT INTO `user` VALUES ('XJ', '123456', 'm', '2019-12-12', '2019-12-12', '25633256', '7', 'n', '556', '510');
INSERT INTO `user` VALUES ('ZWH', '123456', 'm', '2019-12-12', '2019-12-12', '2526656', '8', 'm', '999', '466');

-- ----------------------------
-- Table structure for `user_download`
-- ----------------------------
DROP TABLE IF EXISTS `user_download`;
CREATE TABLE `user_download` (
  `d_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_download` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `resourceid` int(11) NOT NULL,
  `d_date` date NOT NULL,
  `d_point` int(11) NOT NULL,
  `user_upload` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`d_id`),
  KEY `download_fk1` (`user_download`),
  KEY `download_fk2` (`resourceid`),
  KEY `download_fk3` (`user_upload`),
  CONSTRAINT `download_fk1` FOREIGN KEY (`user_download`) REFERENCES `user` (`username`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `download_fk2` FOREIGN KEY (`resourceid`) REFERENCES `resource` (`resourceid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `download_fk3` FOREIGN KEY (`user_upload`) REFERENCES `user` (`username`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of user_download
-- ----------------------------
INSERT INTO `user_download` VALUES ('1', 'XJ', '2', '2019-12-28', '20', 'ZWH');
INSERT INTO `user_download` VALUES ('2', 'XJ', '2', '2019-12-25', '20', 'ZWH');
INSERT INTO `user_download` VALUES ('3', 'XJ', '2', '2019-12-28', '20', 'ZWH');
INSERT INTO `user_download` VALUES ('5', 'XJ', '2', '2019-12-27', '20', 'ZWH');
INSERT INTO `user_download` VALUES ('6', 'QinKuai', '7', '2019-12-25', '16', 'XJ');
INSERT INTO `user_download` VALUES ('7', 'QinKuai', '6', '2019-12-25', '16', 'DYB');
INSERT INTO `user_download` VALUES ('19', 'QinKuai', '5', '2019-12-30', '16', 'DYB');
INSERT INTO `user_download` VALUES ('20', 'QinKuai', '8', '2019-12-30', '16', 'XJ');
INSERT INTO `user_download` VALUES ('21', 'QinKuai', '9', '2019-12-30', '16', 'XJ');
INSERT INTO `user_download` VALUES ('22', 'XJ', '11', '2019-12-03', '20', 'QinKuai');
INSERT INTO `user_download` VALUES ('23', 'ZWH', '11', '2019-12-04', '20', 'QinKuai');
INSERT INTO `user_download` VALUES ('24', 't', '9', '2019-12-30', '20', 'XJ');

-- ----------------------------
-- Table structure for `user_follow`
-- ----------------------------
DROP TABLE IF EXISTS `user_follow`;
CREATE TABLE `user_follow` (
  `follower` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `following` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `follow_date` date NOT NULL,
  `cancel_date` date DEFAULT NULL,
  PRIMARY KEY (`follower`,`following`),
  KEY `user_follow_ibfk_2` (`following`),
  CONSTRAINT `user_follow_ibfk_1` FOREIGN KEY (`follower`) REFERENCES `user` (`username`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `user_follow_ibfk_2` FOREIGN KEY (`following`) REFERENCES `user` (`username`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of user_follow
-- ----------------------------
INSERT INTO `user_follow` VALUES ('DYB', 'XJ', '2019-12-04', null);
INSERT INTO `user_follow` VALUES ('QinKuai', 'XJ', '2019-12-25', null);
INSERT INTO `user_follow` VALUES ('QinKuai', 'ZWH', '2019-12-25', null);
INSERT INTO `user_follow` VALUES ('XJ', 'QinKuai', '2019-12-03', null);
INSERT INTO `user_follow` VALUES ('XJ', 'ZWH', '2019-12-11', null);
INSERT INTO `user_follow` VALUES ('ZWH', 'DYB', '2019-12-25', null);

-- ----------------------------
-- Table structure for `user_rank`
-- ----------------------------
DROP TABLE IF EXISTS `user_rank`;
CREATE TABLE `user_rank` (
  `u_rank` smallint(6) NOT NULL,
  `search` int(11) DEFAULT NULL,
  `seeurl` int(11) DEFAULT NULL,
  `upload` int(11) DEFAULT NULL,
  `post` int(11) DEFAULT NULL,
  `u_comment` int(11) DEFAULT NULL,
  `newfield` int(11) DEFAULT NULL,
  `up_exp` int(11) DEFAULT NULL,
  PRIMARY KEY (`u_rank`),
  CONSTRAINT `user_rank_chk_1` CHECK ((`search` in (1,0))),
  CONSTRAINT `user_rank_chk_2` CHECK ((`seeurl` in (1,0))),
  CONSTRAINT `user_rank_chk_3` CHECK ((`upload` in (1,0))),
  CONSTRAINT `user_rank_chk_4` CHECK ((`post` in (1,0))),
  CONSTRAINT `user_rank_chk_5` CHECK ((`u_comment` in (1,0))),
  CONSTRAINT `user_rank_chk_6` CHECK ((`newfield` in (1,0)))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of user_rank
-- ----------------------------
INSERT INTO `user_rank` VALUES ('0', '1', '1', '1', '0', '0', '0', '50');
INSERT INTO `user_rank` VALUES ('1', '1', '1', '1', '0', '0', '0', '100');
INSERT INTO `user_rank` VALUES ('2', '1', '1', '1', '0', '0', '0', '150');
INSERT INTO `user_rank` VALUES ('3', '1', '1', '1', '0', '1', '0', '200');
INSERT INTO `user_rank` VALUES ('4', '1', '1', '1', '1', '1', '0', '250');
INSERT INTO `user_rank` VALUES ('5', '1', '1', '1', '1', '1', '0', '300');
INSERT INTO `user_rank` VALUES ('6', '1', '1', '1', '1', '1', '1', '500');
INSERT INTO `user_rank` VALUES ('7', '1', '1', '1', '1', '1', '1', '800');
INSERT INTO `user_rank` VALUES ('8', '1', '1', '1', '1', '1', '1', '1500');
INSERT INTO `user_rank` VALUES ('9', '1', '1', '1', '1', '1', '1', '4000');
INSERT INTO `user_rank` VALUES ('10', '1', '1', '1', '1', '1', '1', '8000');
INSERT INTO `user_rank` VALUES ('11', '1', '1', '1', '1', '1', '1', '15000');
INSERT INTO `user_rank` VALUES ('12', '1', '1', '1', '1', '1', '1', '30000');
INSERT INTO `user_rank` VALUES ('13', '1', '1', '1', '1', '1', '1', '40000');
INSERT INTO `user_rank` VALUES ('14', '1', '1', '1', '1', '1', '1', '50000');
INSERT INTO `user_rank` VALUES ('15', '1', '1', '1', '1', '1', '1', '60000');
INSERT INTO `user_rank` VALUES ('16', '1', '1', '1', '1', '1', '1', '1000000');
INSERT INTO `user_rank` VALUES ('17', '1', '1', '1', '1', '1', '1', '1000000000');
DROP TRIGGER IF EXISTS `increase_comamount`;
DELIMITER ;;
CREATE TRIGGER `increase_comamount` AFTER INSERT ON `comment` FOR EACH ROW BEGIN 
 UPDATE post
 SET commentamount = commentamount+1
 WHERE new.postid=post.postid;
 END
;;
DELIMITER ;
DROP TRIGGER IF EXISTS `decrease_comamount`;
DELIMITER ;;
CREATE TRIGGER `decrease_comamount` AFTER DELETE ON `comment` FOR EACH ROW BEGIN 
 UPDATE post
 SET commentamount = commentamount-1
 WHERE old.postid=post.postid;
 END
;;
DELIMITER ;
DROP TRIGGER IF EXISTS `increase_resamount`;
DELIMITER ;;
CREATE TRIGGER `increase_resamount` AFTER INSERT ON `resource` FOR EACH ROW BEGIN
  UPDATE field
	SET resamount = resamount+1
	WHERE new.restype=field.fieldid;
	END
;;
DELIMITER ;
DROP TRIGGER IF EXISTS `transfer_resamount`;
DELIMITER ;;
CREATE TRIGGER `transfer_resamount` AFTER UPDATE ON `resource` FOR EACH ROW BEGIN
	UPDATE field
	SET resamount = resamount-1
	WHERE old.restype=field.fieldid;
	UPDATE field
	SET resamount = resamount+1
	WHERE new.restype=field.fieldid;
END
;;
DELIMITER ;
DROP TRIGGER IF EXISTS `decrease_resamount`;
DELIMITER ;;
CREATE TRIGGER `decrease_resamount` AFTER DELETE ON `resource` FOR EACH ROW BEGIN
  UPDATE field
	SET resamount = resamount-1
	WHERE old.restype=field.fieldid;
	END
;;
DELIMITER ;
DROP TRIGGER IF EXISTS `update_exp`;
DELIMITER ;;
CREATE TRIGGER `update_exp` BEFORE UPDATE ON `user` FOR EACH ROW BEGIN 
   DECLARE up_exp1 int;
	 
	 SELECT up_exp 
	 INTO up_exp1
	 FROM user_rank
	 WHERE old.u_rank=user_rank.u_rank;
	
   
   IF new.u_exp>=up_exp1
	 THEN
	
	 SET new.u_rank = new.u_rank+1;
	
	 END IF;
END
;;
DELIMITER ;
DROP TRIGGER IF EXISTS `insert_user_download`;
DELIMITER ;;
CREATE TRIGGER `insert_user_download` BEFORE INSERT ON `user_download` FOR EACH ROW BEGIN 

  DECLARE need_point int;
	DECLARE point_now int;
	DECLARE user_type CHAR(1);
	DECLARE download_amount int;
	DECLARE  d_max int;
		
			
	SELECT COUNT(d_id)
	INTO download_amount
	FROM user_download
	WHERE user_download.user_download=new.user_download
	      AND user_download.d_date=CURDATE();
	
	
		
	SELECT r_point
	INTO need_point
	FROM resource
	WHERE new.resourceid=resource.resourceid;
	
	
	
	SELECT u_point
	INTO point_now
	FROM `user`
	WHERE new.user_download=`user`.username;
	
	SELECT u_type
	INTO user_type
	FROM `user`
	WHERE new.user_download=`user`.username;
	
	
	IF point_now >need_point
	THEN
	  IF user_type="v" OR user_type="m"
		THEN 
		
			 SET d_max=10;
	   ELSE
		   SET d_max=1;
		END IF;
		 
		
		 
  IF download_amount>=d_max 
	THEN 
	   SIGNAL SQLSTATE 'TX000' SET MESSAGE_TEXT = 'Too much';
	 END IF;  
		
	
		UPDATE `user`
	  SET `user`.u_exp = `user`.u_exp+50
	  WHERE new.user_upload=`user`.username;

		
		UPDATE `user`
	  SET `user`.u_exp = `user`.u_exp+10
	  WHERE new.user_download=`user`.username;
		
		
		UPDATE `user`
		SET u_point = u_point+10
	  WHERE new.user_upload=`user`.username;
		
		
		UPDATE `user`
		 SET u_point = u_point-need_point
	  WHERE  new.user_download=`user`.username;
	
	ELSE
		SIGNAL SQLSTATE 'TX000' SET MESSAGE_TEXT = 'XXX';
	END IF;
	
	
	
	
END
;;
DELIMITER ;

/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50515
Source Host           : localhost:3306
Source Database       : nano

Target Server Type    : MYSQL
Target Server Version : 50515
File Encoding         : 65001

Date: 2020-05-13 22:51:58
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `nano_attachment`
-- ----------------------------
DROP TABLE IF EXISTS `nano_attachment`;
CREATE TABLE `nano_attachment` (
  `attach_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `attach_created` datetime DEFAULT NULL,
  `attach_name` varchar(255) DEFAULT NULL,
  `attach_path` varchar(255) DEFAULT NULL,
  `attach_small_path` varchar(255) DEFAULT NULL,
  `attach_suffix` varchar(255) DEFAULT NULL,
  `attach_type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`attach_id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of nano_attachment
-- ----------------------------
INSERT INTO `nano_attachment` VALUES ('1', '2020-05-13 15:54:22', 'lion.jpg', '/upload/2020/5/lion.jpg', '/upload/2020/5/lion.jpg', '.jpg', 'image/jpeg');
INSERT INTO `nano_attachment` VALUES ('2', '2020-05-13 15:55:05', 'city_52-wallpaper-1920x1080.jpg', '/upload/2020/5/city_52-wallpaper-1920x1080.jpg', '/upload/2020/5/city_52-wallpaper-1920x1080_small.jpg', '.jpg', 'image/jpeg');
INSERT INTO `nano_attachment` VALUES ('3', '2020-05-13 15:55:05', 'charlie_chaplin_quote-wallpaper-1920x1080.jpg', '/upload/2020/5/charlie_chaplin_quote-wallpaper-1920x1080.jpg', '/upload/2020/5/charlie_chaplin_quote-wallpaper-1920x1080_small.jpg', '.jpg', 'image/jpeg');
INSERT INTO `nano_attachment` VALUES ('4', '2020-05-13 15:55:05', 'clear_vision-wallpaper-1920x1080.jpg', '/upload/2020/5/clear_vision-wallpaper-1920x1080.jpg', '/upload/2020/5/clear_vision-wallpaper-1920x1080_small.jpg', '.jpg', 'image/jpeg');
INSERT INTO `nano_attachment` VALUES ('5', '2020-05-13 15:55:05', 'cute_kittens-wallpaper-1920x1080.jpg', '/upload/2020/5/cute_kittens-wallpaper-1920x1080.jpg', '/upload/2020/5/cute_kittens-wallpaper-1920x1080_small.jpg', '.jpg', 'image/jpeg');
INSERT INTO `nano_attachment` VALUES ('6', '2020-05-13 15:55:05', 'crossing_to_new_zealand_south-wallpaper-1920x1080.jpg', '/upload/2020/5/crossing_to_new_zealand_south-wallpaper-1920x1080.jpg', '/upload/2020/5/crossing_to_new_zealand_south-wallpaper-1920x1080_small.jpg', '.jpg', 'image/jpeg');
INSERT INTO `nano_attachment` VALUES ('7', '2020-05-13 15:55:05', 'cute_tiger_cub-wallpaper-1920x1080.jpg', '/upload/2020/5/cute_tiger_cub-wallpaper-1920x1080.jpg', '/upload/2020/5/cute_tiger_cub-wallpaper-1920x1080_small.jpg', '.jpg', 'image/jpeg');
INSERT INTO `nano_attachment` VALUES ('8', '2020-05-13 15:55:05', 'digimon_x_pokemon_mash_up_2014-wallpaper-1920x1080.jpg', '/upload/2020/5/digimon_x_pokemon_mash_up_2014-wallpaper-1920x1080.jpg', '/upload/2020/5/digimon_x_pokemon_mash_up_2014-wallpaper-1920x1080_small.jpg', '.jpg', 'image/jpeg');
INSERT INTO `nano_attachment` VALUES ('9', '2020-05-13 15:55:05', 'cortex-wallpaper-1920x1080.jpg', '/upload/2020/5/cortex-wallpaper-1920x1080.jpg', '/upload/2020/5/cortex-wallpaper-1920x1080_small.jpg', '.jpg', 'image/jpeg');
INSERT INTO `nano_attachment` VALUES ('10', '2020-05-13 15:55:05', 'denpa_onna_to_seishun_otoko-wallpaper-1920x1080.jpg', '/upload/2020/5/denpa_onna_to_seishun_otoko-wallpaper-1920x1080.jpg', '/upload/2020/5/denpa_onna_to_seishun_otoko-wallpaper-1920x1080_small.jpg', '.jpg', 'image/jpeg');
INSERT INTO `nano_attachment` VALUES ('11', '2020-05-13 15:55:05', 'infinite_3-wallpaper-1920x1080.jpg', '/upload/2020/5/infinite_3-wallpaper-1920x1080.jpg', '/upload/2020/5/infinite_3-wallpaper-1920x1080_small.jpg', '.jpg', 'image/jpeg');
INSERT INTO `nano_attachment` VALUES ('12', '2020-05-13 15:55:05', 'inception_totem-wallpaper-1920x1080.jpg', '/upload/2020/5/inception_totem-wallpaper-1920x1080.jpg', '/upload/2020/5/inception_totem-wallpaper-1920x1080_small.jpg', '.jpg', 'image/jpeg');
INSERT INTO `nano_attachment` VALUES ('13', '2020-05-13 15:55:05', 'in_the_rain-wallpaper-1920x1080.jpg', '/upload/2020/5/in_the_rain-wallpaper-1920x1080.jpg', '/upload/2020/5/in_the_rain-wallpaper-1920x1080_small.jpg', '.jpg', 'image/jpeg');
INSERT INTO `nano_attachment` VALUES ('14', '2020-05-13 15:55:06', 'jammu-wallpaper-1920x1080.jpg', '/upload/2020/5/jammu-wallpaper-1920x1080.jpg', '/upload/2020/5/jammu-wallpaper-1920x1080_small.jpg', '.jpg', 'image/jpeg');
INSERT INTO `nano_attachment` VALUES ('15', '2020-05-13 15:55:06', 'lamborghini_2-wallpaper-1920x1080.jpg', '/upload/2020/5/lamborghini_2-wallpaper-1920x1080.jpg', '/upload/2020/5/lamborghini_2-wallpaper-1920x1080_small.jpg', '.jpg', 'image/jpeg');
INSERT INTO `nano_attachment` VALUES ('16', '2020-05-13 15:55:06', 'jump_to_the_sky-wallpaper-1920x1080.jpg', '/upload/2020/5/jump_to_the_sky-wallpaper-1920x1080.jpg', '/upload/2020/5/jump_to_the_sky-wallpaper-1920x1080_small.jpg', '.jpg', 'image/jpeg');
INSERT INTO `nano_attachment` VALUES ('17', '2020-05-13 15:55:06', 'island_6-wallpaper-1920x1080.jpg', '/upload/2020/5/island_6-wallpaper-1920x1080.jpg', '/upload/2020/5/island_6-wallpaper-1920x1080_small.jpg', '.jpg', 'image/jpeg');
INSERT INTO `nano_attachment` VALUES ('18', '2020-05-13 15:55:06', 'lake_48-wallpaper-1920x1080.jpg', '/upload/2020/5/lake_48-wallpaper-1920x1080.jpg', '/upload/2020/5/lake_48-wallpaper-1920x1080_small.jpg', '.jpg', 'image/jpeg');
INSERT INTO `nano_attachment` VALUES ('19', '2020-05-13 15:55:06', 'legs-wallpaper-1920x1080.jpg', '/upload/2020/5/legs-wallpaper-1920x1080.jpg', '/upload/2020/5/legs-wallpaper-1920x1080_small.jpg', '.jpg', 'image/jpeg');
INSERT INTO `nano_attachment` VALUES ('20', '2020-05-13 15:55:06', 'life_is_good-wallpaper-1920x1080.jpg', '/upload/2020/5/life_is_good-wallpaper-1920x1080.jpg', '/upload/2020/5/life_is_good-wallpaper-1920x1080_small.jpg', '.jpg', 'image/jpeg');
INSERT INTO `nano_attachment` VALUES ('21', '2020-05-13 15:55:06', 'linkin_park_alichavoshi2008_40gmail_com-wallpaper-1600x900.jpg', '/upload/2020/5/linkin_park_alichavoshi2008_40gmail_com-wallpaper-1600x900.jpg', '/upload/2020/5/linkin_park_alichavoshi2008_40gmail_com-wallpaper-1600x900_small.jpg', '.jpg', 'image/jpeg');
INSERT INTO `nano_attachment` VALUES ('22', '2020-05-13 15:55:06', 'leopard_2-wallpaper-1920x1080.jpg', '/upload/2020/5/leopard_2-wallpaper-1920x1080.jpg', '/upload/2020/5/leopard_2-wallpaper-1920x1080_small.jpg', '.jpg', 'image/jpeg');
INSERT INTO `nano_attachment` VALUES ('23', '2020-05-13 15:55:06', 'me_and_my_keyboard-wallpaper-1920x1080.jpg', '/upload/2020/5/me_and_my_keyboard-wallpaper-1920x1080.jpg', '/upload/2020/5/me_and_my_keyboard-wallpaper-1920x1080_small.jpg', '.jpg', 'image/jpeg');
INSERT INTO `nano_attachment` VALUES ('25', '2020-05-13 16:48:29', 'favicon.png', '/upload/2020/5/favicon.png', '/upload/2020/5/favicon.png', '.png', 'image/png');

-- ----------------------------
-- Table structure for `nano_category`
-- ----------------------------
DROP TABLE IF EXISTS `nano_category`;
CREATE TABLE `nano_category` (
  `cate_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cate_desc` varchar(255) DEFAULT NULL,
  `cate_name` varchar(255) DEFAULT NULL,
  `cate_url` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`cate_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of nano_category
-- ----------------------------
INSERT INTO `nano_category` VALUES ('1', '未分类', '未分类', 'default');
INSERT INTO `nano_category` VALUES ('2', 'java基础', 'JavaSE', '/JavaSE');
INSERT INTO `nano_category` VALUES ('3', 'java高级', 'javaee', '/javaee');
INSERT INTO `nano_category` VALUES ('4', '7777', '1111', '1111');

-- ----------------------------
-- Table structure for `nano_comment`
-- ----------------------------
DROP TABLE IF EXISTS `nano_comment`;
CREATE TABLE `nano_comment` (
  `comment_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `comment_agent` varchar(255) DEFAULT NULL,
  `comment_author` varchar(255) DEFAULT NULL,
  `comment_author_avatar_md5` varchar(255) DEFAULT NULL,
  `comment_author_email` varchar(255) DEFAULT NULL,
  `comment_author_ip` varchar(255) DEFAULT NULL,
  `comment_author_url` varchar(255) DEFAULT NULL,
  `comment_content` longtext,
  `comment_date` datetime DEFAULT NULL,
  `comment_parent` bigint(20) DEFAULT NULL,
  `comment_status` int(11) DEFAULT NULL,
  `is_admin` int(11) DEFAULT NULL,
  `post_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`comment_id`),
  KEY `FKe2g9ani5j82vprqtxnnlhj9pi` (`post_id`),
  CONSTRAINT `FKe2g9ani5j82vprqtxnnlhj9pi` FOREIGN KEY (`post_id`) REFERENCES `nano_post` (`post_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of nano_comment
-- ----------------------------
INSERT INTO `nano_comment` VALUES ('1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/80.0.3987.106 Safari/537.36', 'LMH', 'e5f38406566a3f4df2ca711b7f9c9673', '459296228@qq.com', '127.0.0.1', 'https://jqlmh.com', '欢迎来到nano', '2020-05-12 18:11:17', '0', '0', '0', '1');
INSERT INTO `nano_comment` VALUES ('2', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:76.0) Gecko/20100101 Firefox/76.0', 'lmh', 'e5f38406566a3f4df2ca711b7f9c9673', '459296228@qq.com', '0:0:0:0:0:0:0:1', 'http://localhost:8090', '谢谢你哦~~~~么么哒~~~ //<a href=\'#\'>@LMH</a>:欢迎来到nano', '2020-05-12 23:35:19', '1', '0', '1', '1');
INSERT INTO `nano_comment` VALUES ('3', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:76.0) Gecko/20100101 Firefox/76.0', '222', 'bcbe3365e6ac95ea2c0343a2395834dd', '222', '0:0:0:0:0:0:0:1', '22222', '大家好才是真的好,广州好滴~~~~', '2020-05-13 00:29:59', '0', '1', '0', '1');
INSERT INTO `nano_comment` VALUES ('4', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:76.0) Gecko/20100101 Firefox/76.0', '333', '310dcbbf4cce62f762a2aaa148d556bd', '333', '0:0:0:0:0:0:0:1', '3333', '333333', '2020-05-13 00:30:23', '0', '1', '0', '1');
INSERT INTO `nano_comment` VALUES ('5', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:76.0) Gecko/20100101 Firefox/76.0', '你傻傻破', 'e88ef3ae67176aa54bf609aec8126643', '二当前无多无群', '0:0:0:0:0:0:0:1', '459296228@qq.com', '而我却而我请二位请按时多as打扫打扫打扫打扫打扫多阿萨德啊阿萨德腌=======', '2020-05-13 00:31:12', '0', '1', '0', '1');
INSERT INTO `nano_comment` VALUES ('6', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:76.0) Gecko/20100101 Firefox/76.0', 'lmh02', 'e5f38406566a3f4df2ca711b7f9c9673', '459296228@qq.com', '0:0:0:0:0:0:0:1', 'www.baidu.com', '阿里云创立于2009年，是全球领先的云计算及人工智能科技公司，为200多个国家和地区的企业、开发者和政府机构提供服务。阿里云致力于以在线公共服务的方式，提供安全、可靠的计算和数据处理能力，让计算和人工智能成为普惠科技。2017年1月阿里云成为奥运会全球指定云服务商。', '2020-05-13 00:33:07', '0', '1', '0', '1');

-- ----------------------------
-- Table structure for `nano_gallery`
-- ----------------------------
DROP TABLE IF EXISTS `nano_gallery`;
CREATE TABLE `nano_gallery` (
  `gallery_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `gallery_date` varchar(255) DEFAULT NULL,
  `gallery_desc` varchar(255) DEFAULT NULL,
  `gallery_location` varchar(255) DEFAULT NULL,
  `gallery_name` varchar(255) DEFAULT NULL,
  `gallery_thumbnail_url` varchar(255) DEFAULT NULL,
  `gallery_url` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`gallery_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of nano_gallery
-- ----------------------------
INSERT INTO `nano_gallery` VALUES ('1', '2020-04-27', '', '111', '11', '/upload/2020/5/me_and_my_keyboard-wallpaper-1920x1080.jpg', '/upload/2020/5/me_and_my_keyboard-wallpaper-1920x1080.jpg');
INSERT INTO `nano_gallery` VALUES ('2', '2020-05-15', '2222', '22', '22', '/upload/2020/5/leopard_2-wallpaper-1920x1080.jpg', '/upload/2020/5/leopard_2-wallpaper-1920x1080.jpg');
INSERT INTO `nano_gallery` VALUES ('3', '2020-04-30', '33', '33', '33', '/upload/2020/5/linkin_park_alichavoshi2008_40gmail_com-wallpaper-1600x900.jpg', '/upload/2020/5/linkin_park_alichavoshi2008_40gmail_com-wallpaper-1600x900.jpg');
INSERT INTO `nano_gallery` VALUES ('5', '2020-05-07', '55', '55', '55', '/upload/2020/5/lake_48-wallpaper-1920x1080.jpg', '/upload/2020/5/lake_48-wallpaper-1920x1080.jpg');

-- ----------------------------
-- Table structure for `nano_link`
-- ----------------------------
DROP TABLE IF EXISTS `nano_link`;
CREATE TABLE `nano_link` (
  `link_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `link_desc` varchar(255) DEFAULT NULL,
  `link_name` varchar(255) DEFAULT NULL,
  `link_pic` varchar(255) DEFAULT NULL,
  `link_url` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`link_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of nano_link
-- ----------------------------
INSERT INTO `nano_link` VALUES ('1', '百度', '百度', 'https://www.baidu.com/s?wd=%E4%BB%8A%E6%97%A5%E6%96%B0%E9%B2%9C%E4%BA%8B&tn=SE_PclogoS_8whnvm25&sa=ire_dl_gh_logo&rsv_dl=igh_logo_pcs', 'https://www.baidu.com/');
INSERT INTO `nano_link` VALUES ('2', 'QQ', 'QQ', 'https://im.qq.com/index.shtml', 'https://im.qq.com/');
INSERT INTO `nano_link` VALUES ('3', '网易', '网易', 'https://www.163.com/favicon.ico', 'https://www.163.com/');
INSERT INTO `nano_link` VALUES ('5', '22', '2222', '222', '222');
INSERT INTO `nano_link` VALUES ('6', '333', '333', '3333', '333');

-- ----------------------------
-- Table structure for `nano_logs`
-- ----------------------------
DROP TABLE IF EXISTS `nano_logs`;
CREATE TABLE `nano_logs` (
  `log_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `log_content` varchar(255) DEFAULT NULL,
  `log_created` datetime DEFAULT NULL,
  `log_ip` varchar(255) DEFAULT NULL,
  `log_title` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`log_id`)
) ENGINE=InnoDB AUTO_INCREMENT=104 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of nano_logs
-- ----------------------------
INSERT INTO `nano_logs` VALUES ('1', '安装成功，欢迎使用Halo。', '2020-05-12 18:11:18', '0:0:0:0:0:0:0:1', '初始化博客');
INSERT INTO `nano_logs` VALUES ('2', '登录成功', '2020-05-12 21:58:38', '0:0:0:0:0:0:0:1', '登录后台');
INSERT INTO `nano_logs` VALUES ('3', '登录成功', '2020-05-12 22:13:23', '0:0:0:0:0:0:0:1', '登录后台');
INSERT INTO `nano_logs` VALUES ('4', '登录成功', '2020-05-12 22:29:34', '0:0:0:0:0:0:0:1', '登录后台');
INSERT INTO `nano_logs` VALUES ('5', '登录成功', '2020-05-12 23:22:26', '0:0:0:0:0:0:0:1', '登录后台');
INSERT INTO `nano_logs` VALUES ('6', '登录成功', '2020-05-12 23:34:56', '0:0:0:0:0:0:0:1', '登录后台');
INSERT INTO `nano_logs` VALUES ('7', 'luminghao', '2020-05-13 00:38:46', '0:0:0:0:0:0:0:1', '退出登录');
INSERT INTO `nano_logs` VALUES ('8', '登录成功', '2020-05-13 00:38:49', '0:0:0:0:0:0:0:1', '登录后台');
INSERT INTO `nano_logs` VALUES ('9', '登录成功', '2020-05-13 11:18:48', '127.0.0.1', '登录后台');
INSERT INTO `nano_logs` VALUES ('10', '登录成功', '2020-05-13 11:23:35', '127.0.0.1', '登录后台');
INSERT INTO `nano_logs` VALUES ('11', '登录成功', '2020-05-13 11:26:55', '127.0.0.1', '登录后台');
INSERT INTO `nano_logs` VALUES ('12', '更换为material', '2020-05-13 11:29:27', '127.0.0.1', '更换主题');
INSERT INTO `nano_logs` VALUES ('13', '更换为anatole', '2020-05-13 11:31:01', '127.0.0.1', '更换主题');
INSERT INTO `nano_logs` VALUES ('14', '登录成功', '2020-05-13 11:59:21', '0:0:0:0:0:0:0:1', '登录后台');
INSERT INTO `nano_logs` VALUES ('15', '登录成功', '2020-05-13 12:02:32', '0:0:0:0:0:0:0:1', '登录后台');
INSERT INTO `nano_logs` VALUES ('16', '更换为material', '2020-05-13 12:17:51', '0:0:0:0:0:0:0:1', '更换主题');
INSERT INTO `nano_logs` VALUES ('17', '登录成功', '2020-05-13 13:56:39', '127.0.0.1', '登录后台');
INSERT INTO `nano_logs` VALUES ('18', '登录成功', '2020-05-13 14:34:48', '127.0.0.1', '登录后台');
INSERT INTO `nano_logs` VALUES ('19', '登录成功', '2020-05-13 14:50:21', '127.0.0.1', '登录后台');
INSERT INTO `nano_logs` VALUES ('20', '登录成功', '2020-05-13 14:51:24', '127.0.0.1', '登录后台');
INSERT INTO `nano_logs` VALUES ('21', '登录成功', '2020-05-13 14:53:12', '127.0.0.1', '登录后台');
INSERT INTO `nano_logs` VALUES ('22', '登录成功', '2020-05-13 14:54:16', '127.0.0.1', '登录后台');
INSERT INTO `nano_logs` VALUES ('23', '登录成功', '2020-05-13 15:01:45', '127.0.0.1', '登录后台');
INSERT INTO `nano_logs` VALUES ('24', '登录成功', '2020-05-13 15:02:22', '127.0.0.1', '登录后台');
INSERT INTO `nano_logs` VALUES ('25', '登录成功', '2020-05-13 15:03:02', '127.0.0.1', '登录后台');
INSERT INTO `nano_logs` VALUES ('26', '修改密码成功[666666]', '2020-05-13 15:26:07', '127.0.0.1', '修改密码');
INSERT INTO `nano_logs` VALUES ('27', '登录失败[459296228@qq.com,123456]', '2020-05-13 15:26:11', '127.0.0.1', '登录后台');
INSERT INTO `nano_logs` VALUES ('28', '登录成功', '2020-05-13 15:26:14', '127.0.0.1', '登录后台');
INSERT INTO `nano_logs` VALUES ('29', '登录失败[459296228@qq.com,123456]', '2020-05-13 15:39:46', '127.0.0.1', '登录后台');
INSERT INTO `nano_logs` VALUES ('30', '登录成功', '2020-05-13 15:39:50', '127.0.0.1', '登录后台');
INSERT INTO `nano_logs` VALUES ('31', 'lion.jpg', '2020-05-13 15:54:22', '127.0.0.1', '上传附件');
INSERT INTO `nano_logs` VALUES ('32', 'city_52-wallpaper-1920x1080.jpg', '2020-05-13 15:55:05', '127.0.0.1', '上传附件');
INSERT INTO `nano_logs` VALUES ('33', 'charlie_chaplin_quote-wallpaper-1920x1080.jpg', '2020-05-13 15:55:05', '127.0.0.1', '上传附件');
INSERT INTO `nano_logs` VALUES ('34', 'clear_vision-wallpaper-1920x1080.jpg', '2020-05-13 15:55:05', '127.0.0.1', '上传附件');
INSERT INTO `nano_logs` VALUES ('35', 'cortex-wallpaper-1920x1080.jpg', '2020-05-13 15:55:05', '127.0.0.1', '上传附件');
INSERT INTO `nano_logs` VALUES ('36', 'crossing_to_new_zealand_south-wallpaper-1920x1080.jpg', '2020-05-13 15:55:05', '127.0.0.1', '上传附件');
INSERT INTO `nano_logs` VALUES ('37', 'cute_kittens-wallpaper-1920x1080.jpg', '2020-05-13 15:55:05', '127.0.0.1', '上传附件');
INSERT INTO `nano_logs` VALUES ('38', 'digimon_x_pokemon_mash_up_2014-wallpaper-1920x1080.jpg', '2020-05-13 15:55:05', '127.0.0.1', '上传附件');
INSERT INTO `nano_logs` VALUES ('39', 'cute_tiger_cub-wallpaper-1920x1080.jpg', '2020-05-13 15:55:05', '127.0.0.1', '上传附件');
INSERT INTO `nano_logs` VALUES ('40', 'denpa_onna_to_seishun_otoko-wallpaper-1920x1080.jpg', '2020-05-13 15:55:05', '127.0.0.1', '上传附件');
INSERT INTO `nano_logs` VALUES ('41', 'in_the_rain-wallpaper-1920x1080.jpg', '2020-05-13 15:55:06', '127.0.0.1', '上传附件');
INSERT INTO `nano_logs` VALUES ('42', 'infinite_3-wallpaper-1920x1080.jpg', '2020-05-13 15:55:06', '127.0.0.1', '上传附件');
INSERT INTO `nano_logs` VALUES ('43', 'inception_totem-wallpaper-1920x1080.jpg', '2020-05-13 15:55:06', '127.0.0.1', '上传附件');
INSERT INTO `nano_logs` VALUES ('44', 'jammu-wallpaper-1920x1080.jpg', '2020-05-13 15:55:06', '127.0.0.1', '上传附件');
INSERT INTO `nano_logs` VALUES ('45', 'island_6-wallpaper-1920x1080.jpg', '2020-05-13 15:55:06', '127.0.0.1', '上传附件');
INSERT INTO `nano_logs` VALUES ('46', 'jump_to_the_sky-wallpaper-1920x1080.jpg', '2020-05-13 15:55:06', '127.0.0.1', '上传附件');
INSERT INTO `nano_logs` VALUES ('47', 'lamborghini_2-wallpaper-1920x1080.jpg', '2020-05-13 15:55:06', '127.0.0.1', '上传附件');
INSERT INTO `nano_logs` VALUES ('48', 'lake_48-wallpaper-1920x1080.jpg', '2020-05-13 15:55:06', '127.0.0.1', '上传附件');
INSERT INTO `nano_logs` VALUES ('49', 'legs-wallpaper-1920x1080.jpg', '2020-05-13 15:55:06', '127.0.0.1', '上传附件');
INSERT INTO `nano_logs` VALUES ('50', 'leopard_2-wallpaper-1920x1080.jpg', '2020-05-13 15:55:06', '127.0.0.1', '上传附件');
INSERT INTO `nano_logs` VALUES ('51', 'linkin_park_alichavoshi2008_40gmail_com-wallpaper-1600x900.jpg', '2020-05-13 15:55:06', '127.0.0.1', '上传附件');
INSERT INTO `nano_logs` VALUES ('52', 'life_is_good-wallpaper-1920x1080.jpg', '2020-05-13 15:55:06', '127.0.0.1', '上传附件');
INSERT INTO `nano_logs` VALUES ('53', 'me_and_my_keyboard-wallpaper-1920x1080.jpg', '2020-05-13 15:55:06', '127.0.0.1', '上传附件');
INSERT INTO `nano_logs` VALUES ('54', 'lonely_girl-wallpaper-1920x1080.jpg', '2020-05-13 15:55:06', '127.0.0.1', '上传附件');
INSERT INTO `nano_logs` VALUES ('55', 'lonely_girl-wallpaper-1920x1080.jpg', '2020-05-13 16:19:04', '127.0.0.1', '移除附件');
INSERT INTO `nano_logs` VALUES ('56', '登录成功', '2020-05-13 16:25:41', '127.0.0.1', '登录后台');
INSERT INTO `nano_logs` VALUES ('57', '登录成功', '2020-05-13 16:32:41', '127.0.0.1', '登录后台');
INSERT INTO `nano_logs` VALUES ('58', '登录成功', '2020-05-13 16:33:47', '127.0.0.1', '登录后台');
INSERT INTO `nano_logs` VALUES ('59', '登录成功', '2020-05-13 16:34:59', '127.0.0.1', '登录后台');
INSERT INTO `nano_logs` VALUES ('60', '登录成功', '2020-05-13 16:35:43', '127.0.0.1', '登录后台');
INSERT INTO `nano_logs` VALUES ('61', '登录成功', '2020-05-13 16:39:26', '127.0.0.1', '登录后台');
INSERT INTO `nano_logs` VALUES ('62', 'favicon.png', '2020-05-13 16:48:29', '127.0.0.1', '上传附件');
INSERT INTO `nano_logs` VALUES ('63', '登录成功', '2020-05-13 16:53:35', '127.0.0.1', '登录后台');
INSERT INTO `nano_logs` VALUES ('64', '更换为anatole', '2020-05-13 16:53:42', '127.0.0.1', '更换主题');
INSERT INTO `nano_logs` VALUES ('65', '登录成功', '2020-05-13 16:59:26', '127.0.0.1', '登录后台');
INSERT INTO `nano_logs` VALUES ('66', '登录成功', '2020-05-13 19:10:47', '0:0:0:0:0:0:0:1', '登录后台');
INSERT INTO `nano_logs` VALUES ('67', '登录成功', '2020-05-13 20:14:17', '0:0:0:0:0:0:0:1', '登录后台');
INSERT INTO `nano_logs` VALUES ('68', '登录成功', '2020-05-13 20:15:51', '0:0:0:0:0:0:0:1', '登录后台');
INSERT INTO `nano_logs` VALUES ('69', 'java', '2020-05-13 20:19:03', '0:0:0:0:0:0:0:1', '发表文章');
INSERT INTO `nano_logs` VALUES ('70', '登录成功', '2020-05-13 20:39:54', '0:0:0:0:0:0:0:1', '登录后台');
INSERT INTO `nano_logs` VALUES ('71', '55555555555555555555', '2020-05-13 20:42:46', '0:0:0:0:0:0:0:1', '发表文章');
INSERT INTO `nano_logs` VALUES ('72', '登录成功', '2020-05-13 20:47:05', '0:0:0:0:0:0:0:1', '登录后台');
INSERT INTO `nano_logs` VALUES ('73', '登录成功', '2020-05-13 20:50:28', '0:0:0:0:0:0:0:1', '登录后台');
INSERT INTO `nano_logs` VALUES ('74', 'java', '2020-05-13 20:51:24', '0:0:0:0:0:0:0:1', '发表文章');
INSERT INTO `nano_logs` VALUES ('75', 'java', '2020-05-13 20:51:41', '0:0:0:0:0:0:0:1', '发表文章');
INSERT INTO `nano_logs` VALUES ('76', 'java', '2020-05-13 20:51:55', '0:0:0:0:0:0:0:1', '发表文章');
INSERT INTO `nano_logs` VALUES ('77', '登录成功', '2020-05-13 20:57:01', '0:0:0:0:0:0:0:1', '登录后台');
INSERT INTO `nano_logs` VALUES ('78', 'java1', '2020-05-13 21:01:15', '0:0:0:0:0:0:0:1', '发表文章');
INSERT INTO `nano_logs` VALUES ('79', 'java2', '2020-05-13 21:01:22', '0:0:0:0:0:0:0:1', '发表文章');
INSERT INTO `nano_logs` VALUES ('80', 'java2', '2020-05-13 21:02:24', '0:0:0:0:0:0:0:1', '发表文章');
INSERT INTO `nano_logs` VALUES ('81', 'java1', '2020-05-13 21:02:34', '0:0:0:0:0:0:0:1', '发表文章');
INSERT INTO `nano_logs` VALUES ('82', 'java3', '2020-05-13 21:10:00', '0:0:0:0:0:0:0:1', '发表文章');
INSERT INTO `nano_logs` VALUES ('83', '登录成功', '2020-05-13 21:13:19', '0:0:0:0:0:0:0:1', '登录后台');
INSERT INTO `nano_logs` VALUES ('84', '登录成功', '2020-05-13 21:14:14', '0:0:0:0:0:0:0:1', '登录后台');
INSERT INTO `nano_logs` VALUES ('85', '登录成功', '2020-05-13 21:23:21', '0:0:0:0:0:0:0:1', '登录后台');
INSERT INTO `nano_logs` VALUES ('86', '登录成功', '2020-05-13 21:28:09', '0:0:0:0:0:0:0:1', '登录后台');
INSERT INTO `nano_logs` VALUES ('87', '登录成功', '2020-05-13 21:31:53', '127.0.0.1', '登录后台');
INSERT INTO `nano_logs` VALUES ('88', '登录成功', '2020-05-13 21:34:51', '127.0.0.1', '登录后台');
INSERT INTO `nano_logs` VALUES ('89', '登录成功', '2020-05-13 21:38:00', '127.0.0.1', '登录后台');
INSERT INTO `nano_logs` VALUES ('90', '登录成功', '2020-05-13 22:03:21', '127.0.0.1', '登录后台');
INSERT INTO `nano_logs` VALUES ('91', '登录成功', '2020-05-13 22:14:28', '127.0.0.1', '登录后台');
INSERT INTO `nano_logs` VALUES ('92', '登录成功', '2020-05-13 22:25:44', '127.0.0.1', '登录后台');
INSERT INTO `nano_logs` VALUES ('93', '11', '2020-05-13 22:25:55', '127.0.0.1', '发表文章');
INSERT INTO `nano_logs` VALUES ('94', '11', '2020-05-13 22:26:06', '127.0.0.1', '删除文章');
INSERT INTO `nano_logs` VALUES ('95', '11', '2020-05-13 22:26:18', '127.0.0.1', '发表文章');
INSERT INTO `nano_logs` VALUES ('96', '22', '2020-05-13 22:30:15', '127.0.0.1', '发表文章');
INSERT INTO `nano_logs` VALUES ('97', '33', '2020-05-13 22:34:05', '127.0.0.1', '发表文章');
INSERT INTO `nano_logs` VALUES ('98', '33', '2020-05-13 22:34:14', '127.0.0.1', '删除文章');
INSERT INTO `nano_logs` VALUES ('99', '22', '2020-05-13 22:34:31', '127.0.0.1', '发表文章');
INSERT INTO `nano_logs` VALUES ('100', '登录失败[459296228@qq.com,123456]', '2020-05-13 22:41:32', '0:0:0:0:0:0:0:1', '登录后台');
INSERT INTO `nano_logs` VALUES ('101', '登录成功', '2020-05-13 22:41:35', '0:0:0:0:0:0:0:1', '登录后台');
INSERT INTO `nano_logs` VALUES ('102', '登录成功', '2020-05-13 22:42:53', '0:0:0:0:0:0:0:1', '登录后台');
INSERT INTO `nano_logs` VALUES ('103', '登录成功', '2020-05-13 22:43:11', '0:0:0:0:0:0:0:1', '登录后台');

-- ----------------------------
-- Table structure for `nano_menu`
-- ----------------------------
DROP TABLE IF EXISTS `nano_menu`;
CREATE TABLE `nano_menu` (
  `menu_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `menu_icon` varchar(255) DEFAULT NULL,
  `menu_name` varchar(255) DEFAULT NULL,
  `menu_sort` int(11) DEFAULT NULL,
  `menu_url` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`menu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of nano_menu
-- ----------------------------
INSERT INTO `nano_menu` VALUES ('1', '', '首页', '1', '/');
INSERT INTO `nano_menu` VALUES ('2', '', '归档', '2', '/archives');
INSERT INTO `nano_menu` VALUES ('4', '', 'java', '3', '/java');

-- ----------------------------
-- Table structure for `nano_options`
-- ----------------------------
DROP TABLE IF EXISTS `nano_options`;
CREATE TABLE `nano_options` (
  `option_name` varchar(255) NOT NULL,
  `option_value` longtext,
  PRIMARY KEY (`option_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of nano_options
-- ----------------------------
INSERT INTO `nano_options` VALUES ('admin_loading', 'false');
INSERT INTO `nano_options` VALUES ('admin_pjax', 'true');
INSERT INTO `nano_options` VALUES ('admin_theme', 'skin-green');
INSERT INTO `nano_options` VALUES ('anatole_style_favicon', '/anatole/source/images/favicon.png');
INSERT INTO `nano_options` VALUES ('anatole_style_hitokoto', 'true');
INSERT INTO `nano_options` VALUES ('blog_footer_info', ' <h8 style=\"text-align: center\">互联网ICP备案: <a class=\"\" href=\"http://www.beian.miit.gov.cn\" target=\"_blank\">蜀ICP备20003283号</a> </h8>\r\n<div style=\"width:300px;margin:0 auto; padding:20px 0;\">\r\n<a target=\"_blank\" href=\"http://www.beian.gov.cn/portal/registerSystemInfo?recordcode=51032102000042\" style=\"display:inline-block;text-decoration:none;height:20px;line-height:20px;\"><img src=\"https://jq1013.oss-cn-beijing.aliyuncs.com/halo/beian_1583831402023.png\" style=\"float:left;\"/><p style=\"float:left;height:20px;line-height:20px;margin: 0px 0px 0px 5px; color:#939393;\">川公网安备 51032102000042号</p></a>\r\n</div>');
INSERT INTO `nano_options` VALUES ('blog_logo', '/upload/2020/5/favicon.png');
INSERT INTO `nano_options` VALUES ('blog_start', '2020-05-12');
INSERT INTO `nano_options` VALUES ('blog_title', '轻博客');
INSERT INTO `nano_options` VALUES ('blog_url', 'http://localhost:8090');
INSERT INTO `nano_options` VALUES ('comment_pass_notice', 'false');
INSERT INTO `nano_options` VALUES ('comment_reply_notice', 'false');
INSERT INTO `nano_options` VALUES ('comment_system', 'native');
INSERT INTO `nano_options` VALUES ('index_posts', '10');
INSERT INTO `nano_options` VALUES ('new_comment_notice', 'false');
INSERT INTO `nano_options` VALUES ('page_editor', 'editor.md');
INSERT INTO `nano_options` VALUES ('post_editor', 'editor.md');
INSERT INTO `nano_options` VALUES ('post_summary', '100');
INSERT INTO `nano_options` VALUES ('smtp_email_enable', 'false');
INSERT INTO `nano_options` VALUES ('theme', 'anatole');
INSERT INTO `nano_options` VALUES ('theme_anatole_sns_email', '459296228@qq.com');
INSERT INTO `nano_options` VALUES ('theme_anatole_sns_github', 'https://github.com/JQ1013');
INSERT INTO `nano_options` VALUES ('theme_anatole_sns_weibo', 'https://weibo.com/5334425717/profile?rightmod=1&wvr=6&mod=personinfo');

-- ----------------------------
-- Table structure for `nano_post`
-- ----------------------------
DROP TABLE IF EXISTS `nano_post`;
CREATE TABLE `nano_post` (
  `post_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `post_content` longtext,
  `post_content_md` longtext,
  `post_date` datetime DEFAULT NULL,
  `post_status` int(11) DEFAULT NULL,
  `post_summary` varchar(255) DEFAULT NULL,
  `post_thumbnail` varchar(255) DEFAULT NULL,
  `post_title` varchar(255) DEFAULT NULL,
  `post_type` varchar(255) DEFAULT NULL,
  `post_url` varchar(255) DEFAULT NULL,
  `user_id` bigint(20) NOT NULL,
  PRIMARY KEY (`post_id`),
  UNIQUE KEY `UK_6ydul5cmvb56ou1tbef6swpvk` (`post_url`),
  KEY `FKsls45s91fd502nhahl3bncewf` (`user_id`),
  CONSTRAINT `FKsls45s91fd502nhahl3bncewf` FOREIGN KEY (`user_id`) REFERENCES `nano_user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of nano_post
-- ----------------------------
INSERT INTO `nano_post` VALUES ('1', '<h1 id=\"h1-hello-Nano-\"><a name=\"Hello Nano!\" class=\"reference-link\"></a><span class=\"header-link octicon octicon-link\"></span>Hello Nano!</h1><p>欢迎使用Nano,开始你的博客之旅吧.这些残暴的欢愉 , 终将以残暴为结局 ——莎士比亚 《罗密欧与朱丽叶》</p>\n', '#Hello Nano!\nNano[ˈnɑnoʊ]，意思是毫微；纤（10的负九次方。', '2020-05-12 18:11:17', '0', '这些残暴的欢愉 , 终将以残暴为结局 ——莎士比亚 《罗密欧与朱丽叶》', null, 'Hello Nano!', 'post', 'hello-nano', '1');
INSERT INTO `nano_post` VALUES ('2', '<p>转载自iVictor，原文链接：<a href=\"http://www.cnblogs.com/ivictor/p/5028368.html\">http://www.cnblogs.com/ivictor/p/5028368.html</a></p>\n<p>一、MySQL中如何表示当前时间？</p>\n<p>其实，表达方式还是蛮多的，汇总如下：</p>\n<p>CURRENT_TIMESTAMP</p>\n<p>CURRENT_TIMESTAMP()</p>\n<p>NOW()</p>\n<p>LOCALTIME</p>\n<p>LOCALTIME()</p>\n<p>LOCALTIMESTAMP</p>\n<p>LOCALTIMESTAMP()</p>\n<p>二、关于TIMESTAMP和DATETIME的比较</p>\n<p>一个完整的日期格式如下：YYYY-MM-DD HH:MM:SS[.fraction]，它可分为两部分：date部分和time部分，其中，date部分对应格式中的“YYYY-MM-DD”，time部分对应格式中的“HH:MM:SS[.fraction]”。对于date字段来说，它只支持date部分，如果插入了time部分的内容，它会丢弃掉该部分的内容，并提示一个warning。</p>\n<p>如下所示：<br>复制代码<br>复制代码</p>\n<p>mysql&gt; create table test(id int,hiredate date);<br>Query OK, 0 rows affected (0.01 sec)</p>\n<p>mysql&gt; insert into test values(1,’20151208000000’);<br>Query OK, 1 row affected (0.00 sec)</p>\n<p>mysql&gt; insert into test values(1,’20151208104400’);<br>Query OK, 1 row affected, 1 warning (0.01 sec)</p>\n<p>mysql&gt; show warning;<br>ERROR 1064 (42000): You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near ‘warning’ at line 1<br>mysql&gt; select * from test;<br>+——+————+<br>| id   | hiredate   |<br>+——+————+<br>|    1 | 2015-12-08 |<br>|    1 | 2015-12-08 |<br>+——+————+<br>2 rows in set (0.00 sec)</p>\n<p>复制代码<br>复制代码</p>\n<p>注：第一个没提示warning的原因在于它的time部分都是0</p>\n<p>TIMESTAMP和DATETIME的相同点：</p>\n<p>1&gt; 两者都可用来表示YYYY-MM-DD HH:MM:SS[.fraction]类型的日期。</p>\n<p>TIMESTAMP和DATETIME的不同点：</p>\n<p>1&gt; 两者的存储方式不一样</p>\n<p>对于TIMESTAMP，它把客户端插入的时间从当前时区转化为UTC（世界标准时间）进行存储。查询时，将其又转化为客户端当前时区进行返回。</p>\n<p>而对于DATETIME，不做任何改变，基本上是原样输入和输出。</p>\n<p>下面，我们来验证一下</p>\n<p>首先创建两种测试表，一个使用timestamp格式，一个使用datetime格式。</p>\n', '转载自iVictor，原文链接：http://www.cnblogs.com/ivictor/p/5028368.html\n\n一、MySQL中如何表示当前时间？\n\n其实，表达方式还是蛮多的，汇总如下：\n\nCURRENT_TIMESTAMP\n\nCURRENT_TIMESTAMP()\n\nNOW()\n\nLOCALTIME\n\nLOCALTIME()\n\nLOCALTIMESTAMP\n\nLOCALTIMESTAMP()\n\n \n\n二、关于TIMESTAMP和DATETIME的比较\n\n一个完整的日期格式如下：YYYY-MM-DD HH:MM:SS[.fraction]，它可分为两部分：date部分和time部分，其中，date部分对应格式中的“YYYY-MM-DD”，time部分对应格式中的“HH:MM:SS[.fraction]”。对于date字段来说，它只支持date部分，如果插入了time部分的内容，它会丢弃掉该部分的内容，并提示一个warning。\n\n如下所示：\n复制代码\n复制代码\n\nmysql> create table test(id int,hiredate date);\nQuery OK, 0 rows affected (0.01 sec)\n\nmysql> insert into test values(1,\'20151208000000\');\nQuery OK, 1 row affected (0.00 sec)\n\nmysql> insert into test values(1,\'20151208104400\');\nQuery OK, 1 row affected, 1 warning (0.01 sec)\n\nmysql> show warning;\nERROR 1064 (42000): You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near \'warning\' at line 1\nmysql> select * from test;\n+------+------------+\n| id   | hiredate   |\n+------+------------+\n|    1 | 2015-12-08 |\n|    1 | 2015-12-08 |\n+------+------------+\n2 rows in set (0.00 sec)\n\n复制代码\n复制代码\n\n注：第一个没提示warning的原因在于它的time部分都是0\n\n \n\nTIMESTAMP和DATETIME的相同点：\n\n1> 两者都可用来表示YYYY-MM-DD HH:MM:SS[.fraction]类型的日期。\n\n \n\nTIMESTAMP和DATETIME的不同点：\n\n1> 两者的存储方式不一样\n\n对于TIMESTAMP，它把客户端插入的时间从当前时区转化为UTC（世界标准时间）进行存储。查询时，将其又转化为客户端当前时区进行返回。\n\n而对于DATETIME，不做任何改变，基本上是原样输入和输出。\n\n \n\n下面，我们来验证一下\n\n首先创建两种测试表，一个使用timestamp格式，一个使用datetime格式。', '2020-05-13 21:02:34', '1', '转载自iVictor，原文链接：http://www.cnblogs.com/ivictor/p/5028368.html一、MySQL中如何表示当前时间？其实，表达方式还是蛮多的，汇总如下：CURR', 'http://localhost:8090/upload/2020/5/life_is_good-wallpaper-1920x1080.jpg', 'java1', 'post', 'java', '1');
INSERT INTO `nano_post` VALUES ('3', '<p>5555555555555555555555555555555555</p>\n<p>55555555555</p>\n', '5555555555555555555555555555555555\n\n\n\n\n\n55555555555', '2020-05-13 20:42:45', '1', '555555555555555555555555555555555555555555555\n', 'http://localhost:8090/upload/2020/5/jammu-wallpaper-1920x1080.jpg', '55555555555555555555', 'post', '55', '1');
INSERT INTO `nano_post` VALUES ('4', '<p>转载自iVictor，原文链接：<a href=\"http://www.cnblogs.com/ivictor/p/5028368.html\">http://www.cnblogs.com/ivictor/p/5028368.html</a></p>', '转载自iVictor，原文链接：http://www.cnblogs.com/ivictor/p/5028368.html', '2020-05-13 21:02:24', '1', '转载自iVictor，原文链接：http://www.cnblogs.com/ivictor/p/5', 'http://localhost:8090/static/images/thumbnail.png', 'java2', 'post', 'java2', '1');
INSERT INTO `nano_post` VALUES ('5', '<p>大大打算打算的asd撒<br>da是<br>das<br>as dasd是a<br>打算asas啊</p>\n', '大大打算打算的asd撒\nda是\ndas \nas dasd是a \n打算asas啊', '2020-05-13 21:10:00', '0', '大大打算打算的asd撒da是dasas dasd是a打算asas啊\n', 'http://localhost:8090/upload/2020/5/lamborghini_2-wallpaper-1920x1080.jpg', 'java3', 'post', 'java3', '1');
INSERT INTO `nano_post` VALUES ('8', '<p>1111</p>\n', '1111', '2020-05-13 22:26:18', '0', null, 'http://localhost:8090/upload/2020/5/life_is_good-wallpaper-1920x1080.jpg', '11', 'page', '11', '1');
INSERT INTO `nano_post` VALUES ('9', '<p>44444444444444</p>\n', '44444444444444', '2020-05-13 22:34:31', '0', null, 'http://localhost:8090/upload/2020/5/denpa_onna_to_seishun_otoko-wallpaper-1920x1080.jpg', '22', 'page', '222', '1');

-- ----------------------------
-- Table structure for `nano_posts_categories`
-- ----------------------------
DROP TABLE IF EXISTS `nano_posts_categories`;
CREATE TABLE `nano_posts_categories` (
  `post_id` bigint(20) NOT NULL,
  `cate_id` bigint(20) NOT NULL,
  KEY `FKilgmuvl6thphj1rsvebma6q4u` (`cate_id`),
  KEY `FKdgaet8r72swtrkwlhqpw03fuc` (`post_id`),
  CONSTRAINT `FKdgaet8r72swtrkwlhqpw03fuc` FOREIGN KEY (`post_id`) REFERENCES `nano_post` (`post_id`),
  CONSTRAINT `FKilgmuvl6thphj1rsvebma6q4u` FOREIGN KEY (`cate_id`) REFERENCES `nano_category` (`cate_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of nano_posts_categories
-- ----------------------------
INSERT INTO `nano_posts_categories` VALUES ('1', '1');
INSERT INTO `nano_posts_categories` VALUES ('3', '1');
INSERT INTO `nano_posts_categories` VALUES ('4', '1');
INSERT INTO `nano_posts_categories` VALUES ('4', '1');
INSERT INTO `nano_posts_categories` VALUES ('2', '1');
INSERT INTO `nano_posts_categories` VALUES ('5', '1');

-- ----------------------------
-- Table structure for `nano_posts_tags`
-- ----------------------------
DROP TABLE IF EXISTS `nano_posts_tags`;
CREATE TABLE `nano_posts_tags` (
  `post_id` bigint(20) NOT NULL,
  `tag_id` bigint(20) NOT NULL,
  KEY `FKlnbv4qgkqqifp43nuhx1rbsad` (`tag_id`),
  KEY `FKdgwbjj607db8hfgvls9bydvch` (`post_id`),
  CONSTRAINT `FKdgwbjj607db8hfgvls9bydvch` FOREIGN KEY (`post_id`) REFERENCES `nano_post` (`post_id`),
  CONSTRAINT `FKlnbv4qgkqqifp43nuhx1rbsad` FOREIGN KEY (`tag_id`) REFERENCES `nano_tag` (`tag_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of nano_posts_tags
-- ----------------------------
INSERT INTO `nano_posts_tags` VALUES ('3', '4');
INSERT INTO `nano_posts_tags` VALUES ('4', '5');
INSERT INTO `nano_posts_tags` VALUES ('2', '1');
INSERT INTO `nano_posts_tags` VALUES ('2', '3');
INSERT INTO `nano_posts_tags` VALUES ('5', '2');
INSERT INTO `nano_posts_tags` VALUES ('5', '1');
INSERT INTO `nano_posts_tags` VALUES ('5', '3');

-- ----------------------------
-- Table structure for `nano_tag`
-- ----------------------------
DROP TABLE IF EXISTS `nano_tag`;
CREATE TABLE `nano_tag` (
  `tag_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `tag_name` varchar(255) DEFAULT NULL,
  `tag_url` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`tag_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of nano_tag
-- ----------------------------
INSERT INTO `nano_tag` VALUES ('1', 'java', 'java');
INSERT INTO `nano_tag` VALUES ('2', '新闻', '新闻');
INSERT INTO `nano_tag` VALUES ('3', 'mysql', 'mysql');
INSERT INTO `nano_tag` VALUES ('4', '5555', '5555');
INSERT INTO `nano_tag` VALUES ('5', 'java2', 'java2');

-- ----------------------------
-- Table structure for `nano_user`
-- ----------------------------
DROP TABLE IF EXISTS `nano_user`;
CREATE TABLE `nano_user` (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `login_enable` varchar(255) DEFAULT NULL,
  `login_error` int(11) DEFAULT NULL,
  `login_last` datetime DEFAULT NULL,
  `user_avatar` varchar(255) DEFAULT NULL,
  `user_desc` varchar(255) DEFAULT NULL,
  `user_display_name` varchar(255) DEFAULT NULL,
  `user_email` varchar(255) DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  `user_pass` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of nano_user
-- ----------------------------
INSERT INTO `nano_user` VALUES ('1', 'true', '0', '2020-05-13 22:43:11', '/upload/2020/5/lion.jpg', '我与杀戮之中盛放,亦如黎明中的花朵', 'LMH0826', '459296228@qq.com', 'luminghao', 'f379eaf3c831b04de153469d1bec345e');

-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: melon
-- ------------------------------------------------------
-- Server version	5.7.19-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Dumping data for table `company`
--

LOCK TABLES `company` WRITE;
/*!40000 ALTER TABLE `company` DISABLE KEYS */;
INSERT INTO `company` VALUES (1000936662225932289,'中国电建集团贵州电力设计院研究院有限公司',997325005979074561,'央企','贵州省贵阳市遵义路133号','83603.83','贵州电力设计研究院前身为贵州电力设计院，1958年8月建院，位于贵阳市遵义路56号。贵州电力设计研究院属中国电力建设集团有限公司，是贵州省唯一的甲级电力设计研究院，具有国家建设部颁发的勘察综合类甲级证书、电力工程设计甲级证书、电力工程咨询甲级证书、电力工程总承包甲级证书、建筑工程设计乙级证书及测绘资质乙级证书等，主要承担电网规划、大中型火力发电工程、输变电工程以及民用建筑工程的勘测、设计、监理、咨询和工程总承包任务。','gzed@sina.com','08514548',0,'1958-09-27 00:00:00','2018-05-28 10:53:07','2018-05-28 10:53:07'),(1000941346412060673,'网易（杭州）',997325005979074561,'互联网技术公司','浙江省杭州市滨江区网商路33号','13760.0','网易网站为互联网用户提供了以内容、社区和电子商务服务为核心的中文在线服务。2010年10月11日，中国领先的门户网站网易宣布将旗下新闻资讯类频道进行新一轮的页面改版，新版本首次提出“有态度的门户”的内容建设理念。','NeatEase@corp.netease.com','0571-26201163',1,'1997-06-01 00:00:00','2018-05-28 11:26:28','2018-05-28 11:26:28');
/*!40000 ALTER TABLE `company` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `department`
--

LOCK TABLES `department` WRITE;
/*!40000 ALTER TABLE `department` DISABLE KEYS */;
INSERT INTO `department` VALUES (1000993941251973122,1000936662225932289,997325752758124545,'地理信息中心','地理信息软件研发','2018-05-28 16:51:46','2018-05-28 14:51:20','2018-05-28 16:17:12');
/*!40000 ALTER TABLE `department` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `educational_experience`
--

LOCK TABLES `educational_experience` WRITE;
/*!40000 ALTER TABLE `educational_experience` DISABLE KEYS */;
INSERT INTO `educational_experience` VALUES (998840884049231873,998462921537581057,'浙江大学','计算机软件工程',2.5,'Web Service服务','吴朝晖','2018-05-22 15:58:00','2018-05-22 15:58:00','2014-09-01 00:00:00','2017-03-31 00:00:00'),(998840884053426178,998462921537581057,'西南大学','计算机软件工程',1,'Web Service服务','***','2018-05-22 15:58:00','2018-05-22 15:58:00','2013-09-01 00:00:00','2014-07-01 00:00:00'),(998840884061814785,998462921537581057,'中国地质大学（武汉）','信息与计算科学',4,'数学计算','***','2018-05-22 15:58:00','2018-05-22 15:58:00','2009-09-01 00:00:00','2017-07-01 00:00:00');
/*!40000 ALTER TABLE `educational_experience` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `family_relationship`
--

LOCK TABLES `family_relationship` WRITE;
/*!40000 ALTER TABLE `family_relationship` DISABLE KEYS */;
INSERT INTO `family_relationship` VALUES (998488557404561410,997325005979074561,'父亲','duyajun',3,'无','18385839758','1956-10-10 00:00:00','2018-05-21 16:59:19','2018-05-21 16:59:19'),(998488557505224705,997325005979074561,'母亲','yangxuzhi',2,'无','18722906643','1965-10-05 00:00:00','2018-05-21 16:59:19','2018-05-21 16:59:19'),(998488557509419009,997325005979074561,'姐','dujuan',2,'无','13595672626','1986-08-07 01:00:00','2018-05-21 16:59:19','2018-05-21 16:59:19');
/*!40000 ALTER TABLE `family_relationship` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `internship_experience`
--

LOCK TABLES `internship_experience` WRITE;
/*!40000 ALTER TABLE `internship_experience` DISABLE KEYS */;
INSERT INTO `internship_experience` VALUES (998847689043230722,998462921537581057,'云课堂Java后台云开发','网易','浙江省杭州市滨江区网商路33号','2018-05-22 00:00:00','2018-08-04 00:00:00','2018-05-22 16:41:34','2018-05-22 16:41:34','方航');
/*!40000 ALTER TABLE `internship_experience` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `permission`
--

LOCK TABLES `permission` WRITE;
/*!40000 ALTER TABLE `permission` DISABLE KEYS */;
/*!40000 ALTER TABLE `permission` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `project`
--

LOCK TABLES `project` WRITE;
/*!40000 ALTER TABLE `project` DISABLE KEYS */;
/*!40000 ALTER TABLE `project` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `project_company`
--

LOCK TABLES `project_company` WRITE;
/*!40000 ALTER TABLE `project_company` DISABLE KEYS */;
/*!40000 ALTER TABLE `project_company` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `project_department`
--

LOCK TABLES `project_department` WRITE;
/*!40000 ALTER TABLE `project_department` DISABLE KEYS */;
/*!40000 ALTER TABLE `project_department` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `project_group`
--

LOCK TABLES `project_group` WRITE;
/*!40000 ALTER TABLE `project_group` DISABLE KEYS */;
INSERT INTO `project_group` VALUES (1001021956451295233,997325005979074561,1000993941251973122,'开发一组','二维Gis研发','2018-05-28 16:45:30','2018-05-28 16:45:30','2018-05-28 00:00:00'),(1001023594222149634,997325005979074561,1000993941251973122,'开发二组','电力四维','2018-05-28 16:45:30','2018-05-28 16:45:30','2018-05-28 00:00:00'),(1001023734605504513,997325005979074561,1000993941251973122,'开发三组','Java相关项目开发','2018-05-28 16:45:30','2018-05-28 16:45:30','2018-05-28 00:00:00');
/*!40000 ALTER TABLE `project_group` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `project_group_member`
--

LOCK TABLES `project_group_member` WRITE;
/*!40000 ALTER TABLE `project_group_member` DISABLE KEYS */;
/*!40000 ALTER TABLE `project_group_member` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `project_member`
--

LOCK TABLES `project_member` WRITE;
/*!40000 ALTER TABLE `project_member` DISABLE KEYS */;
/*!40000 ALTER TABLE `project_member` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `project_type`
--

LOCK TABLES `project_type` WRITE;
/*!40000 ALTER TABLE `project_type` DISABLE KEYS */;
/*!40000 ALTER TABLE `project_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `resume`
--

LOCK TABLES `resume` WRITE;
/*!40000 ALTER TABLE `resume` DISABLE KEYS */;
INSERT INTO `resume` VALUES (998462921537581057,997325005979074561,'admin','/images/admin.jpg',0,0,2,'11',7,7,'15268528314','admin@sina.com','string',1,'2018-05-21 00:00:00','2018-05-21 14:54:15','2018-05-21 14:54:15'),(999110944034668546,997325752758124545,'admin','/images/admin.jpg',0,0,2,'1',8,8,'18883308404','admin@sina.com','打羽毛球',1,'1985-05-23 00:00:00','2018-05-23 10:11:30','2018-05-23 10:11:30');
/*!40000 ALTER TABLE `resume` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `role_permission`
--

LOCK TABLES `role_permission` WRITE;
/*!40000 ALTER TABLE `role_permission` DISABLE KEYS */;
/*!40000 ALTER TABLE `role_permission` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `school_activities`
--

LOCK TABLES `school_activities` WRITE;
/*!40000 ALTER TABLE `school_activities` DISABLE KEYS */;
INSERT INTO `school_activities` VALUES (998848783186149378,998462921537581057,'数理学院数学建模协会','刘志远','2010-09-20 00:00:00','2013-07-01 00:00:00','2018-05-22 16:48:34','2018-05-22 16:48:34'),(998848783190343682,998462921537581057,'数理学院足球协会','刘志远','2010-09-20 00:00:00','2013-07-01 00:00:00','2018-05-22 16:48:34','2018-05-22 16:48:34');
/*!40000 ALTER TABLE `school_activities` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `school_reward`
--

LOCK TABLES `school_reward` WRITE;
/*!40000 ALTER TABLE `school_reward` DISABLE KEYS */;
INSERT INTO `school_reward` VALUES (998851754280108034,998462921537581057,'数理学院学业二等奖学金','湖北省武汉市洪山区鲁磨路133号中国地质大学（武汉）','刘志远','2010-09-01 00:00:00','2011-09-22 00:00:00','2018-05-22 16:53:34','2018-05-22 16:53:34'),(998851754284302337,998462921537581057,'数理学院学业二等奖学金','湖北省武汉市洪山区鲁磨路133号中国地质大学（武汉）','刘志远','2011-09-01 00:00:00','2012-09-22 00:00:00','2018-05-22 16:53:34','2018-05-22 16:53:34'),(998851754288496642,998462921537581057,'数理学院学业二等奖学金','湖北省武汉市洪山区鲁磨路133号中国地质大学（武汉）','刘志远','2012-09-01 00:00:00','2013-05-22 00:00:00','2018-05-22 16:53:34','2018-05-22 16:53:34'),(998851754292690945,998462921537581057,'浙江大学硕士研究生学业奖学金','浙江省浙江大学','吴朝晖','2014-09-01 00:00:00','2015-09-22 00:00:00','2018-05-22 16:53:34','2018-05-22 16:53:34'),(998851754292690946,998462921537581057,'浙江大学硕士研究生奖学金','浙江省浙江大学','吴朝晖','2015-09-01 00:00:00','2016-09-22 00:00:00','2018-05-22 16:53:34','2018-05-22 16:53:34'),(998851754301079554,998462921537581057,'浙江大学硕士研究生奖学金','浙江省浙江大学','吴朝晖','2016-09-01 00:00:00','2017-03-31 00:00:00','2018-05-22 16:53:34','2018-05-22 16:53:34');
/*!40000 ALTER TABLE `school_reward` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `task`
--

LOCK TABLES `task` WRITE;
/*!40000 ALTER TABLE `task` DISABLE KEYS */;
/*!40000 ALTER TABLE `task` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (997325005979074561,'solstice','solstice','iKXM0haPQrtTRyR0XxQAYSQeGLs=','30797ffbaca64aa086d057b24f89a813','工程师','Java开发工程师','15268528314','solstice@sina.com',1,'string','string','贵州松桃','贵阳市','2018-05-18 00:00:00','2018-05-18 14:33:02','2018-05-18 11:47:54'),(997325752758124545,'admin','admin','dHJBtwhDmccbHP/mZEiNgNGUwaE=','c8a7f52bb96c4fc18099922254b9cc6b','系统管理员','系统管理员','15268528314','admin@sina.com',1,'string','string','贵州松桃','贵阳市','2018-05-18 00:00:00','2018-05-18 14:33:02','2018-05-18 11:58:54');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `user_role`
--

LOCK TABLES `user_role` WRITE;
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `weekly`
--

LOCK TABLES `weekly` WRITE;
/*!40000 ALTER TABLE `weekly` DISABLE KEYS */;
/*!40000 ALTER TABLE `weekly` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `work_experience`
--

LOCK TABLES `work_experience` WRITE;
/*!40000 ALTER TABLE `work_experience` DISABLE KEYS */;
INSERT INTO `work_experience` VALUES (998774649118797826,998462921537581057,'网易','浙江省杭州市滨江区网商路33号','Java开发','Java开发实习','方航','2016-05-04 00:00:00','2016-08-04 00:00:00','2018-05-22 11:45:24','2018-05-22 11:45:24'),(998774649177518081,998462921537581057,'浙江大学','浙江省杭州市西湖区浙大路33号','Java开发','Java开发','杨建华','2014-08-01 00:00:00','2017-03-31 00:00:00','2018-05-22 11:45:24','2018-05-22 11:45:24'),(998817107311607810,998462921537581057,'贵州电力设计研究院有限公司','贵州省贵阳市遵义路133号','Java开发工程师','Java开发','***','2017-05-04 00:00:00','2018-05-21 00:00:00','2018-05-22 14:38:11','2018-05-22 14:38:11');
/*!40000 ALTER TABLE `work_experience` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-05-28 16:57:34

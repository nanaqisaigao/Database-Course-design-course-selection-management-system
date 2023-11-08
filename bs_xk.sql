-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: localhost    Database: bs_xk
-- ------------------------------------------------------
-- Server version	8.0.32

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `admin_info`
--

DROP TABLE IF EXISTS `admin_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `admin_info` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '密码',
  `sex` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '性别',
  `age` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '年龄',
  `phone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '手机号',
  `level` int DEFAULT '1' COMMENT '权限等级',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=DYNAMIC COMMENT='管理员信息表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin_info`
--

LOCK TABLES `admin_info` WRITE;
/*!40000 ALTER TABLE `admin_info` DISABLE KEYS */;
INSERT INTO `admin_info` VALUES (1,'胡婷','123456','女','20','520520520520',1),(15,'卢俊朴','123456','男','20','1234567891234',1),(30,'admin','123456','男','21','18877778888',1),(34,'卢俊辰','123456','男','10','24445568778',1),(41,'aaa','123456','男','1','1',1),(42,'bbb','123456','男','11','11',1);
/*!40000 ALTER TABLE `admin_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `class_info`
--

DROP TABLE IF EXISTS `class_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `class_info` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '课程名称',
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '课程介绍',
  `zhuanyeId` bigint DEFAULT NULL COMMENT '专业ID',
  `score` int DEFAULT NULL COMMENT '课程学分',
  `teacherId` bigint DEFAULT NULL COMMENT '教师ID',
  `kaiban` int DEFAULT '0' COMMENT '开班人数',
  `time` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '上课时段',
  `location` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '上课地点',
  `yixuan` int DEFAULT '0' COMMENT '已选人数',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC COMMENT='课程信息表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `class_info`
--

LOCK TABLES `class_info` WRITE;
/*!40000 ALTER TABLE `class_info` DISABLE KEYS */;
INSERT INTO `class_info` VALUES (12,'网络攻防','教授黑客入侵的方法与防治',13,4,51,15,'周二第四大节','31302',1),(13,'Java基础','学会Java语言基础',9,3,35,15,'周一第一大节','11201',3),(14,'Python基础','学会Python基础',9,3,44,15,'周二第一大节','11213',1),(15,'德语商务','学会跟德国人谈生意',14,3,40,5,'周三第二大节','30402',1),(16,'古代兽语','教你元谋人怎么书画',12,2,50,5,'周四第三大节','33401',2),(17,'商务英语','各种商务场景英语交流技巧',15,3,52,10,'周五第六大节','22301',3),(18,'网络安全概论','这是一条课程介绍',13,1,35,10,'周五第三大节','11202',1);
/*!40000 ALTER TABLE `class_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student_info`
--

DROP TABLE IF EXISTS `student_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student_info` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '密码',
  `sex` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '性别',
  `age` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '年龄',
  `code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '学号',
  `level` int DEFAULT '3' COMMENT '权限等级',
  `xueyuanId` bigint DEFAULT NULL COMMENT '学院ID',
  `score` int DEFAULT '0' COMMENT '总学分',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=DYNAMIC COMMENT='学生信息表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student_info`
--

LOCK TABLES `student_info` WRITE;
/*!40000 ALTER TABLE `student_info` DISABLE KEYS */;
INSERT INTO `student_info` VALUES (27,'张三','123456','男','24','20000',3,1,0),(28,'李四','123456','男','23','20001',3,2,0),(29,'王五','123456','男','23','20002',3,3,0),(30,'赵六','123456','男','23','20003',3,4,0),(32,'卢同学','123456','男','20','202113407120',3,2,3),(33,'胡婷','123456','女','20','202110000',3,4,6),(34,'小明','123456','男','21','20223474',3,2,3);
/*!40000 ALTER TABLE `student_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teacher_info`
--

DROP TABLE IF EXISTS `teacher_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `teacher_info` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '密码',
  `sex` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '性别',
  `age` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '年龄',
  `zhicheng` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '职称',
  `level` int DEFAULT '2' COMMENT '权限等级',
  `zhuanyeId` bigint DEFAULT NULL COMMENT '专业ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=53 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=DYNAMIC COMMENT='教师信息表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teacher_info`
--

LOCK TABLES `teacher_info` WRITE;
/*!40000 ALTER TABLE `teacher_info` DISABLE KEYS */;
INSERT INTO `teacher_info` VALUES (35,'卢老师','123','男','33','教授',2,9),(40,'古月婷','123456','女','34','副教授',2,14),(44,'杨松','123456','男','31','副教授',2,9),(49,'王小明','123456','男','55','院长',2,8),(50,'晓黄仁','123456','女','42','教授',2,12),(51,'叶凡','123456','男','37','教授',2,13),(52,'杜啤','123456','女','43','副教授',2,15);
/*!40000 ALTER TABLE `teacher_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `xuanke_info`
--

DROP TABLE IF EXISTS `xuanke_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `xuanke_info` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '课程名称',
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '课程介绍',
  `zhuanyeId` bigint DEFAULT NULL COMMENT '专业ID',
  `score` int DEFAULT NULL COMMENT '课程学分',
  `teacherId` bigint DEFAULT NULL COMMENT '教师ID',
  `kaiban` int DEFAULT '0' COMMENT '开班人数',
  `time` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '上课时段',
  `location` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '上课地点',
  `studentId` bigint DEFAULT NULL COMMENT '学生ID',
  `status` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '课程状态',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC COMMENT='选课信息表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `xuanke_info`
--

LOCK TABLES `xuanke_info` WRITE;
/*!40000 ALTER TABLE `xuanke_info` DISABLE KEYS */;
INSERT INTO `xuanke_info` VALUES (16,'网络攻防','教授黑客入侵的方法与防治',13,4,51,15,'周二第四大节','31302',28,'待开课'),(23,'Java基础','学会Java语言基础',9,3,35,20,'周一第一大节','11201',32,'已结课'),(24,'德语商务','学会跟德国人谈生意',14,3,40,5,'周三第二大节','30402',33,'待开课'),(25,'商务英语','各种商务场景英语交流技巧',15,3,52,10,'周五第六大节','22301',33,'待开课'),(28,'Java基础','学会Java语言基础',9,3,35,15,'周一第一大节','11201',34,'已结课'),(29,'Python基础','学会Python基础',9,3,44,15,'周二第一大节','11213',34,'待开课'),(30,'商务英语','各种商务场景英语交流技巧',15,3,52,10,'周五第六大节','22301',32,'待开课'),(31,'古代兽语','教你元谋人怎么书画',12,2,50,5,'周四第三大节','33401',32,'待开课'),(33,'古代兽语','教你元谋人怎么书画',12,2,50,5,'周四第三大节','33401',33,'待开课'),(34,'Java基础','学会Java语言基础',9,3,35,15,'周一第一大节','11201',33,'已结课'),(35,'网络安全概论','这是一条课程介绍',13,1,35,10,'周五第三大节','11202',32,'待开课');
/*!40000 ALTER TABLE `xuanke_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `xueyuan_info`
--

DROP TABLE IF EXISTS `xueyuan_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `xueyuan_info` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '学院名称',
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '学院介绍',
  `score` int DEFAULT NULL COMMENT '学分限制,这个学院最多修多少学分',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC COMMENT='学院信息表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `xueyuan_info`
--

LOCK TABLES `xueyuan_info` WRITE;
/*!40000 ALTER TABLE `xueyuan_info` DISABLE KEYS */;
INSERT INTO `xueyuan_info` VALUES (1,'信息工程学院','这是一条描述这是一条描述',100),(2,'计算机学院','这是一条描述这是一条描述',120),(3,'软件学院','这是一条描述这是一条描述',120),(4,'外国语学院','这是一条描述这是一条描述',60),(7,'文学院','这是一条描述这是一条描述',60),(8,'体育学院','这是一条描述这是一条描述',50);
/*!40000 ALTER TABLE `xueyuan_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `zhuanye_info`
--

DROP TABLE IF EXISTS `zhuanye_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `zhuanye_info` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '专业名称',
  `department` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '系名',
  `xueyuanId` bigint DEFAULT NULL COMMENT '学院ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC COMMENT='专业信息表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `zhuanye_info`
--

LOCK TABLES `zhuanye_info` WRITE;
/*!40000 ALTER TABLE `zhuanye_info` DISABLE KEYS */;
INSERT INTO `zhuanye_info` VALUES (8,'电子信息工程','电子系',1),(9,'软件工程','工科系',2),(12,'古汉语信息','文学系',7),(13,'网络安全','工科系',2),(14,'德语','语言系',4),(15,'英语','语言系',4);
/*!40000 ALTER TABLE `zhuanye_info` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-11-08  9:49:03

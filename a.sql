-- MySQL dump 10.13  Distrib 5.6.40, for Win64 (x86_64)
--
-- Host: localhost    Database: thesis_manage
-- ------------------------------------------------------
-- Server version	5.6.40-log

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
-- Table structure for table `friends`
--

DROP TABLE IF EXISTS `friends`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `friends` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(16) COLLATE utf8_bin DEFAULT NULL,
  `friend` varchar(16) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `friends`
--

LOCK TABLES `friends` WRITE;
/*!40000 ALTER TABLE `friends` DISABLE KEYS */;
INSERT INTO `friends` VALUES (1,'12345601','12345602'),(2,'12345601','12345603'),(3,'12345601','12345604'),(4,'12345601','12345605'),(5,'12345602','12345601'),(6,'12345602','12345603'),(7,'12345602','12345604'),(8,'12345602','12345605'),(9,'12345603','12345601'),(10,'12345603','12345602'),(11,'12345603','12345604'),(12,'12345603','12345605'),(13,'12345604','12345601'),(14,'12345604','12345602'),(15,'12345604','12345603'),(16,'12345604','12345605'),(17,'12345605','12345601'),(18,'12345605','12345602'),(19,'12345605','12345603'),(20,'12345605','12345604'),(21,'12345601','12345678'),(22,'12345602','12345678'),(23,'12345603','12345678'),(24,'12345604','12345678'),(25,'12345605','12345678'),(26,'12345678','12345601'),(27,'12345678','12345602'),(28,'12345678','12345603'),(29,'12345678','12345604'),(30,'12345678','12345605');
/*!40000 ALTER TABLE `friends` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `message`
--

DROP TABLE IF EXISTS `message`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `message` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username1` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `username2` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `message` varchar(200) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `message`
--

LOCK TABLES `message` WRITE;
/*!40000 ALTER TABLE `message` DISABLE KEYS */;
INSERT INTO `message` VALUES (17,'12345601','12345678','欢迎使用本系统'),(18,'12345602','12345678','欢迎使用本系统'),(19,'12345603','12345678','欢迎使用本系统'),(20,'12345604','12345678','欢迎使用本系统'),(37,'12345605','12345678','欢迎使用本系统'),(38,'12345602','12345601',''),(39,'12345602','12345601','兄弟你好\n'),(40,'12345603','12345601','今天过得开心吗\n'),(41,'12345605','12345601',''),(42,'12345601','12345603','不开心');
/*!40000 ALTER TABLE `message` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `paperdownload`
--

DROP TABLE IF EXISTS `paperdownload`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `paperdownload` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `paperID` int(11) DEFAULT NULL,
  `username` varchar(16) DEFAULT NULL,
  `time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `paperdownload`
--

LOCK TABLES `paperdownload` WRITE;
/*!40000 ALTER TABLE `paperdownload` DISABLE KEYS */;
/*!40000 ALTER TABLE `paperdownload` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `thesis`
--

DROP TABLE IF EXISTS `thesis`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `thesis` (
  `id` int(6) NOT NULL AUTO_INCREMENT,
  `title` varchar(32) COLLATE utf8_bin DEFAULT NULL,
  `author` varchar(7) COLLATE utf8_bin DEFAULT NULL,
  `abstract1` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `teacher` varchar(7) COLLATE utf8_bin DEFAULT NULL,
  `type` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `specialized` varchar(16) COLLATE utf8_bin DEFAULT NULL,
  `pages` int(11) DEFAULT NULL,
  `score` float DEFAULT NULL,
  `successtime` date DEFAULT NULL,
  `uid` varchar(16) COLLATE utf8_bin DEFAULT NULL,
  `src` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `downloadnumb` int(11) DEFAULT '0',
  `score1` float DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=100063 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `thesis`
--

LOCK TABLES `thesis` WRITE;
/*!40000 ALTER TABLE `thesis` DISABLE KEYS */;
INSERT INTO `thesis` VALUES (100047,'交通安全论述','Ww','有关交通安全','撒达娃','专本论文','14交通',45,68,'2023-06-12','12345601','12345601/交通安全.docx',0,NULL),(100049,'论法律带给我们的作用','Ww','系统的阐述了法律所带来的作用','熟即可','专本论文','3法学',36,66,'2023-06-12','12345601','12345601/论法律所带来的作用.docx',0,NULL),(100050,'论教育带来社会的改变','Ww','教育对人类社会的影响','库大街','专本论文','1教育',68,97,'2023-06-12','12345601','12345601/教育带给社会的改变.docx',0,NULL),(100051,'如何保护我们的生态环境','Ww','提出了几个保护我们生态环境的措施','维西语','专本论文','5环境',87,90,'2023-06-12','12345601','12345601/如何保护我们的生态环境.docx',0,NULL),(100052,'新时期电子信息技术在农业机械中的应用研究','顾小六','电子信息技术对新时代的农业发展起着关键作用','周江','专本论文','12软件',5,78,'2023-06-13','12345605','12345605/论文.doc',0,NULL),(100053,'浅析电子信息技术在农业机械应用的特点及难点','顾长柏','电子信息技术在农业机械应用中既有优点也有缺点','周国','专本论文','20计算机',5,8,'2023-06-13','12345605','12345605/论文2.doc',0,NULL),(100055,'生成式人工智能的风险规制困境及其化解','毕文轩','以ChatGPT为代表的生成式人工智能技术产生，在极大地提升人们工作效率的同时','wjf','期刊发表','20计算机',22,85,'2023-06-13','12345602','12345602/生成式人工智能的风险规制困...ChatGPT的规制为视角_毕文轩.docx',0,NULL),(100057,'新时期电子信息技术发展现状与趋势分析','左柚','新时期电子信息技术的迅速发展的两面性','周全','硕士论文','19电子',7,9,'2023-06-13','12345605','12345605/论文3.doc',0,NULL),(100058,'提升小学生汉语言文学运用能力的策略研究','李小宝','小学生汉语言文学运用能力在当代社会是一个很关键的标准','张珊珊','专本论文','1教育',3,87,'2023-06-13','05123456','05123456/论文4.doc',0,NULL),(100059,'浅谈大学语文教育中我国古代文学教学创新路径','王红','大学语文教育渐渐开辟自己的创新之路','张珊珊','专本论文','1教育',5,90,'2023-06-13','05123456','05123456/论文5.doc',0,NULL),(100060,'关于新闻','Ss','新闻一则','萨迪克','硕士论文','6新闻',23,67,'2023-06-15','12345603','12345603/关于新闻.docx',0,NULL),(100062,'社会一则','Ss','关于社会','史蒂文','专本论文','7社会',21,62,'2023-06-15','12345603','12345603/社会这本书.docx',0,NULL);
/*!40000 ALTER TABLE `thesis` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `userinfo`
--

DROP TABLE IF EXISTS `userinfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `userinfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(16) COLLATE utf8_bin DEFAULT NULL,
  `password` varchar(16) COLLATE utf8_bin DEFAULT NULL,
  `Permissions` varchar(12) COLLATE utf8_bin DEFAULT NULL,
  `attach` varchar(7) COLLATE utf8_bin DEFAULT NULL,
  `name` varchar(16) COLLATE utf8_bin DEFAULT NULL,
  `school` varchar(32) COLLATE utf8_bin DEFAULT NULL,
  `specialized` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=100015 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userinfo`
--

LOCK TABLES `userinfo` WRITE;
/*!40000 ALTER TABLE `userinfo` DISABLE KEYS */;
INSERT INTO `userinfo` VALUES (100008,'12345601','123456','管理员',NULL,'Ww','信息学院','软件工程'),(100009,'12345602','123456',NULL,NULL,NULL,'工程学院',NULL),(100010,'12345603','123456','管理员',NULL,'Ss','信息学院',NULL),(100011,'12345604','123456',NULL,NULL,NULL,'工程学院',NULL),(100012,'12345605','123456','普通用户',NULL,'12345605','信息学院','软件工程'),(100013,'12345678','123456',NULL,NULL,NULL,'文法学院',NULL),(100014,'05123456','123456','普通用户',NULL,'05123456','文法学院','汉语言文学');
/*!40000 ALTER TABLE `userinfo` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-06-16 16:38:34

-- MySQL dump 10.13  Distrib 5.7.20, for Win64 (x86_64)
--
-- Host: localhost    Database: quizzer
-- ------------------------------------------------------
-- Server version	5.7.20-log

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
-- Table structure for table `domain`
--

DROP TABLE IF EXISTS `domain`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `domain` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `domain`
--

LOCK TABLES `domain` WRITE;
/*!40000 ALTER TABLE `domain` DISABLE KEYS */;
INSERT INTO `domain` VALUES (1,'BIOLOGY'),(2,'HISTORY'),(3,'GEOGRAPHY');
/*!40000 ALTER TABLE `domain` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `level1`
--

DROP TABLE IF EXISTS `level1`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `level1` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `domain` varchar(50) NOT NULL,
  `question` varchar(150) NOT NULL,
  `answer1` varchar(150) NOT NULL,
  `answer2` varchar(50) NOT NULL,
  `answer3` varchar(50) NOT NULL,
  `correct` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `level1`
--

LOCK TABLES `level1` WRITE;
/*!40000 ALTER TABLE `level1` DISABLE KEYS */;
INSERT INTO `level1` VALUES (1,'BIOLOGY','question1','var1','var2','var3','var1'),(2,'BIOLOGY','question2','var1','var2','var3','var1'),(3,'BIOLOGY','question4','var1','var2','var3','var1'),(4,'BIOLOGY','question4','var1','var2','var3','var1'),(5,'BIOLOGY','question5','var1','var2','var3','var1'),(6,'BIOLOGY','question6','var1','var2','var3','var1'),(7,'BIOLOGY','question7','var1','var2','var3','var1'),(8,'BIOLOGY','question8','var1','var2','var3','var1'),(9,'BIOLOGY','question9','var1','var2','var3','var1'),(10,'BIOLOGY','question10','var1','var2','var3','var1'),(11,'BIOLOGY','question404','var1','var2','var3','var1');
/*!40000 ALTER TABLE `level1` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `level2`
--

DROP TABLE IF EXISTS `level2`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `level2` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `domain` varchar(50) NOT NULL,
  `question` varchar(150) NOT NULL,
  `answer1` varchar(150) NOT NULL,
  `answer2` varchar(50) NOT NULL,
  `answer3` varchar(50) NOT NULL,
  `correct` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `level2`
--

LOCK TABLES `level2` WRITE;
/*!40000 ALTER TABLE `level2` DISABLE KEYS */;
INSERT INTO `level2` VALUES (1,'BIOLOGY','question1','var1','var2','var3','var1'),(2,'BIOLOGY','question2','var1','var2','var3','var1'),(3,'BIOLOGY','question3','var1','var2','var3','var1'),(4,'BIOLOGY','question4','var1','var2','var3','var1'),(5,'BIOLOGY','question5','var1','var2','var3','var1'),(6,'BIOLOGY','question6','var1','var2','var3','var1'),(7,'BIOLOGY','question7','var1','var2','var3','var1'),(8,'BIOLOGY','question8','var1','var2','var3','var1'),(9,'BIOLOGY','question9','var1','var2','var3','var1'),(10,'BIOLOGY','question10','var1','var2','var3','var1');
/*!40000 ALTER TABLE `level2` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `level3`
--

DROP TABLE IF EXISTS `level3`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `level3` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `domain` varchar(50) NOT NULL,
  `question` varchar(150) NOT NULL,
  `answer1` varchar(150) NOT NULL,
  `answer2` varchar(50) NOT NULL,
  `answer3` varchar(50) NOT NULL,
  `correct` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `level3`
--

LOCK TABLES `level3` WRITE;
/*!40000 ALTER TABLE `level3` DISABLE KEYS */;
INSERT INTO `level3` VALUES (1,'BIOLOGY','question1','var1','var2','var3','var1'),(2,'BIOLOGY','question2','var1','var2','var3','var1'),(3,'BIOLOGY','question3','var1','var2','var3','var1'),(4,'BIOLOGY','question4','var1','var2','var3','var1'),(5,'BIOLOGY','question5','var1','var2','var3','var1'),(6,'BIOLOGY','question6','var1','var2','var3','var1'),(7,'BIOLOGY','question7','var1','var2','var3','var1'),(8,'BIOLOGY','question8','var1','var2','var3','var1'),(9,'BIOLOGY','question9','var1','var2','var3','var1'),(10,'BIOLOGY','question10','var1','var2','var3','var1'),(11,'BIOLOGY','Ce grad de viziune are un iepure?','270','150','360','270');
/*!40000 ALTER TABLE `level3` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `level4`
--

DROP TABLE IF EXISTS `level4`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `level4` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `domain` varchar(50) NOT NULL,
  `question` varchar(150) NOT NULL,
  `answer1` varchar(150) NOT NULL,
  `answer2` varchar(50) NOT NULL,
  `answer3` varchar(50) NOT NULL,
  `correct` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `level4`
--

LOCK TABLES `level4` WRITE;
/*!40000 ALTER TABLE `level4` DISABLE KEYS */;
INSERT INTO `level4` VALUES (1,'BIOLOGY','question1','var1','var2','var3','var1'),(2,'BIOLOGY','question2','var1','var2','var3','var1'),(3,'BIOLOGY','question3','var1','var2','var3','var1'),(5,'BIOLOGY','question5','var1','var2','var3','var1'),(6,'BIOLOGY','question6','var1','var2','var3','var1'),(7,'BIOLOGY','question7','var1','var2','var3','var1'),(8,'BIOLOGY','question8','var1','var2','var3','var1'),(9,'BIOLOGY','question9','var1','var2','var3','var1'),(10,'BIOLOGY','question10','var1','var2','var3','var1');
/*!40000 ALTER TABLE `level4` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `level5`
--

DROP TABLE IF EXISTS `level5`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `level5` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `domain` varchar(50) NOT NULL,
  `question` varchar(150) NOT NULL,
  `answer1` varchar(150) NOT NULL,
  `answer2` varchar(50) NOT NULL,
  `answer3` varchar(50) NOT NULL,
  `correct` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `level5`
--

LOCK TABLES `level5` WRITE;
/*!40000 ALTER TABLE `level5` DISABLE KEYS */;
INSERT INTO `level5` VALUES (1,'BIOLOGY','question1','var1','var2','var3','var1'),(2,'BIOLOGY','question2','var1','var2','var3','var1'),(3,'BIOLOGY','question3','var1','var2','var3','var1'),(4,'BIOLOGY','question4','var1','var2','var3','var1'),(5,'BIOLOGY','question5','var1','var2','var3','var1'),(6,'BIOLOGY','question6','var1','var2','var3','var1'),(7,'BIOLOGY','question7','var1','var2','var3','var1'),(8,'BIOLOGY','question8','var1','var2','var3','var1'),(9,'BIOLOGY','question9','var1','var2','var3','var1'),(10,'BIOLOGY','question10','var1','var2','var3','var1');
/*!40000 ALTER TABLE `level5` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `level6`
--

DROP TABLE IF EXISTS `level6`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `level6` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `domain` varchar(50) NOT NULL,
  `question` varchar(150) NOT NULL,
  `answer1` varchar(150) NOT NULL,
  `answer2` varchar(50) NOT NULL,
  `answer3` varchar(50) NOT NULL,
  `correct` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `level6`
--

LOCK TABLES `level6` WRITE;
/*!40000 ALTER TABLE `level6` DISABLE KEYS */;
INSERT INTO `level6` VALUES (1,'BIOLOGY','question1','var1','var2','var3','var1'),(2,'BIOLOGY','question2','var1','var2','var3','var1'),(3,'BIOLOGY','question3','var1','var2','var3','var1'),(4,'BIOLOGY','question4','var1','var2','var3','var1'),(5,'BIOLOGY','question5','var1','var2','var3','var1'),(6,'BIOLOGY','question6','var1','var2','var3','var1'),(7,'BIOLOGY','question7','var1','var2','var3','var1'),(8,'BIOLOGY','question8','var1','var2','var3','var1'),(9,'BIOLOGY','question9','var1','var2','var3','var1'),(10,'BIOLOGY','question10','var1','var2','var3','var1');
/*!40000 ALTER TABLE `level6` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `level7`
--

DROP TABLE IF EXISTS `level7`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `level7` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `domain` varchar(50) NOT NULL,
  `question` varchar(150) NOT NULL,
  `answer1` varchar(150) NOT NULL,
  `answer2` varchar(50) NOT NULL,
  `answer3` varchar(50) NOT NULL,
  `correct` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `level7`
--

LOCK TABLES `level7` WRITE;
/*!40000 ALTER TABLE `level7` DISABLE KEYS */;
INSERT INTO `level7` VALUES (1,'BIOLOGY','question1','var1','var2','var3','var1'),(2,'BIOLOGY','question2','var1','var2','var3','var1'),(3,'BIOLOGY','question3','var1','var2','var3','var1'),(4,'BIOLOGY','question4','var1','var2','var3','var1'),(5,'BIOLOGY','question5','var1','var2','var3','var1'),(6,'BIOLOGY','question6','var1','var2','var3','var1'),(7,'BIOLOGY','question7','var1','var2','var3','var1'),(8,'BIOLOGY','question8','var1','var2','var3','var1'),(9,'BIOLOGY','question9','var1','var2','var3','var1'),(10,'BIOLOGY','question10','var1','var2','var3','var1');
/*!40000 ALTER TABLE `level7` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `role` varchar(50) NOT NULL,
  `status` varchar(50) NOT NULL,
  `domain` varchar(50) NOT NULL,
  `first` varchar(50) NOT NULL,
  `currlevel` varchar(30) DEFAULT NULL,
  `last1` varchar(50) NOT NULL,
  `last2` varchar(50) NOT NULL,
  `last3` varchar(50) NOT NULL,
  `accountNonExpired` int(11) NOT NULL DEFAULT '1',
  `accountNonLocked` int(11) NOT NULL DEFAULT '1',
  `credentialsNonExpired` int(11) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10014 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (10000,'user','user','USER','ACTIVE','BIOLOGY','NO','1','89','60','75',1,1,1),(10001,'admin','admin','ADMIN','ACTIVE','BIOLOGY','NO','3','0','0','0',1,1,1),(10003,'player','player','USER','ACTIVE','BIOLOGY','NO','3','29','56','72',1,1,1),(10004,'testing','testing8','USER','INACTIVE','GEOGRAPHY','NO','1','89','60','75',1,1,1),(10005,'test1','test1','USER','ACTIVE','BIOLOGY','YES','3','0','0','0',1,1,1),(10006,'test2','test2','USER','ACTIVE','BIOLOGY','NO','5','0','0','0',1,1,1),(10007,'test3','test3','USER','ACTIVE','BIOLOGY','YES','4','0','0','0',1,1,1),(10008,'test5','test5','USER','ACTIVE','BIOLOGY','NO','5','0','0','0',1,1,1),(10009,'test6','test6','USER','ACTIVE','GEOGRAPHY','YES','1','5.0','5.0','0',1,1,1),(10010,'test7','test7','USER','ACTIVE','BIOLOGY','NO','6','0','0','0',1,1,1),(10011,'test8','test8','USER','ACTIVE','BIOLOGY','NO','7','0','0','0',1,1,1),(10012,'test9','test9','USER','ACTIVE','BIOLOGY','YES','1','0','0','0',1,1,1),(10013,'testing10','testing10','USER','ACTIVE','BIOLOGY','NO','6','5.0','4.0','4.0',1,1,1);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_attempts`
--

DROP TABLE IF EXISTS `user_attempts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_attempts` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `attempts` int(2) NOT NULL,
  `lastModified` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `firstAttempt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_attempts`
--

LOCK TABLES `user_attempts` WRITE;
/*!40000 ALTER TABLE `user_attempts` DISABLE KEYS */;
INSERT INTO `user_attempts` VALUES (1,10001,1,'2018-01-28 15:43:04','2018-01-28 15:43:04'),(2,10001,1,'2018-01-28 19:46:46','2018-01-28 19:46:46'),(3,10008,1,'2018-02-26 17:34:01','2018-02-26 17:34:01'),(4,10008,1,'2018-02-26 17:45:13','2018-02-26 17:45:13'),(5,10005,1,'2018-03-11 10:27:18','2018-03-11 10:27:18');
/*!40000 ALTER TABLE `user_attempts` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-06-22 23:40:20

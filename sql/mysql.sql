-- MySQL dump 10.13  Distrib 5.7.19, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: mydb
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
-- Table structure for table `chore_log_by_user`
--

DROP TABLE IF EXISTS `chore_log_by_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `chore_log_by_user` (
  `week_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `task_id` int(11) NOT NULL,
  `minutes` int(11) DEFAULT NULL,
  PRIMARY KEY (`week_id`,`user_id`,`task_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chore_log_by_user`
--

LOCK TABLES `chore_log_by_user` WRITE;
/*!40000 ALTER TABLE `chore_log_by_user` DISABLE KEYS */;
/*!40000 ALTER TABLE `chore_log_by_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `household`
--

DROP TABLE IF EXISTS `household`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `household` (
  `household_id` int(11) NOT NULL,
  `household_name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`household_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `household`
--

LOCK TABLES `household` WRITE;
/*!40000 ALTER TABLE `household` DISABLE KEYS */;
INSERT INTO `household` VALUES (1,'Purple Palace'),(2,'Drew House'),(3,'Bob House');
/*!40000 ALTER TABLE `household` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `task`
--

DROP TABLE IF EXISTS `task`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `task` (
  `task_id` int(11) NOT NULL,
  `task_name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`task_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `task`
--

LOCK TABLES `task` WRITE;
/*!40000 ALTER TABLE `task` DISABLE KEYS */;
INSERT INTO `task` VALUES (1,'Wash dishes'),(2,'Clean kitchen'),(3,'Clean kitchen floor'),(4,'Clean bathroom'),(5,'Clean bathroom floor'),(6,'Clean living/family room'),(7,'Clean living/family room floor'),(8,'Clean dining room'),(9,'Clean dining room floor'),(10,'Clean bedroom'),(11,'Clean bedroom floor'),(12,'Take out trash'),(13,'Clean basement/garage'),(14,'Clean basement/garage floor'),(15,'Wash laundry'),(16,'Clean stairs/hall/entryway'),(17,'Clean stairs/hall/entryway floor'),(18,'Clean office/spare room'),(19,'Clean office/spare room floor'),(20,'Miscelleanous cleaning'),(21,'Clear general clutter');
/*!40000 ALTER TABLE `task` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `user_id` int(20) NOT NULL,
  `username` varchar(16) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(32) NOT NULL,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `owner` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'hentwistle','hentwistle@madisoncollege.edu','password123','Heather','Entwistle','1'),(2,'cring','bikeacrossamerica@yahoo.com','passwordabc','Cory','Ring','0'),(3,'nancydrew','newgirl@yahoo.com','passwordnewgirl','Nancy','Drew','1'),(4,'ned','nednickerson@gmail.com','passwordned','Ned','Nickerson','0'),(5,'anna','a@a.com','a','Anna','Banana','0'),(6,'christi','christi@christi.com','password','Christi','Entwistle','0'),(7,'admin','admin@admin.com','passwordadmin','Admin','Istrator','1');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_household`
--

DROP TABLE IF EXISTS `user_household`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_household` (
  `user_id` int(11) NOT NULL,
  `household_id` int(11) NOT NULL,
  PRIMARY KEY (`user_id`,`household_id`),
  KEY `household_id` (`household_id`),
  CONSTRAINT `household_id` FOREIGN KEY (`household_id`) REFERENCES `household` (`household_id`),
  CONSTRAINT `user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_household`
--

LOCK TABLES `user_household` WRITE;
/*!40000 ALTER TABLE `user_household` DISABLE KEYS */;
INSERT INTO `user_household` VALUES (1,1),(2,1),(6,1),(3,2),(4,2),(5,2);
/*!40000 ALTER TABLE `user_household` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_role` (
  `user_role_id` int(11) NOT NULL,
  `role_name` varchar(25) NOT NULL,
  `username` varchar(255) NOT NULL,
  PRIMARY KEY (`user_role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_role`
--

LOCK TABLES `user_role` WRITE;
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
INSERT INTO `user_role` VALUES (1,'admin','admin'),(2,'hentwistle','user'),(3,'cring','user'),(4,'christi','user'),(5,'nancydrew','user'),(6,'ned','user'),(7,'anna','user');
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `week`
--

DROP TABLE IF EXISTS `week`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `week` (
  `week_id` int(11) NOT NULL,
  `start_date` datetime DEFAULT NULL,
  `end_date` datetime DEFAULT NULL,
  PRIMARY KEY (`week_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `week`
--

LOCK TABLES `week` WRITE;
/*!40000 ALTER TABLE `week` DISABLE KEYS */;
INSERT INTO `week` VALUES (1,'2017-10-16 00:00:00','2017-10-22 23:59:59'),(2,'2017-10-23 00:00:00','2017-10-29 23:59:59'),(3,'2017-10-30 00:00:00','2017-11-05 23:59:59'),(4,'2017-11-06 00:00:00','2017-11-12 23:59:59'),(5,'2017-11-13 00:00:00','2017-11-19 23:59:59'),(6,'2017-11-20 00:00:00','2017-11-26 23:59:59'),(7,'2017-11-27 00:00:00','2017-12-03 23:59:59'),(8,'2017-12-04 00:00:00','2017-12-10 23:59:59'),(9,'2017-12-11 00:00:00','2017-12-17 23:59:59'),(10,'2017-12-18 00:00:00','2017-12-24 23:59:59'),(11,'2017-12-25 00:00:00','2017-12-31 23:59:59'),(12,'2018-01-01 00:00:00','2018-01-07 23:59:59'),(13,'2018-01-08 00:00:00','2018-01-14 23:59:59'),(14,'2018-01-15 00:00:00','2018-01-21 23:59:59'),(15,'2018-01-22 00:00:00','2018-01-28 23:59:59'),(16,'2018-01-29 00:00:00','2018-02-04 23:59:59'),(17,'2018-02-05 00:00:00','2018-02-11 23:59:59'),(18,'2018-02-12 00:00:00','2018-02-18 23:59:59'),(19,'2018-02-19 00:00:00','2018-02-25 23:59:59'),(20,'2018-02-26 00:00:00','2018-03-04 23:59:59'),(21,'2018-03-05 00:00:00','2018-03-11 23:59:59'),(22,'2018-03-12 00:00:00','2018-03-18 23:59:59'),(23,'2018-03-19 00:00:00','2018-03-25 23:59:59'),(24,'2018-03-26 00:00:00','2018-04-01 23:59:59'),(25,'2018-04-02 00:00:00','2018-04-08 23:59:59'),(26,'2018-04-09 00:00:00','2018-04-15 23:59:59'),(27,'2018-04-16 00:00:00','2018-04-22 23:59:59'),(28,'2018-04-23 00:00:00','2018-04-29 23:59:59'),(29,'2018-04-30 00:00:00','2018-05-06 23:59:59'),(30,'2018-05-07 00:00:00','2018-05-13 23:59:59'),(31,'2018-05-14 00:00:00','2018-05-20 23:59:59'),(32,'2018-05-21 00:00:00','2018-05-27 23:59:59'),(33,'2018-05-28 00:00:00','2018-06-03 23:59:59'),(34,'2018-06-04 00:00:00','2018-06-10 23:59:59'),(35,'2018-06-11 00:00:00','2018-06-17 23:59:59'),(36,'2018-06-18 00:00:00','2018-06-24 23:59:59'),(37,'2018-06-25 00:00:00','2018-07-01 23:59:59'),(38,'2018-07-02 00:00:00','2018-07-08 23:59:59'),(39,'2018-07-09 00:00:00','2018-07-15 23:59:59'),(40,'2018-07-16 00:00:00','2018-07-22 23:59:59'),(41,'2018-07-23 00:00:00','2018-07-29 23:59:59'),(42,'2018-07-30 00:00:00','2018-08-05 23:59:59'),(43,'2018-08-06 00:00:00','2018-08-12 23:59:59'),(44,'2018-08-13 00:00:00','2018-08-19 23:59:59'),(45,'2018-08-20 00:00:00','2018-08-26 23:59:59'),(46,'2018-08-27 00:00:00','2018-09-02 23:59:59'),(47,'2018-09-03 00:00:00','2018-09-09 23:59:59'),(48,'2018-09-10 00:00:00','2018-09-16 23:59:59'),(49,'2018-09-17 00:00:00','2018-09-23 23:59:59'),(50,'2018-09-24 00:00:00','2018-09-30 23:59:59'),(51,'2018-10-01 00:00:00','2018-10-07 23:59:59'),(52,'2018-10-08 00:00:00','2018-10-14 23:59:59');
/*!40000 ALTER TABLE `week` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-12-13  3:00:38

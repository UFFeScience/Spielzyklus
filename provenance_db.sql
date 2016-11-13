CREATE DATABASE  IF NOT EXISTS `provenance_db` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `provenance_db`;
-- MySQL dump 10.13  Distrib 5.5.16, for Win32 (x86)
--
-- Host: localhost    Database: provenance_db
-- ------------------------------------------------------
-- Server version	5.5.25

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
-- Table structure for table `mining`
--

DROP TABLE IF EXISTS `mining`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mining` (
  `idmining` int(11) NOT NULL AUTO_INCREMENT,
  `gameSession` text,
  `action` text,
  `time` text,
  PRIMARY KEY (`idmining`)
) ENGINE=InnoDB AUTO_INCREMENT=109 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mining`
--

LOCK TABLES `mining` WRITE;
/*!40000 ALTER TABLE `mining` DISABLE KEYS */;
INSERT INTO `mining` VALUES (59,'GS_05','CatchRedHull','14'),(60,'GS_05','TouchCoin','56'),(61,'GS_05','TouchCoin','57'),(62,'GS_05','TouchCoin','58'),(63,'GS_05','TouchCoin','59'),(64,'GS_05','TouchCoinYoshi','65'),(65,'GS_05','TouchCoin','90'),(66,'GS_05','TouchCoin','91'),(67,'GS_05','TouchCoin','92'),(68,'GS_05','TouchCoin','92'),(69,'GS_05','TouchCoinYoshi','100'),(70,'GS_05','TouchGreenKoopaTroopa','100'),(71,'GS_06','TouchCoin','59'),(72,'GS_06','TouchCoin','59'),(73,'GS_06','TouchCoin','60'),(74,'GS_06','TouchCoin','60'),(75,'GS_06','TouchCoin','61'),(76,'GS_06','TouchCoinYoshi','67'),(77,'GS_06','TouchCoin','99'),(78,'GS_06','TouchCoin','99'),(79,'GS_06','TouchCoin','100'),(80,'GS_06','TouchCoin','105'),(81,'GS_06','TouchCoinYoshi','110'),(82,'GS_06','TouchGreenKoopaTroopa','110'),(83,'GS_07','CatchRedHull','18'),(84,'GS_07','TouchCoin','53'),(85,'GS_07','TouchCoin','53'),(86,'GS_07','TouchCoin','54'),(87,'GS_07','TouchCoin','54'),(88,'GS_07','TouchCoinYoshi','61'),(89,'GS_07','TouchCoin','92'),(90,'GS_07','TouchCoin','92'),(91,'GS_07','TouchCoin','94'),(92,'GS_07','TouchCoin','94'),(93,'GS_07','TouchCoinYoshi','98'),(94,'GS_07','TouchGreenKoopaTroopa','98'),(95,'GS_08','TouchCoin','65'),(96,'GS_08','TouchCoin','65'),(97,'GS_08','TouchCoin','66'),(98,'GS_08','TouchCoin','66'),(99,'GS_08','TouchCoin','67'),(100,'GS_08','TouchCoin','67'),(101,'GS_08','TouchCoin','68'),(102,'GS_08','TouchCoinYoshi','69'),(103,'GS_08','TouchCoin','99'),(104,'GS_08','TouchCoin','99'),(105,'GS_08','TouchCoin','108'),(106,'GS_08','TouchCoin','108'),(107,'GS_08','TouchCoinYoshi','109'),(108,'GS_08','TouchGreenKoopaTroopa','109');
/*!40000 ALTER TABLE `mining` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `activity`
--

DROP TABLE IF EXISTS `activity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `activity` (
  `id` int(11) NOT NULL,
  `idGameSession` text,
  `idAgent` text,
  `idEntity` text,
  `idActivityType` text,
  `time` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `activity`
--

LOCK TABLES `activity` WRITE;
/*!40000 ALTER TABLE `activity` DISABLE KEYS */;
INSERT INTO `activity` VALUES (1,'1','NULL','7','1','14'),(2,'1','NULL','1','2','15'),(3,'1','NULL','1','2','15'),(4,'1','NULL','1','2','15'),(5,'1','NULL','2','2','15'),(6,'1','NULL','7','1','16'),(7,'1','2','NULL','3','43'),(8,'1','NULL','1','2','46'),(9,'1','NULL','2','2','46'),(10,'1','NULL','1','2','55'),(11,'1','NULL','1','2','59'),(12,'1','NULL','1','2','59'),(13,'1','NULL','1','2','62'),(14,'1','NULL','2','2','62'),(15,'1','NULL','1','2','63'),(16,'1','NULL','1','2','63'),(17,'1','NULL','1','2','92'),(18,'1','NULL','1','2','92'),(19,'1','NULL','1','2','94'),(20,'1','NULL','1','2','94'),(21,'1','NULL','1','2','98'),(22,'1','NULL','1','2','98'),(23,'2','NULL','7','1','14'),(24,'2','NULL','1','2','15'),(25,'2','NULL','1','2','15'),(26,'2','NULL','1','2','15'),(27,'2','NULL','7','1','16'),(28,'2','2','NULL','3','43'),(29,'2','1','NULL','2','45'),(30,'3','NULL','1','2','13'),(31,'3','NULL','1','2','14'),(32,'3','NULL','1','2','14'),(33,'3','NULL','7','1','15'),(34,'3','NULL','1','2','16'),(35,'3','2','NULL','3','45'),(36,'3','1','NULL','2','47'),(37,'4','NULL','7','1','13'),(38,'4','NULL','1','2','14'),(39,'4','NULL','1','2','15'),(40,'4','1','NULL','3','15'),(41,'4','NULL','1','2','16'),(42,'4','NULL','2','2','18'),(43,'4','NULL','7','1','20'),(44,'4','NULL','1','2','22'),(45,'4','NULL','3','2','35'),(46,'4','NULL','1','2','36'),(47,'4','NULL','1','2','45'),(48,'4','NULL','1','2','46'),(49,'4','NULL','2','2','58'),(50,'4','1','NULL','2','59'),(51,'4','2','NULL','3','60'),(52,'4','NULL','1','2','64'),(53,'4','NULL','1','2','66'),(54,'4','2','NULL','3','67'),(55,'4','3','NULL','2','67'),(56,'5','NULL','7','1','14'),(57,'5','NULL','1','2','56'),(58,'5','NULL','1','2','57'),(59,'5','NULL','1','2','58'),(60,'5','NULL','1','2','59'),(61,'5','NULL','2','2','65'),(62,'5','NULL','1','2','90'),(63,'5','NULL','1','2','91'),(64,'5','NULL','1','2','92'),(65,'5','NULL','1','2','92'),(66,'5','NULL','2','2','100'),(67,'5','2','NULL','2','100'),(68,'6','NULL','1','2','59'),(69,'6','NULL','1','2','59'),(70,'6','NULL','1','2','60'),(71,'6','NULL','1','2','60'),(72,'6','NULL','1','2','61'),(73,'6','NULL','2','2','67'),(74,'6','NULL','1','2','99'),(75,'6','NULL','1','2','99'),(76,'6','NULL','1','2','100'),(77,'6','NULL','1','2','105'),(78,'6','NULL','2','2','110'),(79,'6','2','NULL','2','110'),(80,'7','NULL','7','1','18'),(81,'7','NULL','1','2','53'),(82,'7','NULL','1','2','53'),(83,'7','NULL','1','2','54'),(84,'7','NULL','1','2','54'),(85,'7','NULL','2','2','61'),(86,'7','NULL','1','2','92'),(87,'7','NULL','1','2','92'),(88,'7','NULL','1','2','94'),(89,'7','NULL','1','2','94'),(90,'7','NULL','2','2','98'),(91,'7','2','NULL','2','98'),(92,'8','NULL','1','2','65'),(93,'8','NULL','1','2','65'),(94,'8','NULL','1','2','66'),(95,'8','NULL','1','2','66'),(96,'8','NULL','1','2','67'),(97,'8','NULL','1','2','67'),(98,'8','NULL','1','2','68'),(99,'8','NULL','2','2','69'),(100,'8','NULL','1','2','99'),(101,'8','NULL','1','2','99'),(102,'8','NULL','1','2','108'),(103,'8','NULL','1','2','108'),(104,'8','NULL','2','2','109'),(105,'8','2','NULL','2','109');
/*!40000 ALTER TABLE `activity` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `gamesession`
--

DROP TABLE IF EXISTS `gamesession`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `gamesession` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `data` datetime DEFAULT NULL,
  `fase` text,
  `name` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gamesession`
--

LOCK TABLES `gamesession` WRITE;
/*!40000 ALTER TABLE `gamesession` DISABLE KEYS */;
INSERT INTO `gamesession` VALUES (1,'2014-02-05 00:00:00','1','GS_01'),(2,'2014-02-10 00:21:00','1','GS_02'),(3,'2014-05-12 00:10:01','1','GS_03'),(4,'2014-05-12 00:40:00','1','GS_04'),(5,'2014-05-12 01:22:10','1','GS_05'),(6,'2014-05-13 00:05:24','1','GS_06'),(7,'2014-05-13 00:25:50','1','GS_07'),(8,'2014-05-13 01:20:43','1','GS_08'),(9,'2014-05-13 01:50:32','1','GS_09');
/*!40000 ALTER TABLE `gamesession` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `activitytype`
--

DROP TABLE IF EXISTS `activitytype`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `activitytype` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `reason` text,
  `trigger` text,
  `effect` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `activitytype`
--

LOCK TABLES `activitytype` WRITE;
/*!40000 ALTER TABLE `activitytype` DISABLE KEYS */;
INSERT INTO `activitytype` VALUES (1,'Catch','Hand','Upgrade'),(2,'Touch','Body','Depends'),(3,'Destroy','foot','Life');
/*!40000 ALTER TABLE `activitytype` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary table structure for view `activityview`
--

DROP TABLE IF EXISTS `activityview`;
/*!50001 DROP VIEW IF EXISTS `activityview`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `activityview` (
  `id` int(11),
  `idGameSession` text,
  `idAgent` text,
  `idEntity` text,
  `idActivityType` text,
  `time` text
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `agent`
--

DROP TABLE IF EXISTS `agent`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `agent` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` text,
  `atributes` text,
  `goals` text,
  `location` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `agent`
--

LOCK TABLES `agent` WRITE;
/*!40000 ALTER TABLE `agent` DISABLE KEYS */;
INSERT INTO `agent` VALUES (1,'RedKoopaTroopa','Hull','Catch Mario','Ground'),(2,'GreenKoopaTroopa','Hull','Catch Mario','Ground'),(3,'CharginChuck','Resistance and Speed','Catch Mario','Ground'),(4,'BulletBill','Speed','Catch Mario','Sky'),(5,'JumpingPiranhaPlants','Surprise','Catch Mario','Tube');
/*!40000 ALTER TABLE `agent` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `entity`
--

DROP TABLE IF EXISTS `entity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `entity` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` text,
  `type` text,
  `importance` text,
  `location` text,
  `attributes` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `entity`
--

LOCK TABLES `entity` WRITE;
/*!40000 ALTER TABLE `entity` DISABLE KEYS */;
INSERT INTO `entity` VALUES (1,'Coin','Coin','1','Sky','Life'),(2,'CoinYoshi','Coin','4','Sky','Life'),(3,'RedMushroom','Upgrade','8','Ground','Survival'),(4,'GreenMushroom','Life','4','Ground','Life'),(5,'Flower','Upgrade','9','Ground','Shot'),(6,'Feather','Upgrade','9','Sky','Fly'),(7,'RedHull','Upgrade','3','Ground','Shot');
/*!40000 ALTER TABLE `entity` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Final view structure for view `activityview`
--

/*!50001 DROP TABLE IF EXISTS `activityview`*/;
/*!50001 DROP VIEW IF EXISTS `activityview`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `activityview` AS select `activity`.`id` AS `id`,`activity`.`idGameSession` AS `idGameSession`,`activity`.`idAgent` AS `idAgent`,`activity`.`idEntity` AS `idEntity`,`activity`.`idActivityType` AS `idActivityType`,`activity`.`time` AS `time` from `activity` limit 10 */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-04-28 19:47:47

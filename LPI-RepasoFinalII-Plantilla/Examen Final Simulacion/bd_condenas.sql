CREATE DATABASE  IF NOT EXISTS `condenas` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `condenas`;
-- MySQL dump 10.13  Distrib 5.6.13, for Win32 (x86)
--
-- Host: localhost    Database: condenas
-- ------------------------------------------------------
-- Server version	5.6.16

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
-- Table structure for table `persona`
--

DROP TABLE IF EXISTS `persona`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `persona` (
  `idpersona` int(11) NOT NULL AUTO_INCREMENT,
  `dni` varchar(8) NOT NULL,
  `nombre` varchar(200) NOT NULL,
  PRIMARY KEY (`idpersona`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `persona`
--

LOCK TABLES `persona` WRITE;
/*!40000 ALTER TABLE `persona` DISABLE KEYS */;
INSERT INTO `persona` VALUES (1,'05896145','Miguel Carpio'),(2,'42589689','Jose Gutierrez'),(3,'06985132','Marcelina Garcia'),(4,'41589688','Julio Jimenez'),(5,'44124589','Wilfredo Saavedra'),(6,'40894512','Raul Aranda');
/*!40000 ALTER TABLE `persona` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sentencias`
--

DROP TABLE IF EXISTS `sentencias`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sentencias` (
  `idsentencias` int(11) NOT NULL AUTO_INCREMENT,
  `numeroexpediente` varchar(10) NOT NULL,
  `juzgado` varchar(100) NOT NULL,
  `fechademanda` date DEFAULT NULL,
  `fechasentencia` date DEFAULT NULL,
  `acusacion` varchar(5000) DEFAULT NULL,
  `fallo` varchar(5000) DEFAULT NULL,
  `idpersona` int(11) NOT NULL,
  `aniosCondena` int(11) DEFAULT NULL,
  PRIMARY KEY (`idsentencias`),
  KEY `FK_sentencia_persona_idx` (`idpersona`),
  CONSTRAINT `FK_sentencia_persona` FOREIGN KEY (`idpersona`) REFERENCES `persona` (`idpersona`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sentencias`
--

LOCK TABLES `sentencias` WRITE;
/*!40000 ALTER TABLE `sentencias` DISABLE KEYS */;
INSERT INTO `sentencias` VALUES (1,'EXP-001','TERCER JUZGADO DE LIMA','2000-08-14','2002-09-20','Lavado de Activos','Se le condena a....',1,1),(2,'EXP-002','PRIMER JUZGADO DE LIMA','2000-08-14','2002-09-20','Malversacion de fondos','Se le condena a....',2,1),(3,'EXP-003','PRIMER JUZGADO DE PIURA','2000-08-14','2002-09-20','Homicidio culposo','Se le condena a....',2,2),(4,'EXP-004','TERCER JUZGADO DE LIMA','2000-08-14','2002-09-20','Robo de bienes','Se le condena a....',3,3),(5,'EXP-005','DECIMO TERCER JUZGADO DE LIMA','2000-08-14','2002-09-20','Lavado de Activos','Se le condena a....',4,4),(6,'EXP-006','TERCER JUZGADO DE LIMA','2000-08-14','2002-09-20','Lavado de Activos','Se le condena a....',5,5),(7,'EXP-007','VIGESIMO PRIMERO  JUZGADO DE LIMA','2002-09-20','2002-09-20','Lavado de Activos','Se le condena a....',6,10),(8,'EXP-008','TERCER JUZGADO DE PIURA','2000-08-14','2002-09-20','Lavado de Activos','Se le condena a....',1,20),(9,'EXP-009','TERCER JUZGADO DE AREQUIPA','2000-08-14','2002-09-20','Homicidio en la forma de parricidio','Se le condena a....',2,15),(10,'EXP-010','SEGUNDO JUZGADO DE LIMA','2000-08-14','2002-09-20','Trafico de menores','Se le condena a....',3,20),(11,'EXP-011','QUINTO JUZGADO DE LIMA','2000-08-14','2002-09-20','Trafico de influencias en perjuicio del estado','Se le condena a....',4,20),(12,'EXP-012','SEXTO JUZGADO DE LIMA','2000-08-14','2002-09-20','Robo a mano armada','Se le condena a....',5,6),(13,'EXP-013','VIGESIMO PRIMERO  JUZGADO DE LIMA','2000-08-14','2002-09-20','Terrorismo','Se le condena a....',6,40),(14,'EXP-014','TERCER JUZGADO DE LIMA','2000-08-14','2002-09-20','Lavado de Activos','Se le condena a....',1,6),(15,'EXP-015','SEPTIMO JUZGADO DE LIMA','2000-08-14','2002-09-20','Homicidio','Se le condena a....',1,8),(16,'EXP-016','TERCER JUZGADO DE LIMA','2000-08-14','2002-09-20','Lavado de Activos','Se le condena a....',1,15),(17,'EXP-017','TERCER JUZGADO DE LIMA','2000-08-14','2002-09-20','Robo de bienes','Se le condena a....',1,12),(18,'EXP-018','VIGESIMO PRIMERO  JUZGADO DE LIMA','2000-08-14','2002-09-20','Lavado de Activos','Se le condena a....',1,8),(19,'EXP-019','TERCER JUZGADO DE LIMA','2000-08-14','2002-09-20','Lavado de Activos','Se le condena a....',1,4),(20,'EXP-020','DECIMO CUARTO JUZGADO DE LIMA','2000-08-14','2002-09-20','Malversacion de fondos','Se le condena a....',1,6),(21,'EXP-021','VIGESIMO PRIMERO JUZGADO DE LIMA','2000-08-14','2002-09-20','Lavado de Activos','Se le condena a....',1,12);
/*!40000 ALTER TABLE `sentencias` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-01-17 18:50:35

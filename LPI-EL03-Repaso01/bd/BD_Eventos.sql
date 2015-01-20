CREATE DATABASE  IF NOT EXISTS `eventos` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `eventos`;
-- MySQL dump 10.13  Distrib 5.6.13, for Win32 (x86)
--
-- Host: localhost    Database: eventos
-- ------------------------------------------------------
-- Server version	5.6.17

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
-- Table structure for table `evento`
--

DROP TABLE IF EXISTS `evento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `evento` (
  `idEvento` int(11) NOT NULL,
  `idLocal` int(11) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `fechaInicio` datetime NOT NULL,
  `fechaFin` datetime NOT NULL,
  `capacidad` int(11) NOT NULL,
  `url` varchar(250) NOT NULL,
  `emailContacto` varchar(250) NOT NULL,
  PRIMARY KEY (`idEvento`),
  KEY `fk_evento_local_idx` (`idLocal`),
  CONSTRAINT `fk_evento_local` FOREIGN KEY (`idLocal`) REFERENCES `local` (`idLocal`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `evento`
--

LOCK TABLES `evento` WRITE;
/*!40000 ALTER TABLE `evento` DISABLE KEYS */;
INSERT INTO `evento` VALUES (1,1,'Certificación CISCO','2014-05-08 00:00:00','2014-05-08 00:00:00',40,'www.cisco.com/evento1','info@cisco.com'),(2,1,'IPV6 - Proceso de Migración','2014-05-08 00:00:00','2014-05-08 00:00:00',40,'www.datasys.com/evento1','contactenos@datasys.com'),(3,2,'Modelamiento matemático de objetos físicos con Software Libre','2014-05-08 00:00:00','2014-05-08 00:00:00',60,'www.bellachri.com/evento1','info@bellachri.com'),(4,2,'Algoritmos con PSeint y DFD','2014-05-08 00:00:00','2014-05-08 00:00:00',100,'www.mibizagi.com/evento1','mail@mizagi.com'),(5,1,'Modelos Tabulares en Microsoft SQL Server 2012','2014-05-10 00:00:00','2014-05-10 00:00:00',80,'www.microsoft.pe/evento1','concacto@microsoft.pe'),(6,2,'Vulnerabilidad en aplicaciones de red','2014-05-10 00:00:00','2014-05-10 00:00:00',40,'www.redhat.com/evento1','info@redhat.com'),(7,1,'Metodologías ágiles en la dirección de proyectos','2014-12-05 00:00:00','2014-12-04 00:00:00',50,'www.proyectosagiles.com/evento1','inicio@pagiles.com'),(8,3,'IBM  CAMSS (Cloud, Analytics, Mobile, Social y Security)','2014-05-11 00:00:00','2014-05-11 00:00:00',70,'www.ibm.com/pe/evento1','info@ibm.com'),(9,1,'Seguridad en Servidores Web','2014-08-10 00:00:00','2014-08-10 00:00:00',20,'www.cloudy.com.pe/evento1','data@cloudy.com'),(10,3,'Software Craftsmanship: Desarrollando Códiglo limpio','2014-05-08 00:00:00','2014-05-08 00:00:00',50,'www.proyectosagiles.com/evento1','inicio@pagiles.com'),(11,2,'HP- Cloud','2014-08-02 00:00:00','2014-08-02 00:00:00',24,'www.hp-peru.com/evento1','info@hp-peru.com'),(12,1,'Novedades en el Core .Net','2014-08-09 00:00:00','2014-08-09 00:00:00',100,'www.microsoft.pe/evento1','concacto@microsoft.pe');
/*!40000 ALTER TABLE `evento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `local`
--

DROP TABLE IF EXISTS `local`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `local` (
  `idLocal` int(11) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  PRIMARY KEY (`idLocal`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `local`
--

LOCK TABLES `local` WRITE;
/*!40000 ALTER TABLE `local` DISABLE KEYS */;
INSERT INTO `local` VALUES (1,'Swissotel Lima'),(2,'Centro de Convenciones Real Audiencia'),(3,'Centro de Capacitación La Moneda'),(4,'Centro de Convenciones Jckey'),(5,'Hotel Sheraton'),(6,'María Angola');
/*!40000 ALTER TABLE `local` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-11-13 17:26:34

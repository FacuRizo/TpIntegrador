-- MySQL dump 10.13  Distrib 8.0.33, for Win64 (x86_64)
--
-- Host: localhost    Database: tpintegrador
-- ------------------------------------------------------
-- Server version	8.0.33

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `pronosticos`
--

DROP TABLE IF EXISTS `pronosticos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pronosticos` (
  `Id_Pronostico` int NOT NULL,
  `Nombre_participante` varchar(50) DEFAULT NULL,
  `Equipo_1` varchar(50) DEFAULT NULL,
  `Gana_1` varchar(5) DEFAULT NULL,
  `Empata` varchar(5) DEFAULT NULL,
  `Gana_2` varchar(5) DEFAULT NULL,
  `Equipo_2` varchar(50) DEFAULT NULL,
  `Id_Resultado` int DEFAULT NULL,
  PRIMARY KEY (`Id_Pronostico`),
  KEY `Id_Resultado` (`Id_Resultado`),
  CONSTRAINT `pronosticos_ibfk_1` FOREIGN KEY (`Id_Resultado`) REFERENCES `resultados` (`Id_Resultado`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pronosticos`
--

LOCK TABLES `pronosticos` WRITE;
/*!40000 ALTER TABLE `pronosticos` DISABLE KEYS */;
INSERT INTO `pronosticos` VALUES (1,'Mariana','Argentina','1','0','0','Arabia Saudita',1),(2,'Mariana','Polonia','0','1','0','Mexico',2),(3,'Mariana','Alemania','1','0','0','Italia',3),(4,'Mariana','Venezuela','0','0','1','España',4),(5,'Pedro','Argentina','1','0','0','Arabia Saudita',1),(6,'Pedro','Polonia','0','0','1','Mexico',2),(7,'Pedro','Alemania','1','0','0','Italia',3),(8,'Pedro','Venezuela','0','1','0','España',4),(9,'Mariana','Alemania','0','1','0','España',5),(10,'Mariana','Italia','1','0','0','Venezuela',6),(11,'Mariana','Argentina','0','1','0','Mexico',7),(12,'Mariana','Arabia Saudita','0','0','1','Polonia',8),(13,'Pedro','Alemania','1','0','0','España',5),(14,'Pedro','Italia','0','1','0','Venezuela',6),(15,'Pedro','Argentina','1','0','0','Mexico',7),(16,'Pedro','Arabia Saudita','0','0','1','Polonia',8);
/*!40000 ALTER TABLE `pronosticos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `resultados`
--

DROP TABLE IF EXISTS `resultados`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `resultados` (
  `Id_Resultado` int NOT NULL,
  `Equipo1` varchar(50) DEFAULT NULL,
  `Equipo2` varchar(50) DEFAULT NULL,
  `Cant_Goles_1` int DEFAULT NULL,
  `Cant_Goles_2` int DEFAULT NULL,
  `Nro_Ronda` int DEFAULT NULL,
  `Fase` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`Id_Resultado`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `resultados`
--

LOCK TABLES `resultados` WRITE;
/*!40000 ALTER TABLE `resultados` DISABLE KEYS */;
INSERT INTO `resultados` VALUES (1,'Argentina','Arabia Saudita',1,2,1,'Eliminatorias'),(2,'Polonia','Mexico',0,0,1,'Eliminatorias'),(3,'Alemania','Italia',2,0,1,'Eliminatorias'),(4,'Venezuela','España',1,1,1,'Eliminatorias'),(5,'Alemania','España',3,0,2,'Grupos'),(6,'Italia','Venezuela',2,1,2,'Grupos'),(7,'Argentina','Mexico',2,0,2,'Grupos'),(8,'Arabia Saudita','Polonia',0,2,2,'Grupos'),(9,'Argentina','Italia',3,0,3,'Finales'),(10,'Polonia','España',2,1,3,'Finales'),(11,'Alemania','Arabia Saudita',1,0,3,'Finales'),(12,'Venezuela','México',1,2,3,'Finales'),(13,'Argentina','Alemania',2,1,4,'Finales'),(14,'Polonia','España',0,1,4,'Finales'),(15,'Venezuela','Italia',1,2,4,'Finales'),(16,'Arabia Saudita','México',0,0,4,'Finales');
/*!40000 ALTER TABLE `resultados` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-11-29 16:59:08

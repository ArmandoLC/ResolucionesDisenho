-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: resolucionesbd
-- ------------------------------------------------------
-- Server version	5.7.18-log

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
-- Table structure for table `anotaciones`
--

DROP TABLE IF EXISTS `anotaciones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `anotaciones` (
  `idSolicitud` int(11) NOT NULL,
  `detalle` text,
  PRIMARY KEY (`idSolicitud`),
  CONSTRAINT `idsolic` FOREIGN KEY (`idSolicitud`) REFERENCES `solicitudes` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `anotaciones`
--

LOCK TABLES `anotaciones` WRITE;
/*!40000 ALTER TABLE `anotaciones` DISABLE KEYS */;
/*!40000 ALTER TABLE `anotaciones` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cursos`
--

DROP TABLE IF EXISTS `cursos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cursos` (
  `codigo` varchar(100) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cursos`
--

LOCK TABLES `cursos` WRITE;
/*!40000 ALTER TABLE `cursos` DISABLE KEYS */;
INSERT INTO `cursos` VALUES ('s11','Diseño de Software');
/*!40000 ALTER TABLE `cursos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `inconsistencias`
--

DROP TABLE IF EXISTS `inconsistencias`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `inconsistencias` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `detalle` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `inconsistencias`
--

LOCK TABLES `inconsistencias` WRITE;
/*!40000 ALTER TABLE `inconsistencias` DISABLE KEYS */;
/*!40000 ALTER TABLE `inconsistencias` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ofertas`
--

DROP TABLE IF EXISTS `ofertas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ofertas` (
  `idoferta` int(11) NOT NULL AUTO_INCREMENT,
  `codigoCurso` varchar(100) DEFAULT NULL,
  `idProfesor` varchar(100) DEFAULT NULL,
  `numeroGrupo` int(11) DEFAULT NULL,
  `periodo` varchar(100) DEFAULT NULL,
  `modalidad` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`idoferta`),
  UNIQUE KEY `idoferta_UNIQUE` (`idoferta`),
  KEY `ofertaCurso_idx` (`codigoCurso`),
  KEY `ofertaProfesor_idx` (`idProfesor`),
  CONSTRAINT `ofertaCurso` FOREIGN KEY (`codigoCurso`) REFERENCES `cursos` (`codigo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `ofertaProfesor` FOREIGN KEY (`idProfesor`) REFERENCES `profesores` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ofertas`
--

LOCK TABLES `ofertas` WRITE;
/*!40000 ALTER TABLE `ofertas` DISABLE KEYS */;
INSERT INTO `ofertas` VALUES (1,'s11','1',40,'2017','Bimestre');
/*!40000 ALTER TABLE `ofertas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `profesores`
--

DROP TABLE IF EXISTS `profesores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `profesores` (
  `id` varchar(100) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `profesores`
--

LOCK TABLES `profesores` WRITE;
/*!40000 ALTER TABLE `profesores` DISABLE KEYS */;
INSERT INTO `profesores` VALUES ('1','Ericka Solano');
/*!40000 ALTER TABLE `profesores` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `resoluciones`
--

DROP TABLE IF EXISTS `resoluciones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `resoluciones` (
  `idSolicitud` int(11) NOT NULL,
  `numeroResolucion` int(11) NOT NULL,
  `fecha` date DEFAULT NULL,
  `coordinador` varchar(100) DEFAULT NULL,
  `directorEscuela` varchar(100) DEFAULT NULL,
  `directorAdmyReg` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`idSolicitud`),
  UNIQUE KEY `idSolicitud_UNIQUE` (`idSolicitud`),
  UNIQUE KEY `numeroResolucion_UNIQUE` (`numeroResolucion`),
  CONSTRAINT `idsolic2` FOREIGN KEY (`idSolicitud`) REFERENCES `solicitudes` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `resoluciones`
--

LOCK TABLES `resoluciones` WRITE;
/*!40000 ALTER TABLE `resoluciones` DISABLE KEYS */;
/*!40000 ALTER TABLE `resoluciones` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `resueltos`
--

DROP TABLE IF EXISTS `resueltos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `resueltos` (
  `numeroResolucion` int(11) NOT NULL,
  `detalle` text NOT NULL,
  PRIMARY KEY (`numeroResolucion`),
  CONSTRAINT `numRes` FOREIGN KEY (`numeroResolucion`) REFERENCES `resoluciones` (`numeroResolucion`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `resueltos`
--

LOCK TABLES `resueltos` WRITE;
/*!40000 ALTER TABLE `resueltos` DISABLE KEYS */;
/*!40000 ALTER TABLE `resueltos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `solicitudes`
--

DROP TABLE IF EXISTS `solicitudes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `solicitudes` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idOferta` int(11) DEFAULT NULL,
  `fecha` date DEFAULT NULL,
  `tipoSituacion` varchar(100) DEFAULT NULL,
  `descripcion` text,
  `idSolicitante` varchar(100) DEFAULT NULL,
  `solicitante` varchar(100) DEFAULT NULL,
  `idAfectado` varchar(100) DEFAULT NULL,
  `nombreAfectado` varchar(100) DEFAULT NULL,
  `correoAfectado` varchar(100) DEFAULT NULL,
  `telefonoAfectado` varchar(100) DEFAULT NULL,
  `rutaAdjunto` text,
  `estado` varchar(100) NOT NULL,
  `aclaracion` text,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `solicitudOferta_idx` (`idOferta`),
  CONSTRAINT `solicitudOferta` FOREIGN KEY (`idOferta`) REFERENCES `ofertas` (`idoferta`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `solicitudes`
--

LOCK TABLES `solicitudes` WRITE;
/*!40000 ALTER TABLE `solicitudes` DISABLE KEYS */;
INSERT INTO `solicitudes` VALUES (1,1,'2017-04-19','INCLUSION','Dato de descripcion','1','solicitante ejemplo','1-1651','afectado 01','correo@afectado.com','73L3F0N0','ruta archivo','PENDIENTE','Sin aclaraciones');
/*!40000 ALTER TABLE `solicitudes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuarios` (
  `id` varchar(100) NOT NULL,
  `contrasenha` varchar(100) NOT NULL,
  `tipoUsuario` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'resolucionesbd'
--
/*!50003 DROP PROCEDURE IF EXISTS `consultarAnotaciones` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `consultarAnotaciones`(IN id INT)
BEGIN
	SELECT detalle AS 'anotaciones' FROM anotaciones WHERE idSolicitud = id;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `consultarSolicitudes` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `consultarSolicitudes`()
BEGIN
	SELECT s.id, s.fecha, s.idSolicitante, s.solicitante, s.idAfectado, s.nombreAfectado,
		   s.correoAfectado, s.telefonoAfectado, s.tipoSituacion, s.descripcion, 
           s.rutaAdjunto, s.estado, s.aclaracion, -1 as 'numResolucion',
		   o.periodo, o.codigoCurso, o.numeroGrupo, s.estado
	FROM solicitudes s, ofertas o
    WHERE s.idOferta = o.idoferta and s.id not in (select idSolicitud from resoluciones)
    UNION
    SELECT s.id, s.fecha, s.idSolicitante, s.solicitante, s.idAfectado, s.nombreAfectado,
		   s.correoAfectado, s.telefonoAfectado, s.tipoSituacion, s.descripcion, 
           s.rutaAdjunto, s.estado, s.aclaracion, r.numeroResolucion as 'numResolucion',
		   o.periodo, o.codigoCurso, o.numeroGrupo, s.estado
	FROM solicitudes s, ofertas o, resoluciones r
    WHERE s.idOferta = o.idoferta and r.idSolicitud = s.id;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-04-19 16:55:51

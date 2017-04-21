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
-- Table structure for table `cursos`
--

DROP TABLE IF EXISTS `cursos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cursos` (
  `codigo` varchar(100) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `creditos` int(11) DEFAULT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cursos`
--

LOCK TABLES `cursos` WRITE;
/*!40000 ALTER TABLE `cursos` DISABLE KEYS */;
INSERT INTO `cursos` VALUES ('IC1802','Introducci�n a la Programaci�n',3),('IC1803','Taller de Programaci�n',3),('IC4301','Bases de Datos I',4),('IC5821','Requerimientos de Software',4),('IC6821','Dise�o de Software',4);
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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `inconsistencias`
--

LOCK TABLES `inconsistencias` WRITE;
/*!40000 ALTER TABLE `inconsistencias` DISABLE KEYS */;
INSERT INTO `inconsistencias` VALUES (2,'EXCLUSION_ACTA'),(3,'INCLUSION_ACTA');
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
  `horario` varchar(100) DEFAULT NULL,
  `aula` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`idoferta`),
  UNIQUE KEY `idoferta_UNIQUE` (`idoferta`),
  KEY `ofertaCurso_idx` (`codigoCurso`),
  KEY `ofertaProfesor_idx` (`idProfesor`),
  CONSTRAINT `ofertaCurso` FOREIGN KEY (`codigoCurso`) REFERENCES `cursos` (`codigo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `ofertaProfesor` FOREIGN KEY (`idProfesor`) REFERENCES `profesores` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ofertas`
--

LOCK TABLES `ofertas` WRITE;
/*!40000 ALTER TABLE `ofertas` DISABLE KEYS */;
INSERT INTO `ofertas` VALUES (8,'IC1802','5-5555-5555',1,'IS2017',NULL,'K-J 7:30-9:20','B3-08'),(9,'IC1803','5-5555-5555',1,'IS2017',NULL,'K-J 9:30-11:20','B3-08'),(10,'IC4301','2-2222-2222',1,'IS2017',NULL,'M-V 13:00-14:50','B3-06'),(11,'IC4301','4-4444-4444',2,'IS2017',NULL,'M-V 7:30-9:20','B3-06'),(12,'IC5821','2-2222-2222',1,'IS2017',NULL,'M-V 15:00-16:50','B3-06'),(13,'IC6821','1-1111-1111',1,'IS2017',NULL,'K-J 7:30-9:20','B3-07'),(14,'IC6821','1-1111-1111',2,'IS2017',NULL,'M-V 7:30-9:20','B3-07');
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
  `correo` varchar(100) DEFAULT NULL,
  `telefono` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `profesores`
--

LOCK TABLES `profesores` WRITE;
/*!40000 ALTER TABLE `profesores` DISABLE KEYS */;
INSERT INTO `profesores` VALUES ('1-1111-1111','Ericka Solano Fern�ndez','ersolano@itcr.ac.cr','8111-1111'),('2-2222-2222','Alicia Salazar Hern�ndez','asalazar@itcr.ac.cr','8222-2222'),('3-3333-3333','Sa�l Calder�n Ram�rez','sacalderon@itcr.ac.cr','8333-3333'),('4-4444-4444','Franco Quir�s Ram�rez','fquiros@itcr.ac.cr','8444-4444'),('5-5555-5555','Ivannia Cerdas Quesada','iquesada@itcr.ac.cr','8555-5555'),('CRC 101','Brondon','mail@mail.com','8591-7790');
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
  `introduccion` text,
  `resultado` text,
  `considerandos` text,
  `resuelvo` text,
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
INSERT INTO `resoluciones` VALUES (12,15,'2014-12-12','esta','esta','esta','estaesta','esta','esta','esta');
/*!40000 ALTER TABLE `resoluciones` ENABLE KEYS */;
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
  `inconsistencia` varchar(100) DEFAULT NULL,
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
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `solicitudes`
--

LOCK TABLES `solicitudes` WRITE;
/*!40000 ALTER TABLE `solicitudes` DISABLE KEYS */;
INSERT INTO `solicitudes` VALUES (12,8,'2014-02-02','asdf','asdf','asdf','sdf','asdf','asdf','asf','asdf','asdf','Anulada','Satanas en vida la anulo'),(13,8,'2017-04-21','EXCLUSION_ACTA','tengala adentro','2015114132','Julian Salinas','201514132','Julians Salinas','beto@dltgkbmfg','546546','C:\\Users\\july1\\Documents\\mysql-installer-web-community-5.7.18.0.msi','Tramitada','Sin definir'),(14,8,'2017-04-19','ERROR_NOTA','Nota mal asignada, es un 90, no un 70\"','2015082908','Andrey Mendoza','2015082908','Andrey Mendoza','amf@gmail.com','86382040','Solicutud por medio del formulario','Anulada','EL HUEBON ES VIEN HUEBON'),(15,8,'2017-04-19','INCLUSION_NOTA','Mi nota no fue asignada\"','2015555555','Brandon Dinarte','2015555555','Brnadon Dinarte','brandon@gmail.com','88888888','Solicutud por medio del formulario','Tramitada',''),(16,8,'2017-04-21','EXCLUSION_ACTA','dwaefawefaewfaef','21323423','Benito Camelas','56485468','Nombre','julitre@sekjnvse.com','165416356','C:\\Users\\july1\\Documents\\mysql-installer-web-community-5.7.18.0.msi','Tramitada','Sin definir');
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
/*!50003 DROP PROCEDURE IF EXISTS `anularSolicitud` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `anularSolicitud`(
IN idS INT, IN aclaration TEXT
)
BEGIN
	UPDATE solicitudes
    SET estado = 'Anulada', aclaracion = aclaration
    WHERE id = idS;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `consultarResolucion` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `consultarResolucion`(in pidSolicitud int(11) )
BEGIN

	select * from resoluciones where pidSolicitud = resoluciones.idSolicitud;

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
		   s.correoAfectado, s.telefonoAfectado, s.inconsistencia, s.descripcion, 
           s.rutaAdjunto, s.estado, s.aclaracion, -1 as 'numResolucion',
		   o.periodo, o.codigoCurso, o.numeroGrupo, s.estado
	FROM solicitudes s, ofertas o
    WHERE s.idOferta = o.idoferta and s.id not in (select idSolicitud from resoluciones)
    UNION
    SELECT s.id, s.fecha, s.idSolicitante, s.solicitante, s.idAfectado, s.nombreAfectado,
		   s.correoAfectado, s.telefonoAfectado, s.inconsistencia, s.descripcion, 
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
/*!50003 DROP PROCEDURE IF EXISTS `obtenerNumResolucionParaSolic` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `obtenerNumResolucionParaSolic`(IN idBuscado INT)
BEGIN
	SELECT numeroResolucion FROM resoluciones
    WHERE idSolicitud = idBuscado;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `registrarCurso` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `registrarCurso`(
IN cod VARCHAR(100), IN nomb VARCHAR(100), IN cred INT
)
BEGIN
	IF NOT EXISTS (SELECT codigo FROM cursos WHERE codigo = cod)
	THEN
		INSERT INTO cursos 	(`codigo`, `nombre`, `creditos`)
					VALUES	(cod, nomb, IFNULL(cred, 1) );
                                
	ELSE
		SELECT codigo FROM cursos WHERE codigo = cod;
	END IF;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `registrarInconsistencia` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `registrarInconsistencia`(
IN detail VARCHAR(100)
)
BEGIN
	IF NOT EXISTS (SELECT id FROM inconsistencias WHERE LOWER(detail) = LOWER(detalle) )
	THEN
		INSERT INTO inconsistencias	(`detalle`)
					VALUES	(detail);
                                
		SELECT LAST_INSERT_ID() AS 'ultimoID';
	ELSE
		SELECT id FROM inconsistencias WHERE LOWER(detail) = LOWER(detalle);
	END IF;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `registrarOferta` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `registrarOferta`( 
IN codCurso VARCHAR(100), IN idProfe VARCHAR(100), IN nGrupo INT, 
IN period VARCHAR(100), IN sched VARCHAR(100), IN class VARCHAR(100)
)
BEGIN
	IF NOT EXISTS (SELECT idoferta FROM ofertas WHERE period = periodo AND codigoCurso = codCurso
											AND numeroGrupo = nGrupo)
	THEN
		INSERT INTO ofertas (`codigoCurso`, `idProfesor`, `numeroGrupo`, `periodo`,
							`horario`, `aula`)
					VALUES	(codCurso, idProfe, nGrupo, period, IFNULL(sched, 'No definido'),
							IFNULL(class, 'No definida'));
                                
		SELECT LAST_INSERT_ID() AS 'ultimoID';
	ELSE
		SELECT idoferta FROM ofertas WHERE period = periodo AND codigoCurso = codCurso
											AND numeroGrupo = nGrupo;
	END IF;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `registrarProfesor` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `registrarProfesor`(
IN identif VARCHAR(100), IN nomb VARCHAR(100), IN mail VARCHAR(100), IN tel VARCHAR(100)
)
BEGIN
	IF NOT EXISTS (SELECT id FROM profesores WHERE id = identif)
	THEN
		INSERT INTO profesores 	(`id`, `nombre`, `correo`, `telefono`)
					VALUES	(identif, nomb, IFNULL(mail, 'Sin correo'), 
							IFNULL(tel, 'Sin teléfono') );

	ELSE
		SELECT id FROM profesores WHERE id = identif;
	END IF;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `registrarResolucion` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `registrarResolucion`(
IN idSolicitud INT(11), IN nResolucion INT(11),  IN fecha DATE, IN coordinador VARCHAR(100), 
in directorEscuela VARCHAR(100), in directorAdmyReg VARCHAR(100), in introduccion text, 
in resultado text, in considerandos text, in resuelvo text
)
BEGIN
	IF NOT EXISTS (select idSolicitud from resoluciones where idSolicitud = resoluciones.idSolicitud)
	THEN
		insert into resoluciones (`idSolicitud`, `numeroResolucion`, `fecha`, `coordinador`, `directorEscuela`,
					`directorAdmYReg`, `introduccion`, `resultado`,`considerandos`,`resuelvo`)  
                    VALUES 
                    (idSolicitud, nResolucion, fecha, coordinador, directorEscuela,
					directorAdmyReg, introduccion, resultado, considerandos, resuelvo);
	END IF;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `registrarSolicitud` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `registrarSolicitud`(
IN fecha DATE, IN idSolic VARCHAR(100), IN nombreSolic VARCHAR(100),
IN period VARCHAR(100), IN codCurso VARCHAR(100), IN nGrupo INT,
IN idAfect VARCHAR(100), IN nombreAfect VARCHAR(100), IN correoAfect VARCHAR(100),
IN telefonoAfect VARCHAR(100), IN inconsist VARCHAR(100), IN descrip TEXT, 
IN ruta TEXT, IN estado VARCHAR(100), IN aclarac TEXT
)
BEGIN
	IF EXISTS (SELECT idoferta FROM ofertas WHERE period = periodo AND codigoCurso = codCurso
											AND numeroGrupo = nGrupo)
	THEN
		SET @idOferta = (SELECT idoferta FROM ofertas WHERE period = periodo AND codigoCurso = codCurso
											AND numeroGrupo = nGrupo);
		INSERT INTO solicitudes (`idOferta`,`fecha`,`inconsistencia`,`descripcion`,
								`idSolicitante`,`solicitante`,`idAfectado`,`nombreAfectado`,
                                `correoAfectado`,`telefonoAfectado`,`rutaAdjunto`,`estado`,
                                `aclaracion`)
					VALUES		(@idOferta, fecha, inconsist, descrip, idSolic,
								nombreSolic, idAfect, nombreAfect, correoAfect, 
                                telefonoAfect, ruta, estado, aclarac);
                                
		SELECT LAST_INSERT_ID() AS 'ultimoID';
	ELSE
		SIGNAL SQLSTATE '01000';
	END IF;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `tramitarSolicitud` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `tramitarSolicitud`(
IN idS INT
)
BEGIN
	UPDATE solicitudes
    SET estado = 'Tramitada'
    WHERE id = idS;
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

-- Dump completed on 2017-04-21  5:08:57

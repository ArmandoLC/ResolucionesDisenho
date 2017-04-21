CREATE PROCEDURE `registrarResolucion` (
IN idSolicitud INT(11), IN nResolucion INT(11),  IN fecha DATE, IN coordinador VARCHAR(100), 
in directorEscuela VARCHAR(100), in directorAdmyReg text, in introduccion text, 
in resultado text, in considerandos text, in resuelvo text
)
BEGIN
	IF NOT EXISTS (select idS from resoluciones where idS = resoluciones.idSolicitud)
	THEN
		insert into resoluciones (`idSolicitud`, `numeroResolucion`, `fecha`, `coordinador`, `directorEscuela`,
					`directorAdmYReg`, `introduccion`, `resultado`,`considerandos`,`resuelvo`)  
                    VALUES 
                    (idSolicitud, nResolucion, fecha, coordinador, directorEscuela,
					directorAdmyReg, introduccion, resultado, considerandos, resuelvo);
	END IF;
END

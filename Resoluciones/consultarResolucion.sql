CREATE PROCEDURE `consultarResolucion` (in pidSolicitud int(11) )
BEGIN

	select * from resoluciones where pidSolicitud = resoluciones.idSolicitud;

END

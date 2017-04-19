/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Controlador.IDAOSolicitud;
import Enums.Recurso;

/**
 *
 * @author Armando
 */
public class FactoryDAOSolicitud {

    public FactoryDAOSolicitud() {
    }
    
    public IDAOSolicitud CrearDAOSolicitud(Recurso recurso) {
        IDAOSolicitud daoSolicitud;
        
        try{
            String name = IDAOSolicitud.class.getPackage().getName();            
            daoSolicitud = (IDAOSolicitud) Class.forName(name + "." + recurso.name()).newInstance();
            
            return daoSolicitud;       
            
        }catch (Exception e) {
            //throw new Exception("Tipo de DAO desconocido.");
            return null;
        }
    }

}

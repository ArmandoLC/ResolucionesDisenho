/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;
import Enums.Recurso;

/**
 *
 * @author Armando
 */
public class FactoryDAOSolicitud {

    public FactoryDAOSolicitud() {
    }
    
    public DAOSolicitud CrearDAOSolicitud(Recurso recurso) {
        DAOSolicitud daoSolicitud;
        
        try{
            String name = DAOSolicitud.class.getPackage().getName();            
            daoSolicitud = (DAOSolicitud) Class.forName(name + "." + "DAO" + recurso.name()).newInstance();
            
            return daoSolicitud;       
            
        }catch (Exception e) {
            //throw new Exception("Tipo de DAO desconocido.");
            return null;
        }
    }

}

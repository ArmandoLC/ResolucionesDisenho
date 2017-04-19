/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Login;

import DTOs.DTOUsuario;

public class LoginMySQL implements ILogin{
    
    private String stringConexion;

    @Override
    public DTOUsuario Login(String id, String contrasenha) throws Exception {

        //Informacion temporal
        DTOUsuario usuario =  new DTOUsuario();
        //usuario.setId(Integer.parseInt(id));
        usuario.setId(id);
        if("305000681".equals(id) && "1234".equals(contrasenha))
             usuario.setTipoUsuario("Coordinador");
        else usuario.setTipoUsuario("Estudiante"); 
        Sesion.getInstance().setUsuario(usuario);
        return usuario;
      
    }
    
}

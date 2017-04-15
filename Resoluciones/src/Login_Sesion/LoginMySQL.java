/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Login_Sesion;

import DTOs.DTOUsuario;
import Interfaces.ILogin;

/**
 *
 * @author Armando
 */
public class LoginMySQL implements ILogin{
    private String stringConexion;

    @Override
    public DTOUsuario Login(String id, String contrasenha) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

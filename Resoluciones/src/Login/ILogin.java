/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Login;

import DTOs.DTOUsuario;

/**
 *
 * @author Armando
 */
public interface ILogin {

    public DTOUsuario Login(String id, String contrasenha) throws Exception ;
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Login_Sesion;

import DTOs.DTOUsuario;

/**
 *
 * @author Armando
 */
public class Sesion {

    private static Sesion instance;
    private DTOUsuario usuario;

    public static Sesion GetInstance() {
        return instance;
    }

}

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
public class Sesion {

    private static Sesion instance;
    private DTOUsuario usuario;

    public static Sesion getInstance() {
        if(instance == null)
            instance = new Sesion();
        return instance;
    }

    public DTOUsuario getUsuario() {
        return usuario;
    }

    public void setUsuario(DTOUsuario usuario) {
        this.usuario = usuario;
    }

}

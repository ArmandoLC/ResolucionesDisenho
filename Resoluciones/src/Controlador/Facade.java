/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Controlador.ControladorPrincipal;
import Controlador.ISolicitud;

/**
 *
 * @author Armando
 */
public abstract class Facade implements ISolicitud {

    private ControladorPrincipal controlador;
}

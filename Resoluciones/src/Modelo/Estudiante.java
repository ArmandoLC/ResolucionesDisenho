/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Armando
 */
public class Estudiante extends Persona {

    public Estudiante(String id, String nombre, String correo, String telefono) {
        super(id, nombre, correo, telefono);
    }
    //Por el momento el estudiante no tiene ningún método ni atributo propio
    //no obstante se decide crear esta clase con la finalidad de brindar escalabilidad al proyecto.

}
